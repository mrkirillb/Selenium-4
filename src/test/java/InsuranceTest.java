import org.junit.Test;
import pages.ClickButtonPage;
import pages.MainPage;
import pages.OptionsInsurancePage;
import pages.SendAppPage;

import static org.junit.Assert.assertTrue;

public class InsuranceTest extends BaseTest {

    @Test
    public void InsuranseTest () {
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.waitSendAppClickable();
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия");

        ClickButtonPage clickOnlineButtonPage = new ClickButtonPage(driver);

        String actualTitle = clickOnlineButtonPage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        clickOnlineButtonPage.sendButton.click();
        clickOnlineButtonPage.sendButton2.click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        OptionsInsurancePage optionInsurancePage = new OptionsInsurancePage(driver);
        optionInsurancePage.selectType("Минимальная");
        optionInsurancePage.sendButton("Оформить");

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Фамилия застрахованного", "Будаев");
        sendAppPage.fillField("Имя застрахованного", "Кирилл");
        sendAppPage.fillField("Дата рождения застрахованного", "10.03.1994");
        sendAppPage.fillField("Фамилия страхователя", "Будаев");
        sendAppPage.fillField("Имя страхователя", "Кирилл");
        sendAppPage.fillField("Отчество страхователя", "Витальевич");
        sendAppPage.fillField("Дата рождения страхователя", "10.03.1994");
        sendAppPage.fillField("Серия паспорта", "0000");
        sendAppPage.fillField("Номер паспорта", "777777");
        sendAppPage.fillField("Дата выдачи", "16.10.2020");
        sendAppPage.fillField("Кем выдан", "Отделом ФМС");
        sendAppPage.male.click();


        sendAppPage.getFillField("Фамилия застрахованного", "Будаев");
        sendAppPage.getFillField("Имя застрахованного", "Кирилл");
        sendAppPage.getFillField("Дата рождения застрахованного", "10.03.1994");
        sendAppPage.getFillField("Фамилия страхователя", "Будаев");
        sendAppPage.getFillField("Имя страхователя", "Кирилл");
        sendAppPage.getFillField("Отчество страхователя", "Витальевич");
        sendAppPage.getFillField("Дата рождения страхователя", "10.03.1994");
        sendAppPage.getFillField("Серия паспорта", "0000");
        sendAppPage.getFillField("Номер паспорта", "777777");
        sendAppPage.getFillField("Дата выдачи", "16.10.2020");
        sendAppPage.getFillField("Кем выдан", "Отделом ФМС");

        sendAppPage.sendButton.click();

        sendAppPage.checkFieldErrorMessage("Мобильный телефон", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("Электронная почта", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("Повтор электронной почты", "Поле не заполнено.");
    }

}