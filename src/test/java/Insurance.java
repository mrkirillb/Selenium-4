import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Insurance {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void testInsurence () {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "https://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void InsuranceTest () throws InterruptedException {
    driver.findElement(By.xpath ("//ul[contains(@class,'kitt-top-menu__list_center')]/li/*[contains(text(),'Страхование')]")).click();
    driver.findElement(By.xpath ("//*[contains(text(),'Все страховые программы')]")).click();
    driver.findElement(By.xpath ("//div[contains(@class,'product-catalog__carousel_row')]/div[contains(@data-product,'Страхование путешественников')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')][contains(@class,'kitt-heading')]"))));
        assertEquals("Страхование путешественников",driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')][contains(@class,'kitt-heading')]")).getText());
        if(!driver.findElements(By.xpath("//div[contains(@class,'kitt-cookie-warning')][contains(@style,'display: block;')]//button[contains(@class,'kitt-cookie-warning__close')]")).isEmpty()){
            driver.findElement(By.xpath("//button[contains(@class,'kitt-cookie-warning__close')]")).click();
        }
        driver.findElement(By.xpath("//span[contains(text(),'Оформить на сайте')]")).click();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

            driver.findElement(By.xpath("//h3[contains(text(),'Минимальная')]")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//legend[contains(text(),'Застрахованные')]"))));
            fillField(By.xpath("//input[contains(@placeholder, 'Surname')]"), "Буаев");
            fillField(By.xpath("//input[contains(@placeholder, 'Name')]"), "Крил");
            fillField(By.xpath("//input[contains(@placeholder, 'дд.мм.гггг')]"), "10.01.1963");

            fillField(By.id("person_firstName"), "Крил");
            fillField(By.id("person_lastName"), "Буаев");
            fillField(By.id("person_middleName"), "Втальевч");
            fillField(By.id("person_birthDate"), "10.01.1963");
            driver.findElement(By.xpath("//input[contains(@id,'person_firstName')]")).click();

            driver.findElement(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid')][contains(text(),'Мужской')]")).click();

            fillField(By.id("passportSeries"), "1234");
            fillField(By.id("passportNumber"), "567890");
            fillField(By.id("documentDate"), "10.01.2020");
            fillField(By.id("documentIssue"), "ФГБОУ");

            assertEquals("Буаев", driver.findElement(By.xpath("//input[contains(@placeholder,'Surname')]")).getAttribute("value"));
            assertEquals("Крил", driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).getAttribute("value"));
            assertEquals("10.01.1963", driver.findElement(By.xpath("//input[contains(@placeholder,'дд.мм.гггг')]")).getAttribute("value"));
            assertEquals("Буаев", driver.findElement(By.id("person_lastName")).getAttribute("value"));
            assertEquals("Крил", driver.findElement(By.id("person_firstName")).getAttribute("value"));
            assertEquals("Втальевч", driver.findElement(By.id("person_middleName")).getAttribute("value"));
            assertEquals("10.01.1963", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
            assertEquals("1234", driver.findElement(By.id("passportSeries")).getAttribute("value"));
            assertEquals("567890", driver.findElement(By.id("passportNumber")).getAttribute("value"));
            assertEquals("10.01.2020", driver.findElement(By.id("documentDate")).getAttribute("value"));
            assertEquals("ФГБОУ", driver.findElement(By.id("documentIssue")).getAttribute("value"));

            driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();

            assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[contains(@class,'alert-form alert-form-error')]")).getAttribute("innerText"));
            assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Мобильный телефон')]//span[contains(@class,'message')]")).getAttribute("innerText"));
            assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Электронная почта')]//span[contains(@class,'message')]")).getAttribute("innerText"));
            assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Повтор электронной почты')]//span[contains(@class,'message')]")).getAttribute("innerText"));

        }

        @After
        public void afterTest(){
        driver.quit();
        }

    private void fillField(By locator, String value) throws InterruptedException {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        Thread.sleep(1000);
        driver.findElement(locator).sendKeys(value);
    }
    }
