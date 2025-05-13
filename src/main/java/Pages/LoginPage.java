package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

    @Step("Username alanı doldurulur")
    public LoginPage fillEmailAddress(String email){
        webDriver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys(email);
        return this;
    }

    @Step("Password alanı doldurulur")
    public LoginPage fillPassword(String password){
        webDriver.findElement(By.cssSelector("[data-qa='login-password']")).sendKeys(password);
        return this;
    }


    @Step("Login butonuna tıklanır")
    public LoginPage clickLoginButton(){
        webDriver.findElement(By.cssSelector("[data-qa='login-button']")).click();
        return this;
    }

    @Step("Login Hata mesajı alınır")
    public String getLoginErrorMessage(){
        String errorText = webDriver.findElement(By.cssSelector("[style='color: red;']")).getText();
        screenshot();
        return errorText;
    }
    
}
