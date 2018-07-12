package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver webDriver;

    public RegistrationPage (WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (name = "firstname")
    WebElement FirstName;
    @FindBy (name = "lastname")
    WebElement Lastname;
    @FindBy (name = "email")
    WebElement Email;
    @FindBy (name = "password")
    WebElement Password;
    @FindBy (name = "passwordconfirm")
    WebElement Passwordconfirm;
        @FindBy(id = "firstname-error")
    WebElement AllertFirstName;
    @FindBy (id = "lastname-error")
    WebElement AllertLastName;
    @FindBy (id = "email-field-error")
    WebElement AllertEmail;
    @FindBy (xpath = "//div[@id='password-error']")
    WebElement AllertPassword;
    @FindBy (id = "checkboxagree-error")
    WebElement AllertCheckBox;
    @FindBy (css = "#step1form > div.form-checkbox > label")
    WebElement CheckBox;
    @FindBy (id = "submit")
    WebElement SignUpButton;
    @FindBy (css = "#step1form > div.form-description > a")
    WebElement AlreadyAccount;
}

