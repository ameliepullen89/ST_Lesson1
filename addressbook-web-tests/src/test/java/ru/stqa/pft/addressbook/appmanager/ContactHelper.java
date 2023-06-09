package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getSecondName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("company"), contactData.getJob());
    type(By.name("address"), contactData.getHomeAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFaxPhone());
    type(By.name("email"), contactData.getMainEmail());
    type(By.name("email2"), contactData.getSpareEmail1());
    type(By.name("email3"), contactData.getSpareEmail2());
    type(By.name("homepage"), contactData.getWebsiteContact());
    type2(By.name("bday"), contactData.getDayBirth());
    type2(By.name("bmonth"), contactData.getMonthBirth());
    type(By.name("byear"), contactData.getYearBirth());
    type2(By.name("aday"), contactData.getDayAnniversary());
    type2(By.name("amonth"), contactData.getMonthAnniversary());
    type(By.name("ayear"), contactData.getYearAnniversary());
    if (creation) {
      type2(By.name("new_group"), contactData.getNameGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    ;
    type(By.name("address2"), contactData.getSecondaryAddress());
    type(By.name("phone2"), contactData.getSecondaryAddressPhone());
    type(By.name("notes"), contactData.getNotes());
  }



  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeDeleteContactAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id="+ id + "']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }


  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;

  }

  public void modify(ContactData contact)  {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    closeDeleteContactAlert();

  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
    for (WebElement element : elements) {
      List<WebElement> elementstd = element.findElements(By.cssSelector("td"));
      String firstname = elementstd.get(2).getText();
      String lastname = elementstd.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));

    }
    return new Contacts(contactCache);
  }


}
