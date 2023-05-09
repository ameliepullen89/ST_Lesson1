package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariTechPreviewDriverService;

import java.time.Duration;

public class ApplicationManager {
  public WebDriver wd;


  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper ;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private Browser browser;

  public ApplicationManager(Browser browser) {

    this.browser = browser;
  }

  public void init() {
    if (browser == Browser.CHROME) { wd = new ChromeDriver();}
      else if (browser == Browser.FIREFOX) { wd = new FirefoxDriver();}
      else if (browser == Browser.SAFARI) { wd = new SafariDriver();};
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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


  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
