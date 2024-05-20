import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class Abstract {

    public static EventFiringWebDriver mts;
    public static ChromeOptions chromeOptions;
    public static WebDriverWait wait;
    public static String urlMts = "https://www.mts.by";

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        mts = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
        mts.register(new Custom());

        mts.get(urlMts);
        mts.findElement(By.xpath("//div[@class='cookie__buttons']//button[@class='btn btn_black cookie__ok']")).click();
        wait = new WebDriverWait(mts, 10);
    }

    @BeforeEach
    public void init() {
        setUp();
    }

}
