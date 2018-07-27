package SupportClasses;

import Pages.EditorPage;
import Pages.LoginPage;
import Pages.Sidebar;
import Pages.TinyMCE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GlobalHelper {
    WebDriver webDriver;


    public GlobalHelper (WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
    public LoginPage loginPage(){
        return new LoginPage(webDriver);
    }
    public TinyMCE tinyMCE(){
        return new TinyMCE(webDriver);
    }
    public Sidebar sidebar(){
        return new Sidebar(webDriver);
    }
    public EditorPage editorPage(){
        return new EditorPage(webDriver);
    }

    public List<WebElement> getSliderRoles(){
        return webDriver.findElements(By.xpath("//div[@class='accordion-panel__inner accordion-panel__inner_open']//div[@role='slider']"));
    }
    public List<WebElement> getInputGlobalStyles(){
        return webDriver.findElements(By.xpath("//div[@class='accordion-panel__inner accordion-panel__inner_open']//input"));
    }
    public void setDefaultValue (WebElement webElement, String oldValue){
        oldValue = oldValue.replaceAll("[^0-9]", "");
        webElement.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        webElement.sendKeys(oldValue);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
        }
    }

    public String getHeadlineGlobalValue(int headlineType, String value){
        String result = null;
        switch (value.toLowerCase()){
            case "font family":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("font-family");
                break;
            case "font size":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("font-size");
                break;
            case "line height":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("line-height");
                break;
            case "letter spacing":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("letter-spacing");
                break;
            case "paragraph spacing":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("margin-bottom");
                break;
            case "dark color":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("color");
                break;
        }
        return result;
    }
    public List getHeaderFontDropdown_globalStyle(){
        List<WebElement> headerFontDropdown = new ArrayList<>();
        headerFontDropdown = webDriver.findElements(By.xpath("//div[@class='select-panel-list__inner']"));
        return headerFontDropdown;
    }
}
