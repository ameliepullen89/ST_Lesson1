package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if (app.db().contacts().size() == 0) {
      app.goTo().createContactPage();
      app.contact().create(new ContactData().withFirstName("Sherlock").withLastName("Holmes").withHomeAddress("10-11 Northumberland Street, Westminster, London WC2N 5DB"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(),equalTo(before.size()- 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(deletedContact)));
    verifyContactListInUI();

  }
}
