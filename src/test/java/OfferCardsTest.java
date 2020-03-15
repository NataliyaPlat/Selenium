import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
//1. Assert only 10 cards appears on page

public class OfferCardsTest extends BaseTest {

    @Test
    public void OfferListSizeTest () throws InterruptedException{
        driver.get("https://testkwidos.tk/offer/search");
        Thread.sleep(2000);
        List<WebElement> cardLists = driver.findElements(By.cssSelector("[class*='card-shape']"));
        Assert.assertEquals(cardLists.size(),10);
    }
    //2. Filter by service type and make sure that only services with given service type are shown on the page


    @Test
    public void FilterByServiceTypeTest() throws InterruptedException{
        driver.get("https://testkwidos.tk/offer/search");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[contains(text(), 'Service Type')]/../p-multiselect")).click();
        driver.findElement(By.xpath("//label[contains(text(), '3D Capture')]")).click();
        Thread.sleep(2000);
        List<WebElement> serviceTypeCards = driver.findElements(By.cssSelector("[class*='service-type-flex']"));
        for (WebElement element: serviceTypeCards){
            System.out.println(element.getText());
            Assert.assertEquals(element.getText(), "3D Capture");
        }
    }
}
