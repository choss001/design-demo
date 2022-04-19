package com.example.demo.design_patter_decorate.one;

public class TrafficeDecorator extends DisplayDecorator{
  public TrafficeDecorator(Display decoratedDisplay) {
    super(decoratedDisplay);
  }

  public void draw() {
    super.draw();
    drawTraffic();
  }

  private void drawTraffic() {
    System.out.println("\t 교통량 표시");
  }
}
