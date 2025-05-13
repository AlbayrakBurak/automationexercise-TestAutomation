package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductsPage extends BaseTest {

    @Step("Your Name alanı doldurulur")
    public ProductsPage fillYourName(String text){
        webDriver.findElement(By.id("name")).sendKeys(text);
        return this;
    }

    @Step("E-Mail Address alanı doldurulur")
    public ProductsPage fillEmailAddress(String text){
        webDriver.findElement(By.id("email")).sendKeys(text);
        return this;
    }

    @Step("Review alanı doldurulur")
    public ProductsPage fillReview(String text){
        webDriver.findElement(By.id("review")).sendKeys(text);
        return this;
    }

    @Step("Submit butonuna tıklanır")
    public ProductsPage clickSubmitReview(){
        webDriver.findElement(By.id("button-review")).click();
        return this;
    }

    @Step("Success review mesajı alınır")
    public String getSuccessReviewMessage(){
        screenshot();
        return webDriver.findElement(By.cssSelector("[style='font-size: 20px;']")).getText();
    }
}
