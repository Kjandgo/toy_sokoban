package com.sokoban.run;

import com.sokoban.member.service.MemberService;
import com.sokoban.session.SessionStorage;

import java.util.Scanner;

public class MemberPage {
    public static void findMemberInfo(MemberService ms) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("아이디 : " + SessionStorage.getMember().getId());
            System.out.println("패스워드 : " + SessionStorage.getMember().getPwd());
            System.out.println("닉네임 : " + SessionStorage.getMember().getName());
            System.out.println("최고 스테이지 : " + SessionStorage.getMember().getHighestStageNo());

            System.out.println("--------------------------------------");
            System.out.println("1. 아이디 수정");
            System.out.println("2. 패스워드 수정");
            System.out.println("3. 닉네임 수정");
            System.out.println("0. 뒤로 가기");
            System.out.println("--------------------------------------");
            System.out.print("번호를 입력하세요. : ");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    System.out.print("변경할 아이디를 입력하세요. : ");
                    ms.modifyMemberInfo(sc.nextLine(), "id");
                    break;
                case "2":
                    System.out.print("변경할 패스워드를 입력하세요. : ");
                    ms.modifyMemberInfo(sc.nextLine(), "pwd");
                    break;
                case "3":
                    System.out.print("변경할 닉네임을 입력하세요. : ");
                    ms.modifyMemberInfo(sc.nextLine(), "name");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 값을 입력했습니다.");
            }
        }

    }
}
