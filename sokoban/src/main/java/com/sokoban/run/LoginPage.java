package com.sokoban.run;

import com.sokoban.member.aggregate.Member;

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

    public static Member memberSignUp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요. : ");
        String id = sc.nextLine();
        System.out.print("패스워드를 입력하세요. : ");
        String pwd = sc.nextLine();
        System.out.print("닉네임을 입력하세요. : ");
        String name = sc.nextLine();
        return new Member(0, id, pwd, name, 0);
    }
}
