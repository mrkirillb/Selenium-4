package steps;

import pages.OptionsInsurancePage;
import io.qameta.allure.Step;

import static org.junit.Assert.assertTrue;


public class OptionsInsuranceSteps {

    @Step("Проверка заголовка страницы -  равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new OptionsInsurancePage(BaseSteps.getDriver()).title.getText();
        String expectedTitle2 = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle2));
    }

    @Step("нажата кнопка -  {0}")
    public void sendButton(){
        new OptionsInsurancePage(BaseSteps.getDriver()).sendButton.click();

    }
    @Step("выбран тип страхования -  {0}")
    public void selectType(String itemName) {
        new OptionsInsurancePage(BaseSteps.getDriver()).selectType(itemName);

    }
}