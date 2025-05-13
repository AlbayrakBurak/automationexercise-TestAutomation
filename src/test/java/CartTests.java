import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(description = "Başarılı Sepete ürün ekleme")
    public void AddToCartSuccessful() {
        String randomProductId = String.valueOf(randomNumber(20));
        homePage.clickAddToCart(randomProductId);
        String addToCartSuccessful =webDriver.findElement(By.cssSelector("[class='modal-title w-100']")).getText();
        assertEqualsText(addToCartSuccessful,addCartSuccess);
        webDriver.findElement(By.cssSelector("[class='btn btn-success close-modal btn-block']")).click();
    }

    @Test(description = "Başarılı View Product ")
    public void ViewProductSuccessful() {
        String randomProductId = String.valueOf(randomNumber(20));
        homePage.clickViewProduct(randomProductId);
        String expectedUrl = "https://www.automationexercise.com/product_details/" + randomProductId;
        assertEqualsText(getCurrentUrl(),expectedUrl);
    }
}
