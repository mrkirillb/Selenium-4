package Task_3.steps;

import Task_3.pages.SendAppPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SendAppSteps extends BaseSteps {

    @FindBy(xpath = "//*[contains(text(), 'Продолжить')]")
    public WebElement sendButton;

    @Step("Поле |{0}| заполняется значением - {1}")
    public void fillField(String field, String value){
        new SendAppPage(driver).fillField(field, value);
    }

    @Step("Проверяем, что поле |{0}| заполнено значением - {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage(driver).getFillField(field);
        assertTrue(String.format("Значение поля |[%s]| равно - [%s]. Ожидалось - [%s]", field, actual, value), actual.equals(value));
    }

    @Step("Наполнение полей")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("Проверка полей")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("Нажимаем кнопку - {0}")
    public void sendButton(String menuItem){
        new SendAppPage(driver).sendButton.click();
    }


    @Step("В поле |{0}| присутствует сообщение об ошибке - {1}")
    public void checkErrorMessageField(String field,  String value){
        new SendAppPage(driver).checkFieldErrorMessage(field, value);
    }
}