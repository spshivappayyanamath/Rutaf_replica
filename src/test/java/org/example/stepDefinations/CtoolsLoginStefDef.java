package org.example.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.pageActions.CtoolsHomePA;
import org.example.pageActions.CtoolsLoginPA;

import org.example.utils.HelperClass;
import org.testng.Assert;

public class CtoolsLoginStefDef {
    CtoolsLoginPA ctoolsLoginPA = new CtoolsLoginPA();
    CtoolsHomePA ctoolsHomePA = new CtoolsHomePA();

    @Given("navigate to ct login url")
    public void navigate_to_ct_login_url() {
        HelperClass.getDriver().get("https://contribute.refinitiv.com/");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        ctoolsLoginPA.setEmail("suresh.shivappayyanamath1@lseg.com");
        ctoolsLoginPA.setPassword("test1");
    }
    @When("user enters wrong {string} and {string}")
    public void user_enters_wrong_and(String string, String string2) {
        ctoolsLoginPA.setEmail("suresh.s@abc.com");
        ctoolsLoginPA.setPassword("1111");
    }

    @When("clicks on signin button")
    public void clicks_on_signin_button() {
        ctoolsLoginPA.signClk();
    }
    @Then("home page should show")
    public void home_page_should_show() {
        System.out.println(ctoolsHomePA.getHomeHeader());
        Assert.assertEquals(ctoolsHomePA.getHomeHeader(), "DEALS CONTRIBUTION TOOL");;
    }

    @When("click on username")
    public void click_on_username() {
        HelperClass.webDriverImplicitWait();
//        HelperClass.getJavascriptExecutor().executeScript("document")
        ctoolsHomePA.usernameClk();
    }
    @When("click on logout")
    public void click_on_logout() {
        HelperClass.webDriverImplicitWait();
        ctoolsHomePA.logoutClk();
    }
    @Then("login page should display")
    public void login_page_should_display() {
        Assert.assertEquals(ctoolsLoginPA.getPageTitle(),"Log in - Contribution Tool");
    }


}
