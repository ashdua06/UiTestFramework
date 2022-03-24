package com.abg.pages;
import com.avis.core.AbstractBasePage;
import com.avis.utils.ElementHelper;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * This class contains all the elements and actions performed on HomePage
 *
 * @author Himanshu Dua
 */
@Log4j2
public class Homepage extends AbstractBasePage {
    @FindBy(xpath = "//input[@id='PicLoc_value']")
    private WebElement pageHeaderTitle;

    @FindBy(xpath = "//li[contains(@class,\"mob-nav-menu\")]/a[text()='Avis Preferred']")
    private WebElement avisPreferredHeader;

    public Homepage(WebDriver driver) {
        super(driver);
    }

//    public AvisPreferredHeader clickAvisPreferredTab() {
//        log.info("Click Avis Preferred Tab on page header");
//        avisPreferredHeader.click();
//        return new AvisPreferredHeader(driver);
//    }


    public boolean isAvisPreferredTabDisplayed() {
        log.info("Verify Avis Preferred Tab displayed on page header");
        return new ElementHelper(avisPreferredHeader,"HomePage","Avis Preferred Header").isDisplayed();
    }

    @Override
    public void isOnPage() {
        log.info("Verify Home Page");
        waitForVisibilityOfElement(pageHeaderTitle);
    }
}
