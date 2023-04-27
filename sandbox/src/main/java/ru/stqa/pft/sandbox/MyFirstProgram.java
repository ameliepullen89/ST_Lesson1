package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Alice");
    hello("guys");
    hello("world");

    Square s = new Square(5.5);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

    Rectangle r = new Rectangle(7.2, 5.8);
    System.out.println("Площадь прямоугольника со сторонами  " + r.a + " и " + r.b + " равна " + r.areap());

  }

  public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "! How are you?");
  }

}


