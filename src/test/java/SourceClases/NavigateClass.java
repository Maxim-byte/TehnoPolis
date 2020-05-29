package SourceClases;

import Pages.UserPage;
import Pages.MyMainPage;
import Pages.LoginPage;
import Pages.MyHomePage;
import Pages.MusicPage;

public class NavigateClass {

    public static MyMainPage doLogin(String Username, String Password) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLogin(Username, Password);
    }

    public static MyHomePage openHomePage(String Username, String Password) {
        return doLogin(Username, Password).openHomePage();
    }

    public static MusicPage openMusicPage(String Username, String Password) {
        return doLogin(Username, Password).openMusicPage();
    }

    public static UserPage openUserPage(String Username, String Password) {
        return doLogin(Username, Password).openUserPage();
    }

    public static MyMainPage openMyMainPage(String Username, String Password) {
        return doLogin(Username, Password);
    }
}

