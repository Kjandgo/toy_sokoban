package com.sokoban.run;

import com.sokoban.gameplay.Game;
import com.sokoban.member.service.MemberService;
import com.sokoban.ranking.service.RankingService;
import com.sokoban.session.SessionStorage;
import com.sokoban.stage.repository.StageRepository;
import com.sokoban.stage.service.StageService;

import java.io.IOException;
import java.util.Scanner;

public class MainPage {
    private static final MemberService memberService = new MemberService();
    private static final StageService stageService = new StageService();
    private static final RankingService rankingService = new RankingService();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean loginFlag = false;

        asciiArt();
        while (true) {
            while (!loginFlag) {
                System.out.println("--------------------------------------");
                System.out.println("1. 로그인");
                System.out.println("2. 회원 가입");
                System.out.println("0. 나가기");
                System.out.println("--------------------------------------");

                System.out.print("번호를 입력하세요. : ");
                int loginInput = sc.nextInt();

                System.out.println("--------------------------------------");
                switch (loginInput) {
                    case 1:
                        loginFlag = LoginPage.memberLogin(memberService);
                        if (loginFlag) {
                            System.out.println(SessionStorage.getMember().getName() + " 님 로그인 되었습니다.");
                            break;
                        } else {
                            System.out.println("일치하는 회원이 없습니다.");
                        }
                        break;
                    case 2:
                        memberService.registMember(LoginPage.memberSignUp());
                        break;
                    case 0:
                        System.out.println("게임을 종료합니다.");
                        return;
                    case 59956887:
                        stageService.insertStage();
                        System.out.println("맵 정보 입력 완료");
                        break;
                    default:
                        System.out.println("잘못된 값을 입력했습니다.");
                }
            }
            System.out.println("--------------------------------------");
            System.out.println("1. 게임 시작");
            System.out.println("2. 랭킹");
            System.out.println("3. 개인 정보");
            System.out.println("4. 로그아웃");
            System.out.println("0. 나가기");
            System.out.println("--------------------------------------");

            System.out.print("번호를 입력하세요. : ");
            int input = sc.nextInt();

            System.out.println("--------------------------------------");
            switch (input) {
                case 1:
                    System.out.print("스테이지 번호를 입력하세요. : ");
                    int inputStage = sc.nextInt();
                    Game game = new Game();
                    System.out.println(System.identityHashCode(game));
                    game.startGame(stageService,inputStage);
                    break;
                case 2:
                    RankingPage.findRankingInfo(rankingService);
                    break;
                case 3:
                    MemberPage.findMemberInfo(memberService);
                    break;
                case 4:
                    memberService.logoutCheck();
                    System.out.println("로그아웃");
                    loginFlag = false;
                    break;
                case 0:
                    memberService.logoutCheck();
                    System.out.println("게임을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 값을 입력했습니다.");
            }
        }
    }

    private static void clearConsole() {
            for (int i = 0; i < 80; i++)
                System.out.println("");
    }

    private static void asciiArt() {
        System.out.println("\n" +
                " _____  _____  _   __ _____ ______   ___   _   _ \n" +
                "/  ___||  _  || | / /|  _  || ___ \\ / _ \\ | \\ | |\n" +
                "\\ `--. | | | || |/ / | | | || |_/ // /_\\ \\|  \\| |\n" +
                " `--. \\| | | ||    \\ | | | || ___ \\|  _  || . ` |\n" +
                "/\\__/ /\\ \\_/ /| |\\  \\\\ \\_/ /| |_/ /| | | || |\\  |\n" +
                "\\____/  \\___/ \\_| \\_/ \\___/ \\____/ \\_| |_/\\_| \\_/\n" +
                "                                                 \n");
    }
}

