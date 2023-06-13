package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class ApplicationManager {
  public WebDriver wd;


  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper ;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private String browser;

  public ApplicationManager(String browser) {

    this.browser = browser;
  }

  public void init() {
    if (browser.equals(Browser.CHROME.browserName())) { wd = new ChromeDriver();}
      else if (browser.equals(Browser.FIREFOX.browserName())) { wd = new FirefoxDriver();}
      else if (browser.equals(Browser.SAFARI.browserName())) { wd = new SafariDriver();};
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    wd.get("http://localhost/addressbook/index.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }


  public ContactHelper contact() {
    return contactHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }
}
