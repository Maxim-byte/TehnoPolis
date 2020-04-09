package MusicTest.Pages;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    public LoginPage(SelenideDriver driver) {
        this.driver = driver;
        login = $(By.name("st.email"));
        password = $(By.name("st.password"));
        enter = $(By.cssSelector("input.button-pro.__wide"));
    }

    public void login() throws NoSuchElementException {
        open("https://ok.ru/");
        login.setValue("+79117703698");
        password.setValue("Gromov12345");
        enter.pressEnter();
        sleep(2000);
    }

    public String getOpen() {
        return driver.url();
    }

    protected SelenideDriver driver;
    private SelenideElement login;
    private SelenideElement password;
    private SelenideElement enter;
}