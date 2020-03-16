import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// Create Before Method and After methods to close and open browser
// //Create BaseTest file and move setup and teardown there


        public class BaseTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp()  {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
