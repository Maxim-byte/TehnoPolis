package SourceClases;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class ElementUtils {

    private static final String SOURCE_CLASS = ElementUtils.class.getName();

    private static final Logger logger = Logger.getLogger(SOURCE_CLASS);

    /**
     * This method checked visibility element.
     * Within 4 seconds they will check element visibility or present.
     *
     * @param locator locator for checking
     */
    private static boolean isElementVisible(By locator) {
        try {
            Selenide.$(locator).shouldBe(Condition.visible);
            return true;
        } catch (NoSuchElementException exception) {
            logger.throwing(SOURCE_CLASS, "isElementVisible", exception);
            return false;
        }
    }

    /**
     * This method checked presented element.
     * Within 4 seconds they will check element presented.
     *
     * @param locator locator for checking
     */
    private static boolean isElementPresent(By locator) {
        try {
            Selenide.$(locator).shouldBe(Condition.exist);
            return true;
        } catch (NoSuchElementException exception) {
            logger.throwing(SOURCE_CLASS, "isElementPresent", exception);
            return false;
        }
    }

    /**
     * This method send keys if element presented and visible.
     * Within 4 seconds they will wait wile element not presented or invisible.
     *
     * @param locator                 locator for send keys
     * @param keys                    String for sending
     */
    public static void sendKeys(By locator, final @NotNull String keys) {
        checkPresentAndVisibility("Can't send key in invisible element!!!" + locator.toString(), locator);
        Selenide.$(locator).sendKeys(keys);
    }

    /**
     * This method delete old and send new keys if element presented and visible.
     * Within 4 seconds they will wait wile element not presented or invisible.
     *
     * @param locator Locator for checking
     * @param keys    String for sending keys
     */
    public static void sendKeysWithDeleteOldValue(By locator, final @NotNull String keys) {
        //delete old value and set new
        final String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        ElementUtils.sendKeys(locator, deleteString);
        ElementUtils.sendKeys(locator, keys);
    }

    /**
     * This method delete old and send new keys if element presented and visible.
     * Within 4 seconds they will wait wile element not presented or invisible.
     *
     * @param locator locator on element for clicking.
     */
    public static void click(By locator) {
        checkPresentAndVisibility("Can't click on invisible element: " + locator.toString(), locator);
        Selenide.$(locator).click();
    }

    /**
     * This method find element.
     * Within 4 seconds they will wait wile element not presented.
     *
     * @param locator Locator on element for finding
     */
    @NotNull
    public static SelenideElement find(By locator) {
        SelenideElement element = Selenide.$(locator);
        Assert.assertNotNull("Don't find element!!!", element);
        return element;
    }

    /**
     * This method check present and visibility element.
     * Within 4 seconds they will wait wile element not presented.
     *
     * @param message String for error.
     * @param locator Locator on element for finding
     */
    @NotNull
    public static void checkPresentAndVisibility(String message, By locator) {
        Assert.assertTrue(message, isElementPresent(locator) && isElementVisible(locator));
    }

    public static String getValue(By locator) {
        SelenideElement element = find(locator);
        return element.innerText();
    }

    public static void checkEqualsWithAssert(String message, @NotNull Object obj1, Object obj2) {
        Assert.assertFalse(message, obj1.equals(obj2));
    }

    public static boolean isDisplayed(By locator) {
        return Selenide.$(locator).isDisplayed();
    }
}