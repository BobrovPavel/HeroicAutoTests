import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import Pages.EditorPage;
import Pages.LoginPage;
import Pages.Sidebar;
import Pages.TinyMCE;
import SupportClasses.SupportMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
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
     public void test() throws InterruptedException, AWTException {

      Actions action = new Actions(webDriver);

             webDriver.get("https://community.pekama.com/");
             Thread.sleep(2000);
         action.sendKeys(Keys.SPACE).click().perform();
         Thread.sleep(2000);
//             action.sendKeys(Keys.HOME).click().perform();
             Thread.sleep(2000);
             webDriver.findElement(By.cssSelector(".button.button_size_s ")).click();
             Thread.sleep(2000);


         JavascriptExecutor js = (JavascriptExecutor)webDriver;
         js.executeScript("document.querySelector('.sidebar-integration .sidebar-popup-menu__link')[0].click()");
     }
     @Test
     public void integration() throws InterruptedException {
        webDriver.get("https://community.pekama.com/login");
        webDriver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        Thread.sleep(2000);
        System.out.println(webDriver.findElements(By.xpath("//div[@class='field__error-item'][contains(text(),'This field may not be blank.')]")).size());
        Thread.sleep(2000);
        Assert.assertEquals(2, webDriver.findElements(By.xpath("//div[@class='field__error-item'][contains(text(),'This field may not be blank.')]")).size());
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
