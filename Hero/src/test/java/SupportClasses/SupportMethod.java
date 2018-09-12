package SupportClasses;


import Components.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SupportMethod {

    private static WebDriver webDriver;
    private static WebDriverWait wait;
    private static Actions action;
    private static JavascriptExecutor js;
    private static StringBuilder builder;

    public SupportMethod(WebDriver driver){
        webDriver = driver;
        action = new Actions(webDriver);
        js = (JavascriptExecutor)webDriver;
        wait = new WebDriverWait(webDriver, 45, 300);
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
    public Variables variables(){
        return new Variables(webDriver);
    }
    public GlobalHelper globalHelper(){
        return new GlobalHelper(webDriver);
    }

    public void openSidebar(){
        waitAndClick(sidebar().pages);
    }
    public void createElement (String element){
        js.executeScript("document.querySelector('.button-add-element').click()");
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().blankCanvas)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().addSectionPlus)).click();
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
    }
    public void createElements (String element, int quantity){
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
    public void changeFontSize(List<WebElement> element){
        try {
            for (int i = 0; i < getTextElements().size(); i++) {
                action.click(getTextElements().get(i));
                getTextElements().get(i).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().getTinyMCEFontSizeButtons().get(i))).click();
                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(element.get(i))).click();
                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeFontSize)).click();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterText(){
        for (int i = 0; i < getTextElements().size(); i++){
            getTextElements().get(i).sendKeys(Keys.BACK_SPACE);
            getTextElements().get(i).sendKeys(Keys.BACK_SPACE);
            wait.until(ExpectedConditions.elementToBeClickable(getTextElements().get(i))).sendKeys(Variables.oneLine);
            action.sendKeys(Keys.ENTER).perform();
            wait.until(ExpectedConditions.elementToBeClickable(getTextElements().get(i))).sendKeys(Variables.oneLine);
        }
    }

    public List<WebElement> getTextElements(){
        return webDriver.findElements(By.cssSelector(".mce-content-body"));
    }


    public void waitAndClick(WebElement element){
        try {
            Thread.sleep(500);
            action.moveToElement(element).perform();
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void waitAndClickByxpath(String element){
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(element)))).click();
    }
    public void waitAndClickBycss(String element){
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(element)))).click();
    }
    public void wait(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    public int asInt(String string){
        string = string.replaceAll("[^0-9]", "");
        return Integer.parseInt(string);
    }
    public double asDouble (String string){
        string = string.replaceAll("[a-zA-Zа-яА-Я]*", "");
        return Double.parseDouble(string);
    }
    public void createThreeLine(){
        editorPage().headerText.sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.oneLine);
        action.keyDown(Keys.SHIFT).sendKeys(Keys.ENTER).keyUp(Keys.SHIFT).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.oneLine);
        action.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).sendKeys(Variables.oneLine);
    }
    public void selectPartText(){
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

    public void createThreeColumnRowAndAddElements_firstSection(WebElement element){
        js.executeScript("document.querySelector('.button-add-element').click()");
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().blankCanvas)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().addSectionPlus)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().fullWidthSection)).click();
        editorPage().threeColumnRowClick();
        for(int i = 0; i < 3; i++){
            wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementHeader));
            action.moveToElement(element).click().perform();
        }
    }
    public void createThreeColumnRowAndAddElements_anySection(WebElement element, int index) throws InterruptedException {
        Thread.sleep(500);
        waitAndClick(editorPage().getPlusAddNewRow().get(index));
        Thread.sleep(500);
        waitAndClick(editorPage().getThreeColumnsRow().get(index));
        for(int i = 0; i < 3; i++){
            Thread.sleep(500);
//            wait.until(ExpectedConditions.elementToBeClickable(element));
            action.moveToElement(element).click().perform();
        }
    }
    public void gotToParagraphSettings(){
        waitAndClick(sidebar().globalStyles);
        waitAndClick(sidebar().paragraphStyles);
    }
    public void goToLargeFieldSettings(){
        waitAndClick(sidebar().globalStyles);
        waitAndClick(sidebar().fieldStyles);
        waitAndClick(sidebar().largeFieldsSettings);
    }
    public void goToMediumFieldSettings(){
        waitAndClick(sidebar().globalStyles);
        waitAndClick(sidebar().fieldStyles);
        waitAndClick(sidebar().mediumFieldsSettings);
    }
    public void goToSmallFieldSettings(){
        waitAndClick(sidebar().globalStyles);
        waitAndClick(sidebar().fieldStyles);
        waitAndClick(sidebar().smallFieldsSettings);
    }
    public void focus(WebElement element){
        waitAndClick(element);
    }

    public String toRGBA(String value){
        int first = value.indexOf("b");
        int last = value.indexOf(")");
        builder = new StringBuilder(value);
        builder.insert(first+1,"a").insert(last+1, ", 1");
        return builder.toString();
    }
    public String toRGBA(String value, int alpha){
        int first = value.indexOf("b");
        int last = value.indexOf(")");
        builder = new StringBuilder(value);
        builder.insert(first+1,"a").insert(last+1, ", " +alpha);
        return builder.toString();
    }
    public static void removeItemFromLocalStorage(String item) {
        js.executeScript(String.format(
                "window.localStorage.removeItem('%s');", item));
    }
    public static void clearLocalStorage() {
        js.executeScript(String.format("window.localStorage.clear();"));
    }

    public void addInputElements(String inputSize) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath("//button[contains(@class,'sidebar-main-menu__button')]"))));
        js.executeScript("document.querySelector('.button-add-element').click()");
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().blankCanvas)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().addSectionPlus)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().fullWidthSection)).click();
        editorPage().sixColumnRowClick();
        for(int i = 0; i < globalHelper().getInputElements().size(); i++){
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementHeader));
            action.moveToElement(globalHelper().getInputElements().get(i)).click().perform();
        }
        openSidebar();
        List<WebElement> list = webDriver.findElements(By.xpath(Variables.elementsColumn));
        for (WebElement aList : list) {
            Thread.sleep(500);
            aList.click();
            changeInputElementSize(inputSize);
        }
    }

    public void changeInputElementSize(String size){
        WebElement element = null;
        wait = new WebDriverWait(webDriver, 2, 300);
        switch (size.toLowerCase()){
            case "large":
                if(webDriver.findElements(By.xpath(Variables.sizeDropDown)).size() == 0){
                    waitAndClick(sidebar().designTab);
                    waitAndClick(sidebar().largeField);
                }else{
                    waitAndClick(sidebar().sizeDropDown);
                    waitAndClick(sidebar().largeSize);
                }
                break;
            case "medium":
                if(webDriver.findElements(By.xpath(Variables.sizeDropDown)).size() == 0){
                    waitAndClick(sidebar().designTab);
                    waitAndClick(sidebar().mediumField);
                }else{
                    waitAndClick(sidebar().sizeDropDown);
                    waitAndClick(sidebar().mediumSize);
                }
                break;
            case "small":
                if(webDriver.findElements(By.xpath(Variables.sizeDropDown)).size() == 0){
                    waitAndClick(sidebar().designTab);
                    waitAndClick(sidebar().smallField);
                }else{
                    waitAndClick(sidebar().sizeDropDown);
                    waitAndClick(sidebar().smallSize);
                }
                break;

        }
    }
}
