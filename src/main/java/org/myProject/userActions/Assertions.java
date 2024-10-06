package org.myProject.userActions;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.HighlightOptions;
import com.codeborne.selenide.SelenideElement;
import org.myProject.reportManager.ExtentLogger;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Assertions {
    public static void assertEquals(String actual, String expected, String key) {
        try {
            Assert.assertEquals(actual, expected);
            ExtentLogger.pass("Equal :=> <b>" + key + "</b>");
        } catch (Exception e) {
            ExtentLogger.fail("Not equal :=> <b>" + key + "</b>");
        }
    }

    public static void assertNotEquals(String actual, String expected, String key) {
        try {
            Assert.assertNotEquals(actual, expected);
            ExtentLogger.pass("Not equal :=> <b>" + key + "</b>");
        } catch (Exception e) {
            ExtentLogger.fail("Equal :=> <b>" + key + "</b>");
        }
    }
    public static void assertTrue(boolean actual, String key) {
        try {
            Assert.assertTrue(actual);
            ExtentLogger.pass("True :=> <b>" + key + "</b>");
        } catch (Exception e) {
            ExtentLogger.fail("False :=> <b>" + key + "</b>");
        }
    }

    public static void assertFalse(boolean actual, String key) {
        try {
            Assert.assertFalse(actual);
            ExtentLogger.pass("False :=> <b>" + key + "</b>");
        } catch (Exception e) {
            ExtentLogger.fail("True :=> <b>" + key + "</b>");
        }
    }

    public static void assertElementExists(SelenideElement element, String key) {
        try {
            element.shouldBe(Condition.exist);
            ExtentLogger.pass("Element found :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element not found :=> " + key);
        }
    }

    public static void assertElementNotExists(SelenideElement element, String key) {
        try {
            element.shouldBe(Condition.not(Condition.exist));
            ExtentLogger.pass("Element not found :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element found :=> " + key);
        }
    }

    public static boolean assertElementVisible(SelenideElement element, String key) {
        try {
            element.shouldBe(visible).highlight(HighlightOptions.border());
            ExtentLogger.pass("Element visible :=> <b>" + key + "</b>");
            return true;
        } catch (Exception e) {
            ExtentLogger.fail("Element not visible :=><b> " + key + "</b>");
            return false;
        }
    }

    public static boolean assertElementIfVisible(SelenideElement element, String key) {
        try {
            element.shouldBe(visible);
            ExtentLogger.pass("Element visible :=>  <b>" + key + "</b>");
            return true;
        } catch (Exception e) {
            ExtentLogger.info("Element not visible :=> <b>" + key + "</b>");
            return false;
        }
    }

    public static boolean isElementVisible(SelenideElement element, String key) {
        try {
            if (element.isDisplayed())
                ExtentLogger.pass("Element visible :=> <b>" + key + "</b>");
            return true;
        } catch (Exception e) {
            ExtentLogger.info("Element not visible :=> <b>" + key + "</b>");
            return false;
        }
    }

    public static void assertElementNotVisible(SelenideElement element, String key) {
        try {
            element.shouldBe(Condition.not(visible));
            ExtentLogger.pass("Element not visible :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element visible :=> " + key);
        }
    }

    public static void assertElementEnabled(SelenideElement element, String key) {
        try {
            element.shouldBe(Condition.enabled);
            ExtentLogger.pass("Element enabled :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element not enabled :=> " + key);
        }
    }

    public static void assertElementNotEnabled(SelenideElement element, String key) {
        try {
            element.shouldBe(Condition.not(Condition.enabled));
            ExtentLogger.pass("Element not enabled :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element enabled :=> " + key);
        }
    }

    public static void assertTextPresence(String text) {
        try {
            $(byText(text)).shouldBe(visible);
            ExtentLogger.pass("Element disabled :=> " + text);
        } catch (Exception e) {
            ExtentLogger.fail("Element not disabled :=> " + text);
        }
    }

    public static void assertElementSelected(SelenideElement element, String key) {
        try {
            element.shouldBe(Condition.selected);
            ExtentLogger.pass("Element selected :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element not selected :=> " + key);
        }
    }

    public static void assertElementNotSelected(SelenideElement element, String key) {
        try {
            element.shouldBe(Condition.not(Condition.selected));
            ExtentLogger.pass("Element not selected :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element selected :=> " + key);
        }
    }

    public static void assertElementContainsText(SelenideElement element, String key) {
        try {
            element.shouldHave(Condition.text(key));
            ExtentLogger.pass("Element contains text :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element not contains text :=> " + key);
        }
    }

    public static void assertElementNotContainsText(SelenideElement element, String key) {
        try {
            element.shouldNotHave(Condition.text(key));
            ExtentLogger.pass("Element not contains text :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element contains text :=> " + key);
        }
    }

    public static void assertElementContainsValue(SelenideElement element, String key) {
        try {
            element.shouldHave(Condition.value(key));
            ExtentLogger.pass("Element contains value :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element not contains value :=> " + key);
        }
    }

    public static void assertElementNotContainsValue(SelenideElement element, String key) {
        try {
            element.shouldNotHave(Condition.value(key));
            ExtentLogger.pass("Element not contains value :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element contains value :=> " + key);
        }
    }

    public static void assertElementContainsAttribute(SelenideElement element, String key) {
        try {
            element.shouldHave(Condition.attribute(key));
            ExtentLogger.pass("Element contains attribute :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element not contains attribute :=> " + key);
        }
    }

    public static void assertElementNotContainsAttribute(SelenideElement element, String key) {
        try {
            element.shouldNotHave(Condition.attribute(key));
            ExtentLogger.pass("Element not contains attribute :=> " + key);
        } catch (Exception e) {
            ExtentLogger.fail("Element contains attribute :=> " + key);
        }
    }


}
