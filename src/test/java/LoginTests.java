import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Başarılı kullanıcı girişi")
    public void LoginSuccessful() {
        homePage.clickLoginOrRegister();
        loginPage.fillEmailAddress(emailAddress)
                .fillPassword(password)
                .clickLoginButton();
        assertEqualsText(getCurrentUrl(), overviewUrl);
    }

    @Test(description = "Başarısız kullanıcı girişi ")
    public void LoginUnSuccessful() {
        homePage.clickLoginOrRegister();
        loginPage.fillEmailAddress(emailAddress)
                .fillPassword("aaa")
                .clickLoginButton();
        String errorText = loginPage.getErrorMessage();
        assertEqualsText(errorText.trim(), errorMessage.trim());
    }

    @Test(description = "Zorunlu karakter kontrolü")
    public void LoginRequiredController() {
        homePage.clickLoginOrRegister();
        loginPage.fillEmailAddress(emailAddress);
        String passwordValue = webDriver.findElement(By.cssSelector("[data-qa='login-password']")).getAttribute("value");

        if (!passwordValue.isEmpty()) {
            loginPage.clickLoginButton();
        } else {
            assertPasswordFieldIsEmpty(passwordValue);
        }
    }
}
