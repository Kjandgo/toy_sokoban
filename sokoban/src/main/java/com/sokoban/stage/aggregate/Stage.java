package com.sokoban.stage.aggregate;

import java.io.Serializable;
import java.util.Arrays;

public class Stage implements Serializable {
    private int stageNo;
    private char[][] stageMap;
    private boolean[][] box;
    private boolean[][] boxArea;
    private int playerXAxis;
    private int playerYAxis;
    private int boxCount;


    public Stage() {
    }

    public Stage(int stageNo, char[][] stageMap, boolean[][] box, boolean[][] boxArea, int playerXAxis, int playerYAxis, int boxCount) {
        this.stageNo = stageNo;
        this.stageMap = stageMap;
        this.box = box;
        this.boxArea = boxArea;
        this.playerXAxis = playerXAxis;
        this.playerYAxis = playerYAxis;
        this.boxCount = boxCount;
    }

    public int getStageNo() {
        return stageNo;
    }

    public void setStageNo(int stageNo) {
        this.stageNo = stageNo;
    }

    public char[][] getStageMap() {
        return stageMap;
    }

    public void setStageMap(char[][] stageMap) {
        this.stageMap = stageMap;
    }

    public boolean[][] getBox() {
        return box;
    }

    public void setBox(boolean[][] box) {
        this.box = box;
    }

    public boolean[][] getBoxArea() {
        return boxArea;
    }

    public void setBoxArea(boolean[][] boxArea) {
        this.boxArea = boxArea;
    }

    public int getPlayerXAxis() {
        return playerXAxis;
    }

    public void setPlayerXAxis(int playerXAxis) {
        this.playerXAxis = playerXAxis;
    }

    public int getPlayerYAxis() {
        return playerYAxis;
    }

    public void setPlayerYAxis(int playerYAxis) {
        this.playerYAxis = playerYAxis;
    }

    public int getBoxCount() {
        return boxCount;
    }

    public void setBoxCount(int boxCount) {
        this.boxCount = boxCount;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "stageNo=" + stageNo +
                ", stageMap=" + Arrays.toString(stageMap) +
                ", box=" + Arrays.toString(box) +
                ", boxArea=" + Arrays.toString(boxArea) +
                ", playerXAxis=" + playerXAxis +
                ", playerYAxis=" + playerYAxis +
                ", boxCount=" + boxCount +
                '}';
    }
}
