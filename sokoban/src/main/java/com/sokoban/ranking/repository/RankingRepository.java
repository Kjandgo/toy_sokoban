package com.sokoban.ranking.repository;

import com.sokoban.ranking.aggregate.Ranking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class RankingRepository {
    private final ArrayList<Ranking> rankingList = new ArrayList<>();
    private final File file = new File("src/main/java/com/sokoban/ranking/db/rankingDB.dat");

    public RankingRepository() {
        if (!file.exists()) {
            ArrayList<Ranking> ranking = new ArrayList<>();
            for (int i = 1; i <= 50; i++) {
                ranking.add(new Ranking(i, "Nope", 51 - i));
            }
            setRanking(ranking);
        }
        getRanking();
    }

    private void setRanking(ArrayList<Ranking> rankingArr) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for(Ranking ranking:rankingArr){
                oos.writeObject(ranking);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void getRanking() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            while(true){
                rankingList.add((Ranking)ois.readObject());
            }
        } catch(EOFException e){
            System.out.println("getRanking");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally{
            try {
                if(ois!=null)ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Ranking> findRankingList() {
        ArrayList<Ranking> result = rankingList;
        Collections.sort(result);
        return result;
    }
}
