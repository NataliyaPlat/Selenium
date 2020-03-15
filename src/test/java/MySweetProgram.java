
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MySweetProgram extends BaseTest{

    @Test
    public void titleTest() {
        driver= new ChromeDriver();
        driver.get("https://www.kwidos.com/");
        String title = driver.getTitle();
        assertEquals(title, "Kwidos");
    }
    @Test
    public void ServiceProviderRegistrationTest() throws InterruptedException {
        driver.get("https://kwidos.com/auth/register/contractor");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("Nataliya");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Platonova");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("Drowa");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("8897653216");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("drowa1582@gmail.com");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Newjob2020!!");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();

        driver.findElement(By.cssSelector("[type='submit']")).click();
        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        assertEquals(actualText, "Username or password is incorrect");
    }
    }




