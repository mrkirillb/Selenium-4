package steps;

import pages.SendAppPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SendAppSteps {

    @FindBy(xpath = "//*[contains(text(), 'Продолжить')]")
    public WebElement sendButton;

    @Step("поле |{0}| заполняется значением - {1}")
    public void fillField(String field, String value){
        new SendAppPage(BaseSteps.getDriver()).fillField(field, value);
    }

    @Step("поле |{0}| заполнено значением - {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage(BaseSteps.getDriver()).getFillField(field);
        assertTrue(String.format("Значение поля |[%s]| равно - [%s]. Ожидалось - [%s]", field, actual, value), actual.equals(value));
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("нажата кнопка - {0}")
    public void sendButton(){
        new SendAppPage(BaseSteps.getDriver()).sendButton.click();
    }


    @Step("в поле |{0}| присутствует сообщение об ошибке - {1}")
    public void checkErrorMessageField(String field,  String value){
        new SendAppPage(BaseSteps.getDriver()).checkFieldErrorMessage(field, value);
    }
}