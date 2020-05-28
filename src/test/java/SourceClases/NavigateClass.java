package SourceClases;

import Pages.UserPage;
import Pages.MyMainPage;
import Pages.LoginPage;
import Pages.MyHomePage;
import Pages.MusicPage;


public class NavigateClass {

    public static MyMainPage login(String Username, String Password) {
        LoginPage loginPage = new LoginPage();
        return loginPage.doLogin(Username, Password);
    }

    public static MyHomePage homePage(String Username, String Password) {
        return login(Username, Password).openHomePage();
    }

    public static MusicPage musicPage(String Username, String Password) {
        return login(Username, Password).openMusicPage();
    }

    public static UserPage userPage(String Username, String Password) {
        return login(Username, Password).openUserPage();
    }

    public static MyMainPage openMyMainPage(String Username, String Password) {
        return login(Username, Password);
    }
}

