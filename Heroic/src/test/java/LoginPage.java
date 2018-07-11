import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "user_email")
    WebElement EmailField;
    @FindBy (id = "user_password")
    WebElement PasswordField;
    @FindBy (xpath = "//button[@id='submit']")
    WebElement SignInButton;
    @FindBy (css = "#new_user > div.alert")
    WebElement AllertField;

    @FindBy (id = "tmp_button-98358mainText")
    WebElement WaitFor;

    @FindBy (css = "#new_user > div:nth-child(4) > a")
    WebElement RestoringPassword;

    @FindBy (id = "id_email")
    WebElement RestPassEmailField;

    @FindBy (css = "body > div > div > div > div > div > div.login > form > div.login-button.btn-section > button")
    WebElement RestPassButton;

    @FindBy (xpath = "//div[@class='alert']")
    WebElement RestPassAllerField;

    @FindBy (css = "body > div > div > div > div > div > div.login > form > div.form-footer-link-section > ul > li > a")
    WebElement BackToLogin;

    @FindBy (css = "#new_user > div:nth-child(5) > a")
    WebElement DontHaveAccount;
}
