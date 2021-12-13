package pages;

import steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }
}