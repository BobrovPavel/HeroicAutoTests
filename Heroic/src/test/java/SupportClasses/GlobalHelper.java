package SupportClasses;

import Components.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class GlobalHelper {
    private WebDriver webDriver;
    private Actions action;
    private WebDriverWait wait;

    public GlobalHelper (WebDriver driver){
        webDriver = driver;
        action = new Actions(webDriver);
        wait = new WebDriverWait(webDriver,10,300);
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
        List<WebElement> colors = webDriver.findElements(By.xpath("//div[contains(@class,'accordion-panel__inner_open')]//span[@class='select-color-section__color']"));
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
    public WebElement getFieldColors (String value){
        List<WebElement> colors = webDriver.findElements(By.xpath("//div[contains(@class,'accordion-panel__inner_open')]//span[@class='select-color-section__color']"));
        WebElement element = null;
        switch (value.toLowerCase()){
            case "fill color":
                element = colors.get(0);
                break;
            case "font color":
                element = colors.get(1);
                break;
            case "border color":
                element = colors.get(2);
                break;
        }
        return element;
    }

    public void setDefaultValue (WebElement webElement, String value){
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
        action.click(editorPage().headerText);
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

    public void applyBullet(int index, int paragraphType){
        if(webDriver.findElements(By.xpath("//div[contains(@class,'text-element-p"+paragraphType+"')]//ul//li")).size() == 0) {
            action.click(supportMethod().getTextElements().get(index));
            supportMethod().getTextElements().get(index).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            supportMethod().waitAndClick(tinyMCE().getListsButtons().get(index));
            supportMethod().waitAndClick(tinyMCE().bulletedList);
            supportMethod().waitAndClick(tinyMCE().closeLists);
        }
    }

    public void applyNumberBullet(int index, int paragraphType){
        if(webDriver.findElements(By.xpath("//div[contains(@class,'text-element-p"+paragraphType+"')]//ol//li")).size() == 0) {
            action.click(supportMethod().getTextElements().get(index));
            supportMethod().getTextElements().get(index).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            supportMethod().waitAndClick(tinyMCE().getListsButtons().get(index));
            supportMethod().waitAndClick(tinyMCE().numberedList);
            supportMethod().waitAndClick(tinyMCE().closeLists);
        }
    }

    public void setDefaultColorValue(){
        try {
            action.moveToElement(globalStyles().colorInput,0,-100).perform();
            wait.until(ExpectedConditions.elementToBeClickable(globalStyles().colorInput)).click();
            globalStyles().colorInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
            globalStyles().colorInput.sendKeys("#00000");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void changeCapacity(){
        try {
            Actions action = new Actions(webDriver);
            Thread.sleep(500);
            action.moveToElement(tinyMCE().colorpicker,-2, 60).click().perform();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
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


    public void checkInPageViewMode(String newValue, String verifiedValue){
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, verifiedValue);
    }

    public String getParagraphGlobalValue(int paragraphType, String value){
        String result = null;
        switch (value.toLowerCase()){
            case "font family":
                result = webDriver.findElement(By.xpath("//div[contains(@class,'text-block-element text-element-p"+paragraphType+"')]//p")).getCssValue("font-family");
                break;
            case "font size":
                result = webDriver.findElement(By.xpath("//div[contains(@class,'text-block-element text-element-p"+paragraphType+"')]//div[contains(@class,'font-size-element-style')]")).getCssValue("font-size");
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
        List<WebElement> dropdown = new ArrayList<>();
        dropdown = webDriver.findElements(By.xpath("//div[@class='select-panel-list__inner']"));
        return dropdown;
    }

    public void changeColorWithColorPicker(){
        Actions action = new Actions(webDriver);
        try {
            Thread.sleep(500);
        }catch (InterruptedException ignored){

        }
        action.moveToElement(tinyMCE().colorpicker,-30, 60).click().perform();
    }

    public void changeColorWithPalette(){
        try {
            Thread.sleep(500);
            List<WebElement> colors = webDriver.findElements(By.xpath("//div[@class='color-picker-item__palette']//i"));
            Thread.sleep(500);
            supportMethod().waitAndClick(colors.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getColorPalette(int index){
        List<WebElement> colors = webDriver.findElements(By.xpath("//div[@class='color-picker-item__palette']//i"));
        String color = colors.get(index).getCssValue("background-color");
        int first = color.lastIndexOf("(");
        int last = color.lastIndexOf(")");
        return "rgb"+color.substring(first,last-3)+")";
    }
    public List <WebElement> getPaletteColors(){
        return webDriver.findElements(By.xpath(variables().colorPalette));
    }
    public String getDefaultColorValue(){
        String color = globalStyles().inputColorLable.getCssValue("background-color");
        int first = color.lastIndexOf("(");
        int last = color.lastIndexOf(")");
        return "rgb"+color.substring(first,last-3)+")";
    }

    public void setLarge_Input(){
        supportMethod().waitAndClick(sidebar().designTab);
        supportMethod().waitAndClick(sidebar().largeField);
    }
    public void setMedium_Input(){
        supportMethod().waitAndClick(sidebar().designTab);
        supportMethod().waitAndClick(sidebar().mediumField);
    }
    public void setSmall_Input(){
        supportMethod().waitAndClick(sidebar().designTab);
        supportMethod().waitAndClick(sidebar().smallField);
    }


    public void setLarge_fromDropDown(){
        supportMethod().waitAndClick(sidebar().sizeDropDown);
        supportMethod().waitAndClick(sidebar().largeSize);
    }
    public void setMedium_fromDropDown(){
        supportMethod().waitAndClick(sidebar().sizeDropDown);
        supportMethod().waitAndClick(sidebar().mediumSize);
    }
    public void setSmall_fromDropDown(){
        supportMethod().waitAndClick(sidebar().sizeDropDown);
        supportMethod().waitAndClick(sidebar().smallSize);
    }

    public void setElementsType(){
        supportMethod().waitAndClick(globalStyles().getDropListElements().get(0));
        setLarge_fromDropDown();
        supportMethod().waitAndClick(globalStyles().getDropListElements().get(1));
        setMedium_fromDropDown();
        supportMethod().waitAndClick(globalStyles().getDropListElements().get(2));
        setSmall_fromDropDown();

        action.click(globalStyles().getCheckRadioElements().get(0)).perform();
        setLarge_fromDropDown();
        action.click(globalStyles().getCheckRadioElements().get(1)).perform();
        setMedium_fromDropDown();
        action.click(globalStyles().getCheckRadioElements().get(2)).perform();
        setSmall_fromDropDown();
        action.click(globalStyles().getCheckRadioElements().get(3)).perform();
        setLarge_fromDropDown();
        action.click(globalStyles().getCheckRadioElements().get(4)).perform();
        setMedium_fromDropDown();
        action.click(globalStyles().getCheckRadioElements().get(5)).perform();
        setSmall_fromDropDown();

    }

    public void setInputFieldsType(){
        supportMethod().waitAndClick(globalStyles().getInputElements().get(0));
        setLarge_Input();
        supportMethod().waitAndClick(globalStyles().getInputElements().get(1));
        setMedium_Input();
        supportMethod().waitAndClick(globalStyles().getInputElements().get(2));
        setSmall_Input();
        supportMethod().waitAndClick(globalStyles().getInputElements().get(3));
        setLarge_Input();
        supportMethod().waitAndClick(globalStyles().getInputElements().get(4));
        setMedium_Input();
        supportMethod().waitAndClick(globalStyles().getInputElements().get(5));
        setSmall_Input();
    }



    public void createElements (String element, int quantity){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        try {
            js.executeScript("document.querySelector('.button-add-element').click()");
            wait.until(ExpectedConditions.elementToBeClickable(editorPage().blankCanvas)).click();
            wait.until(ExpectedConditions.elementToBeClickable(editorPage().addSectionPlus)).click();
            wait.until(ExpectedConditions.elementToBeClickable(editorPage().fullWidthSection)).click();
            wait.until(ExpectedConditions.elementToBeClickable(editorPage().fullWidthColumn)).click();
            switch (element) {
                case "header":
                    wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementHeader)).click();
                    for (int i = 0; i < quantity-1; i++) {
                        Thread.sleep(500);
                        js.executeScript("document.querySelector('.button-add-new_dark').click()");
                        wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementHeader)).click();
                    }
                    break;
                case "paragraph":
                    wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementParagraph)).click();
                    for (int i = 0; i < quantity-1; i++) {
                        Thread.sleep(500);
                        js.executeScript("document.querySelector('.button-add-new_dark').click()");
                        wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementParagraph)).click();
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
