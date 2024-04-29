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

    @Test
    public void checkingName(){
        mts.get("https://www.mts.by");
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

        assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']//h2"))) != null)
                .isEqualTo(true);
    }

    @Test
    public void checkingPaymentSystemsLogo(){
        WebDriverWait wait = new WebDriverWait(mts, Duration.ofSeconds(10));

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
    }

    @Test
    public void checkingButtonContinue(){

        mts.findElement(By.id("connection-phone")).sendKeys("297777777");
        mts.findElement(By.id("connection-sum")).sendKeys("10");
        mts.findElement(By.id("connection-email")).sendKeys("ds@mail.ru");
        mts.findElement(By.xpath("//div[@class='pay__forms']//form[@class='pay-form opened']//button[@class='button button__default ']")).click();
    }
}
