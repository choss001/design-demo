package com.example.demo.design_pattern_observer.three;

import com.example.demo.design_pattern_observer.two.Observer;
import com.example.demo.design_pattern_observer.two.ScoreRecord;

import java.util.Collections;
import java.util.List;

public class MinMaxView implements Observer {
  private com.example.demo.design_pattern_observer.two.ScoreRecord scoreRecord;

  public MinMaxView(ScoreRecord scoreRecord){
    this.scoreRecord = scoreRecord;
  }
  @Override
  public void update() {
   List<Integer> record = scoreRecord.getScoreRecord();
    displayMinMax(record);
  }

  private void displayMinMax(List<Integer> record) {
    int min = Collections.min(record, null);
    int max = Collections.max(record, null);
    System.out.println("Min: " + min + " Max: " + max);
  }
}
