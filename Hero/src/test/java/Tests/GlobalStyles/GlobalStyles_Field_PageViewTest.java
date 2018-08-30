package Tests.GlobalStyles;

import Components.*;
import SupportClasses.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalStyles_Field_PageViewTest {
    private static WebDriver webDriver;
    private static WebDriverWait wait;
    private static Actions action;
    private static LoginPage loginPage(){
        return new LoginPage(webDriver);
    }
    private static Factory factory(){
        return new Factory(webDriver);
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
    private static Constants constants(){
        return new Constants();
    }


    @BeforeClass
    public static void setupClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 45, 300);
        action = new Actions(webDriver);
        webDriver.get(constants().QA_GLOBALSTYLES_FIELD_PAGEVIEW);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
        supportMethod().createThreeColumnRowAndAddElements_firstSection(editorPage().elementInput);
        supportMethod().createThreeColumnRowAndAddElements_anySection(editorPage().elementTextArea,0);
        supportMethod().createThreeColumnRowAndAddElements_anySection(editorPage().elementDroplist,1);
        supportMethod().createThreeColumnRowAndAddElements_anySection(editorPage().elementCheckbox,2);
        supportMethod().createThreeColumnRowAndAddElements_anySection(editorPage().elementRadiobox,3);
        supportMethod().waitAndClick(sidebar().globalStyles);
        globalHelper().setInputFieldsType();
        globalHelper().setElementsType();
        supportMethod().waitAndClick(sidebar().globalStyles);
        sidebar().paragraphStylesClick();
        wait = new WebDriverWait(webDriver, 10, 300);
    }








    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
