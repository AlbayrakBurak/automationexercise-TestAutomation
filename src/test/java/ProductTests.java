import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        try {
            Thread.sleep(1000); // 1 saniye bekle
        } catch (InterruptedException e) {
            e.printStackTrace(); // İstisna olursa logla
        }
        assertEqualsText(addToCartSuccessful, addCartSuccess);
    }

    @Test(description = "View Product - Başarılı")
    public void ViewProductSuccessful() {
        String randomProductId = String.valueOf(randomNumber(9));
        homePage.clickViewProduct(randomProductId);
        String expectedUrl = "https://www.automationexercise.com/product_details/" + randomProductId;
        assertEqualsText(getCurrentUrl(), expectedUrl);
    }

    @Test(description = "Brands - Başarılı")
    public void SelectBrands() {
        String brand = "Polo";
        homePage.clickBrands(brand);
        String expectedUrl = "https://www.automationexercise.com/brand_products/" + brand;
        assertEqualsText(getCurrentUrl(), expectedUrl);
    }

    @Test(description = "Review Product - Başarılı")
    public void ReviewProductSuccessful() {
        String randomProductId = String.valueOf(randomNumber(9));
        homePage.clickViewProduct(randomProductId);
        productsPage.fillYourName(name)
                .fillEmailAddress(emailAddress)
                .fillReview(reviewText);
        WebElement submitButton = webDriver.findElement(By.id("button-review"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", submitButton);
        //productsPage.clickSubmitReview();  ----- Reklama tıkladığı için kapatıldı
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-row:not(.hide)")));
        String successReviewMessage = productsPage.getSuccessReviewMessage();
        assertEqualsText(successReviewMessage, "Thank you for your review.");
    }
}
