package Pages;

import SourceClases.UtilitiesForElements;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyHomePage extends BasePage {
    private static final By MORE_INFORMATION_LOCATOR = By.id("mctc_navMenuDropdownSec_otherSections");
    private static final By NOTES_BUTTON_LOCATOR = By.xpath(".//a[contains(@class, 'mctc_navMenuSec')]");
    private static final By ABOUT_MY_LOCATOR =
            By.xpath(".//li[contains(@class, 'mctc_navMenuDDLIL')]//a[contains(@hrefattrs, 'st.cmd=userProfile&st._aid=NavMenu_User_SelfProfile')]");
    private static final By STATUS_BUTTON_LOCATOR = By.className("text-field h-mod user-bio __mod-counter __placeholder");
    private static final By STATUS_TEXT_FIELD_LOCATOR
            = By.xpath(".//textarea[text()='Напишите что-нибудь интересное о себе']");
    private static final By SAVE_STATUS_BUTTON_LOCATOR = By.xpath(".//button[contains(@data-l, 't,textField-save')]");
    private static final By STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR = By.xpath(".//div[contains(@tsid, 'TextFieldText')]");

    public MyHomePage(SelenideDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue("Button more is not visible or not presented!!!",
                UtilitiesForElements.isElementVisible(driver, MORE_INFORMATION_LOCATOR));
        assertTrue("Button notes is not visible or not presented!!!",
                UtilitiesForElements.isElementVisible(driver, NOTES_BUTTON_LOCATOR));
        assertTrue("Status button locator is not visible or not presented!!!",
                UtilitiesForElements.isElementVisible(driver, STATUS_BUTTON_LOCATOR));
    }

    public MyInfoPage openInfoPage() {
        assertTrue(UtilitiesForElements.clickIfElementPresentAndVisible(driver, MORE_INFORMATION_LOCATOR));
        assertTrue("Button about me not visible or not presented!!!",
                UtilitiesForElements.isElementVisible(driver, ABOUT_MY_LOCATOR));
        assertTrue(UtilitiesForElements.clickIfElementPresentAndVisible(driver, ABOUT_MY_LOCATOR));
        return new MyInfoPage(driver);
    }

    public NotesPage openNotes() {
        assertTrue(UtilitiesForElements.clickIfElementPresentAndVisible(driver, NOTES_BUTTON_LOCATOR));
        return new NotesPage(driver);
    }

    public void changeStatus(String text) {
        assertTrue(UtilitiesForElements.clickIfElementPresentAndVisible(driver, STATUS_BUTTON_LOCATOR));
        assertTrue("Status text field is not visible or not presented!!!",
                UtilitiesForElements.sendKeysIfElementPresentAndVisible(driver, STATUS_TEXT_FIELD_LOCATOR, text));
        assertTrue("Status changing button invisible or not presented!!!",
                UtilitiesForElements.clickIfElementPresentAndVisible(driver, SAVE_STATUS_BUTTON_LOCATOR));
    }

    public void checkStatusChanging(String expectedText) {
        assertTrue("Status text field invisible or not present!!!",
                UtilitiesForElements.isElementVisible(driver, STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR));
        assertEquals(expectedText, UtilitiesForElements.find(driver, STATUS_TEXT_FIELD_WITH_TEXT_LOCATOR).text());
    }
}
