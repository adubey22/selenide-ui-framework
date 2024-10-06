package org.myProject.userActions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.myProject.reportManager.ExtentLogger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CustomWaits {

    public static void waitFor(int seconds) {
        try {
            Selenide.sleep(seconds * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeVisible(SelenideElement element, int timeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                ExtentLogger.info("This element is visible");
            } else {
                ExtentLogger.info("This element is not visible");
            }
        } catch (Exception ignored) {
        }
    }

    public static void waitForElementToBeClickable(SelenideElement element, int timeInSeconds) {
        try {
            element.shouldBe(Condition.enabled, Duration.ofSeconds(timeInSeconds));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeInvisible(SelenideElement element, int timeInSeconds) {
        try {
            element.shouldBe(Condition.hidden, Duration.ofSeconds(timeInSeconds));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeDisabled(SelenideElement element, int timeInSeconds) {
        try {
            element.shouldBe(Condition.disabled, Duration.ofSeconds(timeInSeconds));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeEnabled(SelenideElement element, int timeInSeconds) {
        try {
            element.shouldBe(Condition.enabled, Duration.ofSeconds(timeInSeconds));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeSelected(SelenideElement element, int timeInSeconds) {
        try {
            element.shouldBe(Condition.selected, Duration.ofSeconds(timeInSeconds));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeUnselected(SelenideElement element, int timeInSeconds) {
        try {
            element.shouldBe(Condition.not(Condition.selected), Duration.ofSeconds(timeInSeconds));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
