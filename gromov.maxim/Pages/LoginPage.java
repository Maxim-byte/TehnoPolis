package Pages;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.WebDriverRunner;

public class LoginPage extends BasePage
{
    public LoginPage(SelenideDriver driver){
        driver_ = driver;
        login_ =  $(By.name("st.email"));
        password_ = $(By.name("st.password"));
        enter_ = $(By.cssSelector("input.button-pro.__wide"));
    }
    public void login(){
        open("https://ok.ru/");
        login_.setValue("+79117703698");
        password_.setValue("Gromov12345");
        enter_.pressEnter();
        sleep(2000);
    }
    public String getOpen(){
        return driver_.url();
    }
    protected SelenideDriver driver_;
    private SelenideElement login_;
    private SelenideElement password_;
    private SelenideElement enter_;
}
