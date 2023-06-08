import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập vào chuỗi");
String chuoi= sc.nextLine();
       for(int i=0; i<chuoi.length();i++){
           if(chuoi.charAt(i)==' '){
               System.out.println();

           } else {
               System.out.printf(""+chuoi.charAt(i));
           }
       }

    }
}