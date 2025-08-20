package com.sokoban.ranking.service;

import com.sokoban.ranking.aggregate.Ranking;
import com.sokoban.ranking.repository.RankingRepository;

import java.util.ArrayList;

public class RankingService {
    private final RankingRepository rankingRepository = new RankingRepository();

    public RankingService() {}

    public void findRankingList() {
        ArrayList<Ranking> rankingList = rankingRepository.findRankingList();
        for(Ranking ranking :rankingList){
            System.out.println(ranking.getRankingNo() + ". " + ranking.getName() + " / 점수 : " + ranking.getHighestStageNo());
        }
    }
}
