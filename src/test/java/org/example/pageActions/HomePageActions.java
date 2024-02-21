package org.example.pageActions;

import org.example.pageObjects.HomePageLocators;
import org.example.utils.HelperClass;
import org.openqa.selenium.support.PageFactory;

public class HomePageActions {

    HomePageLocators homePageLocators = null;

    public HomePageActions() {

        this.homePageLocators = new HomePageLocators();

        PageFactory.initElements(HelperClass.getDriver(),homePageLocators);
    }


    // Get the User name from Home Page
    public String getHomePageText() {
        return homePageLocators.homePageUserName.getText();
    }

}