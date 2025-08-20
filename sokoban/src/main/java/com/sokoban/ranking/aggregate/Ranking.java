package com.sokoban.ranking.aggregate;

import java.io.Serializable;

public class Ranking implements Serializable {
    private int rankingNo;
    private String name;
    private int highestStageNo;

    public Ranking() {
    }

    public Ranking(int rankingNo, String name, int highestStageNo) {
        this.rankingNo = rankingNo;
        this.name = name;
        this.highestStageNo = highestStageNo;
    }

    public int getRankingNo() {
        return rankingNo;
    }

    public void setRankingNo(int rankingNo) {
        this.rankingNo = rankingNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighestStageNo() {
        return highestStageNo;
    }

    public void setHighestStageNo(int highestStageNo) {
        this.highestStageNo = highestStageNo;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "rankingNo=" + rankingNo +
                ", name='" + name + '\'' +
                ", highestStageNo=" + highestStageNo +
                '}';
    }
}
