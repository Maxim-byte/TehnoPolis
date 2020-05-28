package Pages;

import SourceClases.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class UserPage extends BasePage {

    private static final String PROFILE_BOT_LINK = "https://ok.ru/profile/580370912164";
    private static final By ADD_FRIEND_BUTTON = By.xpath("//div[contains(@id, 'hook_Block_MainMenu')]" +
            "//a[contains(text(), 'Добавить')]");
    private static final By MENU_FRIEND_BUTTON = By.xpath("//div[contains(@id, 'hook_Block_MainMenu')]" +
            "//span[contains(text(), 'Запрос')]");
    private static final By MENU_FRIEND_END_FRIENDSHIP_BUTTON = By.xpath("//div[contains(@id, 'hook_Block_MainMenu')]//a[contains(text(), 'Отменить')]");

    UserPage() {
        super();
        open();
    }

    @Override
    protected void check() {
        /*
        nothing
        */
    }

    private void open() {
        WebDriver tmp = getWebDriver();
        tmp.get(PROFILE_BOT_LINK);
        setWebDriver(tmp);
    }

    public void addFriend() {
        if (!ElementUtils.isDisplayed(ADD_FRIEND_BUTTON)) {
            endFriend();
        }
        ElementUtils.click(ADD_FRIEND_BUTTON);
    }

    public void endFriend() {
        ElementUtils.click(MENU_FRIEND_BUTTON);
        ElementUtils.click(MENU_FRIEND_END_FRIENDSHIP_BUTTON);
    }
}
