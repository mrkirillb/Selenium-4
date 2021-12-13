package pages;

import steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickButtonPage {

    @FindBy(xpath = "//h1[contains(text(), 'Страхование путешественников')]")
    public WebElement title;

    @FindBy(xpath = "//*[contains(text(), 'Оформить онлайн')]")
    public WebElement sendButton;

    @FindBy(xpath = "//*[contains(text(), 'Оформить на сайте')]")
    public WebElement sendButton2;

    public ClickButtonPage(WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


    public void sendButton() {
        sendButton.click();
    }
    public void sendButton2() {
        sendButton2.click();
    }

}