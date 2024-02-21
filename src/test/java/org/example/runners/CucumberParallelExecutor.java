package org.example.runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.BaseStepConfig;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class CucumberParallelExecutor extends AbstractTestNGCucumberTests {
    private static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass().getName());
    private BaseStepConfig baseStepConfig;
    public static String getTimeStamp(){
        DateFormat dateFormat= new SimpleDateFormat("MMddyyy_HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IOException {
        ExtentService.getInstance().setSystemInfo("OS Name", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("OS Version", System.getProperty("os.version"));
        ExtentService.getInstance().setSystemInfo("OS Architecture", System.getProperty("os.arch"));
        ExtentService.getInstance().setSystemInfo("OS Version", System.getProperty("os.version"));

        FileUtils.cleanDirectory( new File("./Reports"));
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("taskkill /F /IM chromedriver.exe");
        logger.info("cleaned chrome.exe from task manager");
//        logger.trace("meaas");
//        logger.debug("debugg");
//        logger.warn("warning");
//        logger.error("error");
//        logger.fatal("fatal");

    }
    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext iTestContext){
        baseStepConfig = new BaseStepConfig();
        baseStepConfig.onPrepare();
        System.out.println(System.currentTimeMillis());
        logger.info("Before TestNG starting");


    }
    @AfterClass(alwaysRun = true)
    public void afterAllCleanUp(){
//shutdown hooks
    }
    @AfterSuite(alwaysRun = true)
    public void generateReport(){
//    if(BaseStepConfig.getConfigprop().getProperty("testRailEnabale").equalsIgnoreCase("true")){

//        call testrail update
//        }
        System.out.println("exit");
    }




//    public static Properties getConfigprop(){
//        return BaseStepConfig.getConfigprop();
//    }

    public static void main(String args[]) throws IOException {
        new CucumberParallelExecutor().beforeSuite();
//        String url=BaseStepConfig.getConfigprop().getProperty("applicationName").toString();
//        System.out.println(url);

    }
}
