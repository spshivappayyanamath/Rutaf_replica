package org.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        tags = "",
//        \src\test\resources\features
        features = {"src/test/resources/features/ctoolslogin.feature"},
        glue = {"org.example.stepDefinations"},
//        org\example\stepDefinations
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)

//public class CucumberRunnerTests extends CucumberParallelExecutor {

public class CucumberRunnerTests extends CucumberParallelExecutor {

}
