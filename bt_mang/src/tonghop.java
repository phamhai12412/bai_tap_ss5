import java.util.Arrays;
import java.util.Scanner;

public class tonghop {

    static Scanner scanner = new Scanner(System.in);
    static int[] arr1 = {1, 2, 3, 4, 5, 6};
    static int[] arr2 = {3, 35, 2, 3, 53};
    static int[] arr3 = {2, 34, 21, 46, 2};

    public static void main(String[] args) {

        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Hiển thị các mảng số nguyên");
            System.out.println("2. Gộp 2 mảng số nguyên");
            System.out.println("3. Gộp 3 mảng số nguyên");
            System.out.println("4. Hiển thị 1 mảng");
            System.out.println("5. Dừng chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showArr(arr1, "Mảng 1:");
                    showArr(arr2, "Mảng 2:");
                    showArr(arr3, "Mảng 3:");
                    break;
                case 2:
                    int[] arr = gopMang();
                    System.out.println("Mảng sau khi gộp là: " + Arrays.toString(arr));
                    break;
                case 3:
                    System.out.println("Mảng sau khi gộp 3 mảng là: " + Arrays.toString(gop3Mang()));
                    break;
                case 4:
                    arrayHandle();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void arrayHandle() {
        System.out.print("Nhập mảng bạn muốn in: ");
        int choice = scanner.nextInt();
        int[] arr = layMang(choice);
        System.out.println("Mảng " + choice + " là: " + Arrays.toString(arr));

        System.out.println("1. Thêm 1 phần tử vào cuối");
        System.out.println("2. Thêm 1 phần tử vào đầu");
        System.out.println("3. Xóa 1 phần tử được chọn");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice1 = scanner.nextInt();
        switch (choice1) {
            case 1:
                ganMang(choice, addLast(arr));
                break;
            case 2:
                ganMang(choice, addFirst(arr));
                break;
            case 3:
                ganMang(choice, remove(arr));
                break;
        }
    }

    public static int[] addFirst(int[] arr) {
        System.out.print("Nhập phần tử số muốn thêm: ");
        int num = scanner.nextInt();
        int[] newArr = new int[arr.length + 1];
        newArr[0] = num;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

    private static int[] remove(int[] arr) {
        System.out.print("Nhập vị trí của phần tử muốn xóa: ");
        int position = scanner.nextInt();
        if (position < 1 || position > arr.length) {
            System.out.println("Vị trí không hợp lệ!");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != position - 1) {
                newArr[index] = arr[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

    private static int[] addLast(int[] arr) {
        System.out.print("Nhập phần tử số muốn thêm: ");
        int num = scanner.nextInt();
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = num;
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

    private static int[] gop3Mang() {
        int[] gop3Mang = new int[arr1.length + arr2.length + arr3.length];
        for (int i = 0; i < gop3Mang.length; i++) {
            if (i < arr1.length) {
                gop3Mang[i] = arr1[i];
            } else if (i < (arr1.length + arr2.length)) {
                gop3Mang[i] = arr2[i - arr1.length];
            } else if (i < (arr1.length + arr2.length + arr3.length)) {
                gop3Mang[i] = arr3[i - arr2.length - arr1.length];
            }
        }

        return gop3Mang;
    }

    private static int[] gopMang() {
        System.out.print("Nhập số của mảng thứ nhất bạn muốn gộp: ");
        int choice = scanner.nextInt();
        int[] mang1 = layMang(choice);
        System.out.print("Nhập số của mảng thứ hai bạn muốn gộp: ");
        choice = scanner.nextInt();
        int[] mang2 = layMang(choice);
        int[] newArr = new int[mang1.length + mang2.length];
        for (int i = 0; i < newArr.length; i++) {
            if (i < mang1.length) {
                newArr[i] = mang1[i];
            } else {
                newArr[i] = mang2[i - mang1.length];
            }
        }
        return newArr;
    }

    private static void showArr(int[] arr, String tenmang) {
        System.out.println(tenmang + " " + Arrays.toString(arr));
    }

    private static void ganMang(int soMang, int[] arr) {
        switch (soMang) {
            case 1:
                arr1 = arr;
                break;
            case 2:
                arr2 = arr;
                break;
            case 3:
                arr3 = arr;
                break;
        }
    }

    private static int[] layMang(int soMang) {
        switch (soMang) {
            case 1:
                return arr1;
            case 2:
                return arr2;
            case 3:
                return arr3;
        }
        return null;
    }
}
