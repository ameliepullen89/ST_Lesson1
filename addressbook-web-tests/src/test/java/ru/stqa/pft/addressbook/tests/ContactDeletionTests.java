package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

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
  public void testContactDeletion() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
      Assert.assertEquals(before, after);
  }


}
