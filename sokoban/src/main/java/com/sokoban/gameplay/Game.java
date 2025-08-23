package com.sokoban.gameplay;

import com.sokoban.stage.aggregate.Stage;
import com.sokoban.stage.service.StageService;

import java.util.Scanner;

public class Game {
    private static int player_x = 0;
    private static int player_y = 0;

    public void startGame(StageService ss) {
        Scanner sc = new Scanner(System.in);
        Stage stage = ss.selectStage(1);
        char[][] stageMap = stage.getStageMap().clone();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (stageMap[i][j] == '⊙') {
                    player_x = i;
                    player_y = j;
                    break;
                }
            }
        }

        while (true) {
            clearConsole();
                System.out.println();
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(stageMap[i][j]);
                }
                System.out.println();
            }
            String s = sc.nextLine();
            movePlayer(s, stageMap,stage);
            /*
             * ● : 상자
             * ○ : 목적지
             * ■ : 벽
             * ◎ : 목적지에 도착한 상자
             * ⊙ : 플레이어
             * */
        }
    }

    private void movePlayer(String s, char[][] stageMap,Stage stage) {
        stageMap[player_x][player_y] = ' ';
        switch (s) {
            case "w":
                if (player_x - 1 >= 0) {
                    player_x = player_x - 1;
                }
                break;
            case "a":
                if (player_y - 1 >= 0) {
                    player_y = player_y - 1;
                }
                break;
            case "s":
                if (player_x + 1 < 20) {
                    player_x = player_x + 1;
                }
                break;
            case "d":
                if (player_y + 1 < 20) {
                    player_y = player_y + 1;
                }
                break;
            default:
                System.out.println("잘못된 입력");
        }
        stageMap[player_x][player_y] = '⊙';

    }

    private boolean checkMoveable(){
        return false;
    }

    private void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


}
