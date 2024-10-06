package org.myProject.pageObject;

import static org.myProject.configManager.ConfigFactory.getConfig;
import static org.myProject.frameworkComstants.PageURLs.LOGIN_PAGE_URL;


import com.codeborne.selenide.SelenideElement;
import org.myProject.userActions.Assertions;
import org.myProject.userActions.CustomActions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.myProject.userActions.Assertions.assertElementVisible;
import static org.myProject.userActions.CustomActions.clickCustom;
import static org.myProject.userActions.CustomActions.openUrl;

public class LandingPage {

    // Elements identified using Selenide selectors
    private final SelenideElement logoMyShop = $("a[title$='Shop']");
    private final SelenideElement textBoxSearchTop = $("#search_block_top");
    private final SelenideElement buttonSubmitSearch = $("button[name='submit_search']");
    private final SelenideElement linkViewMyShoppingCart = $("a[title$='cart']");
    private final SelenideElement bCart = $("b");
    private final SelenideElement divColumns = $("#columns");
    private final SelenideElement linkLogInYourCustomerAccount = $("a[class='login']");
    private final SelenideElement linkContact = $("a[title^='Contact']");

    // Method to verify visibility of key elements on the landing page
    public void verifyLandingPageUI() {
        assertElementVisible(logoMyShop, "Logo MyShop");
        assertElementVisible(textBoxSearchTop, "TextBox Search Top");
        assertElementVisible(buttonSubmitSearch, "Button Submit Search");
        assertElementVisible(linkViewMyShoppingCart, "Link View My Shopping Cart");
        assertElementVisible(bCart, "B Cart");
    }

    // Method to navigate to the login page
    public void navigateToLoginPage() {
        clickCustom(linkLogInYourCustomerAccount, "Link Log In Your Customer Account");
        //openUrl(getConfig()+LOGIN_PAGE_URL);
    }
}
