package Pages;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BaseTest {

    @Step("Giriş/Kayıt butonuna tıklanır")
    public HomePage clickLoginOrRegister(){
        webDriver.findElement(By.cssSelector("[href*='login']")).click();
        return this;
    }

    @Step("Kayıt butonuna tıklanır")
    public HomePage clickRegister(){
        webDriver.findElement(By.cssSelector("[data-qa='signup-button']")).click();
        return this;
    }


    @Step("Add To Cart butonuna tıklanır")
    public HomePage clickAddToCart(String productId){
        webDriver.findElement(By.xpath("//a[@data-product-id='" + productId + "' and contains(@class, 'add-to-cart')]")).click();
        screenshot();
        return this;
    }

    @Step("View Product butonuna tıklanır")
    public HomePage clickViewProduct(String productId){
        webDriver.findElement(By.cssSelector("[href='/product_details/"+productId+"']")).click();
        screenshot();
        return this;
    }

}
