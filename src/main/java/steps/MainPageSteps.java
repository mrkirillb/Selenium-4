package steps;

import pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps {

    @Step("Закрытие предупреждения cookie-файлов")
    public void waitSendAppClickable(){
        new MainPage(BaseSteps.getDriver()).waitSendAppClickable();
    }

    @Step("Выбираем пункт меню {0}")
    public void selectMainMenu(String itemName){
        new MainPage(BaseSteps.getDriver()).selectMainMenu(itemName);
    }

    @Step("Выбираем пункт меню {0}")
    public void selectSubMenu(String itemName){
        new MainPage(BaseSteps.getDriver()).selectSubMenu(itemName);
    }
}