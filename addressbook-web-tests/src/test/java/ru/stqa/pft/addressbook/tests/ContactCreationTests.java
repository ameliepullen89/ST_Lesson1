package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    Set<ContactData> before = app.contact().all();
    app.goTo().createContactPage();
    ContactData contact = new ContactData().withFirstName("Who").withLastName("isAlice?").withHomeAddress("221b, Baker Street, London, NW1 6XE").withHomePhone("5510089").withSecondaryAddress("10-11 Northumberland Street, Westminster, London WC2N 5DB");
    app.contact().create(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    assertEquals(after.size(),before.size()+1);



    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);

  }




}

