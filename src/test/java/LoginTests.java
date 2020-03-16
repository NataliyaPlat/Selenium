import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginTests extends BaseTest {
    @Test
    public void LoginWrongCredentialTest() throws InterruptedException {

        // openLoginPage();
        //enterEmail("europlatinum@mail.ru");
        //enterPassword("Newjob2!");
        driver.get("https://kwidos.com/auth/login");
        driver.findElement(By.cssSelector("#email")).sendKeys("europlatinum@mail.ru");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#password")).sendKeys("Newjob2!");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        String actualText = getErrorText(".alert.alert-danger");
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }
    @Test
    public void LoginEmptyEmailTest() throws InterruptedException {
        // openLoginPage();
        // enterEmail("");
        driver.get("https://kwidos.com/auth/login");
        driver.findElement(By.cssSelector("#email")).sendKeys(" ");
        driver.get("https://kwidos.com/auth/login");
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#password")).sendKeys("Newjob2!");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);

        String actualText = getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Email is required");

//
   }
   @Test
    public void LoginEmptyPasswordTest() throws InterruptedException{
        //openLoginPage();
        driver.get("https://kwidos.com/auth/login");
        driver.findElement(By.cssSelector("#email")).sendKeys("europlatinum@mail.ru");
       driver.findElement(By.cssSelector("#password")).sendKeys("Password");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        String actualText = getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Password is required");

    }
  public String getErrorText (String cssSelector) throws InterruptedException{
       Thread.sleep(2000);
        String actualText = driver.findElement(By.cssSelector(cssSelector)).getText();
    return actualText;
    }
 public void openLoginPage(){
driver.get("https://testkwidos.tk/auth/login");
 }
        public void enterEmail(String email) throws InterruptedException {
        Thread.sleep(4000);
       driver.findElement(By.cssSelector("#email")).sendKeys(email);

      //  public void enterPassword (String password) throws InterruptedException {
        //    Thread.sleep(2000);
          //  driver.findElement(By.cssSelector("#password")).sendKeys(password);

        //}


    }
}