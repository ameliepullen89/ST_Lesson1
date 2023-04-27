package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest2 {


  @Test
  public void testDistance()     {
    Point p1 = new Point(6, 7);
    Point p2 = new Point(4, 11);
    Assert.assertEquals(p1.distance(p2), 4.48);
  }
}
