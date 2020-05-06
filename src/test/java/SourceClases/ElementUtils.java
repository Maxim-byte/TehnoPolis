package SourceClases;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElementUtils {

    private static final String SOURCE_CLASS = ElementUtils.class.getName();

    private static final Logger logger = Logger.getLogger(SOURCE_CLASS);

    public static boolean isElementVisible(By locator) {
        try {
            Selenide.$(locator).shouldBe(Condition.visible);
            return true;
        } catch (NoSuchElementException exception) {
            logger.throwing(SOURCE_CLASS, "isElementVisible", exception);
            return false;
        }
    }

    public static boolean isElementPresent(By locator) {
        try {
            Selenide.$(locator).shouldBe(Condition.exist);
            return true;
        } catch (NoSuchElementException exception) {
            logger.throwing(SOURCE_CLASS, "isElementPresent", exception);
            return false;
        }
    }

    public static boolean sendKeysIfElementPresentAndVisible(By locator, final @NotNull String keys) {
        if (isElementPresent(locator) && isElementVisible(locator)) {
            Selenide.$(locator).sendKeys(keys);
            return true;
        }
        logger.log(Level.WARNING, "Can't send key in invisible element!!!" + locator.toString());
        return false;
    }

    public static boolean sendKeysWithDeleteOldValueIfElementPresentAndVisible(By locator, final @NotNull String keys) {
        //delete old value and set new
        final String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        return ElementUtils.sendKeysIfElementPresentAndVisible(locator, deleteString) &&
                ElementUtils.sendKeysIfElementPresentAndVisible(locator, keys);
    }

    public static boolean clickIfElementPresentAndVisible(By locator) {
        if (isElementPresent(locator) && isElementVisible(locator)) {
            Selenide.$(locator).click();
            return true;
        }
        logger.log(Level.WARNING, "Can't click on invisible element: " + locator.toString());
        return false;
    }

    @NotNull
    public static SelenideElement find(By locator) {
        SelenideElement element = Selenide.$(locator);
        Assert.assertNotNull("Don't find element!!!", element);
        return element;
    }

}
