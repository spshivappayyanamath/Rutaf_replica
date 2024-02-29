package org.example.stepDefinations;

import com.aventstack.extentreports.reporter.FileUtil;
import org.apache.commons.io.FileUtils;
import org.example.utils.HelperClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public static void setUp() {
        HelperClass.setUpDriver();
    }

    @After
    public static void tearDown(Scenario scenario) {

        //validate if scenario has failed
//        if(scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }

        try {
            if(scenario.isFailed()) {
                File screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("./Reports/ScreenShotsFiles/" + scenario.getName() + ".jpg"));
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        HelperClass.tearDown();
    }
}