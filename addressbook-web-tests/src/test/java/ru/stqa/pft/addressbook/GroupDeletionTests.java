package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class GroupDeletionTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testGroupDeletion() throws Exception {
    wd.get("http://localhost/addressbook/edit.php");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
    wd.findElement(By.linkText("groups")).click();
    wd.get("http://localhost/addressbook/group.php");
    wd.findElement(By.xpath("//div[@id='content']/form/span[5]/input")).click();
    wd.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
    wd.findElement(By.linkText("group page")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
