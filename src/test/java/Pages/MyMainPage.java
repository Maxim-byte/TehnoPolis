package Pages;

import SourceClases.ElementUtils;
import com.codeborne.selenide.SelenideDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyMainPage extends BasePage {

    private static final By MY_HOME_PAGE_BUTTON_LOCATOR = By.xpath(".//a[contains(@data-l, 't,userPage')]");

    public MyMainPage() {
        super();
    }

    @Override
    protected void check() {
        Assert.assertTrue("My home page button is invisible!!!",
                ElementUtils.isElementVisible(MY_HOME_PAGE_BUTTON_LOCATOR));
    }

    public MyHomePage openHomePage() {
        Assert.assertTrue(ElementUtils.clickIfElementPresentAndVisible(MY_HOME_PAGE_BUTTON_LOCATOR));
        return new MyHomePage();
    }
}
