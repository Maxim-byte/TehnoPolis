package Pages;

import SourceClases.UtilitiesForElements;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class MyMainPage extends BasePage {

    private static final By MY_HOME_PAGE_BUTTON_LOCATOR = By.xpath(".//a[contains(@data-l, 't,userPage')]");

    public MyMainPage(SelenideDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue("My home page button is invisible!!!",
                UtilitiesForElements.isElementVisible(driver, MY_HOME_PAGE_BUTTON_LOCATOR));
    }

    public MyHomePage openHomePage() {
        assertTrue(UtilitiesForElements.clickIfElementPresentAndVisible(driver, MY_HOME_PAGE_BUTTON_LOCATOR));
        return new MyHomePage(driver);
    }
}
