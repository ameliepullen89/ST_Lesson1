package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactAddTests extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoAddContactPage();
    app.getContactHelper().createContact(new ContactData("Sherlock2", "Garry2", "Holmes2", "Shelly2", "Adventure agency LLC", "221b, Baker Street, London, NW1 6XE", "5510089", "+300798983988", "2245678", "123", "sherlock_holmes@bk.ru", "shelly.holmes@rambler.ru", "shelly_sweet_pie@icloud.com", "www.ya.ru", "4", "March", "1871", "3", "November", "1805", "test1", "10-11 Northumberland Street, Westminster, London WC2N 5DB", "4578292", "Do not call after 11 pm"));
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before+1);
    app.getSessionHelper().logout();
  }


}

