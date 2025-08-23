package com.sokoban.stage.service;

import com.sokoban.stage.aggregate.Stage;
import com.sokoban.stage.repository.StageRepository;

public class StageService {
    private final StageRepository stageRepository = new StageRepository();

    public StageService() {
    }

    public void insertStage(){
        stageRepository.insertStage();
    }

    public Stage selectStage(int stageNumber){
        Stage currentStage = stageRepository.selectStage(stageNumber);

        if(currentStage != null){
            return currentStage;
        }
        else{
            System.out.println("스테이지를 찾을 수 없습니다.");
            return null;
        }
    }
}
