package com.sokoban.run;

import com.sokoban.ranking.service.RankingService;

public class RankingPage {
    public static void findRankingInfo(RankingService rs) {
        rs.findRankingList();
    }
}
