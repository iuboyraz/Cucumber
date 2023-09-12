package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before(){
        // System.out.println("Senaryo baþladý mý?");
    }

    @After
    public void after(){
        // System.out.println("Senaryo bitti mi?");
        // doðru çalýþýrsa quit'i çaðýracaðýz.
        GWD.quitDriver(); // driver'ý kapattýk.
    }
}
