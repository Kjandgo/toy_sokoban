package com.sokoban.run;

import java.util.Scanner;

public class LoginPage {
    public static String[] memberLogin() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String id = "";
        String pwd = "";
        String[] result = new String[2];

        System.out.println("회원정보를 입력하세요");

        System.out.print("ID : ");
        result[0] = sc.nextLine();

        System.out.print("PASSWORD : ");
        result[1] = sc.nextLine();

        return result;
    }
}
