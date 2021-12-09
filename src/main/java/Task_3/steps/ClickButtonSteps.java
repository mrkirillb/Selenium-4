package Task_3.steps;

import Task_3.pages.ClickButtonPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class ClickButtonSteps extends BaseSteps{


    @FindBy(xpath = "//h2[contains(text(), 'Страхование путешественников')]")
    public WebElement title;

    @Step("Заголовок: {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new ClickButtonPage(driver).title.getText();
        String expectedTitle2 = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle2));
    }

    @Step("Нажимаем кнопку: {0}")
    public void sendButton() {
        new ClickButtonPage(driver).sendButton();
    }

    @Step("Нажимаем кнопку: {0}")
    public void sendButton2() {
        new ClickButtonPage(driver).sendButton2();
    }
}