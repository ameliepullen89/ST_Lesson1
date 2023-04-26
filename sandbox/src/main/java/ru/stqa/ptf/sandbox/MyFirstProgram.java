package ru.stqa.ptf.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Alice");
    hello("guys");
    hello("world");

    double l = 5.5;
    System.out.println("Площадь квадрата со стороной " + l + " равна " + area(l));

    double a = 7.5;
    double b = 8.9;
    System.out.println("Площадь прямоугольника со сторонами  " + a + " и " + b + " равна " + areap(a, b));


  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "! How are you?");
  }

  public static double area(double len) {
    return len * len;
  }


  public static double areap(double a, double b) {
    return a * b;
  }


}


