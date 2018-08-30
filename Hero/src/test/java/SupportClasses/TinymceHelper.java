package SupportClasses;

import Components.EditorPage;
import Components.LoginPage;
import Components.Sidebar;
import Components.TinyMCE;
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

public class TinymceHelper {
    private WebDriver webDriver;


    public TinymceHelper(WebDriver driver){
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
    public SupportMethod supportMethod(){
        return new SupportMethod(webDriver);
    }


    public void changeFontSizeWithSlider(){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        Actions action = new Actions(webDriver);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
            Thread.sleep(500);
            action.moveToElement(tinyMCE().sizeSlider,-20,0).click().perform();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void insertLink(){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
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
    public void changeCapacity(){
        try {
            Actions action = new Actions(webDriver);
            supportMethod().waitAndClick(tinyMCE().color);
            Thread.sleep(500);
            action.moveToElement(tinyMCE().colorpicker,-2, 60).click().perform();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void changeColorWithColorPicker(){
        try {
            Actions action = new Actions(webDriver);
            supportMethod().waitAndClick(tinyMCE().color);
            Thread.sleep(500);
            action.moveToElement(tinyMCE().colorpicker,-30, 60).click().perform();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void changeColorWithPalet(){
        try {
            supportMethod().waitAndClick(tinyMCE().color);
            Thread.sleep(500);
            List<WebElement> colors = webDriver.findElements(By.xpath("//div[@class='color-picker-item__palette']//i"));
            Thread.sleep(500);
            supportMethod().waitAndClick(colors.get(1));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
