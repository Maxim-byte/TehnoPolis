package SourceClases;

import Pages.UserPage;
import Pages.MyMainPage;
import Pages.LoginPage;
import Pages.MyHomePage;
import Pages.MusicPage;


public class NavigateClass {
    protected static Bot BOT = new Bot();

    public NavigateClass(Bot BOT) {
        NavigateClass.BOT = BOT;
    }

    public static MyMainPage login(Bot bot) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLogin(BOT.username, BOT.password);
    }

    public static MyHomePage homePage(Bot bot) {
        return login(BOT).openHomePage();
    }

    public static MusicPage musicPage(Bot bot) {
        return login(BOT).openMusicPage();
    }

    public static UserPage userPage(Bot bot) {
        return login(BOT).openUserPage();
    }

    public static MyMainPage openMyMainPage(Bot bot) {
        return login(BOT);
    }
}

