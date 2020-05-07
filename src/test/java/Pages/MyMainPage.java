package Pages;

import SourceClases.ElementUtils;
import org.openqa.selenium.By;

public class MyMainPage extends BasePage {

    private static final By MY_HOME_PAGE_BUTTON_LOCATOR = By.xpath(".//a[contains(@data-l, 't,userPage')]");

    public MyMainPage() {
        super();
    }

    @Override
    protected void check() {
        ElementUtils.checkPresentAndVisibility("My home page button is invisible!!!", MY_HOME_PAGE_BUTTON_LOCATOR);
    }

    public MyHomePage openHomePage() {
        ElementUtils.click(MY_HOME_PAGE_BUTTON_LOCATOR);
        return new MyHomePage();
    }
}
