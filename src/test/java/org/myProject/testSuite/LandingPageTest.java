package org.myProject.testSuite;

import org.myProject.baseClass.BaseClass;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseClass {

    @Test
    public void verifyLandingPage() {
        landingPage.verifyLandingPageUI();
    }

    @Test
    public void verifyNavigateToLoginPage() {
        landingPage.navigateToLoginPage();
    }
}
