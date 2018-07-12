package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestsRegistration {

    WebSite webSite;
    Variable variable;
    static WebDriver webDriver;
    WebDriverWait wait;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://heroicnow.com/step1.php?id=1&site=46");
    }
    @Before
    public void preCondition() throws AWTException {
        variable = new Variable();
        webSite = new WebSite(webDriver);;
        wait = new WebDriverWait(webDriver, 30, 300);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void passwordLessThanMin(){
        webSite.registrationPage().Password.sendKeys(variable.lessThanMinPass);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Password.getAttribute("aria-invalid").contains("true"));
        Assert.assertTrue(webSite.registrationPage().AllertPassword.getText().contains("YOUR PASSWORD MUST BE AT LEAST 5 CHARACTERS LONG"));
    }
    @Test
    public void passwordMoreThanMax(){
        webSite.registrationPage().Password.sendKeys(variable.moreThanMaxPass);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Password.getAttribute("aria-invalid").contains("true"));
        Assert.assertTrue(webSite.registrationPage().AllertPassword.getText().contains("PLEASE ENTER NO MORE THAN 24 CHARACTERS."));
    }
    @Test
    public void passwordAverage(){
        webSite.registrationPage().Password.sendKeys(variable.averagePass);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Password.getAttribute("aria-invalid").contains("false"));
    }
    @Test
    public void passwordMin(){
        webSite.registrationPage().Password.sendKeys(variable.minPass);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Password.getAttribute("aria-invalid").contains("false"));
    }
    @Test
    public void passwordMax(){
        webSite.registrationPage().Password.sendKeys(variable.maxPass);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Password.getAttribute("aria-invalid").contains("false"));
    }


    @Test
    public void forstNameLessThatMin(){
        webSite.registrationPage().FirstName.sendKeys(variable.lessThanMinFirstName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().FirstName.getAttribute("aria-invalid").contains("true"));
    }
    @Test
    public void firstNameMoreThanMax(){
        webSite.registrationPage().FirstName.sendKeys(variable.moreThanMaxFirstName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().FirstName.getAttribute("aria-invalid").contains("false"));
    }
    @Test
    public void firstNameAverage(){
        webSite.registrationPage().FirstName.sendKeys(variable.averageFirstName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().FirstName.getAttribute("aria-invalid").contains("false"));
    }
    @Test
    public void firstNameOnlySpaces(){
        webSite.registrationPage().FirstName.sendKeys(variable.onlySpacesFirstName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().FirstName.getAttribute("aria-invalid").contains("true"));
    }
    @Test
    public void firstNameSpecialChar(){
        webSite.registrationPage().FirstName.sendKeys(variable.specialCharFirstName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().FirstName.getAttribute("aria-invalid").contains("true"));
    }


    @Test
    public void lastNameLessThatMin(){
        webSite.registrationPage().Lastname.sendKeys(variable.lessThanMinLastName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Lastname.getAttribute("aria-invalid").contains("true"));
    }
    @Test
    public void lastNameMoreThanMax(){
        webSite.registrationPage().Lastname.sendKeys(variable.moreThanMaxLastname);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Lastname.getAttribute("aria-invalid").contains("false"));
    }
    @Test
    public void lastNameAverage(){
        webSite.registrationPage().Lastname.sendKeys(variable.averageLastName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Lastname.getAttribute("aria-invalid").contains("false"));
    }
    @Test
    public void lastNameOnlySpaces(){
        webSite.registrationPage().Lastname.sendKeys(variable.onlySpacesLastName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Lastname.getAttribute("aria-invalid").contains("true"));
    }
    @Test
    public void lastNameSpecialChar(){
        webSite.registrationPage().Lastname.sendKeys(variable.specialCharLastName);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Lastname.getAttribute("aria-invalid").contains("true"));
    }


    @Test
    public void emailNoDomain(){
        webSite.registrationPage().Email.sendKeys(variable.noDomainEmail);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Email.getAttribute("aria-invalid").contains("true"));
    }
    @Test
    public void emailSpecialCharInGlobalPart(){
        webSite.registrationPage().Email.sendKeys(variable.specialCharInGlobalPartEmail);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Email.getAttribute("aria-invalid").contains("true"));
        Assert.assertTrue(webSite.registrationPage().AllertEmail.getText().contains("PLEASE ENTER A VALID EMAIL ADDRESS."));
    }
    @Test
    public void emailSpecialCharInLocalPart(){
        webSite.registrationPage().Email.sendKeys(variable.specialCharInLocalPartEmail);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Email.getAttribute("aria-invalid").contains("true"));
        Assert.assertTrue(webSite.registrationPage().AllertEmail.getText().contains("PLEASE ENTER A VALID EMAIL ADDRESS."));
    }
    @Test
    public void emailMoreThanMaxGlobalPart(){
        webSite.registrationPage().Email.sendKeys(variable.moreThanMaxGlobalPartEmail);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Email.getAttribute("aria-invalid").contains("true"));
        Assert.assertTrue(webSite.registrationPage().AllertEmail.getText().contains("PLEASE ENTER A VALID EMAIL ADDRESS."));
    }
    @Test
    public void emailAverageGlobalPart(){
        webSite.registrationPage().Email.sendKeys(variable.averageGlobalPartEmail);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Email.getAttribute("aria-invalid").contains("false"));
    }
    @Test
    public void EmailLotsOfLocalPart(){
        webSite.registrationPage().Email.sendKeys(variable.lotsOfCharInLocalPart);
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().Email.getAttribute("aria-invalid").contains("true"));
    }
    @Test
    public void emptyValues(){
        webSite.registrationPage().SignUpButton.click();
        Assert.assertTrue(webSite.registrationPage().AllertFirstName.getText().contains("PLEASE ENTER YOUR FIRSTNAME"));
        Assert.assertTrue(webSite.registrationPage().AllertLastName.getText().contains("PLEASE ENTER YOUR LASTNAME"));
        Assert.assertTrue(webSite.registrationPage().AllertEmail.getText().contains("PLEASE ENTER YOUR EMAIL ADDRESS."));
        Assert.assertTrue(webSite.registrationPage().AllertPassword.getText().contains("PLEASE PROVIDE A PASSWORD"));
        Assert.assertTrue(webSite.registrationPage().AllertCheckBox.getText().contains("PLEASE ACCEPT OUR TERMS OF SERVICE"));
    }


    @After
    public void postCondition() throws InterruptedException {
        webDriver.navigate().refresh();
    }



}
