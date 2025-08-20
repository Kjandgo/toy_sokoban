package com.sokoban.run;

import java.util.Scanner;

public class MainPage {
    public static void main(String[] args) {
        /* 메인메뉴를 임시적으로 cli환경으로 제작뒤 gui로 넘어갈지 말지 결정 */
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("------소코반------");
            System.out.println("1. 게임 시작");
            System.out.println("2. 랭킹");
            System.out.println("3. 로그인");
            System.out.println("0. 나가기");
            System.out.print("번호를 입력하세요. : ");
            int input = sc.nextInt();
            switch (input){
                case 1: break;
                case 2:break;
                case 3:break;
                case 0:break;
                default:
                    System.out.println("잘못된 값을 입력했습니다.");
            }
        }
    }
}
