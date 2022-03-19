package com.example.demo.design_pattern_observer.three;

import com.example.demo.design_pattern_observer.two.Subject;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord extends Subject {
  private List<Integer> scores = new ArrayList<Integer>();

  public void addScroe(int score){
    scores.add(score);
    notifyObservers();
  }

  public List<Integer> getScoreRecord(){
    return scores;
  }
}
