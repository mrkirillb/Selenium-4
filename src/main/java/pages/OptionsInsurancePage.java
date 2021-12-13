package pages;

import steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptionsInsurancePage {


    @FindBy(xpath = "//h2[contains(text(), 'Страхование путешественников')]")
    public WebElement title;

    @FindBy(xpath = "//*[contains(text(), 'Оформить')]")
    public WebElement sendButton;



    public OptionsInsurancePage(WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectType(String itemName) {
        BaseSteps.getDriver().findElement(By.xpath("//h3[text() = '" + itemName + "']")).click();
    }

    public void sendButton(String itemName) {
        JavascriptExecutor jse = (JavascriptExecutor) BaseSteps.getDriver();
        jse.executeScript("window.scrollBy(0, 5000)", "");
        BaseSteps.getDriver().findElement(By.xpath("//*[@class='layout-wrapper']")).click();
        BaseSteps.getDriver().findElement(By.xpath("//button[text() = '" + itemName + "']")).click();
    }
    public void sendButton2(String itemName) {
        JavascriptExecutor jse = (JavascriptExecutor) BaseSteps.getDriver();
        jse.executeScript("window.scrollBy(0, 5000)", "");
        BaseSteps.getDriver().findElement(By.xpath("//*[@class='layout-wrapper']")).click();
        BaseSteps.getDriver().findElement(By.xpath("//button[text() = '" + itemName + "']")).click();
    }
}