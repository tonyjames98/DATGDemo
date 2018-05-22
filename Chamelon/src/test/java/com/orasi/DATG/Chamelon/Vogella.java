package com.orasi.DATG.Chamelon;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.orasi.DriverManager;
import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class Vogella extends WebBaseTest {
    private String application = "application";
    private String browserUnderTest = "firefox";
    private String browserVersion = "57";
    private String operatingSystem = "Win10";
    private String runLocation = "local";
    private String testingEnvironment = "stage";
    private String testingName = "TestEnvironment";
    private String pageURL = "http://www.vogella.com/";
    
    @Features("Utilities")
    @Stories("TestEnvironment")
    @Title("testStart")
    @Test(groups = "regression")
    public void testTestStart() {
        WebBaseTest te = new WebBaseTest(application, browserUnderTest, browserVersion, operatingSystem,
                runLocation, testingEnvironment);
        te.setPageURL(pageURL);
        te.testStart(testingName);
        while (DriverManager.getDriver().getTitle().isEmpty()) {
        }

        String title = DriverManager.getDriver().getTitle();
        DriverManager.quitDriver();
        Assert.assertTrue(title.equalsIgnoreCase("Eclipse, Android and Java training and support"));
        
    }

}