import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

// Create Before Method and After methods to close and open browser
// //Create BaseTest file and move setup and teardown there

    public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    @Parameters("URL")
    public void setUp(String url)  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        // options.addArguments("headless");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         wait = new WebDriverWait(driver, 4);
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
