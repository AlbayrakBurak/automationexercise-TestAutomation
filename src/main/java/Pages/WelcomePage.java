package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WelcomePage extends BaseTest {

    @Step("Welcome mesajı alınır")
    public String getWelcomeText(){
        screenshot();
        return webDriver.findElement(By.cssSelector("[data-qa='account-created']")).getText();
    }
}
