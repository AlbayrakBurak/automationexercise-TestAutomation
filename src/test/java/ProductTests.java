import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTests extends BaseTest {

    @Test(description = "Sepete ürün ekleme - Başarılı ")
    public void AddToCartSuccessful() {
        String randomProductId = String.valueOf(randomNumber(9));
        homePage.clickAddToCart(randomProductId);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='modal-title w-100']")));
        String addToCartSuccessful = modalTitle.getText();
        //String addToCartSuccessful =webDriver.findElement(By.cssSelector("[class='modal-title w-100']")).getText();
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
