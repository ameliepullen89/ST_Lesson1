package ru.stqa.pft.sandbox;

public class DistanceCalculation {

public static void main (String[] args){


  Point p1 = new Point(6, 7);
  Point p2 = new Point(4, 11);
  System.out.println("Расстояние между точками равно "+ p1.distance(p2)); // было максимально неочевидно, что можно использовать вызов метода таким образом
}


}
