package String;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class kiem_tra_emaill {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào email");
        String str = sc.nextLine();
     if(checkValidate(str)){
         System.out.println("email vừa nhập đúng định dạng");
     }else System.out.println("email vừa nhập sai định dạng");


    }

    public static boolean checkValidate(String str) {
        String regexEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
//        return Pattern.matches(regexEmail,str);
        return str.matches(regexEmail);
    }

}