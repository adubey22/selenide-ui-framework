package org.myProject.userActions;

import com.codeborne.selenide.*;
import org.myProject.reportManager.ExtentLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.WheelInput;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.myProject.userActions.CustomWaits.waitFor;

public class CustomActions {
    public static void openUrl(String url) {
        ExtentLogger.info("Navigating to " + url);
        open(url);
        ExtentLogger.pass("Navigated to " + url);
    }
    public static void refreshPage() {
        getWebDriver().navigate().refresh();
        ExtentLogger.pass("Refreshed page");
    }
    public static void navigateBack() {
        getWebDriver().navigate().back();
        ExtentLogger.pass("Navigated back");
    }
    public static void navigateTo(String url) {
        getWebDriver().navigate().to(url);
        ExtentLogger.pass("Navigated to " + url);
    }

    public static void setValueCustom(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        element.shouldBe(visible).highlight(HighlightOptions.border()).setValue(value);
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }

    public static void setValueByTypingCustom(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        element.type(TypeOptions.text(value));
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }

    public static void setValueByActionCustom(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        actions().moveToElement(element).sendKeys(value).perform();
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }

    public static void clickAndTypeCustom(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        element.shouldBe(visible).click(ClickOptions.usingJavaScript()).sendKeys(value);
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }

    public static void clickAndTypeCharactersCustom(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        element.shouldBe(visible).click(ClickOptions.usingJavaScript()).type(value);
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }

    public static void selectFromSuggestion(SelenideElement element, String value, String key) {
        ExtentLogger.info("Selecting value [" + value + "] on " + key);
        actions().moveToElement(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ExtentLogger.pass("Selected value [" + value + "] on " + key);
    }


    public static void clickAndSetAndSelectFromSuggestion(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        element.shouldBe(visible).click(ClickOptions.usingDefaultMethod()).setValue(value);
        actions().moveToElement(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }

    public static void clickAndTypeAndSelectFromSuggestion(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        element.shouldBe(visible);
        actions().moveToElement(element).sendKeys(value).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }
    public static void clickAndSetValueWithCharSeqAndSelectFromSuggestion(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        element.shouldBe(visible).highlight(HighlightOptions.border()).setValue(SetValueOptions.withText(value));
        waitFor(1);
        actions().moveToElement(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }

    public static void setValueWithCharSeqCustom(SelenideElement element, String value, String key) {
        ExtentLogger.info("Setting value [" + value + "] on " + key);
        element.shouldBe(visible).highlight(HighlightOptions.border()).setValue(SetValueOptions.withText(value));
        ExtentLogger.pass("Set value [" + value + "] on " + key);
    }

    public static void clickCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clicking on : " + key);
        element.shouldBe(visible).highlight(HighlightOptions.DEFAULT).click(ClickOptions.usingDefaultMethod());
        ExtentLogger.pass("Clicked on : " + key);
    }

    public static void clickJSCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clicking on : " + key);
        element.shouldBe(visible).highlight(HighlightOptions.DEFAULT).click(ClickOptions.usingJavaScript());
        ExtentLogger.pass("Clicked on : " + key);
    }
    public static void simpleClickJSCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clicking on : " + key);
        element.click(ClickOptions.usingJavaScript());
        ExtentLogger.pass("Clicked on : " + key);
    }
    public static void clickIfVisible(SelenideElement element, String key) {
        try {
            if (element.isDisplayed()) {
                ExtentLogger.info("Clicking on : " + key);
                element.shouldBe(visible).highlight(HighlightOptions.DEFAULT).click(ClickOptions.usingJavaScript());
                ExtentLogger.pass("Clicked on : " + key);
            }
        } catch (Exception ignored) {
        }

    }
    public static void scrollAndClickJSCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clicking on : " + key);
        element.scrollIntoView(true).shouldBe(visible).highlight(HighlightOptions.DEFAULT).click(ClickOptions.usingJavaScript());
        ExtentLogger.pass("Clicked on : " + key);
    }

    public static void clickWithActionCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clicking on : " + key);
        element.shouldBe(visible).shouldBe(enabled).highlight(HighlightOptions.DEFAULT);
        actions().moveToElement(element).click().perform();
        ExtentLogger.pass("Clicked on : " + key);
    }
    public static void doubleClickWithActionCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clicking on : " + key);
        element.shouldBe(visible).shouldBe(enabled).highlight(HighlightOptions.DEFAULT);
        actions().moveToElement(element).doubleClick(element).perform();
        ExtentLogger.pass("Clicked on : " + key);
    }
    public static void scrollToElementCustom(SelenideElement element, String key) {
        ExtentLogger.info("Scrolling to : " + key);
        element.shouldBe(visible).scrollTo();
        ExtentLogger.pass("Scrolled to : " + key);
    }

    public static void doubleClickCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clicking on : " + key);
        element.shouldBe(visible).shouldBe(enabled).highlight(HighlightOptions.DEFAULT).doubleClick(ClickOptions.usingDefaultMethod());
        ExtentLogger.pass("Clicked on : " + key);
    }

    public static void doubleClickJSCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clicking on : " + key);
        element.shouldBe(visible).highlight(HighlightOptions.DEFAULT).doubleClick(ClickOptions.usingJavaScript());
        ExtentLogger.pass("Clicked on : " + key);
    }

    public static void typeCustom(SelenideElement element, String value, String key) {
        ExtentLogger.info("Typing value [" + value + "] on " + key);
        element.shouldBe(visible).type(value);
        ExtentLogger.pass("Typed value [" + value + "] on " + key);
    }

    public static void clearCustom(SelenideElement element, String key) {
        ExtentLogger.info("Clearing value on " + key);
        element.shouldBe(visible).clear();
        ExtentLogger.pass("Cleared value on " + key);
    }
    public static void clearCustomByKeyboard(SelenideElement element,String fieldName) {
        try {
            String fieldValue = element.getAttribute("value");
            for (int i = 0; i < fieldValue.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
            ExtentLogger.pass(fieldName + " ==> Data Cleared Successfully!");
        } catch (Exception e) {
            ExtentLogger.fail(fieldName + " ==> Data Cleared due to exception: " + e);
        }
    }

    public static void pasteCustom(SelenideElement element, String key) {
        ExtentLogger.info("Pasting on " + key);
        element.shouldBe(visible).paste();
        ExtentLogger.pass("Pasted on " + key);
    }

    public static void submitCustom(SelenideElement element, String key) {
        ExtentLogger.info("Submitting on " + key);
        element.shouldBe(visible).highlight().submit();
        ExtentLogger.pass("Submitted on " + key);
    }

    public static void checkboxCustom(SelenideElement element, String key) {
        ExtentLogger.info("Checking on " + key);
        element.shouldBe(visible).click();
        ExtentLogger.pass("Checked on " + key);
    }

    public static void selectOptionByValue(SelenideElement element, String value, String key) {
        ExtentLogger.info("Selecting value [" + value + "] on " + key);
        element.shouldBe(visible).selectOptionByValue(value);
        ExtentLogger.pass("Selected value [" + value + "] on " + key);
    }

    public static void selectOptionByText(SelenideElement element, String text, String key) {
        ExtentLogger.info("Selecting text [" + text + "] on " + key);
        element.shouldBe(visible).selectOption(text);
        ExtentLogger.pass("Selected text [" + text + "] on " + key);
    }

    public static void scrollCustom(SelenideElement element, String key) {
        ExtentLogger.info("Scrolling on " + key);
        int elementTop = element.getLocation().getY();
        int viewportHeight = getWebDriver().manage().window().getSize().getHeight();
        int scrollPosition = elementTop - (viewportHeight / 2);
        executeJavaScript("window.scrollTo(0, " + scrollPosition + ")");
        element.scrollIntoView("{behavior: \"instant\", block: \"end\", inline: \"nearest\"}");
        actions().moveToElement(element).perform();
        ExtentLogger.pass("Scrolled on " + key);
    }

    public static void scrollToElementCenter(SelenideElement element, String key) {
        ExtentLogger.info("Scrolling element to center of viewport on " + key);
        int elementTop = element.getLocation().getY();
        int viewportHeight = getWebDriver().manage().window().getSize().getHeight();
        int scrollPosition = elementTop - (viewportHeight / 2);
        executeJavaScript("window.scrollTo(0, " + scrollPosition + ")");
        executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'})", element);
        actions().moveToElement(element).perform();
        ExtentLogger.info("Scrolled element to center of viewport");
    }
    public static void scrollViaWheel(SelenideElement element, String key) {
        ExtentLogger.info("Scrolling on " + key);
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(element);
        actions().scrollFromOrigin(scrollOrigin, 0, 200).perform();
        ExtentLogger.pass("Scrolled on " + key);
    }

    public static void hoverCustom(SelenideElement element, String key) {
        ExtentLogger.info("Hovering on " + key);
        element.shouldBe(visible).hover();
        ExtentLogger.pass("Hovered on " + key);
    }

    public static void getTextCustom(SelenideElement element, String key) {
        ExtentLogger.info("Getting text on " + key);
        String getText = element.shouldBe(visible).getText();
        ExtentLogger.pass("Got text on <b>[" + key + "]</b> and value is  : <b>[" + getText + "]</b>");
    }
    public static String readTextCustom(SelenideElement element, String key) {
        ExtentLogger.info("Getting text on " + key);
        String getText = element.shouldBe(visible).getText();
        ExtentLogger.pass("Got text on <b>[" + key + "]</b> and value is  : <b>[" + getText + "]</b>");
        return getText;
    }

    public static void getValueCustom(SelenideElement element, String key) {
        ExtentLogger.info("Getting value on " + key);
        String value = element.shouldBe(visible).getValue();
        ExtentLogger.pass("Got value on <b>[" + key + "]</b> and value is  : <b>[" + value + "]</b>");
    }

    public static void selectSuggestionFromDropDown(SelenideElement element, String value, String key) {
        ExtentLogger.info("Selecting suggestion [" + value + "] from " + key);
        element.shouldBe(visible).hover().click();
        ExtentLogger.pass("Selected suggestion [" + value + "] from " + key);
    }
    public static int getCountOfElements(ElementsCollection elements, String key) {
        ExtentLogger.info("Getting count of elements on " + key);
        int count = elements.size();
        ExtentLogger.pass("Got count of elements on <b>[" + key + "]</b> and value is  : <b>[" + count + "]</b>");
        return count;
    }
}
