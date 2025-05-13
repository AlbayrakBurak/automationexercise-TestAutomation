import Base.BaseTest;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {

    @Test(description = "Kayıt işlemi - Başarılı")
    public void RegisterSuccessful() {
        String userName = "test" + randomNumber(1000000);
        String emailAddress = userName+ "@gmail.com";
        String title = "Mr";
        String userPassword = "test";
        String userDateOfBirthday = "23-05-1999";
        String[] dateParts = userDateOfBirthday.split("-");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String tempText = "test";
        String country = "United States";
        String phoneNumber = "5555555555";

        homePage.clickLoginOrRegister();
        registerPage.fillUsername(userName)
                .fillEmailAddress(emailAddress);
        homePage.clickRegister();
        registerPage.Title(title)
                .fillPassword(userPassword)
                .fillDay(day)
                .fillMonth(month)
                .fillYear(year)
                .NewsletterOptin()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillCompanyName(tempText)
                .fillAddress(tempText)
                .fillCountry(country)
                .fillAddressState(tempText)
                .fillAddressCity(tempText)
                .fillZipCode(tempText)
                .fillPhoneNumber(phoneNumber)
                .clickRegister();
        String welcomeText = welcomePage.getWelcomeText();
        assertEqualsText(welcomeText.toLowerCase(), "Account Created!".toLowerCase());
        System.out.println(emailAddress);
    }

    @Test(description = "Kayıt işlemi - Başarısız Mail zaten kayıtlı")
    public void RegisterUnSuccessful() {
        String userName = "test" + randomNumber(1000000);
        String emailAddress = "test@gmail.com";
        homePage.clickLoginOrRegister();
        registerPage.fillUsername(userName)
                .fillEmailAddress(emailAddress);
        homePage.clickRegister();
        String errorText = registerPage.getRegisterErrorMessage();
        assertEqualsText(errorText.trim(), registerErrorMessage.trim());
    }
}
