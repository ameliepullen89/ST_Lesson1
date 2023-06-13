package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().createContactPage();
      app.contact().create(new ContactData().withFirstName("Ka").withLastName("Prover")
              .withHomeAddress("Revolution st. 44").withHomePhone("22-44").withMobilePhone("33-77")
              .withWorkPhone("911").withMainEmail("raz@bk.ru").withSpareEmail1("dva@list.ru")
              .withSpareEmail2("tri@ya.ru"));
      app.goTo().homePage();
    }
  }


  @Test
  public void testContactPhones() throws Exception{
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(),equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(),equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getHomeAddress(), equalTo(cleanedAddress(contactInfoFromEditForm.getHomeAddress())));
}



  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals("")).map(ContactPhoneTests::cleanedPhone).collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getMainEmail(), contact.getSpareEmail1(), contact.getSpareEmail2())
            .stream().filter((s) -> ! s.equals("")).map(ContactPhoneTests::cleanedEmail).collect(Collectors.joining("\n"));
  }


  public static String cleanedPhone(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  public static String cleanedEmail(String email) {
    return email.replaceAll("\\s", "");
  }

  public static String cleanedAddress(String email) {
    return email.trim().replaceAll("\\s+", " ");
  }

}
