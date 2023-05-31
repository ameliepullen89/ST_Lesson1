package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String secondName;
  private final String lastName;
  private final String nickName;
  private final String job;
  private final String homeAddress;
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String faxPhone;
  private final String mainEmail;
  private final String spareEmail1;
  private final String spareEmail2;
  private final String websiteContact;
  private final String dayBirth;
  private final String monthBirth;
  private final String yearBirth;
  private final String dayAnniversary;
  private final String monthAnniversary;
  private final String yearAnniversary;
  private final String nameGroup;
  private final String secondaryAddress;
  private final String secondaryAddressPhone;
  private final String notes;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public ContactData(String firstName, String secondName, String lastName, String nickName, String job, String homeAddress, String homePhone, String mobilePhone, String workPhone, String faxPhone, String mainEmail, String spareEmail1, String spareEmail2, String websiteContact, String dayBirth, String monthBirth, String yearBirth, String dayAnniversary, String monthAnniversary, String yearAnniversary, String nameGroup, String secondaryAddress, String secondaryAddressPhone, String notes) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.job = job;
    this.homeAddress = homeAddress;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.faxPhone = faxPhone;
    this.mainEmail = mainEmail;
    this.spareEmail1 = spareEmail1;
    this.spareEmail2 = spareEmail2;
    this.websiteContact = websiteContact;
    this.dayBirth = dayBirth;
    this.monthBirth = monthBirth;
    this.yearBirth = yearBirth;
    this.dayAnniversary = dayAnniversary;
    this.monthAnniversary = monthAnniversary;
    this.yearAnniversary = yearAnniversary;
    this.nameGroup = nameGroup;
    this.secondaryAddress = secondaryAddress;
    this.secondaryAddressPhone = secondaryAddressPhone;
    this.notes = notes;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getJob() {
    return job;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFaxPhone() {
    return faxPhone;
  }

  public String getMainEmail() {
    return mainEmail;
  }

  public String getSpareEmail1() {
    return spareEmail1;
  }

  public String getSpareEmail2() {
    return spareEmail2;
  }

  public String getWebsiteContact() {
    return websiteContact;
  }

  public String getDayBirth() {
    return dayBirth;
  }

  public String getMonthBirth() {
    return monthBirth;
  }

  public String getYearBirth() {
    return yearBirth;
  }

  public String getDayAnniversary() {
    return dayAnniversary;
  }

  public String getMonthAnniversary() {
    return monthAnniversary;
  }

  public String getYearAnniversary() {
    return yearAnniversary;
  }

  public String getNameGroup() {
    return nameGroup;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getSecondaryAddressPhone() {
    return secondaryAddressPhone;
  }

  public String getNotes() {
    return notes;
  }
}
