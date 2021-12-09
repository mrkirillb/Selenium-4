package Task_3;

import Task_3.steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;

public class TestForSber extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    ClickButtonSteps clickButtonSteps = new ClickButtonSteps();
    OptionsInsuranceSteps optionsInsuranceSteps = new OptionsInsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();


    @Title("Заявка на страховку для путешественников")
    @Test
    public void Test(){
        HashMap<String, String> personInfo = new HashMap<>();
        personInfo.put("Фамилия застрахованного", "Будаев");
        personInfo.put("Имя застрахованного", "Кирилл");
        personInfo.put("Дата рождения застрахованного", "10.03.1994");
        personInfo.put("Фамилия страхователя", "Будаев");
        personInfo.put("Имя страхователя", "Кирилл");
        personInfo.put("Отчество страхователя", "Витальевич");
        personInfo.put("Дата рождения страхователя", "10.03.1994");
        personInfo.put("Серия паспорта", "0000");
        personInfo.put("Номер паспорта", "777777");
        personInfo.put("Дата выдачи", "16.10.2020");
        personInfo.put("Кем выдан", "Отделом ФМС");

        //mainPageSteps.waitSendAppClickable();
        mainPageSteps.selectMainMenu("Страхование");
        mainPageSteps.selectSubMenu("Путешествия");
        mainPageSteps.waitSendAppClickable();
        clickButtonSteps.checkPageTitle("Страхование путешественников");
        clickButtonSteps.sendButton();
        clickButtonSteps.sendButton2();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        optionsInsuranceSteps.checkPageTitle("Страхование путешественников");
        optionsInsuranceSteps.selectType("Минимальная");
        optionsInsuranceSteps.sendButton("Оформить");

        sendAppSteps.fillFields(personInfo);
        sendAppSteps.checkFillFields(personInfo);
        sendAppSteps.sendButton("Продолжить");


        sendAppSteps.checkErrorMessageField("Мобильный телефон", "Поле не заполнено.");
        sendAppSteps.checkErrorMessageField("Электронная почта", "Поле не заполнено.");
        sendAppSteps.checkErrorMessageField("Повтор электронной почты", "Поле не заполнено.");
    }
}