package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void before(){
        System.out.println("Driver starts...");
    }
    @After
    public void after(){
        GWD.quitDriver();
    }
}
