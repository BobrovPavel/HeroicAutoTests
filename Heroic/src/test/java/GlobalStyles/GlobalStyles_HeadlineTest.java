package GlobalStyles;

import Pages.*;
import SupportClasses.GlobalHelper;
import SupportClasses.SupportMethod;
import SupportClasses.Variables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class GlobalStyles_HeadlineTest {
    static WebDriver webDriver;
    static WebDriverWait wait;
    private static LoginPage loginPage(){
        return new LoginPage(webDriver);
    }
    private static TinyMCE tinyMCE(){
        return new TinyMCE(webDriver);
    }
    private static Sidebar sidebar(){
        return new Sidebar(webDriver);
    }
    private static EditorPage editorPage(){
        return new EditorPage(webDriver);
    }
    private static SupportMethod supportMethod(){
        return new SupportMethod(webDriver);
    }
    private static Variables variables(){
        return new Variables(webDriver);
    }
    private static GlobalStyles globalStyles(){
        return  new GlobalStyles(webDriver);
    }
    private static GlobalHelper globalHelper(){
        return  new GlobalHelper(webDriver);
    }


    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 45, 300);
        webDriver.get("https://stg.heroicnow.com/?token=d84dbc4913dc05e5071342c3bee4fb6e5ffe443e");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
//        supportMethod().createElement("header");
        wait = new WebDriverWait(webDriver, 5, 300);
        supportMethod().waitAndClick(sidebar().globalStyles);
        supportMethod().waitAndClick(sidebar().headerStyles);
    }
    @Before
    public void preCondition(){
        supportMethod().waitAndClick(globalStyles().globalH1);
        supportMethod().waitAndClick(globalStyles().overViewMode);
    }
    @Test
    public void changeFontFamily_H1_OverView() throws InterruptedException {
        System.out.println(globalHelper().getHeadlineGlobalValue(1, "font family"));
        supportMethod().waitAndClick((WebElement) globalHelper().getHeaderFontDropdown_globalStyle().get(0));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        System.out.println(globalHelper().getHeadlineGlobalValue(1, "font family"));
        supportMethod().waitAndClick((WebElement) globalHelper().getHeaderFontDropdown_globalStyle().get(0));
        supportMethod().waitAndClick(globalStyles().asap_font);
        Thread.sleep(3000);
        System.out.println(globalHelper().getHeadlineGlobalValue(1, "font family"));
        supportMethod().waitAndClick(globalStyles().globalH1);
    }
    @Test
    public void TestchangeFontSize_H1_OverView() throws InterruptedException {
        Actions action = new Actions(webDriver);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).perform();
        Thread.sleep(500);
        String newValue = globalHelper().getHeadlineGlobalValue(1, "font size");
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), defaultValue);
        String oldValue = globalHelper().getHeadlineGlobalValue(1, "font size");
        Assert.assertEquals(supportMethod().toInt(defaultValue)-9, supportMethod().toInt(newValue));
        Assert.assertEquals(supportMethod().toInt(defaultValue), supportMethod().toInt(oldValue));
        supportMethod().waitAndClick(globalStyles().globalH1);
    }


    @After
    public void postCondition(){

    }


    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
