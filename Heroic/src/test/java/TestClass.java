import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Components.EditorPage;
import Components.LoginPage;
import Components.Sidebar;
import Components.TinyMCE;
import SupportClasses.SupportMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
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
     public void t1() throws InterruptedException {
        webDriver.get("https://community.pekama.com/login");
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//button[contains(text(),'Sign In')]")))).click();
         System.out.println(webDriver.findElements(By.xpath("//div[@class='field__error-item']")));
        webDriver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("qqqqqqq");
        Thread.sleep(2000);
         System.out.println(webDriver.findElement(By.xpath("//input[@id='user_email']")).getText());
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
        webDriver.findElement(By.cssSelector(".login-checkbox .checkbox__icon")).click();
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

    @Test
    public void testReg() throws InterruptedException {
        webDriver.get("https://heroicnow.com/step1.php?id=1&site=46");
        webDriver.findElement(By.xpath("//label[@for='checkboxagree']")).click();
        webDriver.findElement(By.xpath("//button[@id='submit']")).click();
        System.out.println(webDriver.findElements(By.cssSelector(".valid")).size());
        Assert.assertTrue(!webDriver.findElement(By.cssSelector(".valid")).isDisplayed());
        Assert.assertTrue(webDriver.findElements(By.cssSelector(".valid")).size() > 0);
        Assert.assertEquals(1, webDriver.findElements(By.cssSelector(".valid")).size());
    }

    private void handleMultipleWindows(String windowTitle) {
        Set<String> windows = webDriver.getWindowHandles();

        for (String window : windows) {
            webDriver.switchTo().window(window);
            if (webDriver.getTitle().contains(windowTitle)) {
                return;
            }
        }
    }


    @Test
    public void termOfUseWorks() throws InterruptedException {
        webDriver.get("https://heroicnow.com/step1.php?id=1&site=46");
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//span[contains(text(),'terms of service')]")))).click();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        System.out.println(webDriver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header__form")));
        Assert.assertTrue(webDriver.findElement(By.cssSelector(".header__form")).isDisplayed());
    }

    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
