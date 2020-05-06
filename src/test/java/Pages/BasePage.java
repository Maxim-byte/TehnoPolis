package Pages;

import com.codeborne.selenide.SelenideDriver;

public abstract class BasePage {

    public BasePage() {
        check();
    }

    protected abstract void check();

}
