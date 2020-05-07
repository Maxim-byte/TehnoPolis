package Pages;

import Pages.WrapperOnInfoChangeAlert.InfoAlertWrapper;
import SourceClases.ElementUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

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
        ElementUtils.checkPresentAndVisibility("Main settings button invisible!!!", MAIN_SETTINGS_BUTTON_LOCATOR);
        ElementUtils.checkPresentAndVisibility("Personal data field invisible!!!", PERSONAL_DATA_FIELD_LOCATOR);
        ElementUtils.checkPresentAndVisibility("Home page button invisible!!!", HOME_PAGE_BUTTON_LOCATOR);
    }

    public boolean checkNameAndSurname(final @NotNull String name, final @NotNull String surname) {
        String actualIF = $(HOME_PAGE_BUTTON_LOCATOR).text();
        String expectedStr = name + " " + surname;
        return actualIF.equals(expectedStr);
    }

    //delete old name and surname and add new
    public void changeNameAndSurname(final @NotNull String newName, final @NotNull String newSurname) {
        ElementUtils.click(MAIN_SETTINGS_BUTTON_LOCATOR);
        ElementUtils.click(PERSONAL_DATA_FIELD_LOCATOR);
        InfoAlertWrapper infoAlertWrapper = new InfoAlertWrapper();
        infoAlertWrapper.changeName(newName);
        infoAlertWrapper.changeSurname(newSurname);
        infoAlertWrapper.exitAndSave();
    }
}
