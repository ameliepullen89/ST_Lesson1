package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {

  @Test
  public void testDistance1()     {
  Point p1 = new Point(6, 7);
  Point p2 = new Point(4, 11);
    Assert.assertEquals(p1.distance(p2), 4.47213595499958);
}

  @Test
  public void testDistance2()     {
    Point p1 = new Point(6, 7);
    Point p2 = new Point(4, 11);
    Assert.assertEquals(p1.distance(p2), 4.48);
  }

  @Test
  public void testDistance3()     {
    Point p1 = new Point(6, 7);
    Point p2 = new Point(4, 11);
    Assert.assertEquals(p1.distance(p2), 4.47213595499957);
  }

  @Test
  public void testDistance4()     {
    Point p1 = new Point(6, 7);
    Point p2 = new Point(4, 11);
    Assert.assertEquals(p1.distance(p2), -5);
  }


}