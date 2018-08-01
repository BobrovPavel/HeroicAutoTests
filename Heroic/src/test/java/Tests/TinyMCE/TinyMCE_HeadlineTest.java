package Tests.TinyMCE;

import Pages.*;
import SupportClasses.SupportMethod;
import SupportClasses.TinymceHelper;
import SupportClasses.Variables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class TinyMCE_HeadlineTest {
    private static WebDriver webDriver;
    private static WebDriverWait wait;
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
    private static TinymceHelper tinymceHelper(){
        return new TinymceHelper(webDriver);
    }

    @BeforeClass
    public static void setupClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 45, 300);
//        webDriver.get("https://app.heroicnow.com/?token=66acd0e66964e5dfd488648139148f07e5ea4c4b");
        webDriver.get("https://stg.heroicnow.com/?token=da575fecf7f892c9c6a20fcaea7a080e3f6c2545");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
        supportMethod().createElement("header");
        wait = new WebDriverWait(webDriver, 5, 300);


    }
    @Before
    public void preCondition() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).click();
        editorPage().headerText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Thread.sleep(500);
    }


    @Test
    public void boid_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
    }
    @Test
    public void italic_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
    }
    @Test
    public void underline_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
    }
    @Test
    public void quote_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void alignment_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignment)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignmentLeft)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().leftAlignmentAssert));
        Assert.assertTrue(tinyMCE().leftAlignmentAssert.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignCenter)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().centerAlignmentAssert));
        Assert.assertTrue(tinyMCE().centerAlignmentAssert.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignRight)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().rightAlignmentAssert));
        Assert.assertTrue(tinyMCE().rightAlignmentAssert.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignJustify)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().fullAlignmentAssert));
        Assert.assertTrue(tinyMCE().fullAlignmentAssert.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignClose)).click();
    }
    @Test
    public void color_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        WebElement element = webDriver.findElement(By.xpath(Variables.elementSpan));
        String palet = colors.get(1).getAttribute("style");
        int first = palet.lastIndexOf("(");
        int last = palet.lastIndexOf(")");
        String expected = "color: rgb"+palet.substring(first,last+1)+";";
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("style");
        wait.until(ExpectedConditions.attributeToBe(element, "style", expected));
        Assert.assertEquals(expected, finish);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontFamily_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        Assert.assertTrue(tinyMCE().fontFamilyAssert.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontSize_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        for(int i = 0; i < tinymceHelper().getFontSize_H().size();i++){
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) tinymceHelper().getFontSize_H().get(i))).click();
            Assert.assertTrue(webDriver.findElement(By.xpath((String) tinymceHelper().getAssertForFontSize_H().get(i))).isDisplayed());
        }
        wait.until(ExpectedConditions.elementToBeClickable((WebElement) tinymceHelper().getFontSize_H().get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontSizeWithSlider_Paragraph() throws InterruptedException {
        tinymceHelper().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_h, result);
    }
    @Test
    public void changeFontSizeWithSliderAnd_H1_Headline() throws InterruptedException {
        tinymceHelper().changeFontSizeWithSlider();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().h2FontSize)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.elementSpan)).size());
    }
    @Test
    public void ChangeFontSizeH1AndWithSlider_Headline() throws InterruptedException {
        Actions action = new Actions(webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().h2FontSize)).click();
        Thread.sleep(5000);
        action.moveToElement(tinyMCE().sizeSlider,-20,0).click().perform();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals("font-size: 35px;", result);
    }
    @Test
    public void oid_italic_underline_quote_color_fontSizeWithSlider_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        tinymceHelper().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        tinymceHelper().changeFontSizeWithSlider();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style").contains("underline"));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(result.contains(Variables.fontSizeWithSliderAssert_h));
    }
    @Test
    public void boid_italic_Headline(){
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_Headline(){
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_quote_Headline(){
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_quote_color_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        tinymceHelper().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath(Variables.elementSpan))));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style").contains("underline"));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_quote_color_font_family_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        tinymceHelper().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath(Variables.elementSpan))));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style").contains("underline"));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().fontFamilyAssert.isDisplayed());
    }
    @Test
    public void insertLink_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tinymceHelper().getRemovelinkSelector()))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void insertLinkToUserPage_applyAllStyles_Headline() throws InterruptedException {
        supportMethod().waitAndClick(tinyMCE().bold);
        supportMethod().waitAndClick(tinyMCE().italic);
        supportMethod().waitAndClick(tinyMCE().underLine);
        supportMethod().waitAndClick(tinyMCE().quote);
        supportMethod().waitAndClick(tinyMCE().insertLink);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().selectLinkPage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().selectBlankPage)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath(Variables.elementSpan))));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertTrue(hrefResult.contains("/blank-canvas"));
    }
    @Test
    public void insertLink_changeFontSizeWithSlider_Headline() throws InterruptedException {
        tinymceHelper().insertLink();
        tinymceHelper().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_h, result);
        Assert.assertEquals("https://www.google.com/", hrefResult);
    }
    @Test
    public void globalStyles_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().h2FontSize)).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.elementStyle)).size());
    }
    @Test
    public void openInNewWindow_Headline(){
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().openInNewWindow)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        Assert.assertEquals(webDriver.findElement(By.xpath(Variables.href)).getAttribute("target"), "_blank");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tinymceHelper().getRemovelinkSelector()))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void changeColorWithColorPicker_Headline() throws InterruptedException {
        Actions action = new Actions(webDriver);
        supportMethod().waitAndClick(tinyMCE().color);
        action.moveToElement(tinyMCE().colorpicker,-30, 60).click().perform();
        Thread.sleep(500);
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(!Variables.startColorValue.equals(result));
    }
    @Test
    public void changeColorWithSlider_Headline() throws InterruptedException {
        Actions action = new Actions(webDriver);
        supportMethod().waitAndClick(tinyMCE().color);
        action.moveToElement(tinyMCE().colorpicker,-25, 60).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).click();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(!result.equals("color: rgb(0, 0, 0);"));
    }
    @Test
    public void changeCapacityWithSlider_Headline() throws InterruptedException {
        Actions action = new Actions(webDriver);
        supportMethod().waitAndClick(tinyMCE().color);
        Thread.sleep(500);
        action.moveToElement(tinyMCE().colorpicker,-2, 60).click().perform();
        Thread.sleep(500);
        String finish = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("data-mce-style");
        Assert.assertEquals(finish,"color: rgba(0, 0, 0, 0.46);");
    }
    @Test
    public void changeColorWithPaletAndCapacity_Headline() throws InterruptedException {
        tinymceHelper().changeColorWithPalet();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        int first = result.lastIndexOf("(");
        int last = result.lastIndexOf(")");
        String res = result.substring(first,last);
        supportMethod().waitAndClick(tinyMCE().color);
        tinymceHelper().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish, "color: rgba"+res+", 0.46);");
    }
    @Test
    public void boid_italic_underline_quote_changeColorWithColorPicher_changeCapacity_Headline() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        tinymceHelper().changeColorWithColorPicker();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        int first = result.lastIndexOf("(");
        int last = result.lastIndexOf(")");
        String res = result.substring(first,last);
        supportMethod().waitAndClick(tinyMCE().color);
        tinymceHelper().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish, "text-decoration: underline; color: rgba"+res+", 0.46);");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void insertLink_boid_italic_underline_quote_Headline(){
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
    }






    @Test
    public void changeFontSize_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        for(int i = 0; i < tinymceHelper().getFontSize_H().size();i++){
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) tinymceHelper().getFontSize_H().get(i))).click();
            Assert.assertTrue(webDriver.findElement(By.xpath((String) tinymceHelper().getAssertForFontSize_H().get(i))).isDisplayed());
        }
        wait.until(ExpectedConditions.elementToBeClickable((WebElement) tinymceHelper().getFontSize_H().get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        Thread.sleep(1000);
    }
    @Test
    public void changeFontFamily_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath(Variables.fontFamilyAssert1))));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.fontFamilyAssert1)).size());
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void color_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        String palet = colors.get(1).getAttribute("style");
        WebElement element = webDriver.findElement(By.xpath(Variables.elementSpan));
        int first = palet.lastIndexOf("(");
        int last = palet.lastIndexOf(")");
        String result = "color: rgb"+palet.substring(first,last+1)+";";
        wait.until(ExpectedConditions.attributeToBe(element, "style", result));
        Assert.assertEquals(palet.substring(first, last + 1), palet.substring(first, last + 1));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void alignment_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignment)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignmentLeft)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().leftAlignmentAssert));
        Assert.assertTrue(tinyMCE().leftAlignmentAssert.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignCenter)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().centerAlignmentAssert));
        Assert.assertTrue(tinyMCE().centerAlignmentAssert.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignRight)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().rightAlignmentAssert));
        Assert.assertTrue(tinyMCE().rightAlignmentAssert.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignJustify)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().fullAlignmentAssert));
        Assert.assertTrue(tinyMCE().fullAlignmentAssert.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignClose)).click();
    }
    @Test
    public void quote_Headline_Div_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void underline_Headline_Div_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().underLineAssert));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
    }
    @Test
    public void itaclic_Headline_Div_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
    }
    @Test
    public void bold_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
    }
    @Test
    public void insertLink_Headline_Div_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tinymceHelper().getRemovelinkSelector()))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void insertLinkToUserPage_applyAllStyles_Headline_Dib_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().waitAndClick(tinyMCE().bold);
        supportMethod().waitAndClick(tinyMCE().italic);
        supportMethod().waitAndClick(tinyMCE().underLine);
        supportMethod().waitAndClick(tinyMCE().quote);
        supportMethod().waitAndClick(tinyMCE().insertLink);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().selectLinkPage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().selectBlankPage)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.quoteAssert)).isDisplayed());
        Assert.assertTrue(hrefResult.contains("/blank-canvas"));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.href)).size());
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
    }
    @Test
    public void changeFontSizeWithSlider_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        tinymceHelper().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_h, result);
        Assert.assertEquals(3 , webDriver.findElements(By.xpath("//span[contains(text(),'"+Variables.oneLine+"')]")).size() );
    }
    @Test
    public void changeFontSizeWithSlider_And_H1_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        tinymceHelper().changeFontSizeWithSlider();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().h2FontSize)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.assert_h2)).getText().contains(Variables.severalLinesAssert));
        tinymceHelper().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals("font-size: 35px;", result);
        Assert.assertEquals(3 , webDriver.findElements(By.xpath("//span[contains(text(),'"+Variables.oneLine+"')]")).size() );
    }
    @Test
    public void boid_italic_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_Headline_Div_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_quote_Headline_Div_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_quote_color_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        tinymceHelper().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath(Variables.elementSpan))));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style").contains("underline"));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_quote_color_font_family_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        Thread.sleep(500);
        supportMethod().waitAndClick(tinyMCE().bold);
        supportMethod().waitAndClick(tinyMCE().italic);
        supportMethod().waitAndClick(tinyMCE().underLine);
        supportMethod().waitAndClick(tinyMCE().quote);
        supportMethod().waitAndClick(tinyMCE().color);
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        tinymceHelper().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath(Variables.elementSpan))));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style").contains("underline"));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().fontFamilyAssert.isDisplayed());
    }
    @Test
    public void globalStyles_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().waitAndClick(tinyMCE().bold);
        supportMethod().waitAndClick(tinyMCE().italic);
        supportMethod().waitAndClick(tinyMCE().underLine);
        supportMethod().waitAndClick(tinyMCE().quote);
        supportMethod().waitAndClick(tinyMCE().color);
        Thread.sleep(1000);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().h2FontSize)).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.elementStyle)).size());
    }
    @Test
    public void openInNewWindow_Headline_Div_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        supportMethod().waitAndClick(tinyMCE().openInNewWindow);
        supportMethod().waitAndClick(tinyMCE().saveLink);
        Assert.assertEquals(webDriver.findElement(By.xpath(Variables.href)).getAttribute("target"), "_blank");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tinymceHelper().getRemovelinkSelector()))).click();
        supportMethod().waitAndClickByxpath(tinymceHelper().getRemovelinkSelector());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void insertLinkAndApplyGlobalStyle_Headline_Div_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        supportMethod().waitAndClick(tinyMCE().size);
        supportMethod().waitAndClick(tinyMCE().h2FontSize);
        Assert.assertTrue(tinyMCE().h2GlobalAssert.isDisplayed());
        Assert.assertEquals("https://www.google.com/", hrefResult);
    }

    @Test
    public void changeColorWithColorPicker_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        tinymceHelper().changeColorWithColorPicker();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(!Variables.startColorValue.equals(result));
    }
    @Test
    public void changeColorWithSlider_Headline_Div_Br() throws InterruptedException {
        Actions action = new Actions(webDriver);
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        Thread.sleep(500);
        supportMethod().waitAndClick(tinyMCE().color);
        action.moveToElement(tinyMCE().colorpicker,-25, 60).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().headerText)).click();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(!result.equals("color: rgb(0, 0, 0);"));
    }
    @Test
    public void changeCapacity_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        tinymceHelper().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish,"color: rgba(0, 0, 0, 0.46);");
    }
    @Test
    public void changeColorWithPaletAndCapacity_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        tinymceHelper().changeColorWithPalet();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        int first = result.lastIndexOf("(");
        int last = result.lastIndexOf(")");
        String res = result.substring(first,last);
        supportMethod().waitAndClick(tinyMCE().color);
        tinymceHelper().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish, "color: rgba"+res+", 0.46);");
    }
    @Test
    public void boid_italic_underline_quote_changeColorWithColorPicher_changeCapacity_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        tinymceHelper().changeColorWithColorPicker();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        int first = result.lastIndexOf("(");
        int last = result.lastIndexOf(")");
        String res = result.substring(first,last);
        supportMethod().waitAndClick(tinyMCE().color);
        tinymceHelper().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish, "text-decoration: underline; color: rgba"+res+", 0.46);");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void insertLink_boid_italic_underline_quote_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
    }
    @Test
    public void insertEmptyLink_boid_italic_underline_quote_Headline_Div_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }












    @Test
    public void boid_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void italic_Headline_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void quote_Headline_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
    }
    @Test
    public void underline_Headline_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void alignment_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignment)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignmentLeft)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().leftAlignmentAssert));
        Assert.assertTrue(tinyMCE().leftAlignmentAssert.getText().contains(Variables.textValue));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignCenter)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().centerAlignmentAssert));
        Assert.assertTrue(tinyMCE().centerAlignmentAssert.getText().contains(Variables.textValue));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignRight)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().rightAlignmentAssert));
        Assert.assertTrue(tinyMCE().rightAlignmentAssert.getText().contains(Variables.textValue));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignJustify)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().fullAlignmentAssert));
        Assert.assertTrue(tinyMCE().fullAlignmentAssert.getText().contains(Variables.textValue));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignClose)).click();
    }
    @Test
    public void color_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        WebElement element = webDriver.findElement(By.xpath(Variables.elementSpan));
        String palet = colors.get(1).getAttribute("style");
        String finish = webDriver.findElement(By.xpath(Variables.threePart)).getAttribute("style");
        int first = palet.lastIndexOf("(");
        int last = palet.lastIndexOf(")");
        String expected = "color: rgb"+palet.substring(first,last+1)+";";
        wait.until(ExpectedConditions.attributeToBe(element, "style", expected));
        Assert.assertEquals(expected, finish);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontFamily_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        Assert.assertTrue(tinyMCE().fontFamilyAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontSize_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        for(int i = 0; i < tinymceHelper().getFontSize_H().size();i++){
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) tinymceHelper().getFontSize_H().get(i))).click();
            Assert.assertTrue(webDriver.findElement(By.xpath((String) tinymceHelper().getAssertForFontSize_H().get(i))).getText().contains(Variables.textValue));
        }
        wait.until(ExpectedConditions.elementToBeClickable((WebElement) tinymceHelper().getFontSize_H().get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontSizeWithSlider_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        tinymceHelper().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_h, result);
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void changeFontSizeWithSlider_And_H1_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        tinymceHelper().changeFontSizeWithSlider();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().h2FontSize)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.assert_h2)).getText().contains(Variables.THREE_SIMPLE_TEXT));
        tinymceHelper().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals("font-size: 35px;", result);
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void boid_italic_underline_quote_Headline_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
    }
    @Test
    public void boid_italic_underline_quote_color_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        tinymceHelper().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath(Variables.elementSpan))));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void boid_italic_underline_quote_color_font_family_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        tinymceHelper().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath(Variables.elementSpan))));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
        Assert.assertTrue(tinyMCE().fontFamilyAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void boid_italic_underline_quote_capacity_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        tinymceHelper().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
        Assert.assertTrue(finish.contains("color: rgba(0, 0, 0, 0.46);"));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void inserAndDeleteLink_Headline_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.href)).getText().contains(Variables.THREE_SIMPLE_TEXT));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tinymceHelper().getRemovelinkSelector()))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void insertLinkToUserPage_applyAllStyles_Headline_part(){
        supportMethod().selectPartText();
        supportMethod().waitAndClick(tinyMCE().bold);
        supportMethod().waitAndClick(tinyMCE().italic);
        supportMethod().waitAndClick(tinyMCE().underLine);
        supportMethod().waitAndClick(tinyMCE().quote);
        supportMethod().waitAndClick(tinyMCE().insertLink);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().selectLinkPage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().selectBlankPage)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.quoteAssert)).isDisplayed());
        Assert.assertTrue(hrefResult.contains("/blank-canvas"));
        Assert.assertEquals(Variables.textPart, webDriver.findElement(By.xpath(Variables.href)).getText());
        Assert.assertEquals(Variables.textPart, webDriver.findElement(By.xpath(Variables.boidAssert)).getText());
        Assert.assertEquals(Variables.textPart, webDriver.findElement(By.xpath(Variables.italicAssert)).getText());
        Assert.assertEquals(Variables.textPart, webDriver.findElement(By.xpath(Variables.underLineAssert)).getText());
    }
    @Test
    public void globalStyles_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().h2FontSize)).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.elementStyle)).size());
    }
    @Test
    public void insertLink_boid_italic_underline_quote_Headline_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
    }


    @After
    public void postCondition() throws InterruptedException {
        supportMethod().waitAndClick(editorPage().headerText);
        supportMethod().waitAndClick(editorPage().deleteElement);
        supportMethod().waitAndClick(editorPage().submitDelete);
        supportMethod().waitAndClick(editorPage().plusIntoRow);
        supportMethod().waitAndClick(editorPage().elementHeader);
    }

    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
