package ru.stqa.ptf.sandbox;

public class DistanceCalculation {

public static void main (String[] args){


  Point p = new Point(6, 7, 4, 11);
  System.out.println("Расстояние между точками c координатами " + p.p1x + "," + p.p1y + " и " + p.p2x + "," + p.p2y + " равно "+ p.distanse());
}

}
