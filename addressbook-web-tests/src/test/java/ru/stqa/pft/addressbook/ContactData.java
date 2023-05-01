package ru.stqa.pft.addressbook;

public record ContactData(String firstName, String secondName, String lastName, String nickName, String job,
                          String homeAddress, String homePhone, String mobilePhone, String workPhone, String faxPhone,
                          String mainEmail, String spareEmail1, String spareEmail2, String websiteContact,
                          String dayBirth, String monthBirth, String yearBirth, String dayAnniversary,
                          String monthAnniversary, String yearAnniversary, String nameGroup, String secondaryAddress,
                          String secondaryAddressPhone, String notes) {
}