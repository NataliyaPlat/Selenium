import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MySweetProgram {

    @Test
    public void titleTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testkwidos.tk/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Kwidos");
        driver.quit();
    }

}
