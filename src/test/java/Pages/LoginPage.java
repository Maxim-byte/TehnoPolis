package Pages;

import SourceClases.Bot;
import SourceClases.UtilitiesForElements;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
    private static final By BUTTON_LOCATOR = By.xpath(".//input[contains(@data-l, 't,sign_in')]");
    private static final By EMAIL_LOCATOR = By.name("st.email");
    private static final By PASSWORD_LOCATOR = By.name("st.password");

    public LoginPage(SelenideDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue("Button invisible or presented!!!", UtilitiesForElements.isElementVisible(driver, BUTTON_LOCATOR));
        assertTrue("Email field invisible or not presented!!!", UtilitiesForElements.isElementVisible(driver, BUTTON_LOCATOR));
        assertTrue("Password field invisible or not presented!!!", UtilitiesForElements.isElementVisible(driver, BUTTON_LOCATOR));
    }

    public MyMainPage doLogin(final Bot testBot) {
        assertTrue(UtilitiesForElements.sendKeysIfElementPresentAndVisible(driver, EMAIL_LOCATOR, testBot.username));
        assertTrue(UtilitiesForElements.sendKeysIfElementPresentAndVisible(driver, PASSWORD_LOCATOR, testBot.password));
        assertTrue(UtilitiesForElements.clickIfElementPresentAndVisible(driver, BUTTON_LOCATOR));
        return new MyMainPage(driver);
    }
}
