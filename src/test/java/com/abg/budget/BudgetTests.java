package com.abg.budget;

import com.abg.pages.Homepage;
import com.avis.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.abg.constants.ABGConstants.QA_URL;

public class BudgetTests extends TestBase {
    @DataProvider
    public Object[] getTestDataHomePage1(){
        Object[] data=new Object[2];
        data[0]="Validate Payment using Visa";
        data[1]="Validate Payment using MasterCard";
        return data;
    }
    @Test(dataProvider = "getTestDataHomePage1")
    public void verifyBudgetPaymentMethods(String description) {
        launchUrl(QA_URL);
        Homepage homePage = new Homepage(getDriver());
        Assert.assertTrue(homePage.isAvisPreferredTabDisplayed(),"Avis preferred tab is not displayed");
    }

    @DataProvider
    public Object[] getTestDataHomePage2(){
        Object[] data=new Object[1];
        data[0]="Validate Avis Home Page";
        return data;
    }
    @Test(dataProvider = "getTestDataHomePage2")
    public void verifyBudgetHomepage(String description) {
        launchUrl(QA_URL);
        Homepage homePage = new Homepage(getDriver());
        Assert.assertTrue(homePage.isAvisPreferredTabDisplayed(),"Avis preferred tab is not displayed");
    }


}
