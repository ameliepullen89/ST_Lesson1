package ru.stqa.pft.addressbook.model;

import java.io.File;
import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private String firstName;
  @Column(name = "middlename")
  private String secondName;
  @Expose
  @Column(name = "lastname")
  private String lastName;
  @Column(name = "nickname")
  private String nickName;
  @Column(name = "company")
  private String job;
  @Expose
  @Column(name = "address")
  private String homeAddress;
  @Expose
  @Column(name = "home", columnDefinition = "Text")
  private String homePhone;
  @Expose
  @Column(name = "mobile", columnDefinition = "Text")
  private String mobilePhone;
  @Expose
  @Column(name = "work", columnDefinition = "Text")
  private String workPhone;
  @Column(name = "fax")
  private String faxPhone;
  @Expose
  @Column(name = "email")
  private String mainEmail;
  @Column(name = "email2")
  private String spareEmail1;
  @Column(name = "email3")
  private String spareEmail2;
  @Column(name = "homepage")
  private String websiteContact;
  @XStreamOmitField
  transient private String dayBirth;
  @XStreamOmitField
  transient private String monthBirth;
  @XStreamOmitField
  transient private String yearBirth;
  @XStreamOmitField
  transient private String dayAnniversary;
  @XStreamOmitField transient
  private String monthAnniversary;
  @XStreamOmitField
  transient private String yearAnniversary;
  @Transient
  private String nameGroup;
  @Column(name = "address2")
  private String secondaryAddress;
  @Column(name = "phone2")
  private String secondaryAddressPhone;
  @Column(name = "notes")
  private String notes;
  @Transient
  private String allPhones;
  @Transient
  private String allEmails;
  @XStreamOmitField
  transient private File photo;
  @XStreamOmitField
  transient private String deprecated;



  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }


  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


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

  public File getPhoto() {
    return photo;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAllPhones() {
    return allPhones;
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

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (homeAddress != null ? !homeAddress.equals(that.homeAddress) : that.homeAddress != null) return false;
    if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
    if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
    return mainEmail != null ? mainEmail.equals(that.mainEmail) : that.mainEmail == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (mainEmail != null ? mainEmail.hashCode() : 0);
    return result;
  }
}
