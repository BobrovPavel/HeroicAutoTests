package Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver webDriver;

    public LoginPage(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "user_email")
    public WebElement EmailField;
    @FindBy (id = "user_password")
    public WebElement PasswordField;
    @FindBy (xpath = "//button[@id='submit']")
    public WebElement SignInButton;
    @FindBy (css = "#new_user > div.alert")
    public WebElement AllertField;

    @FindBy (id = "tmp_button-98358mainText")
    public WebElement WaitFor;

    @FindBy (css = "#new_user > div:nth-child(4) > a")
    public WebElement RestoringPassword;

    @FindBy (id = "id_email")
    public WebElement RestPassEmailField;

    @FindBy (css = "body > div > div > div > div > div > div.login > form > div.login-button.btn-section > button")
    public WebElement RestPassButton;

    @FindBy (xpath = "//div[@class='alert']")
    public WebElement RestPassAllerField;

    @FindBy (css = "body > div > div > div > div > div > div.login > form > div.form-footer-link-section > ul > li > a")
    public WebElement BackToLogin;

    @FindBy (css = "#new_user > div:nth-child(5) > a")
    public WebElement DontHaveAccount;
}
