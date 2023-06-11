package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().createContactPage();
      app.contact().create(new ContactData().withFirstName("Ka").withLastName("Prover").withHomeAddress("Revolution st. 44").withHomePhone("22-44").withMobilePhone("33-77").withWorkPhone("911"));
      app.goTo().homePage();
    }
  }



  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }





}
