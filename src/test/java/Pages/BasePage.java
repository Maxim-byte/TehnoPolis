package Pages;

import com.codeborne.selenide.SelenideDriver;

public abstract class BasePage {

    protected SelenideDriver driver;

    public BasePage(final SelenideDriver driver) {
        this.driver = driver;
        check();
    }

    protected abstract void check();

}
