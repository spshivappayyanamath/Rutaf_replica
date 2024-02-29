package org.example.pageActions;

import org.example.pageObjects.CtoolsLoginPO;
import org.example.utils.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CtoolsLoginPA {
    private CtoolsLoginPO ctoolsLoginPO;
    public CtoolsLoginPA(){
        this.ctoolsLoginPO= new CtoolsLoginPO();
        PageFactory.initElements(HelperClass.getDriver(), ctoolsLoginPO);
    }

    public void setEmail(String email){
        ctoolsLoginPO.email.sendKeys(email);
    }
    public void setPassword(String password){
        ctoolsLoginPO.password.sendKeys(password);
    }
    public void signClk(){
        ctoolsLoginPO.signin.click();
    }

    public String getPageTitle(){
        return HelperClass.getDriver().getTitle().trim();
    }

}
