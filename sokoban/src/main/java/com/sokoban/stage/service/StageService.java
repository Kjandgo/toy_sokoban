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
        for(int i=0;i<currentStage.getBox().length;i++){
            for(int j=0;j<currentStage.getBox()[i].length;j++){
                if(currentStage.getBox()[i][j])
                System.out.print(i+", " +j + "   ");
            }
        }

        System.out.println("\n----------------");
        for(int i=0;i<currentStage.getBoxArea().length;i++){
            for(int j=0;j<currentStage.getBoxArea()[i].length;j++){
                if(currentStage.getBoxArea()[i][j])
                    System.out.print(i+", " +j + "   ");
            }
        }
            System.out.println();

        if(currentStage != null){
            return currentStage;
        }
        else{
            System.out.println("스테이지를 찾을 수 없습니다.");
            return null;
        }
    }
}
