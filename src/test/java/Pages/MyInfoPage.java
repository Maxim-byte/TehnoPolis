package Pages;

import SourceClases.UtilitiesForElements;
import com.codeborne.selenide.SelenideDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class MyInfoPage extends MyHomePage {
    private static final By CHANGE_PERSONAL_DATA_BUTTON_LOCATOR = By.xpath(".//a[text()='Редактировать личные данные']");
    private static final By HOME_PAGE_BUTTON_LOCATOR =
            By.xpath(".//a[contains(@hrefattrs, 'st.cmd=userPage&st._aid=NavMenu_User_CPage')");

    public MyInfoPage(SelenideDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        assertTrue("Change personal data button invisible!!!",
                UtilitiesForElements.isElementVisible(driver, CHANGE_PERSONAL_DATA_BUTTON_LOCATOR));
        assertTrue("Home page button invisible!!!",
                UtilitiesForElements.isElementVisible(driver, HOME_PAGE_BUTTON_LOCATOR));
    }

    public boolean checkNameAndSurname(String name, String surname) {
        String actualIF = driver.find(HOME_PAGE_BUTTON_LOCATOR).text();
        return actualIF.equals(name + " " + surname);
    }

}
