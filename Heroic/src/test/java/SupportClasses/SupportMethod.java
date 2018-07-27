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
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("document.querySelector('.button-add-element').click()");
//        wait.until(ExpectedConditions.elementToBeClickable(sidebar().newPageButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().blankCanvas)).click();
        if(webDriver.findElements(By.xpath(Variables.newSectionModale)).size() < 1){
            waitAndClick(editorPage().addSectionPlus);
        }
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
    public void waitAndClickByxpath(String element){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(element)))).click();
    }
    public void waitAndClickBycss(String element){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(element)))).click();
    }
    public void wait(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    public int toInt(String string){
        string = string.replaceAll("[^0-9]", "");
        return Integer.parseInt(string);
    }
    public void createThreeLine(){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        Actions action = new Actions(webDriver);
        editorPage().headerText.sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.oneLine);
        action.keyDown(Keys.SHIFT).sendKeys(Keys.ENTER).keyUp(Keys.SHIFT).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.oneLine);
        action.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.oneLine);
    }
    public void selectPartText(){
        WebDriverWait wait = new WebDriverWait(webDriver, 45, 300);
        Actions action = new Actions(webDriver);
        editorPage().headerText.sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.textValue);

        action
                .sendKeys(Keys.chord(Keys.SHIFT,Keys.LEFT_CONTROL, Keys.LEFT))
                .sendKeys(Keys.chord(Keys.SHIFT,Keys.LEFT_CONTROL, Keys.LEFT))
                .sendKeys(Keys.chord(Keys.SHIFT,Keys.LEFT_CONTROL, Keys.LEFT))
                .perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    public void selectAllText(){
        editorPage().headerText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
