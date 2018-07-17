package SupportClasses;

import Pages.EditorPage;
import Pages.LoginPage;
import Pages.Sidebar;
import Pages.TinyMCE;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SupportMethod {

    WebDriver webDriver;


    public SupportMethod(WebDriver driver){
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


    public void createElement (String element){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        wait.until(ExpectedConditions.elementToBeClickable(sidebar().newPageButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().blankCanvas)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().fullWidthSection)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().fullWidthColumn)).click();
        switch (element){
            case "header":
                wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementHeader)).click();
                break;
            case "paragraph":
                wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementParagraph)).click();
                break;
        }


//        if ("header".equals(element)) {
//            wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementHeader)).click();
//        }
    }
    public void waitAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitAndClick_xpath(String element){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(element)))).click();
    }
    public void waitAndClick_css(String element){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(element)))).click();
    }

    public String getRemovelinkSelector(){
        StringBuilder builder = new StringBuilder(webDriver.findElement(By.xpath("//i[contains(@class,'mce-ico mce-i-textlink')]/parent::*/parent::*")).getAttribute("id")).delete(0,5);
        int id = Integer.parseInt(builder.toString())+1;
        String remove = "//div[@id='mceu_"+id+"']//button[contains(@role,'presentation')]";
        return remove;
    }
    public void colorAssert(List<WebElement> colors){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        String palet = colors.get(1).getAttribute("style");
        WebElement element = webDriver.findElement(By.xpath("//div[contains(@id,'rect-tinymce')]//span"));
        int first = palet.lastIndexOf("(");
        int last = palet.lastIndexOf(")");
        String result = "text-decoration: underline; color: rgb"+palet.substring(first,last+1)+";";
        wait.until(ExpectedConditions.attributeToBe(element, "style", result));
        Assert.assertEquals(palet.substring(first, last + 1), palet.substring(first, last + 1));
    }
    public void colorAssert_p(List<WebElement> colors){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        String palet = colors.get(1).getAttribute("style");
        WebElement element = webDriver.findElement(By.xpath("//div[contains(@id,'rect-tinymce-tmp_text')]//span"));
        int first = palet.lastIndexOf("(");
        int last = palet.lastIndexOf(")");
        String result = "text-decoration: underline; color: rgb"+palet.substring(first,last+1)+";";
        wait.until(ExpectedConditions.attributeToBe(element, "style", result));
        Assert.assertEquals(palet.substring(first, last + 1), palet.substring(first, last + 1));
    }

    public List getFontSize_H(){
        List<WebElement> fontSize_H = new ArrayList<WebElement>();
        fontSize_H.add(tinyMCE().h1FontSize);
        fontSize_H.add(tinyMCE().h2FontSize);
        fontSize_H.add(tinyMCE().h3FontSize);
        fontSize_H.add(tinyMCE().h4FontSize);
        fontSize_H.add(tinyMCE().h5FontSize);
        fontSize_H.add(tinyMCE().h6FontSize);
        return fontSize_H;
    }
    public List getFontSize_p(){
        List<WebElement> fontSize_p = new ArrayList<WebElement>();
        fontSize_p.add(tinyMCE().p1FontSize);
        fontSize_p.add(tinyMCE().p2FontSize);
        fontSize_p.add(tinyMCE().p3FontSize);
        return fontSize_p;
    }

    public List getAssertForFontSize_H() {
        List<String> AssertForFontSize_H = new ArrayList<String>();
        AssertForFontSize_H.add(Variables.assert_h1);
        AssertForFontSize_H.add(Variables.assert_h2);
        AssertForFontSize_H.add(Variables.assert_h3);
        AssertForFontSize_H.add(Variables.assert_h4);
        AssertForFontSize_H.add(Variables.assert_h5);
        AssertForFontSize_H.add(Variables.assert_h6);
        return AssertForFontSize_H;
    }
    public List getAssertForFontSize_p(){
        List<String> AssertForFontSize_p = new ArrayList<String>();
        AssertForFontSize_p.add(Variables.assert_p1);
        AssertForFontSize_p.add(Variables.assert_p2);
        AssertForFontSize_p.add(Variables.assert_p3);
        return AssertForFontSize_p;
    }

    public void createThreeLine(){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        Actions action = new Actions(webDriver);
        editorPage().headerText.sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.headerValue);
        action.keyDown(Keys.SHIFT).sendKeys(Keys.ENTER).keyUp(Keys.SHIFT).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.headerValue);
        action.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.headerValue);
    }
    public void selectAllText(){
        editorPage().headerText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void changeCapacity() throws InterruptedException {
        Actions action = new Actions(webDriver);
        waitAndClick(tinyMCE().color);
        Thread.sleep(500);
        action.moveToElement(tinyMCE().colorpicker,-2, 60).click().perform();
        Thread.sleep(500);
    }
    public void changeColorWithColorPicker() throws InterruptedException {
        Actions action = new Actions(webDriver);
        waitAndClick(tinyMCE().color);
        Thread.sleep(500);
        action.moveToElement(tinyMCE().colorpicker,-30, 60).click().perform();
        Thread.sleep(500);
    }
    public void changeColorWithPalet() throws InterruptedException {
        waitAndClick(tinyMCE().color);
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath("//div[@class='color-picker-item__palette']//i"));
        Thread.sleep(500);
        waitAndClick(colors.get(1));
    }
}
