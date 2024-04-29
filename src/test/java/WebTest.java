import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebTest {

    @Test
    public void checkingName(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']//h2"))) != null)
                .isEqualTo(true);
        mts.quit();
    }

    @Test
    public void checkingPaymentSystemsLogo(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__partners']/descendant::img[@alt='Visa']"))) != null)
                .isEqualTo(true);
        mts.quit();
    }

    @Test
    public void checkingLinks(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

        mts.findElement(By.xpath("//div[@class='pay__wrapper']//a")).click();

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='breadcrumbs__wrapper']//span[@class='breadcrumbs__link']"))) != null)
                .isEqualTo(true);
        mts.quit();
    }

    @Test
    public void checkingButtonContinue(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

        mts.findElement(By.id("connection-phone")).sendKeys("297777777");
        mts.findElement(By.id("connection-sum")).sendKeys("10");
        mts.findElement(By.id("connection-email")).sendKeys("ds@mail.ru");
        mts.findElement(By.xpath("//div[@class='pay__forms']//button[@class='button button__default ']")).click();

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='bepaid-app__container']//iframe[@class='bepaid-iframe']"))) != null)
                .isEqualTo(true);
        mts.quit();
    }

    @Test
    public void checkingEmptyFieldCommunicationServices(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

        assertThat(mts.findElement(By.id("connection-phone")).getAttribute("placeholder"))
                .isEqualTo("Номер телефона");
        assertThat(mts.findElement(By.id("connection-sum")).getAttribute("placeholder"))
                .isEqualTo("Сумма");
        assertThat(mts.findElement(By.id("connection-email")).getAttribute("placeholder"))
                .isEqualTo("E-mail для отправки чека");
        mts.quit();
    }

    @Test
    public void checkingEmptyFieldHomeInternet(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

        mts.findElement(By.xpath("//div[@class='select__wrapper']//span[@class='select__arrow']")).click();
        mts.findElement(By.xpath("//p[text()='Домашний интернет']/parent::li[@class='select__item']")).click();

        assertThat(mts.findElement(By.id("internet-phone")).getAttribute("placeholder"))
                .isEqualTo("Номер абонента");
        assertThat(mts.findElement(By.id("internet-sum")).getAttribute("placeholder"))
                .isEqualTo("Сумма");
        assertThat(mts.findElement(By.id("internet-email")).getAttribute("placeholder"))
                .isEqualTo("E-mail для отправки чека");
        mts.quit();
    }

    @Test
    public void checkingEmptyFieldInstallment(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();

        mts.findElement(By.xpath("//div[@class='select__wrapper']//span[@class='select__arrow']")).click();
        mts.findElement(By.xpath("//p[text()='Рассрочка']/parent::li[@class='select__item']")).click();

        assertThat(mts.findElement(By.id("instalment-sum")).getAttribute("placeholder"))
                .isEqualTo("Сумма");
        assertThat(mts.findElement(By.id("instalment-email")).getAttribute("placeholder"))
                .isEqualTo("E-mail для отправки чека");
        mts.quit();
    }

    @Test
    public void checkingEmptyFieldArrears(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();

        mts.findElement(By.xpath("//div[@class='select__wrapper']//span[@class='select__arrow']")).click();
        mts.findElement(By.xpath("//p[text()='Задолженность']/parent::li[@class='select__item']")).click();

        assertThat(mts.findElement(By.id("score-arrears")).getAttribute("placeholder"))
                .isEqualTo("Номер счета на 2073");
        assertThat(mts.findElement(By.id("arrears-sum")).getAttribute("placeholder"))
                .isEqualTo("Сумма");
        assertThat(mts.findElement(By.id("arrears-email")).getAttribute("placeholder"))
                .isEqualTo("E-mail для отправки чека");
        mts.quit();
    }

    @Test
    public void checkingDataPopupWindowCommunicationServices(){
        WebDriver mts = new ChromeDriver();
        mts.get("https://www.mts.by");
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

        mts.findElement(By.id("connection-phone")).sendKeys("297777777");
        mts.findElement(By.id("connection-sum")).sendKeys("10");
        mts.findElement(By.id("connection-email")).sendKeys("ds@mail.ru");
        mts.findElement(By.xpath("//div[@class='pay__forms']//button[@class='button button__default ']")).click();

        WebDriver element = mts.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='bepaid-app__container']//iframe[@class='bepaid-iframe']"))));
        WebDriverWait waitWindow = new WebDriverWait(element, Duration.ofSeconds(10));
        assertThat(waitWindow.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='pay-description__text']/parent::div[@class='payment-page__order-description pay-description']"))).getText())
                .isEqualTo("10.00 BYN\n" +
                        "Оплата: Услуги связи Номер:375297777777");

        assertThat(waitWindow.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='card-page__card']//button[@class='colored disabled']"))).getText())
                .isEqualTo("Оплатить 10.00 BYN");

        assertThat(waitWindow.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='row ng-tns-c60-0 ng-star-inserted']/parent::div[@class='card ng-tns-c60-0']"))).getText())
                .isEqualTo("Номер карты\nСрок действия\nCVC\nИмя держателя (как на карте)");

        assertThat(waitWindow.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='cards-brands cards-brands__container ng-tns-c60-0 ng-trigger ng-trigger-brandsState ng-star-inserted']" +
                        "/descendant::img[@class='ng-tns-c60-0 ng-star-inserted']"))) != null)
                .isEqualTo(true);

        mts.quit();
    }

}
