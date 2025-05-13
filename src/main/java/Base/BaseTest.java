package Base;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary{

    public static HomePage homePage=new HomePage();
    public static WelcomePage welcomePage =new WelcomePage();
    public static RegisterPage registerPage = new RegisterPage();
    public static LoginPage loginPage = new LoginPage();
    public static ProductsPage productsPage = new ProductsPage();



    @BeforeMethod
    public void openBrowser(){
        webDriver = new ChromeDriver();
        webDriver.get("https://www.automationexercise.com/");
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
