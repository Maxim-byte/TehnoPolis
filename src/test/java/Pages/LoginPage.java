package Pages;

import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
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
        ElementUtils.checkPresentAndVisibility("Button invisible or presented!!!", BUTTON_LOCATOR);
        ElementUtils.checkPresentAndVisibility("Email field invisible or not presented!!!", BUTTON_LOCATOR);
        ElementUtils.checkPresentAndVisibility("Password field invisible or not presented!!!", BUTTON_LOCATOR);
    }

    public MyMainPage doLogin(final @NotNull String username, final @NotNull String password) {
        ElementUtils.sendKeys(EMAIL_LOCATOR, username);
        ElementUtils.sendKeys(PASSWORD_LOCATOR, password);
        ElementUtils.click(BUTTON_LOCATOR);
        return new MyMainPage();
    }
}
