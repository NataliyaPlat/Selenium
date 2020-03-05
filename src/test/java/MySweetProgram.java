import org.junit.Test;
import org.openqa.selenium.By;
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

    @Test
    public void LoginWrongCredentialTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testkwidos.tk/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#email")).sendKeys("europlatinum@mail.ru");

        driver.findElement(By.cssSelector("#password")).sendKeys("Newjob2!");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }

    @Test
    public void ServiceProviderRegistrationTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();git
        driver.get("https://testkwidos.tk/auth/register/contractor");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("Nataliya");

        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Platonova");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("Drowa");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("8897653216");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("drowa1582@gmail.com");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Newjob2020!!");
        Thread.sleep (2000);
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();

        driver.findElement(By.cssSelector("[type='submit']")).click();
        //String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        //Assert.assertEquals(actualText, "Username or password is incorrect");
    }
}



