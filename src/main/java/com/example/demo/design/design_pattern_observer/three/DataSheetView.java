package com.example.demo.design.design_pattern_observer.three;

import com.example.demo.design.design_pattern_observer.two.ScoreRecord;
import com.example.demo.design.design_pattern_observer.two.Observer;

import java.util.List;

public class DataSheetView implements Observer {
  private com.example.demo.design.design_pattern_observer.two.ScoreRecord scoreRecord;
  private int viewCount;

  public DataSheetView(ScoreRecord scoreRecord, int viewCount){
    this.scoreRecord = scoreRecord;
    this.viewCount = viewCount;
  }
  public void update() {
    List<Integer> record = scoreRecord.getScoreRecord();
    displayScores(record, viewCount);
  }

  private void displayScores(List<Integer> record, int viewCount) {
    System.out.println("List of " +viewCount + " entries: ");
    for (int i = 0; i < viewCount && i < record.size(); i++) {
      System.out.print(record.get(i) + " ");
    }
    System.out.println();
  }
}
