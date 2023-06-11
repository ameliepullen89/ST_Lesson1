package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().createContactPage();
    ContactData contact = new ContactData().withFirstName("Who").withLastName("isAlice?").withHomeAddress("221b, Baker Street, London, NW1 6XE").withHomePhone("5510089").withSecondaryAddress("10-11 Northumberland Street, Westminster, London WC2N 5DB");
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }




}

