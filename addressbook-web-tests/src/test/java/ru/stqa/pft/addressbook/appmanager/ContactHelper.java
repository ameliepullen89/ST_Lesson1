package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getSecondName());
    type(By.name("lastname"), contactData.getLastName());
    attach(By.name("photo"), contactData.getPhoto());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("company"), contactData.getJob());
    type(By.name("address"), contactData.getHomeAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFaxPhone());
    type(By.name("email"), contactData.getMainEmail());
    type(By.name("email2"), contactData.getSpareEmail1());
    type(By.name("email3"), contactData.getSpareEmail2());
    type(By.name("homepage"), contactData.getWebsiteContact());
    type2(By.name("bday"), contactData.getDayBirth());
    type2(By.name("bmonth"), contactData.getMonthBirth());
    type(By.name("byear"), contactData.getYearBirth());
    type2(By.name("aday"), contactData.getDayAnniversary());
    type2(By.name("amonth"), contactData.getMonthAnniversary());
    type(By.name("ayear"), contactData.getYearAnniversary());
    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group")))
                .selectByVisibleText(contactData.getGroups().iterator().next().getName());}
    }
    else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    };
    type(By.name("address2"), contactData.getSecondaryAddress());
    type(By.name("phone2"), contactData.getSecondaryAddressPhone());
    type(By.name("notes"), contactData.getNotes());
  }



  public void selectContactById(int id) {
    wd.findElement(By.cssSelector(String.format("input[value='%s']", id))).click();
  }


  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeDeleteContactAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath(String.format("//a[@href='edit.php?id=%s']", id))).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }


  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact, boolean creation) {
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;

  }

  public void modify(ContactData contact)  {
    initContactModificationById(contact.getId());
    fillContactForm(contact, true);
    submitContactModification();
    contactCache = null;
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    closeDeleteContactAlert();

  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
    for (WebElement element : elements) {
      List<WebElement> elementstd = element.findElements(By.cssSelector("td"));
      String firstname = elementstd.get(2).getText();
      String lastname = elementstd.get(1).getText();
      String homeAddress = elementstd.get(3).getText();
      String allPhones = elementstd.get(5).getText();
      String allEmails = elementstd.get(4).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).
              withHomeAddress(homeAddress).withAllEmails(allEmails).withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homeph = wd.findElement(By.name("home")).getAttribute("value");
    String mobileph = wd.findElement(By.name("mobile")).getAttribute("value");
    String workph = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withHomePhone(homeph).withMobilePhone(mobileph).withHomeAddress(address).withMainEmail(email)
                    .withSpareEmail1(email2).withSpareEmail2(email3).withWorkPhone(workph);
  }

  public void selectGroup(Contacts contactData) {
    if (contactData.iterator().next().getGroups().size() > 1) {
      Assert.assertTrue(contactData.iterator().next().getGroups().size() == 1);
      new Select(wd.findElement(By.name("group"))).selectByVisibleText(contactData.iterator().next().getGroups().iterator().next().getName());
    }
  }

  public void selectGroup(GroupData group) {
    wd.findElement(By.xpath(String.format("//select[@name='to_group']/option[@value='%s']", group.getId()))).click();
  }

  public void selectContactWithoutGroup(ContactData contact) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText("[none]");
    click(By.xpath(String.format("//input[@type='checkbox']", contact.getId())));
  }

  public void selectContact(ContactData contact) {
    click(By.xpath(String.format("//input[@type='checkbox']", contact.getId())));
  }

  public void removeContactFromGroup() {
    click(By.name("remove"));
    contactCache = null;
  }

  public void getGroupData(GroupData groupData) {
    click(By.xpath(String.format("//select[@name='group']/option[text() = '%s']", groupData.getName())));;
  }


  public void addContactToGroup() {
    click(By.name("add"));
    contactCache = null;
  }

}


