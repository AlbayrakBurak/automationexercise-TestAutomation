import Base.BaseTest;
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
        loginPage.clickLoginButton();
        assertPasswordFieldIsEmpty(loginPage.verifyPassword());
    }

    @Test(description = "E-mail adres geçerliliği kontrolü - Mail geçersiz")
    public void LoginEmailVerify() {
        homePage.clickLoginOrRegister();
        loginPage.fillEmailAddress(wrongEmailAddress);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
        assertEmailFieldVerify(loginPage.verifyEmailValue());
    }
}
