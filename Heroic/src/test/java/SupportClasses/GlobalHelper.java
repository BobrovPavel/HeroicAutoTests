package SupportClasses;

import Components.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GlobalHelper {
    private WebDriver webDriver;


    public GlobalHelper (WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
    private LoginPage loginPage(){
        return new LoginPage(webDriver);
    }
    private TinyMCE tinyMCE(){
        return new TinyMCE(webDriver);
    }
    private Sidebar sidebar(){
        return new Sidebar(webDriver);
    }
    private EditorPage editorPage(){
        return new EditorPage(webDriver);
    }
    private GlobalHelper globalHelper(){
        return new GlobalHelper(webDriver);
    }
    private SupportMethod supportMethod(){
        return new SupportMethod(webDriver);
    }
    private GlobalStyles globalStyles(){;
        return new GlobalStyles(webDriver);
    }
    private Variables variables(){;
        return new Variables(webDriver);
    }

    public List<WebElement> getSliderRoles(){
        return webDriver.findElements(By.xpath("//div[@class='accordion-panel__inner accordion-panel__inner_open']//div[@role='slider']"));
    }

    public List<WebElement> getInputGlobalStyles(){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return webDriver.findElements(By.xpath("//div[@class='accordion-panel__inner accordion-panel__inner_open']//input"));
    }

    public WebElement getColors(String value){
        List<WebElement> colors = webDriver.findElements(By.xpath("//div[@class='accordion-panel__inner accordion-panel__inner_open']//span[@class='select-color-section__color']"));
        WebElement element = null;
        switch (value.toLowerCase()){
            case "light color":
                element = colors.get(0);
                break;
            case "dark color":
                element = colors.get(1);
                break;
            case "bullet color":
                element = colors.get(2);
                break;
            case "number color":
                element = colors.get(3);
                break;
        }
        return element;
    }

    public void setDefaultValue (WebElement webElement, String value){
        WebDriverWait wait = new WebDriverWait(webDriver, 10, 300);
        value = value.replaceAll("[a-zA-Zа-яА-Я]*", "");
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        webElement.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        webElement.sendKeys(value);
        try {
            Thread.sleep(500);
        }catch (InterruptedException ignored){
        }
    }
    public void changeFontSize(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, 20, 300);
        Actions action = new Actions(webDriver);
        action.click(editorPage().headerText);
//        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).click();
        editorPage().headerText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        try {
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeFontSize)).click();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void applyBullet(){
        Actions action = new Actions(webDriver);
        if(webDriver.findElements(By.xpath("//div[contains(@id,'rect-tinymce-tmp_text')]//ul//li")).size() == 0) {
            action.click(editorPage().headerText);
            editorPage().headerText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            supportMethod().waitAndClick(tinyMCE().lists);
            supportMethod().waitAndClick(tinyMCE().bulletedList);
            supportMethod().waitAndClick(tinyMCE().closeLists);
        }
    }
    public void applyNumberBullet(){
        Actions action = new Actions(webDriver);
        if(webDriver.findElements(By.xpath("//div[contains(@id,'rect-tinymce-tmp_text')]//ol//li")).size() == 0) {
            action.click(editorPage().headerText);
            editorPage().headerText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            supportMethod().waitAndClick(tinyMCE().lists);
            supportMethod().waitAndClick(tinyMCE().numberedList);
            supportMethod().waitAndClick(tinyMCE().closeLists);
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


    public void checkInPageViewMode(WebElement fontSize,String newValue, String verifiedValue){
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().changeFontSize(fontSize);
        Assert.assertEquals(newValue, verifiedValue);
    }

    public void enterText(){
        Actions action = new Actions(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, 20, 300);
        editorPage().headerText.sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.oneLine);
        action.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.oneLine);
    }

    public String getParagraphGlobalValue(int paragraphType, String value){
        String result = null;
        switch (value.toLowerCase()){
            case "font family":
                result = webDriver.findElement(By.xpath("//div[contains(@class,'text-block-element text-element-p"+paragraphType+"')]//p")).getCssValue("font-family");
                break;
            case "font size":
                result = webDriver.findElement(By.xpath("//div[contains(@class,'text-block-element text-element-p"+paragraphType+"')]//div[@class='no-change-item font-size-element-style']")).getCssValue("font-size");
                break;
            case "line height":
                result = webDriver.findElement(By.xpath("//div[contains(@class,'text-element-p"+paragraphType+"')]//div[@class='line-height-element-style']")).getCssValue("font-size");
                break;
            case "letter spacing":
                result = webDriver.findElement(By.cssSelector(".editorSectionsWripper .text-element-p"+paragraphType+":not(.not-global-element)")).getCssValue("letter-spacing");
                break;
            case "paragraph spacing":
                result = webDriver.findElement(By.xpath("//div[contains(@class,'text-element-p"+paragraphType+"')]//p")).getCssValue("padding-bottom");
                break;
            case "dark color":
                result = webDriver.findElement(By.cssSelector(".editorSectionsWripper .text-element-p"+paragraphType)).getCssValue("color");
                break;
            case "bullet spacing":
                result = webDriver.findElement(By.xpath("//div[contains(@class,'text-element-p"+paragraphType+"')]//ul/li")).getCssValue("padding-bottom");
                break;
        }
        return result;
    }

    public List getFontFamilyDropdown(){
        List<WebElement> headerFontDropdown = new ArrayList<>();
        headerFontDropdown = webDriver.findElements(By.xpath("//div[@class='select-panel-list__inner']"));
        return headerFontDropdown;
    }
    public void changeColorWithColorPicker(){
        Actions action = new Actions(webDriver);
        try {
            Thread.sleep(500);
        }catch (InterruptedException ignored){

        }
        action.moveToElement(tinyMCE().colorpicker,-30, 60).click().perform();
    }
    public void changeColorWithPalette() throws InterruptedException {
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath("//div[@class='color-picker-item__palette']//i"));
        Thread.sleep(500);
        supportMethod().waitAndClick(colors.get(1));
    }
    public String getColorPalette(int index){
        List<WebElement> colors = webDriver.findElements(By.xpath("//div[@class='color-picker-item__palette']//i"));
        String color = colors.get(index).getCssValue("background-color");
        int first = color.lastIndexOf("(");
        int last = color.lastIndexOf(")");
        return "rgb"+color.substring(first,last-3)+")";
    }
}
