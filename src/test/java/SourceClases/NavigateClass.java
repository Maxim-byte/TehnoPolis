package SourceClases;

import Pages.UserPage;
import Pages.MyMainPage;
import Pages.LoginPage;
import Pages.MyHomePage;
import Pages.MusicPage;


public class NavigateClass {

    public static MyMainPage login(Bot BOT) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLogin(BOT.username, BOT.password);
    }

    public static MyHomePage homePage(Bot BOT) {
        return login(BOT).openHomePage();
    }

    public static MusicPage musicPage(Bot BOT) {
        return login(BOT).openMusicPage();
    }

    public static UserPage userPage(Bot BOT) {
        return login(BOT).openUserPage();
    }

    public static MyMainPage openMyMainPage(Bot  BOT) {
        return login(BOT);
    }
}

