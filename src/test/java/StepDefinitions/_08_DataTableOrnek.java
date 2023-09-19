package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

public class _08_DataTableOrnek {

    @When("Write username {string}")
    public void writeUsername(String username) {
        System.out.println("username = " + username);
    }

    @And("Write username and password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("pasword = " + password);
    }

    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable usernames) {
        List<String> listUsernames = usernames.asList(String.class);

        for (String user : listUsernames){
            System.out.println("user = " + user);

            /*
            testNG de "dataProvider" / cucumber da "scenario outline" ayný iþleve sahiptir.
            Gönderilen her bir deðer için tüm senaryo çalýþýr.
            DataTable ise bir stepe (tüm senaryoyu çalýþtýrmadan) parametreyi göndermemizi saðlýyor.
             */

        }
    }

    @And("Write username an password as DataTable")
    public void writeUsernameAnPasswordAsDataTable(DataTable usernamesAndPasswords) {
      List<List<String>> listUsernamesAndPasswords =   usernamesAndPasswords.asLists(String.class);

        for (int i = 0; i < listUsernamesAndPasswords.size(); i++) {
            System.out.println("listUsernamesAndPasswords = " + listUsernamesAndPasswords.get(i).get(0)+" "+ // username
                                                                listUsernamesAndPasswords.get(i).get(1));    // password
        }
    }
}
