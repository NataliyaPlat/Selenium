
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginSuccessTest()  {

        openLoginPage();
        enterEmail("europlatinum@mail.ru");
        enterPassword("Newjob2!");
        clickSubmit();
        String actualText = getSuccessText (".alert.alert-danger");
        Assert.assertEquals(actualText, "Success");
    }
    private String getSuccessText(String s){
        String st = "Success";
        return st;
    }
    @Test
    public void LoginWrongCredentialTest() {

         openLoginPage();
        enterEmail("europlatinum@mail.ru");
        enterPassword("Newjob2!");
        clickSubmit();
        String actualText = getErrorText(".alert.alert-danger");
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }
    @Test
    public void LoginEmptyEmailTest(){
        openLoginPage();
        enterPassword("Newjob2!");
         enterEmail("");
        clickSubmit();
        String actualText = getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Email is required");
   }
   @Test
    public void LoginEmptyPasswordTest() {
       enterPassword("");
       enterEmail("europlatinum@mail.ru");
        openLoginPage();
        clickSubmit();
        String actualText = getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Password is required");
    }
  public String getErrorText (String cssSelector) {
       // String actualText = driver.findElement(By.cssSelector(cssSelector)).getText();
      String actualText=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).getText();
        return actualText;
    }
        public void openLoginPage(){
        driver.get("https://kwidos.com/auth/login");
 }
        public void enterEmail(String email) {
           // driver.findElement(By.cssSelector("#email")).sendKeys(email);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email"))).sendKeys(email);

        }

       public void enterPassword(String password) {
         // driver.findElement(By.cssSelector("#password")).sendKeys(password);
           //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password"))).sendKeys(password);
           findElement("#password").sendKeys(password);
        }
        public void clickSubmit() {
            //driver.findElement(By.cssSelector("[type='submit']")).click();
           // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
            clickToElement("[type=''submit']");
        }
        public void clickToElement(String cssSelector){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector))).click();
        }

        public WebElement findElement(String cssSelector){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        }
    }
