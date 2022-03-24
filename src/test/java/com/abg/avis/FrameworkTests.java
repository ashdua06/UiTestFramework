package com.abg.avis;


import com.abg.pages.Homepage;
import com.avis.core.TestBase;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.abg.constants.ABGConstants.QA_URL;
import static org.testng.Assert.assertTrue;

/**
 * Class to test the framework
 *
 * @author ikumar
 */
public class FrameworkTests extends TestBase {
    @DataProvider
    public Object[] getTestDataHomePage1(){
        Object[] data=new Object[2];
        data[0]="Validate Payment using Visa";
        data[1]="Validate Payment using MasterCard";
        return data;
    }


   @Test(dataProvider = "getTestDataHomePage1")
    public void verifyAvisPaymentMethods(String description) {
       // launchUrl(QA_URL);
       launchUrlWithContainer(QA_URL);
       Homepage homePage = new Homepage(getDriver());
       Assert.assertTrue(homePage.isAvisPreferredTabDisplayed(),"Avis preferred tab is not displayed");
    }

    @DataProvider
    public Object[][] getTestDataHomePage2(){
        Object[][] data=new Object[2][2];
        data[0][0]="Validate Avis Home Page";
        data[0][1]="JIRA 1234";
        data[1][0]="Validate Avis Home Page2";
        data[1][1]="JIRA 4321";
        return data;
    }
    @Test(dataProvider = "getTestDataHomePage2")
    public void verifyAvisHomepage(String description, String jiraId) {
        launchUrl(QA_URL);
        Homepage homePage = new Homepage(getDriver());
        Assert.assertTrue(homePage.isAvisPreferredTabDisplayed(),"Avis preferred tab is not displayed");
    }

    @DataProvider
    public Object[] getTestDataHomePage3(){
        Object[] data=new Object[1];
        data[0]="Validate driver insurance";
        return data;
    }
    @Test(dataProvider = "getTestDataHomePage3")
    public void verifyAvisDriversInsurance(String description) {
        launchUrl(QA_URL);
        Homepage homePage = new Homepage(getDriver());
        Assert.assertFalse(homePage.isAvisPreferredTabDisplayed(),"Avis preferred tab is not displayed");
    }

}
