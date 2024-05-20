import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(TestListener.class)
public class WebTest extends Abstract {

    @Test
    public void checkingName(){
        assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']//h2"))));
    }

    @Test
    public void checkingPaymentSystemsLogo(){
        assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__partners']/descendant::img[@alt='Visa']"))));
    }

    @Test
    public void checkingLinks(){
        mts.findElement(By.xpath("//div[@class='pay__wrapper']//a")).click();

        assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='breadcrumbs__wrapper']//span[@class='breadcrumbs__link']"))));
    }

    @Test
    public void checkingButtonContinue(){
        mts.findElement(By.id("connection-phone")).sendKeys("297777777");
        mts.findElement(By.id("connection-sum")).sendKeys("10");
        mts.findElement(By.id("connection-email")).sendKeys("ds@mail.ru");
        mts.findElement(By.xpath("//div[@class='pay__forms']//button[@class='button button__default ']")).click();

        assertNotNull(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='bepaid-app__container']//iframe[@class='bepaid-iframe']"))));
    }

    @Test
    public void checkingEmptyFieldCommunicationServices(){
        assertEquals("Номер телефона", mts.findElement(By.id("connection-phone")).getAttribute("placeholder"));
        assertEquals("Сумма", mts.findElement(By.id("connection-sum")).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", mts.findElement(By.id("connection-email")).getAttribute("placeholder"));
    }

    @Test
    public void checkingEmptyFieldHomeInternet(){
        mts.findElement(By.xpath("//div[@class='select__wrapper']//span[@class='select__arrow']")).click();
        mts.findElement(By.xpath("//p[text()='Домашний интернет']/parent::li[@class='select__item']")).click();

        assertEquals("Номер абонента", mts.findElement(By.id("internet-phone")).getAttribute("placeholder"));
        assertEquals("Сумма", mts.findElement(By.id("internet-sum")).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", mts.findElement(By.id("internet-email")).getAttribute("placeholder"));
    }

    @Test
    public void checkingEmptyFieldInstallment(){
        mts.findElement(By.xpath("//div[@class='select__wrapper']//span[@class='select__arrow']")).click();
        mts.findElement(By.xpath("//p[text()='Рассрочка']/parent::li[@class='select__item']")).click();

        assertEquals("Сумма", mts.findElement(By.id("instalment-sum")).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", mts.findElement(By.id("instalment-email")).getAttribute("placeholder"));
    }

    @Test
    public void checkingEmptyFieldArrears(){
        mts.findElement(By.xpath("//div[@class='select__wrapper']//span[@class='select__arrow']")).click();
        mts.findElement(By.xpath("//p[text()='Задолженность']/parent::li[@class='select__item']")).click();

        assertEquals("Номер счета на 2073", mts.findElement(By.id("score-arrears")).getAttribute("placeholder"));
        assertEquals("Сумма", mts.findElement(By.id("arrears-sum")).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", mts.findElement(By.id("arrears-email")).getAttribute("placeholder"));
    }

    @Test
    public void checkingDataPopupWindowCommunicationServices(){
        mts.findElement(By.id("connection-phone")).sendKeys("297777777");
        mts.findElement(By.id("connection-sum")).sendKeys("10");
        mts.findElement(By.id("connection-email")).sendKeys("ds@mail.ru");
        mts.findElement(By.xpath("//div[@class='pay__forms']//button[@class='button button__default ']")).click();

        WebDriver element = mts.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='bepaid-app__container']//iframe[@class='bepaid-iframe']"))));
        //WebDriverWait waitWindow = new WebDriverWait(element, Duration.ofSeconds(10));
        WebDriverWait waitWindow = new WebDriverWait(element, 10);

        assertEquals("10.00 BYN\nОплата: Услуги связи Номер:375297777777", waitWindow.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='pay-description__text']/parent::div[@class='payment-page__order-description pay-description']"))).getText());

        assertEquals("Оплатить 10.00 BYN", waitWindow.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='card-page__card']//button[@class='colored disabled']"))).getText());

        assertEquals("Номер карты\nСрок действия\nCVC\nИмя держателя (как на карте)",
                waitWindow.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='row ng-tns-c60-0 ng-star-inserted']/parent::div[@class='card ng-tns-c60-0']"))).getText());

        assertNotNull(waitWindow.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='cards-brands cards-brands__container ng-tns-c60-0 ng-trigger ng-trigger-brandsState ng-star-inserted']" +
                        "/descendant::img[@class='ng-tns-c60-0 ng-star-inserted']"))));
    }

}
