package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private  String firstName;
  private  String secondName;
  private  String lastName;
  private  String nickName;
  private  String job;
  private  String homeAddress;
  private  String homePhone;
  private  String mobilePhone;
  private  String workPhone;
  private  String faxPhone;
  private  String mainEmail;
  private  String spareEmail1;
  private  String spareEmail2;
  private  String websiteContact;
  private  String dayBirth;
  private  String monthBirth;
  private  String yearBirth;
  private  String dayAnniversary;
  private  String monthAnniversary;
  private  String yearAnniversary;
  private  String nameGroup;
  private  String secondaryAddress;
  private  String secondaryAddressPhone;
  private  String notes;



  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withSecondName(String secondName) {
    this.secondName = secondName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withJob(String job) {
    this.job = job;
    return this;
  }

  public ContactData withHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withFaxPhone(String faxPhone) {
    this.faxPhone = faxPhone;
    return this;
  }

  public ContactData withMainEmail(String mainEmail) {
    this.mainEmail = mainEmail;
    return this;
  }

  public ContactData withSpareEmail1(String spareEmail1) {
    this.spareEmail1 = spareEmail1;
    return this;
  }

  public ContactData withSpareEmail2(String spareEmail2) {
    this.spareEmail2 = spareEmail2;
    return this;
  }

  public ContactData withWebsiteContact(String websiteContact) {
    this.websiteContact = websiteContact;
    return this;
  }

  public ContactData withDayBirth(String dayBirth) {
    this.dayBirth = dayBirth;
    return this;
  }

  public ContactData withMonthBirth(String monthBirth) {
    this.monthBirth = monthBirth;
    return this;
  }

  public ContactData withYearBirth(String yearBirth) {
    this.yearBirth = yearBirth;
    return this;
  }

  public ContactData withDayAnniversary(String dayAnniversary) {
    this.dayAnniversary = dayAnniversary;
    return this;
  }

  public ContactData withMonthAnniversary(String monthAnniversary) {
    this.monthAnniversary = monthAnniversary;
    return this;
  }

  public ContactData withYearAnniversary(String yearAnniversary) {
    this.yearAnniversary = yearAnniversary;
    return this;
  }

  public ContactData withNameGroup(String nameGroup) {
    this.nameGroup = nameGroup;
    return this;
  }

  public ContactData withSecondaryAddress(String secondaryAddress) {
    this.secondaryAddress = secondaryAddress;
    return this;
  }

  public ContactData withSecondaryAddressPhone(String secondaryAddressPhone) {
    this.secondaryAddressPhone = secondaryAddressPhone;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
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


}
