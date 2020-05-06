package Pages;

import SourceClases.Bot;
import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private static final By BUTTON_LOCATOR = By.xpath(".//input[contains(@data-l, 't,sign_in')]");
    private static final By EMAIL_LOCATOR = By.name("st.email");
    private static final By PASSWORD_LOCATOR = By.name("st.password");

    public LoginPage() {
        super();
    }

    @Override
    protected void check() {
        Assert.assertTrue("Button invisible or presented!!!", ElementUtils.isElementVisible(BUTTON_LOCATOR));
        Assert.assertTrue("Email field invisible or not presented!!!", ElementUtils.isElementVisible(BUTTON_LOCATOR));
        Assert.assertTrue("Password field invisible or not presented!!!", ElementUtils.isElementVisible(BUTTON_LOCATOR));
    }

    public MyMainPage doLogin(final @NotNull String username, final @NotNull String password) {
        Assert.assertTrue(ElementUtils.sendKeysIfElementPresentAndVisible(EMAIL_LOCATOR, username));
        Assert.assertTrue(ElementUtils.sendKeysIfElementPresentAndVisible(PASSWORD_LOCATOR, password));
        Assert.assertTrue(ElementUtils.clickIfElementPresentAndVisible(BUTTON_LOCATOR));
        return new MyMainPage();
    }
}
