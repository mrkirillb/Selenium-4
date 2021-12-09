package Task_3.steps;

import Task_3.pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps extends BaseSteps {

    @Step("Закрытие предупреждения cookie-файлов")
    public void waitSendAppClickable(){
        new MainPage(driver).waitSendAppClickable();
    }

    @Step("Выбираем пункт меню {0}")
    public void selectMainMenu(String itemName){
        new MainPage(driver).selectMainMenu(itemName);
    }

    @Step("Выбираем пункт меню {0}")
    public void selectSubMenu(String itemName){
        new MainPage(driver).selectSubMenu(itemName);
    }
}