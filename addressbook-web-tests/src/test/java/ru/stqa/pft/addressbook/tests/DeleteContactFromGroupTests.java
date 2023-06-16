package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.testng.Assert.assertTrue;

public class DeleteContactFromGroupTests extends TestBase{


  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().homePage();

    if (app.db().contacts().size() == 0) { //Проверка наличия контактов
      app.goTo().createContactPage();
      app.contact().create(new ContactData().withFirstName("Sherlock").withLastName("Holmes").withHomeAddress("10-11 Northumberland Street, Westminster, London WC2N 5DB"));
      app.goTo().homePage();
    }

    if (app.db().groups().size() == 0) { //Проверка наличия групп
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
      app.goTo().homePage();
    }


    if (app.db().contactWithGroups().size() == 0) { //Проверка наличия контакта с указанной группой
      ContactData before = app.db().contactWithoutGroup();
      Groups groups = app.db().groups();
      GroupData group = groups.iterator().next();
      app.goTo().homePage();
      app.contact().selectContactWithoutGroup(before);
      app.contact().selectGroup(group);
      app.contact().addContactToGroup();
    }
  }


  @Test
  public void testDeleteContactFromGroup() {
    ContactData before = app.db().contactWithGroup();
    GroupData group = before.getGroups().iterator().next();
    app.goTo().homePage();
    app.contact().getGroupData(group);
    app.contact().selectContact(before);
    app.contact().removeContactFromGroup();
    ContactData after = app.db().contactById(before.getId());
    assertTrue(after.getGroups().contains(group));
    verifyContactListInUI();
  }

}
