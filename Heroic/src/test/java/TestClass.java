import java.util.List;

import Pages.EditorPage;
import Pages.LoginPage;
import Pages.Sidebar;
import Pages.TinyMCE;
import SupportClasses.SupportMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass{
        static WebDriver webDriver;
        static WebDriverWait wait;

    public LoginPage loginPage(){
        return new LoginPage(webDriver);
    }
    public TinyMCE tinyMCE(){
        return new TinyMCE(webDriver);
    }
    public Sidebar sidebar(){
        return new Sidebar(webDriver);
    }
    public static EditorPage editorPage(){
        return new EditorPage(webDriver);
    }
    public static SupportMethod supportMethod(){
        return new SupportMethod(webDriver);
    }

    @BeforeClass
    public static void setupClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 45, 300);
//        webDriver.get("https://stg.heroicnow.com/?token=934bcf42fe93b2bef4da86bbcecd98d854231e8b");
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
        wait = new WebDriverWait(webDriver, 5, 300);
     }

     @Test
     public void test() throws InterruptedException {
        webDriver.get("https://community.pekama.com/login");
        webDriver.findElement(By.cssSelector("[ng-model=\"vm.email\"]")).sendKeys("qweqwe@mail.ru");
        Thread.sleep(2000);
     }

    @Test
    public void tests() throws InterruptedException {
        Actions action = new Actions(webDriver);
        
        wait.until(ExpectedConditions.elementToBeClickable(sidebar().newPageButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().blankCanvas)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().fullWidthSection)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().fullWidthColumn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//div[contains(@class,'sidebar-properties-item__extra-content_section')]//span[contains(@class,'button-add-element__icon')]")))).click();
        List<WebElement> rows = webDriver.findElements(By.xpath("//div[@class='modal-choose-column__item column-grid']"));
        for(int i = 0; i < rows.size(); i++){
            Thread.sleep(2000);
            rows = webDriver.findElements(By.xpath("//div[@class='modal-choose-column__item column-grid']"));
            wait.until(ExpectedConditions.elementToBeClickable(rows.get(i))).click();
            action.moveToElement(webDriver.findElement(By.xpath("//div[contains(@class,'sidebar-properties-item__extra-content_section')]//span[contains(@class,'button-add-element__icon')]"))).perform();
            wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//div[contains(@class,'sidebar-properties-item__extra-content_section')]//span[contains(@class,'button-add-element__icon')]")))).click();
        }
    }

    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
