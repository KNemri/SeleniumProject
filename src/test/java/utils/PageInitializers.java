package utils;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.ViewCartPage;

public class PageInitializers {
    public static HomePage homePage;
    public static SearchPage searchPage;
    public static ViewCartPage viewCartPage;

    public static void initializePageObjects() {
        homePage = new HomePage();
        searchPage = new SearchPage();
        viewCartPage = new ViewCartPage();
    }
}
