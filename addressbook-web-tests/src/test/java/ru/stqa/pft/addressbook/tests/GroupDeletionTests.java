package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
  }


  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size()- 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.withOut(deletedGroup)));
    verifyGroupListInUI();



  }




}
