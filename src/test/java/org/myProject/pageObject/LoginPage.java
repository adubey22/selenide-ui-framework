package org.myProject.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.myProject.userActions.CustomActions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.myProject.userActions.Assertions.assertElementVisible;

// page_url = http://www.automationpractice.pl/index.php?controller=authentication&back=my-account
public class LoginPage {

    // Selenide elements
    private final SelenideElement labelAuthentication = $("div[class^='breadcrumb']");
    private final SelenideElement linkReturnHome = $("a[class='home']");
    private final SelenideElement formCreateAccount = $("#create-account_form");
    private final SelenideElement labelCreateAccount = $("#create-account_form h3");
    private final SelenideElement formLogin = $("#login_form");
    private final SelenideElement labelAlreadyRegistered = $("#login_form h3");
    private final SelenideElement inputTextBoxEmail = $("#email");
    private final SelenideElement inputTextBoxPassword = $("#passwd");
    private final SelenideElement linkRecoverYourForgottenPassword = $("a[title*='forgotten']");
    private final SelenideElement buttonSubmitLogin = $("#SubmitLogin");

    // Verifying elements visibility on the login page
    public void verifyLoginPageUI() {
        assertElementVisible(labelAuthentication, "Label Authentication");
        assertElementVisible(linkReturnHome, "Link Return Home");
        assertElementVisible(formCreateAccount, "Form Create Account");
        assertElementVisible(labelCreateAccount, "Label Create Account");
        assertElementVisible(formLogin, "Form Login");
        assertElementVisible(labelAlreadyRegistered, "Label Already Registered");
        assertElementVisible(inputTextBoxEmail, "Input Text Box Email");
        assertElementVisible(inputTextBoxPassword, "Input Text Box Password");
        assertElementVisible(linkRecoverYourForgottenPassword, "Link Recover Your Forgotten Password");
        assertElementVisible(buttonSubmitLogin, "Button Submit Login");
    }
    // Login method
    public void loginIntoApplication(String email, String password) {
        CustomActions.setValueCustom(inputTextBoxEmail, email, "Input Text Box Email");
        CustomActions.setValueCustom(inputTextBoxPassword, password, "Input Text Box Password");
        CustomActions.clickCustom(buttonSubmitLogin, "Button Submit Login");
    }

}
