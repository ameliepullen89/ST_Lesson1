package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().createContactPage();
    File photo = new File("src/test/resources/pyx.jpeg");
    ContactData contact = new ContactData().withFirstName("11").withLastName("1111").withHomeAddress("221b, Baker Street, London, NW1 6XE").withHomePhone("5510089").withPhoto(photo);
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream()
             .mapToInt((g) -> g.getId()).max().getAsInt()))));

  }




}

