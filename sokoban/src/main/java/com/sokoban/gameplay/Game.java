package com.sokoban.gameplay;

import com.sokoban.stage.aggregate.Stage;
import com.sokoban.stage.service.StageService;

import java.util.Scanner;

public class Game {
    private static int player_x;
    private static int player_y;
    private static boolean[][] box = null;
    private static boolean[][] boxArea = null;
    private static int boxCount;

    public Game() {
        player_x=0;
        player_y=0;
        box = new boolean[20][20];
        boxArea = new boolean[20][20];
        boxCount = 0;
    }

    public void startGame(StageService ss,int stageNum) {
        Scanner sc = new Scanner(System.in);
        Stage stage = ss.selectStage(stageNum);
        char[][] stageMap = stage.getStageMap();
        for(int i=0;i<20;i++){
            box[i] = stage.getBox()[i].clone();
            boxArea[i] = stage.getBoxArea()[i].clone();
        }
        player_x = stage.getPlayerXAxis();
        player_y = stage.getPlayerYAxis();
        boxCount = stage.getBoxCount();

        while (true) {
            clearConsole();
            if(drawMap(stageMap)) break;
            String s = sc.nextLine();
            movePlayer(s, stageMap);
            /*
             * ● : 상자
             * ○ : 목적지
             * ■ : 벽
             * ◎ : 목적지에 도착한 상자
             * ⊙ : 플레이어
             * */
        }
        asciiStageClear();

    }

    private static boolean drawMap(char[][] stageMap) {
        int cnt=0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i == player_x && j == player_y) System.out.print('⊙');
                else if (boxArea[i][j]) {
                    if (box[i][j]) {
                        System.out.print('◎');
                        cnt++;
                    }
                    else System.out.print('○');
                } else if (box[i][j]) System.out.print('●');
                else System.out.print(stageMap[i][j]);
            }
            System.out.println();
        }
        if(boxCount==cnt)return true;
        return false;
    }

    private void movePlayer(String s, char[][] stageMap) {
        switch (s) {
            case "w":
                if (checkMoveableX(stageMap, -1)) {
                    player_x = player_x - 1;
                }
                break;
            case "a":
                if (checkMoveableY(stageMap, -1)) {
                    player_y = player_y - 1;
                }
                break;
            case "s":
                if (checkMoveableX(stageMap, 1)) {
                    player_x = player_x + 1;
                }
                break;
            case "d":
                if (checkMoveableY(stageMap, 1)) {
                    player_y = player_y + 1;
                }
                break;
            default:
                System.out.println("잘못된 입력");
        }
    }
    
    private boolean checkMoveableX(char[][] stageMap, int playerDisx) {
        if (stageMap[player_x + playerDisx][player_y] == '■') return false;
        else if (box[player_x + playerDisx][player_y]) {
            if (!box[player_x + playerDisx + playerDisx][player_y] && (stageMap[player_x + playerDisx + playerDisx][player_y] == ' ' ||
                    boxArea[player_x + playerDisx + playerDisx][player_y])) {
                box[player_x + playerDisx][player_y] = false;
                box[player_x + playerDisx + playerDisx][player_y] = true;
                return true;
            } else return false;
        } else return true;
    }

    private boolean checkMoveableY(char[][] stageMap, int playerDisy) {
        if (stageMap[player_x][player_y + playerDisy] == '■') return false;
        else if (box[player_x][player_y + playerDisy]) {
            if (!box[player_x][player_y + playerDisy + playerDisy] && (stageMap[player_x][player_y + playerDisy + playerDisy] == ' ' ||
                    boxArea[player_x][player_y + playerDisy + playerDisy])) {
                box[player_x][player_y + playerDisy] = false;
                box[player_x][player_y + playerDisy + playerDisy] = true;
                return true;
            } else return false;
        } else return true;
    }

    private void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    void asciiStageClear(){
        System.out.println("    _____  _____   ___   _____  _____ \n" +
                "   /  ___||_   _| / _ \\ |  __ \\|  ___|\n" +
                "   \\ `--.   | |  / /_\\ \\| |  \\/| |__  \n" +
                "    `--. \\  | |  |  _  || | __ |  __| \n" +
                "   /\\__/ /  | |  | | | || |_\\ \\| |___ \n" +
                "   \\____/   \\_/  \\_| |_/ \\____/\\____/ \n" +
                "                                   ");
        System.out.println(" _____  _      _____   ___  ______  _  _ \n" +
                "/  __ \\| |    |  ___| / _ \\ | ___ \\| || |\n" +
                "| /  \\/| |    | |__  / /_\\ \\| |_/ /| || |\n" +
                "| |    | |    |  __| |  _  ||    / | || |\n" +
                "| \\__/\\| |____| |___ | | | || |\\ \\ |_||_|\n" +
                " \\____/\\_____/\\____/ \\_| |_/\\_| \\_|(_)(_)");
    }

}
