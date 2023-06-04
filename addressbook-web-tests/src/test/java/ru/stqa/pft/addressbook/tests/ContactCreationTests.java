package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    List<ContactData> before = app.contact().list();
    app.goTo().createContactPage();
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"Who", "is", "Alice", "", "", "221b, Baker Street, London, NW1 6XE", "5510089", "", "", "", "", "", "", "", "-", "-", "", "-", "-", "", null, "10-11 Northumberland Street, Westminster, London WC2N 5DB", "", "");
    app.contact().create(contact);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()+1);


    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2)-> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }




}
