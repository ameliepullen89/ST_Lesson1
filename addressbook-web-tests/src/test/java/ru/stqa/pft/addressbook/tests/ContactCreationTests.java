package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    List<ContactData> before = app.contact().list();
    app.goTo().createContactPage();
    ContactData contact = new ContactData().withFirstName("Who").withLastName("isAlice?").withHomeAddress("221b, Baker Street, London, NW1 6XE").withHomePhone("5510089").withSecondaryAddress("10-11 Northumberland Street, Westminster, London WC2N 5DB");
    app.contact().create(contact);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    assertEquals(after.size(),before.size()+1);



    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2)-> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }




}

