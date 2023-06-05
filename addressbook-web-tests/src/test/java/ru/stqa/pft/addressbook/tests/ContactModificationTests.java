package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().createContactPage();
      app.contact().create(new ContactData().withFirstName("Sherlock").withLastName("Holmes").withHomeAddress("10-11 Northumberland Street, Westminster, London WC2N 5DB"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("Modi").withLastName("fication").withHomeAddress("10-11 Northumberland Street, Westminster, London WC2N 5DB");

    app.contact().modify(index, contact);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1,c2)-> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }




}
