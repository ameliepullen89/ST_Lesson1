package ru.stqa.ptf.sandbox;

public class Point {
  public double p1x;
  public double p1y;
  public double p2x;
  public double p2y;


  public Point(double p1x,double p1y, double p2x, double p2y){
    this.p1x = p1x;
    this.p1y = p1y;
    this.p2x = p2x;
    this.p2y = p2y;
  }

  public double distanse() {
    return Math.sqrt(((this.p2x-this.p1x) * (this.p2x-this.p1x))+((this.p2y-this.p1y) * (this.p2y-this.p1y)));
  }
}
