import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.SelenideDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.*;

public class main
{
    @Test
    public void login() {
        LoginPage login = new LoginPage(driver);
        login.login();
    }
    @Test
    public void musicGo() {
        MainPage mainPage = new MainPage(driver);
        mainPage.playMusic();
    }

    protected SelenideDriver driver;
}
