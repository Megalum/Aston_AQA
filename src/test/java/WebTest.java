import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebTest {

    public static WebDriver mts = new ChromeDriver();
    public static WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

    @Test
    public void checkingName(){
        mts.get("https://www.mts.by");

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']//h2"))) != null)
                .isEqualTo(true);
    }

    @Test
    public void checkingPaymentSystemsLogo(){
        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__partners']/descendant::img[@alt='Visa']"))) != null)
                .isEqualTo(true);
        mts.close();
    }

    @Test
    public void checkingLinks(){
        mts.get("https://www.mts.by");

        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        mts.findElement(By.xpath("//div[@class='pay__wrapper']//a")).click();

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='breadcrumbs__wrapper']//span[@class='breadcrumbs__link']"))) != null)
                .isEqualTo(true);
    }

    @Test
    public void checkingButtonContinue(){
        mts.findElement(By.id("connection-phone")).sendKeys("297777777");
        mts.findElement(By.id("connection-sum")).sendKeys("10");
        mts.findElement(By.id("connection-email")).sendKeys("ds@mail.ru");
        mts.findElement(By.xpath("//div[@class='pay__forms']//button[@class='button button__default ']")).click();

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='bepaid-app__container']//iframe[@class='bepaid-iframe']"))) != null)
                .isEqualTo(true);
    }
}
