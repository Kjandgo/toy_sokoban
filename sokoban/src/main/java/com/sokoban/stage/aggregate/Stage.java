package com.sokoban.stage.aggregate;

import java.io.Serializable;
import java.util.Arrays;

public class Stage implements Serializable {
    private int stageNo;
    private int[][] stageMap;

    public Stage() {
    }

    public Stage(int stageNo, int[][] stageMap) {
        this.stageNo = stageNo;
        this.stageMap = stageMap;
    }

    public int getStageNo() {
        return stageNo;
    }

    public void setStageNo(int stageNo) {
        this.stageNo = stageNo;
    }

    public int[][] getStageMap() {
        return stageMap;
    }

    public void setStageMap(int[][] stageMap) {
        this.stageMap = stageMap;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "stageNo=" + stageNo +
                ", stageMap=" + Arrays.toString(stageMap) +
                '}';
    }
}
