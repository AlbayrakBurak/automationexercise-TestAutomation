package Base;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {

    public static HomePage homePage = new HomePage();
    public static WelcomePage welcomePage = new WelcomePage();
    public static RegisterPage registerPage = new RegisterPage();
    public static LoginPage loginPage = new LoginPage();
    public static ProductsPage productsPage = new ProductsPage();

    private final String browser = "chrome"; // "firefox", "edge" de olabilir

    @BeforeMethod
    public void openBrowser() {
        switch (browser.toLowerCase()) {
            case "chrome":
                webDriver = new ChromeDriver();
                break;
            case "edge":
                webDriver = new EdgeDriver();
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            default:
                System.out.println("Geçersiz tarayıcı: " + browser + ". Chrome ile devam ediliyor.");
                webDriver = new ChromeDriver();
        }

        webDriver.get("https://www.automationexercise.com/");
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
