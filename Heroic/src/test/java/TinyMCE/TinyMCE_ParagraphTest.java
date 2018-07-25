package TinyMCE;
import Pages.EditorPage;
import Pages.LoginPage;
import Pages.Sidebar;
import Pages.TinyMCE;
import SupportClasses.SupportMethod;
import SupportClasses.Variables;
import com.google.errorprone.annotations.Var;
import com.sun.org.apache.xpath.internal.operations.Variable;
import com.sun.xml.internal.ws.policy.AssertionSet;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Transient;
import java.util.List;

public class TinyMCE_ParagraphTest {
    static WebDriver webDriver;
    static WebDriverWait wait;
    public LoginPage loginPage(){
        return new LoginPage(webDriver);
    }
    public TinyMCE tinyMCE(){
        return new TinyMCE(webDriver);
    }
    public Sidebar sidebar(){
        return new Sidebar(webDriver);
    }
    public static EditorPage editorPage(){
        return new EditorPage(webDriver);
    }
    public static SupportMethod supportMethod(){
        return new SupportMethod(webDriver);
    }

    @BeforeClass
    public static void setupClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 45, 300);
//        webDriver.get("https://app.heroicnow.com/?token=66acd0e66964e5dfd488648139148f07e5ea4c4b");
        webDriver.get("https://stg.heroicnow.com/?token=2c40e61f625ba7d97f0998de19962a68e11195d9");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
        supportMethod().createElement("paragraph");
        wait = new WebDriverWait(webDriver, 5, 300);
    }
    @Before
    public void preCondition() throws InterruptedException {
        Actions action = new Actions(webDriver);
        action.click(editorPage().headerText);
        editorPage().headerText.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Thread.sleep(1000);
    }

    @Test
    public void boid_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
    }
    @Test
    public void italic_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
    }
    @Test
    public void underline_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
    }
    @Test
    public void quote_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void numberedList_Paragraph(){
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().numberedList);
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.numberedListAssert)).isDisplayed());
    }
    @Test
    public void bulletedList_Paragraph(){
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.bulletedListAssert)).isDisplayed());
    }
    @Test
    public void applyList_changeFontSizeWithSlider_Paragraph() throws InterruptedException {
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        supportMethod().waitAndClick(tinyMCE().closeLists);
        supportMethod().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.listAndFontSizeAssert)).getAttribute("style");
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_p, result);
    }
    @Test
    public void alignment_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignment)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignmentLeft)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().leftAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().leftAlignmentAssert_p.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignCenter)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().centerAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().centerAlignmentAssert_p.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignRight)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().rightAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().rightAlignmentAssert_p.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignJustify)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().fullAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().fullAlignmentAssert_p.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignClose)).click();
    }
    @Test
    public void color_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        WebElement element = webDriver.findElement(By.xpath(Variables.elementSpan));
        String palet = colors.get(1).getAttribute("style");
        int first = palet.lastIndexOf("(");
        int last = palet.lastIndexOf(")");
        String result = "color: rgb"+palet.substring(first,last+1)+";";
        wait.until(ExpectedConditions.attributeToBe(element, "style", result));
        Assert.assertEquals(palet.substring(first, last + 1), palet.substring(first, last + 1));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontFamily_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        Assert.assertTrue(tinyMCE().fontFamilyAssert.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontSize_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        for(int i = 0; i < supportMethod().getFontSize_p().size();i++){
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) supportMethod().getFontSize_p().get(i))).click();
            Assert.assertTrue(webDriver.findElement(By.cssSelector((String) supportMethod().getAssertForFontSize_p().get(i))).isDisplayed());
        }
        wait.until(ExpectedConditions.elementToBeClickable((WebElement) supportMethod().getFontSize_p().get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontSizeWithSlider_Paragraph() throws InterruptedException {
        supportMethod().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_p, result);
    }
    @Test
    public void changeFontSizeWithSlider_AndH1_Paragraph() throws InterruptedException {
        supportMethod().changeFontSizeWithSlider();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().p3FontSize)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.elementSpan)).size());
    }
    @Test
    public void ChangeFontSizeH1_AndWithSlider_Paragraph() throws InterruptedException {
        Actions action = new Actions(webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().p3FontSize)).click();
        Thread.sleep(500);
        action.moveToElement(tinyMCE().sizeSlider,-20,0).click().perform();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals("font-size: 9px;", result);
    }
    @Test
    public void boid_italic_underline_quote_color_fontSizeWithSlider_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        supportMethod().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        supportMethod().changeFontSizeWithSlider();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style").contains("underline"));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(result.contains(Variables.fontSizeWithSliderAssert_p));
    }
    @Test
    public void boid_italic_Paragraph(){
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_Paragraph(){
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
    public void boid_italic_underline_quote_Paragraph(){
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
    public void boid_italic_underline_quote_color_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        supportMethod().colorAssert(colors);
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
    public void boid_italic_underline_quote_color_font_family_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        supportMethod().colorAssert(colors);
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
    public void insertLink_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supportMethod().getRemovelinkSelector()))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void insertLinkToUserPage_applyAllStyles_Paragraph() throws InterruptedException {
        supportMethod().waitAndClick(tinyMCE().bold);
        supportMethod().waitAndClick(tinyMCE().italic);
        supportMethod().waitAndClick(tinyMCE().underLine);
        supportMethod().waitAndClick(tinyMCE().quote);
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        supportMethod().waitAndClick(tinyMCE().closeLists);
        supportMethod().waitAndClick(tinyMCE().insertLink);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().selectLinkPage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().selectBlankPage)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.boidAssert)).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.italicAssert)).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.underLineAssert)).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.quoteAssert)).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.bulletedListAssert)).isDisplayed());
        Assert.assertTrue(hrefResult.contains("/blank-canvas"));
    }
    @Test
    public void insertLink_changeFontSizeWithSlider_Paragraph() throws InterruptedException {
        supportMethod().insertLink();
        supportMethod().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_p, result);
        Assert.assertEquals("https://www.google.com/", hrefResult);
    }
    @Test
    public void globalStyles_Paragraph() throws InterruptedException {
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
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().p3FontSize)).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.elementStyle)).size());
    }
    @Test
    public void openInNewWindow_Paragraph(){
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().openInNewWindow)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        Assert.assertEquals(webDriver.findElement(By.xpath(Variables.href)).getAttribute("target"), "_blank");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supportMethod().getRemovelinkSelector()))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void changeColorWithColorPicker_Paragraph() throws InterruptedException {
        Actions action = new Actions(webDriver);
        supportMethod().waitAndClick(tinyMCE().color);
        action.moveToElement(tinyMCE().colorpicker,-30, 60).click().perform();
        Thread.sleep(500);
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(!Variables.startColorValue.equals(result));
    }
    @Test
    public void changeColorWithSlider_Paragraph() throws InterruptedException {
        Actions action = new Actions(webDriver);
        supportMethod().waitAndClick(tinyMCE().color);
        action.moveToElement(tinyMCE().colorpicker,-25, 60).click().perform();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(!result.equals("color: rgb(0, 0, 0);"));
    }
    @Test
    public void changeCapacityWithSlider_Paragraph() throws InterruptedException {
        Actions action = new Actions(webDriver);
        supportMethod().waitAndClick(tinyMCE().color);
        Thread.sleep(500);
        action.moveToElement(tinyMCE().colorpicker,-2, 60).click().perform();
        Thread.sleep(500);
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        System.out.println(finish);
        Assert.assertEquals(finish,"color: rgba(0, 0, 0, 0.46);");
    }
    @Test
    public void changeColorWithPaletAndCapacity_Paragraph() throws InterruptedException {
        supportMethod().changeColorWithPalet();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        int first = result.lastIndexOf("(");
        int last = result.lastIndexOf(")");
        String res = result.substring(first,last);
        supportMethod().waitAndClick(tinyMCE().color);
        supportMethod().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish, "color: rgba"+res+", 0.46);");
    }
    @Test
    public void boid_italic_underline_quote_changeColorWithColorPicher_changeCapacity_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().underLineAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        supportMethod().changeColorWithColorPicker();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        int first = result.lastIndexOf("(");
        int last = result.lastIndexOf(")");
        String res = result.substring(first,last);
        supportMethod().waitAndClick(tinyMCE().color);
        supportMethod().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish, "text-decoration: underline; color: rgba"+res+", 0.46);");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void insertLink_boid_italic_underline_quote_Paragraph(){
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
    public void boid_italic_underline_quote_capacity_numberedList_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        supportMethod().changeCapacity();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().numberedList);
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.numberedListAssert)).isDisplayed());
        Assert.assertTrue(finish.contains("color: rgba(0, 0, 0, 0.46);"));
    }
    @Test
    public void boid_italic_underline_quote_color_numberedList_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().numberedList);
        supportMethod().waitAndClick(tinyMCE().closeLists);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        WebElement element = webDriver.findElement(By.xpath(Variables.elementSpan));
        String palet = colors.get(1).getAttribute("style");
        int first = palet.lastIndexOf("(");
        int last = palet.lastIndexOf(")");
        String result = "color: rgb"+palet.substring(first,last+1)+";";
        Assert.assertEquals(palet.substring(first, last + 1), palet.substring(first, last + 1));
        Assert.assertTrue(element.getAttribute("style").contains(result));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.numberedListAssert)).isDisplayed());
    }




    @Test
    public void changeFontSize_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        for(int i = 0; i < supportMethod().getFontSize_p().size();i++){
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) supportMethod().getFontSize_p().get(i))).click();
            Assert.assertTrue(webDriver.findElement(By.cssSelector((String) supportMethod().getAssertForFontSize_p().get(i))).isDisplayed());
        }
        wait.until(ExpectedConditions.elementToBeClickable((WebElement) supportMethod().getFontSize_p().get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontFamily_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath(Variables.fontFamilyAssert1))));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.fontFamilyAssert1)).size());
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void color_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
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
    public void alignment_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignment)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignmentLeft)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().leftAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().leftAlignmentAssert_p.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignCenter)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().centerAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().centerAlignmentAssert_p.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignRight)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().rightAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().rightAlignmentAssert_p.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignJustify)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().fullAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().fullAlignmentAssert_p.isDisplayed());
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignClose)).click();
    }
    @Test
    public void quote_Paragraph_P_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void underline_Paragraph_P_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().underLineAssert));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
    }
    @Test
    public void itaclic_Paragraph_P_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
    }
    @Test
    public void bold_Paragraph_P_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        Assert.assertEquals(3, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
    }
    @Test
    public void numberedList_Paragraph_P_br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().numberedList);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.numberedListAssert)).size());
        Assert.assertEquals(Variables.severalLinesAssert, tinyMCE().textBody.getText());
    }
    @Test
    public void bulletedList_Paragraph_P_br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.bulletedListAssert)).size());
        Assert.assertEquals(Variables.severalLinesAssert, tinyMCE().textBody.getText());
    }
    @Test
    public void applyList_changeFontSizeWithSlider_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        supportMethod().waitAndClick(tinyMCE().closeLists);
        supportMethod().changeFontSizeWithSlider();
        supportMethod().waitAndClick(tinyMCE().closeButton);
        String result = webDriver.findElement(By.xpath(Variables.listAndFontSizeAssert)).getAttribute("style");
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.bulletedListAssert)).size());
        Assert.assertEquals(Variables.severalLinesAssert, tinyMCE().textBody.getText());
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_p, result);
    }
    @Test
    public void boid_italic_underline_quote_color__list_fontSizeWithSlider_Paragraph() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(500);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        supportMethod().colorAssert(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        supportMethod().waitAndClick(tinyMCE().closeLists);
        supportMethod().changeFontSizeWithSlider();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        String result = webDriver.findElement(By.xpath("//div[contains(@id,'rect-tinymce')]//ul")).getAttribute("style");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style").contains("underline"));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(result.contains(Variables.fontSizeWithSliderAssert_p));
    }
    @Test
    public void insertLink_Paragraph_P_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
        StringBuilder builder = new StringBuilder(webDriver.findElement(By.xpath("//i[contains(@class,'mce-ico mce-i-textlink')]/parent::*/parent::*")).getAttribute("id")).delete(0,5);
        int id = Integer.parseInt(builder.toString())+1;
        String remove = "//div[@id='mceu_"+id+"']//button[contains(@role,'presentation')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(remove))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void insertLinkToUserPage_applyAllStyles_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().waitAndClick(tinyMCE().bold);
        supportMethod().waitAndClick(tinyMCE().italic);
        supportMethod().waitAndClick(tinyMCE().underLine);
        supportMethod().waitAndClick(tinyMCE().quote);
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        supportMethod().waitAndClick(tinyMCE().closeLists);
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
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.bulletedListAssert)).size());
    }
    @Test
    public void boid_italic_Paragraph_P_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_Paragraph_P_Br(){
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
    public void boid_italic_underline_quote_Paragraph_P_Br(){
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
    public void boid_italic_underline_quote_color_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        Thread.sleep(1000);
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        supportMethod().colorAssert_p(colors);
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
    public void boid_italic_underline_quote_color_font_family_Paragraph_P_Br() throws InterruptedException {
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
        supportMethod().colorAssert_p(colors);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().boidAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().italicAssert));
        wait.until(ExpectedConditions.visibilityOfAllElements(tinyMCE().quoteAssert));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style").contains("underline"));
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().fontFamilyAssert.isDisplayed());
    }
    @Test
    public void boid_italic_underline_quote_capacity_numberedList_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        supportMethod().changeCapacity();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().numberedList);
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.numberedListAssert)).isDisplayed());
        Assert.assertTrue(finish.contains("color: rgba(0, 0, 0, 0.46);"));
    }
    @Test
    public void boid_italic_underline_quote_color_numberedList_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().numberedList);
        supportMethod().waitAndClick(tinyMCE().closeLists);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().color)).click();
        List<WebElement> colors = webDriver.findElements(By.xpath(Variables.colorsInPalette));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        WebElement element = webDriver.findElement(By.xpath(Variables.elementSpan));
        String palet = colors.get(1).getAttribute("style");
        int first = palet.lastIndexOf("(");
        int last = palet.lastIndexOf(")");
        String result = "color: rgb"+palet.substring(first,last+1)+";";
        Assert.assertEquals(palet.substring(first, last + 1), palet.substring(first, last + 1));
        Assert.assertTrue(element.getAttribute("style").contains(result));
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.numberedListAssert)).isDisplayed());
    }
    @Test
    public void globalStyles_Paragraph_P_Br() throws InterruptedException {
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
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().p3FontSize)).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.elementStyle)).size());
    }
    @Test
    public void openInNewWindow_Paragraph_P_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().openInNewWindow)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        Assert.assertEquals(webDriver.findElement(By.xpath(Variables.href)).getAttribute("target"), "_blank");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supportMethod().getRemovelinkSelector()))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void insertLinkAndApplyGlobalStyle_Paragraph_P_Br(){
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        supportMethod().waitAndClick(tinyMCE().size);
        supportMethod().waitAndClick(tinyMCE().p3FontSize);
        Assert.assertTrue(tinyMCE().p3GlobalAssert.isDisplayed());
        Assert.assertEquals("https://www.google.com/", hrefResult);
    }
    @Test
    public void changeColorWithColorPicker_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().changeColorWithColorPicker();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(!Variables.startColorValue.equals(result));
    }
    @Test
    public void changeColorWithSlider_Paragraph_P_Br() throws InterruptedException {
        Actions action = new Actions(webDriver);
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        Thread.sleep(500);
        supportMethod().waitAndClick(tinyMCE().color);
        action.moveToElement(tinyMCE().colorpicker,-25, 60).click().perform();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertTrue(!result.equals("color: rgb(0, 0, 0);"));
    }
    @Test
    public void changeCapacity_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish,"color: rgba(0, 0, 0, 0.46);");
    }
    @Test
    public void changeColorWithPaletAndCapacity_Paragraph_P_Br() throws InterruptedException {
        supportMethod().createThreeLine();
        supportMethod().selectAllText();
        supportMethod().changeColorWithPalet();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        int first = result.lastIndexOf("(");
        int last = result.lastIndexOf(")");
        String res = result.substring(first,last);
        supportMethod().waitAndClick(tinyMCE().color);
        supportMethod().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish, "color: rgba"+res+", 0.46);");
    }
    @Test
    public void boid_italic_underline_quote_changeColorWithColorPicher_changeCapacity_Paragraph_P_Br() throws InterruptedException {
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
        supportMethod().changeColorWithColorPicker();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        int first = result.lastIndexOf("(");
        int last = result.lastIndexOf(")");
        String res = result.substring(first,last);
        supportMethod().waitAndClick(tinyMCE().color);
        supportMethod().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertEquals(finish, "text-decoration: underline; color: rgba"+res+", 0.46);");
        Assert.assertTrue(tinyMCE().boidAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().italicAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().underLineAssert.isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
    }
    @Test
    public void insertLink_boid_italic_underline_quote_Paragraph_P_Br() throws InterruptedException {
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
    public void insertEmptyLink_boid_italic_underline_quote_Paragraph_P_Br() throws InterruptedException {
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
        Assert.assertEquals(webDriver.findElements(By.xpath(Variables.href)).size(), 0);
    }








    @Test
    public void boid_Paragraph_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void italic_Paragraph_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void quote_Paragraph_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
    }
    @Test
    public void underline_Paragraph_part(){
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void numberedList_Paragraph_part(){
        supportMethod().selectPartText();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().numberedList);
        Assert.assertTrue(webDriver.findElement(By.xpath("//div[contains(@id,'rect-tinymce')]//ol//li")).getText().contains(Variables.textValue));
    }
    @Test
    public void alignment_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignment)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignmentLeft)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().leftAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().leftAlignmentAssert_p.getText().contains(Variables.textValue));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignCenter)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().centerAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().centerAlignmentAssert_p.getText().contains(Variables.textValue));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignRight)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().rightAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().rightAlignmentAssert_p.getText().contains(Variables.textValue));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignJustify)).click();
        wait.until(ExpectedConditions.visibilityOf(tinyMCE().fullAlignmentAssert_p));
        Assert.assertTrue(tinyMCE().fullAlignmentAssert_p.getText().contains(Variables.textValue));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().alignClose)).click();
    }
    @Test
    public void color_Paragraph_part() throws InterruptedException {
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
    public void changeFontFamily_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().fontFamily1)).click();
        Assert.assertTrue(tinyMCE().fontFamilyAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontSize_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        for(int i = 0; i < supportMethod().getFontSize_p().size();i++){
            wait.until(ExpectedConditions.elementToBeClickable((WebElement) supportMethod().getFontSize_p().get(i))).click();
            Assert.assertTrue(webDriver.findElement(By.cssSelector((String) supportMethod().getAssertForFontSize_p().get(i))).getText().contains(Variables.textValue));
        }
        wait.until(ExpectedConditions.elementToBeClickable((WebElement) supportMethod().getFontSize_p().get(0))).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
    }
    @Test
    public void changeFontSizeWithSlider_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        supportMethod().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals(Variables.fontSizeWithSliderAssert_p, result);
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void changeFontSizeWithSlider_AndH1_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        supportMethod().changeFontSizeWithSlider();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().p3FontSize)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().closeButton)).click();
        supportMethod().changeFontSizeWithSlider();
        String result = webDriver.findElement(By.xpath(Variables.elementSpan)).getAttribute("style");
        Assert.assertEquals("font-size: 6px;", result);
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void boid_italic_underline_quote_Paragraph_part(){
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
    public void boid_italic_underline_quote_color_Paragraph_part() throws InterruptedException {
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
        supportMethod().colorAssert(colors);
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
    public void boid_italic_underline_quote_color_font_family_Paragraph_part() throws InterruptedException {
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
        supportMethod().colorAssert(colors);
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
    public void boid_italic_underline_quote_capacity_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        supportMethod().changeCapacity();
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
        Assert.assertTrue(finish.contains("color: rgba(0, 0, 0, 0.46);"));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void boid_italic_underline_quote_capacity_numberedList_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        supportMethod().changeCapacity();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().numberedList);
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.numberedListAssert)).isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(finish.contains("color: rgba(0, 0, 0, 0.46);"));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void boid_italic_underline_quote_capacity_bulletedList_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().bold)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().italic)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().underLine)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().quote)).click();
        supportMethod().changeCapacity();
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        String finish = webDriver.findElement(By.xpath(Variables.elementStyle)).getAttribute("data-mce-style");
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.bulletedListAssert)).isDisplayed());
        Assert.assertTrue(tinyMCE().quoteAssert.isDisplayed());
        Assert.assertTrue(finish.contains("color: rgba(0, 0, 0, 0.46);"));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
    }
    @Test
    public void inserAndDeleteLink_Paragraph_part() throws InterruptedException {
        supportMethod().selectPartText();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().insertLink)).click();
        tinyMCE().pasteLink.sendKeys(Keys.BACK_SPACE);
        tinyMCE().pasteLink.sendKeys("https://www.google.com/");
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().saveLink)).click();
        String hrefResult = webDriver.findElement(By.xpath(Variables.href)).getAttribute("href");
        Assert.assertEquals("https://www.google.com/", hrefResult);
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.href)).getText().contains(Variables.THREE_SIMPLE_TEXT));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(supportMethod().getRemovelinkSelector()))).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.href)).size());
    }
    @Test
    public void insertLinkToUserPage_applyAllStyles_Paragraph_part(){
        supportMethod().selectPartText();
        supportMethod().waitAndClick(tinyMCE().bold);
        supportMethod().waitAndClick(tinyMCE().italic);
        supportMethod().waitAndClick(tinyMCE().underLine);
        supportMethod().waitAndClick(tinyMCE().quote);
        supportMethod().waitAndClick(tinyMCE().lists);
        supportMethod().waitAndClick(tinyMCE().bulletedList);
        supportMethod().waitAndClick(tinyMCE().closeLists);
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
        Assert.assertEquals(1 , webDriver.findElements(By.xpath(Variables.bulletedListAssert)).size());
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
        List<WebElement> colors = webDriver.findElements(By.xpath("//div[@class='color-picker-item__palette']//i"));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(colors.get(1))).click();
        Assert.assertTrue(tinyMCE().boidAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().italicAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().underLineAssert.getText().contains(Variables.THREE_SIMPLE_TEXT));
        Assert.assertTrue(tinyMCE().quoteAssert.getText().contains(Variables.textValue));
        Assert.assertTrue(webDriver.findElement(By.xpath(Variables.elementSpan)).getText().contains(Variables.THREE_SIMPLE_TEXT));
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().size)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tinyMCE().p3FontSize)).click();
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.boidAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.italicAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.underLineAssert)).size());
        Assert.assertEquals(0, webDriver.findElements(By.xpath(Variables.elementStyle)).size());
    }
    @Test
    public void insertLink_boid_italic_underline_quote_Paragraph_part(){
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
        Actions action = new Actions(webDriver);
        action.click(editorPage().headerText).perform();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().deleteElement)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().submitDelete)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().plusIntoRow)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editorPage().elementParagraph)).click();
    }

    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
