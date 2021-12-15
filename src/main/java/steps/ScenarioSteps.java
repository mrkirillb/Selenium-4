package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    ClickButtonSteps clickButtonSteps = new ClickButtonSteps();
    OptionsInsuranceSteps optionInsuranceSteps = new OptionsInsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();


    @When("^выбирает пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName) {
        mainPageSteps.selectMainMenu(menuName);
    }

    @When("^выбирает подпункт меню  \"(.+)\"$")
    public void selectSubMenu(String itemName) {
        mainPageSteps.selectSubMenu(itemName);
    }

    @Then("^получает заголовок  -   \"(.+)\"$")
    public void checkTitleSendAppPage(String title) {
        clickButtonSteps.checkPageTitle(title);
    }

    @When("^выполняет нажатие на кнопку 'Оформить онлайн'$")
    public void sendButton() {
        clickButtonSteps.sendButton();
    }

    @Then("^заговолок страницы = \"(.+)\"$")
    public void checkPageTitle(String title) {
        optionInsuranceSteps.checkPageTitle(title);
    }

    @When("^выбирает тип страхования \"(.+)\"$")
    public void selectTypeMin(String item) {
        optionInsuranceSteps.selectType(item);
    }

    @When("^Выбран тип страхования \"(.+)\"$")
    public void selectType(String item) {
        optionInsuranceSteps.selectType(item);
    }

    @Then("^выполняет нажатие на кнопку 'Оформить'$")
    public void sendButtonInsurance() {
        optionInsuranceSteps.sendButton();
    }

    @When("^заполняет поля:$")
    public void fillForm(DataTable fields) {
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.fillField(field, value));
    }

    @Then("^проверяет значения полей :$")
    public void checkFillForm(DataTable fields) {
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> sendAppSteps.checkFillField(field, value));
    }

    @When("^выполняет нажатие на кнопку 'Продолжить'$")
    public void sendButtonEnd() {
        sendAppSteps.sendButton();
    }

    @Then("^в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String field, String errorMessage) {
        sendAppSteps.checkErrorMessageField(field, errorMessage);
    }
}