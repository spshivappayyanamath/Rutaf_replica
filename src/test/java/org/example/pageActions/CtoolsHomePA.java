package org.example.pageActions;

import org.example.pageObjects.CtoolsHomePO;
import org.example.utils.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CtoolsHomePA {
    private CtoolsHomePO ctoolsHomePO;
    private WebDriver driver;
    public CtoolsHomePA(){

        ctoolsHomePO= new CtoolsHomePO();
        PageFactory.initElements(HelperClass.getDriver(), ctoolsHomePO);
    }

    public String getHomeHeader(){
        return ctoolsHomePO.homeheader.getText().trim();
    }

    public void usernameClk(){
//        HelperClass.setExplicitWait();
        HelperClass.getJavascriptExecutor().executeScript("arguments[0].click();", HelperClass.getDriver().findElement(By.className("dropdown-toggle")));
//        HelperClass.webDriverImplicitWait();
//        ctoolsHomePO.userbutton.click();
    }
    public void logoutClk(){
//        HelperClass.setExplicitWait();
        ctoolsHomePO.logout.click();
    }


}
