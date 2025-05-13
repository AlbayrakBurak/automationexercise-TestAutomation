import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test(description = "Sepete ürün ekleme - Başarılı ")
    public void AddToCartSuccessful() {
        String randomProductId = String.valueOf(randomNumber(9));
        homePage.clickAddToCart(randomProductId);
        String addToCartSuccessful =webDriver.findElement(By.cssSelector("[class='modal-title w-100']")).getText();
        assertEqualsText(addToCartSuccessful,addCartSuccess);
        webDriver.findElement(By.cssSelector("[class='btn btn-success close-modal btn-block']")).click();
    }

    @Test(description = "View Product - Başarılı")
    public void ViewProductSuccessful() {
        String randomProductId = String.valueOf(randomNumber(9));
        homePage.clickViewProduct(randomProductId);
        String expectedUrl = "https://www.automationexercise.com/product_details/" + randomProductId;
        assertEqualsText(getCurrentUrl(),expectedUrl);
    }

    @Test(description = "Brands - Başarılı")
    public void SelectBrands() {
        String brand = "Polo";
        homePage.clickBrands(brand);
        String expectedUrl = "https://www.automationexercise.com/brand_products/" + brand;
        assertEqualsText(getCurrentUrl(),expectedUrl);
    }
}
