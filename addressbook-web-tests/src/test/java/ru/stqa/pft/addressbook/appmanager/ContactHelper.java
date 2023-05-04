package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstName());
    type(By.name("middlename"),contactData.getSecondName() );
    type(By.name("lastname"),contactData.getLastName() );
    type(By.name("nickname"),contactData.getNickName() );
    type(By.name("company"),contactData.getJob());
    type(By.name("address"), contactData.getHomeAddress());
    type(By.name("home"),contactData.getHomePhone());
    type(By.name("mobile"),contactData.getMobilePhone() );
    type(By.name("work"),contactData.getWorkPhone() );
    type(By.name("fax"),contactData.getFaxPhone() );
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
    type2(By.name("new_group"), contactData.getNameGroup());
    type(By.name("address2"), contactData.getSecondaryAddress());
    type(By.name("phone2"), contactData.getSecondaryAddressPhone());
    type(By.name("notes"), contactData.getNotes());
  }



}
