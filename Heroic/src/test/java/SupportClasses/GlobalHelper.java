package SupportClasses;

import Pages.*;
import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.InsufficientResourcesException;
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
    public GlobalHelper globalHelper(){
        return new GlobalHelper(webDriver);
    }
    public SupportMethod supportMethod(){
        return new SupportMethod(webDriver);
    }
    public GlobalStyles globalStyles(){;
        return new GlobalStyles(webDriver);
    }

    public List<WebElement> getSliderRoles(){
        return webDriver.findElements(By.xpath("//div[@class='accordion-panel__inner accordion-panel__inner_open']//div[@role='slider']"));
    }
    public List<WebElement> getInputGlobalStyles(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webDriver.findElements(By.xpath("//div[@class='accordion-panel__inner accordion-panel__inner_open']//input"));
    }
    public void setDefaultValue (WebElement webElement, String value){
        WebDriverWait wait = new WebDriverWait(webDriver, 10, 300);
        value = value.replaceAll("[a-zA-Zа-яА-Я]*", "");
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        webElement.sendKeys(value);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
        }
    }
    public void changeFontSize(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, 20, 300);
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).click();
        editorPage().headerText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void setDefaultColorValue(){
        WebDriverWait wait = new WebDriverWait(webDriver, 20, 300);
        Actions action = new Actions(webDriver);
        action.moveToElement(globalStyles().colorInput,0,-100).perform();
        wait.until(ExpectedConditions.elementToBeClickable(globalStyles().colorInput)).click();
        globalStyles().colorInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        globalStyles().colorInput.sendKeys("#00000");
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
                result = webDriver.findElement(By.cssSelector(".editorSectionsWripper .handle-size-headline-h"+headlineType+" .line-height-element-style:not(.not-global-element)")).getCssValue("font-size");
                break;
            case "letter spacing":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("letter-spacing");
                break;
            case "paragraph spacing":
                result = webDriver.findElement(By.xpath("//div[contains(@class,'insert-elements handle-size-headline-h"+headlineType+" headline-element')]//div[contains(@class,'dark-color font-size-element-style')]")).getCssValue("margin-bottom");
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
    public void changeColorWithColorPicker(){
        Actions action = new Actions(webDriver);
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){

        }
        action.moveToElement(tinyMCE().colorpicker,-30, 60).click().perform();
    }
}
