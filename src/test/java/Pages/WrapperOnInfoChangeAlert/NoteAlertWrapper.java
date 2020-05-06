package Pages.WrapperOnInfoChangeAlert;

import Pages.NotesPage;
import SourceClases.UtilitiesForElements;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class NoteAlertWrapper {
    private SelenideDriver driver;
    private static final By WRITE_NOTE_TEXT_FIELD_LOCATOR = By.className("input_placeholder");
    private static final By SAVE_BUTTON_LOCATOR = By.xpath(".//div[contains(@data-save, 'Сохранить')]");

    public NoteAlertWrapper(SelenideDriver driver) {
        this.driver = driver;
        check();
    }

    private void check() {
        assertTrue("Write note text field invisible!!!",
                UtilitiesForElements.isElementVisible(driver, WRITE_NOTE_TEXT_FIELD_LOCATOR));
    }

    public void writeNote(String text) {
        assertTrue(UtilitiesForElements.sendKeysIfElementPresentAndVisible(driver, WRITE_NOTE_TEXT_FIELD_LOCATOR, text));
    }

    public NotesPage exitAndSave() {
        assertTrue("Save button invisible!!!",
                UtilitiesForElements.isElementVisible(driver, SAVE_BUTTON_LOCATOR));
        assertTrue(UtilitiesForElements.clickIfElementPresentAndVisible(driver, SAVE_BUTTON_LOCATOR));
        return new NotesPage(driver);
    }
}
