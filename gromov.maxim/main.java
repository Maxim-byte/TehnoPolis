import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.*;

public class main
{
    @Test
    public void login() {
        try{
            LoginPage login = new LoginPage(driver);
            login.login();
        }
        catch (NoSuchElementException exception){
            exception.getCause();
        }
    }
    @Test
    public void musicGo() {
        try {
            MainPage mainPage = new MainPage(driver);
            mainPage.playMusic();
        }
        catch (NoSuchElementException exception){
          exception.getCause();
        }
    }
    protected SelenideDriver driver;
}
