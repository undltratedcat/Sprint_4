import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CoreTest {
    WebDriver driver;

    @Before
    public void beforeTest() {
        String browser = System.getProperty("browser", "chrome");
        setupDriver(browser);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void setupDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
