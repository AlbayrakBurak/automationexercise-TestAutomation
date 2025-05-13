import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Kullanıcı girişi - Başarılı")
    public void LoginSuccessful() {
        homePage.clickLoginOrRegister();
        loginPage.fillEmailAddress(emailAddress)
                .fillPassword(password)
                .clickLoginButton();
        assertEqualsText(getCurrentUrl(), overviewUrl);
    }

    @Test(description = "Kullanıcı girişi - Başarısız")
    public void LoginUnSuccessful() {
        homePage.clickLoginOrRegister();
        loginPage.fillEmailAddress(emailAddress)
                .fillPassword("aaa")
                .clickLoginButton();
        String errorText = loginPage.getLoginErrorMessage();
        assertEqualsText(errorText.trim(), loginErrorMessage.trim());
    }

    @Test(description = "Zorunlu şifre kontrolü - Şifre eksik")
    public void LoginRequiredController() {
        homePage.clickLoginOrRegister();
        loginPage.fillEmailAddress(emailAddress);
        String passwordValue = webDriver.findElement(By.cssSelector("[data-qa='login-password']")).getAttribute("value");
        loginPage.clickLoginButton();
        assertPasswordFieldIsEmpty(passwordValue);
    }

    @Test(description = "E-mail adres geçerliliği kontrolü - Mail geçersiz")
    public void LoginEmailVerify() {
        homePage.clickLoginOrRegister();
        loginPage.fillEmailAddress(wrongEmailAddress);
        loginPage.fillPassword(password);
        String emailValue = webDriver.findElement(By.cssSelector("[data-qa='login-email']")).getAttribute("value");
        loginPage.clickLoginButton();
        assertEmailFieldVerify(emailValue);
    }
}
