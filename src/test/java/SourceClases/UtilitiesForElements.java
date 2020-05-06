package SourceClases;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

public class UtilitiesForElements {

    private static final String SOURCE_CLASS = UtilitiesForElements.class.getName();

    private static final Logger logger = Logger.getLogger(SOURCE_CLASS);

    public static boolean isElementVisible(SelenideDriver driver, By locator) {
        try {
            return driver.find(locator).isDisplayed();
        } catch (NoSuchElementException exception) {
            logger.throwing(SOURCE_CLASS, "isElementVisible", exception);
            return false;
        }
    }

    public static boolean isElementPresent(SelenideDriver driver, By locator) {
        try {
            driver.find(locator);
            return true;
        } catch (NoSuchElementException exception) {
            logger.throwing(SOURCE_CLASS, "isElementPresent", exception);
            return false;
        }
    }

    public static boolean sendKeysIfElementPresentAndVisible(SelenideDriver driver, By locator, String keys) {
        if (isElementPresent(driver, locator) && isElementVisible(driver, locator)) {
            driver.find(locator).sendKeys(keys);
            return true;
        }
        logger.log(Level.WARNING, "Can't send key in invisible element!!!" + locator.toString());
        return false;
    }

    public static boolean clickIfElementPresentAndVisible(SelenideDriver driver, By locator) {
        if (isElementPresent(driver, locator) && isElementVisible(driver, locator)) {
            driver.find(locator).click();
            return true;
        }
        logger.log(Level.WARNING, "Can't click on invisible element: " + locator.toString());
        return false;
    }

    @NotNull
    public static SelenideElement find(SelenideDriver driver, By locator) {
        SelenideElement element = driver.find(locator);
        assertNotNull("Don't find element!!!", element);
        return element;
    }

}
