package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BaseTest {

    @Step("Hitap alanı doldurulur")
    public RegisterPage Title(String text){
        if(text.equals("Mr")){
            webDriver.findElement(By.id("id_gender1")).click();
        }
        else if(text.equals("Mrs")){
            webDriver.findElement(By.id("id_gender2")).click();
        }
        return this;
    }

    @Step("Username alanı doldurulur")
    public RegisterPage fillUsername(String text){
        webDriver.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys(text);
        return this;
    }

    @Step("Email Address alanı doldurulur")
    public RegisterPage fillEmailAddress(String text){
        webDriver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(text);
        return this;
    }

    @Step("Password alanı doldurulur")
    public RegisterPage fillPassword(String text){
        webDriver.findElement(By.cssSelector("[data-qa='password']")).sendKeys(text);
        return this;
    }

    @Step("Date of Birth alanı doldurulur")
    public RegisterPage fillDay(int text){
        WebElement daysDropdown = webDriver.findElement(By.cssSelector("[data-qa='days']"));
        Select select =new Select(daysDropdown);
        select.selectByValue(String.valueOf(text));
        return this;
    }
    public RegisterPage fillMonth(int text){
        WebElement monthsDropdown = webDriver.findElement(By.cssSelector("[data-qa='months']"));
        Select select =new Select(monthsDropdown);
        select.selectByValue(String.valueOf(text));
        return this;
    }
    public RegisterPage fillYear(int text){
        WebElement yearsDropdown = webDriver.findElement(By.cssSelector("[data-qa='years'"));
        Select select =new Select(yearsDropdown);
        select.selectByValue(String.valueOf(text));
        return this;
    }

    @Step("Bülten ve Teklifler checkboxları Tıklama")
    public RegisterPage NewsletterOptin(){
        webDriver.findElement(By.id("newsletter")).click();
        webDriver.findElement(By.id("optin")).click();
        return this;
    }


    @Step("FirstName alanı doldurulur")
    public RegisterPage fillFirstName(String text){
        webDriver.findElement(By.id("first_name")).sendKeys(text);
        return this;
    }


    @Step("LastName alanı doldurulur")
    public RegisterPage fillLastName(String text){
        webDriver.findElement(By.id("last_name")).sendKeys(text);
        return this;
    }

    @Step("Company alanı doldurulur")
    public RegisterPage fillCompanyName(String text){
        webDriver.findElement(By.id("company")).sendKeys(text);
        return this;
    }

    @Step("Address alanı doldurulur")
    public RegisterPage fillAddress(String text){
        webDriver.findElement(By.id("address1")).sendKeys(text);
        webDriver.findElement(By.id("address2")).sendKeys(text);
        return this;
    }

    @Step("Register Hata mesajı alınır")
    public String getRegisterErrorMessage(){
        String errorText = webDriver.findElement(By.cssSelector("[style='color: red;']")).getText();
        screenshot();
        return errorText;
    }

    public RegisterPage fillCountry(String text){
        WebElement countryDropdown = webDriver.findElement(By.cssSelector("[data-qa='country']"));
        Select select =new Select(countryDropdown);
        select.selectByValue(text);
        return this;
    }

    @Step("AddressState alanı doldurulur")
    public RegisterPage fillAddressState(String text){
        webDriver.findElement(By.id("state")).sendKeys(text);
        return this;
    }

    @Step("AddressCity alanı doldurulur")
    public RegisterPage fillAddressCity(String text){
        webDriver.findElement(By.id("city")).sendKeys(text);
        return this;
    }


    @Step("ZipCode alanı doldurulur")
    public RegisterPage fillZipCode(String text){
        webDriver.findElement(By.id("zipcode")).sendKeys(text);
        return this;
    }

    @Step("PhoneNumber alanı doldurulur")
    public RegisterPage fillPhoneNumber(String text){
        webDriver.findElement(By.id("mobile_number")).sendKeys(text);
        return this;
    }


    @Step("Register butonuna tıklanır")
    public RegisterPage clickRegister(){
        webDriver.findElement(By.cssSelector("[data-qa='create-account']")).click();
        screenshot();
        return this;
    }

}
