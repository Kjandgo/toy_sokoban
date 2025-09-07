package com.sokoban.gameplay;

import com.sokoban.stage.aggregate.Stage;
import com.sokoban.stage.service.StageService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Game extends JFrame implements KeyListener {
    private static int player_x;
    private static int player_y;
    private static boolean[][] box = null;
    private static boolean[][] boxArea = null;
    private static int boxCount;
    private static int moveCount = 0;
    private boolean clearFlag = false;
    private JTextArea ta;

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


//        setSize(1,1);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ta = new JTextArea();
//        setLayout(new BorderLayout());
//        add(ta);
//        setVisible(true);
//        ta.addKeyListener(this);      // 키입력 비동기 처리 넘모 어렵구욘

        while (true) {
            clearConsole();
            if(clearFlag = drawMap(stageMap)) break;
            System.out.println("상, 하, 좌, 우 : w, a, s ,d / 포기하기 : q              이동횟수 : " + moveCount);
            String s = sc.nextLine();
            if("q".equals(s)) break;
            movePlayer(s, stageMap);
            /*
             * ● : 상자
             * ○ : 목적지
             * ■ : 벽
             * ◎ : 목적지에 도착한 상자
             * ⊙ : 플레이어
             * */
        }
        if(clearFlag)asciiStageClear();
        else asciiStageFailed();
        System.out.println("총 이동횟수 : " + moveCount);

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
                    moveCount++;
                }
                break;
            case "a":
                if (checkMoveableY(stageMap, -1)) {
                    player_y = player_y - 1;
                    moveCount++;
                }
                break;
            case "s":
                if (checkMoveableX(stageMap, 1)) {
                    player_x = player_x + 1;
                    moveCount++;
                }
                break;
            case "d":
                if (checkMoveableY(stageMap, 1)) {
                    player_y = player_y + 1;
                    moveCount++;
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

    void asciiStageFailed(){
        System.out.println("    _____  _____   ___   _____  _____ \n" +
                "   /  ___||_   _| / _ \\ |  __ \\|  ___|\n" +
                "   \\ `--.   | |  / /_\\ \\| |  \\/| |__  \n" +
                "    `--. \\  | |  |  _  || | __ |  __| \n" +
                "   /\\__/ /  | |  | | | || |_\\ \\| |___ \n" +
                "   \\____/   \\_/  \\_| |_/ \\____/\\____/ \n" +
                "                                   ");
        System.out.println("______   ___   _____  _      _____ ______  _  _ \n" +
                "|  ___| / _ \\ |_   _|| |    |  ___||  _  \\| || |\n" +
                "| |_   / /_\\ \\  | |  | |    | |__  | | | || || |\n" +
                "|  _|  |  _  |  | |  | |    |  __| | | | || || |\n" +
                "| |    | | | | _| |_ | |____| |___ | |/ / |_||_|\n" +
                "\\_|    \\_| |_/ \\___/ \\_____/\\____/ |___/  (_)(_)\n" +
                "                                                ");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyCode: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("위쪽 화살표 누름");

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("아래쪽 화살표 누름");

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("왼쪽 화살표 누름");

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("오른쪽 화살표 누름");

        }
    }
}
