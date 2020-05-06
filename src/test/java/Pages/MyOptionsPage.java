package Pages;

import Pages.WrapperOnInfoChangeAlert.InfoAlertWrapper;
import SourceClases.ElementUtils;
import com.codeborne.selenide.Selenide;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import sun.rmi.rmic.Main;

public class MyOptionsPage extends BasePage {
    private static final By MAIN_SETTINGS_BUTTON_LOCATOR
            = By.xpath(".//a[contains(@hrefattrs, 'st.cmd=userConfig&st._aid=UserSettingsMenu_userConfig')]");
    private static final By PERSONAL_DATA_FIELD_LOCATOR = By.xpath(".//div[text()= 'Личные данные']");
    private static final By HOME_PAGE_BUTTON_LOCATOR =
            By.xpath(".//a[contains(@hrefattrs, 'st.cmd=userPage&st._aid=NavMenu_User_CPage')]");

    public MyOptionsPage() {
        super();
    }

    @Override
    protected void check() {
        Assert.assertTrue("Main settings button invisible!!!",
                ElementUtils.isElementVisible(MAIN_SETTINGS_BUTTON_LOCATOR));
        Assert.assertTrue("Personal data field invisible!!!",
                ElementUtils.isElementVisible(PERSONAL_DATA_FIELD_LOCATOR));
        Assert.assertTrue("Home page button invisible!!!",
                ElementUtils.isElementVisible(HOME_PAGE_BUTTON_LOCATOR));
    }

    public boolean checkNameAndSurname(final @NotNull String name,final @NotNull String surname) {
        String actualIF = Selenide.$(HOME_PAGE_BUTTON_LOCATOR).text();
        String expectedStr = name + " " + surname;
        return actualIF.equals(expectedStr);
    }

    public void changeNameAndSurname(final @NotNull String newName,final @NotNull String newSurname) {
        Assert.assertTrue(ElementUtils.clickIfElementPresentAndVisible(MAIN_SETTINGS_BUTTON_LOCATOR));
        Assert.assertTrue(ElementUtils.clickIfElementPresentAndVisible(PERSONAL_DATA_FIELD_LOCATOR));
        InfoAlertWrapper infoAlertWrapper = new InfoAlertWrapper();
        infoAlertWrapper.changeName(newName);
        infoAlertWrapper.changeSurname(newSurname);
        infoAlertWrapper.exitAndSave();
    }
}
