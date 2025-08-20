package com.sokoban.run;

import com.sokoban.member.service.MemberService;
import com.sokoban.ranking.service.RankingService;
import com.sokoban.stage.service.StageService;

import java.util.Scanner;

public class MainPage {
    public static void main(String[] args) {
        /* 메인메뉴를 임시적으로 cli환경으로 제작 한 뒤 gui로 넘어갈지 말지 결정 */
        MemberService memberService = new MemberService();
        StageService stageService = new StageService();
        RankingService rankingService = new RankingService();

        Scanner sc = new Scanner(System.in);
        boolean loginFlag = false;
        while (true) {
            System.out.println("------소코반------");
            while (!loginFlag) {
                String[] loginArr = LoginPage.memberLogin().clone();
                loginFlag = memberService.loginValidationCheck(loginArr[0], loginArr[1]);
                if (loginFlag) {
                    System.out.println("로그인 되었습니다.");
                    break;
                } else {
                    System.out.println("회원 정보를 다시 입력해주십시오");
                }
            }

            System.out.println("------------------------------");
            System.out.println("1. 게임 시작");
            System.out.println("2. 랭킹");
            System.out.println("3. 개인 정보");
            System.out.println("0. 나가기");
            System.out.println("------------------------------");
            System.out.print("번호를 입력하세요. : ");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("게임을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 값을 입력했습니다.");

            }
        }
    }
}
