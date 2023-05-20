package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "221b, Baker Street, London, NW1 6XE", "5510089", "", "", "", "", "", "", "", "-", "-", "", "-", "-", "", null, "10-11 Northumberland Street, Westminster, London WC2N 5DB", "", ""), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    app.getSessionHelper().logout();
  }




}
