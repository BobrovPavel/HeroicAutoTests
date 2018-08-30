import Components.EditorPage;
import Components.LoginPage;
import Components.Sidebar;
import Components.TinyMCE;
import SupportClasses.SupportMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Init {
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
        webDriver.get("https://app.heroicnow.com/?token=934bcf42fe93b2bef4da86bbcecd98d854231e8b");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
    }
    @Test
    public void t1() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[contains(@class,'icon-svg-settings')]")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//a[contains(text(),'Integrations')]")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//button[contains(text(),'Add New Integration')]")))).click();
        webDriver.findElement(By.xpath("//div[@class='without-accordion']//input")).sendKeys("123");
        wait.until(ExpectedConditions.attributeToBe(webDriver.findElement(By.xpath("//div[@class='without-accordion']//input")),"value","123"));
        System.out.println(webDriver.findElement(By.xpath("//div[@class='without-accordion']//input")).getAttribute("value"));
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//*[contains(@class,'icon-svg-arrow-right-button')]")))).click();
        Thread.sleep(5000);
    }
 
    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
