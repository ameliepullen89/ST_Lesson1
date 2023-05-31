package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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


  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeDeleteContactAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }


  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    fillContactForm(contact, true);
    submitContactCreation();

  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
    for (WebElement element : elements) {
      List<WebElement> elementstd = element.findElements(By.cssSelector("td"));
      String firstname = elementstd.get(2).getText();
      String lastname = elementstd.get(1).getText();
      ContactData contact = new ContactData(firstname, null, lastname, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
      contacts.add(contact);

    }
    return contacts;
  }
}
