package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before(){
        // System.out.println("Senaryo ba�lad� m�?");
    }

    @After
    public void after(){
        // System.out.println("Senaryo bitti mi?");
        // do�ru �al���rsa quit'i �a��raca��z.
        GWD.quitDriver(); // driver'� kapatt�k.
    }
}
