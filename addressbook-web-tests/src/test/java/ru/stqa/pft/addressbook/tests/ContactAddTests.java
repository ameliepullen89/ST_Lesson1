package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;


public class ContactAddTests extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddContactPage();
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"Who", "is", "Alice", "", "", "221b, Baker Street, London, NW1 6XE", "5510089", "", "", "", "", "", "", "", "-", "-", "", "-", "-", "", null, "10-11 Northumberland Street, Westminster, London WC2N 5DB", "", "");
    app.getContactHelper().createContact(contact);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);
    app.getSessionHelper().logout();


    int max = 0;
    for (ContactData c:after){
      if (c.getId() > max){
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

  }


}

