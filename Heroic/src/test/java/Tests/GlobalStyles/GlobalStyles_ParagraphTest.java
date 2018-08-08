package Tests.GlobalStyles;

import Components.*;
import SupportClasses.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GlobalStyles_ParagraphTest {
    private static WebDriver webDriver;
    private static WebDriverWait wait;
    private static Actions action;
    private static LoginPage loginPage(){
        return new LoginPage(webDriver);
    }
    private static Factory factory(){
        return new Factory(webDriver);
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
    private static Variables variables(){
        return new Variables(webDriver);
    }
    private static GlobalStyles globalStyles(){
        return  new GlobalStyles(webDriver);
    }
    private static GlobalHelper globalHelper(){
        return  new GlobalHelper(webDriver);
    }
    private static Constants constants(){
        return new Constants();
    }



    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 45, 300);
        action = new Actions(webDriver);
//        webDriver.get("https://stg.heroicnow.com/?token=d84dbc4913dc05e5071342c3bee4fb6e5ffe443e");
        webDriver.get("https://app.heroicnow.com/?token=934bcf42fe93b2bef4da86bbcecd98d854231e8b");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
        supportMethod().createElement("paragraph");
        globalHelper().enterText();
        supportMethod().waitAndClick(sidebar().globalStyles);
        sidebar().ParagraphStylesClick();
        wait = new WebDriverWait(webDriver, 10, 300);
    }

    @Test
    public void stageA1_changeFontFamily_P1(){
        supportMethod().waitAndClick(globalStyles().globalP1);
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(0));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(0));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getParagraphGlobalValue(1,"font family");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_P1FontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(0));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageA2_changeFontSize_P1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1Item,"font-size","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(1, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        globalHelper().checkInPageViewMode(tinyMCE().p1FontSize, newValue,variables().getFontSize_PageView());
    }
    @Test
    public void stageA3_changeLineHeight_P1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1LineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1LineHeight, "font-size","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(1,"line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        globalHelper().checkInPageViewMode(tinyMCE().p1FontSize, newValue,variables().getLineHeight_PageView());
    }
    @Test
    public void stageA4_changLetterSpacing_P1(){
        Actions action = new Actions(webDriver);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1Item, "letter-spacing","1px"));
        String newValue = globalHelper().getParagraphGlobalValue(1, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        globalHelper().checkInPageViewMode(tinyMCE().p1FontSize, newValue,variables().getLetterSpacing_PageView());
    }
    @Test
    public void stageA5_changeParagraphSpacing_P1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1Item,"padding-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1Item,"padding-bottom","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(1,"paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        globalHelper().checkInPageViewMode(tinyMCE().p1FontSize, newValue,variables().getParagraphSpacing_P());
    }
    @Test
    public void stageA6_changeFontColor_P1() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("dark color"));
        globalHelper().setDefaultColorValue();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().darkColor_p1,"color", constants().DEFAULT_COLOR_VALUE));
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = globalHelper().getParagraphGlobalValue(1, "dark color");
        action.click(globalHelper().getColors("dark color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        String pageViewValue = globalHelper().getParagraphGlobalValue(1, "dark color");
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageA7_changeBulletSpacing_P1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(4), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1bullet,"padding-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(4).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(4)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p1bullet,"padding-bottom","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(1,"bullet spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        Assert.assertEquals(newValue, variables().getBulletSpacing_PageView());
    }
    @Test
    public void stageA8_changeBulletColor_P1() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("bullet color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = variables().getBulletColor_P1_OverView();
        action.click(globalHelper().getColors("bullet color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        String pageViewValue = variables().getBulletColor_P1_PageView();
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageA9_changeBulletColorWithPalette_P1() throws InterruptedException {
        supportMethod().waitAndClick(globalStyles().globalP1);
        supportMethod().waitAndClick(globalHelper().getColors("bullet color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        Thread.sleep(500);
        String newValue = variables().getBulletColor_P1_OverView();
        action.click(globalHelper().getColors("bullet color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        String pageViewValue = variables().getBulletColor_P1_PageView();
        Assert.assertEquals(newValue, pageViewValue);
        Assert.assertEquals(pageViewValue, paletteColorValue);
    }
    @Test
    public void stageAB1_changeBulletSize_P1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(5), "20");
        String defaultValue = variables().getBulletSize_P1_OverView();
        action.clickAndHold(globalHelper().getSliderRoles().get(5)).moveByOffset(-19,0).release().perform();
        String newValue = variables().getBulletSize_P1_OverView();
        Assert.assertEquals(supportMethod().asInt(defaultValue)-3, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        Assert.assertEquals(newValue, variables().getBulletSize_P1_PageView());
    }
    @Test
    public void stageAB2_changeNumberBulletColor_P1() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("number color"));
        action.moveToElement(sidebar().sidebarBottom).perform();
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = variables().getNumberBulletColor_P1_OverView();
        action.click(globalHelper().getColors("number color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        String pageViewValue = variables().getNumberBulletColor_P1_PageView();
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageAB3_changeNumberBulletColorWithPalette_P2() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("number color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        Thread.sleep(500);
        String newValue = variables().getNumberBulletColor_P1_OverView();
        action.click(globalHelper().getColors("number color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        String pageViewValue = variables().getNumberBulletColor_P1_PageView();
        Assert.assertEquals(newValue, pageViewValue);
        Assert.assertEquals(pageViewValue, paletteColorValue);
    }
    @Test
    public void stageAB4_changeNumberBulletSize_P1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(6), "20");
        String defaultValue = variables().getNumberBulletSize_P1_OverView();
        action.clickAndHold(globalHelper().getSliderRoles().get(6)).moveByOffset(-20,0).release().perform();
        String newValue = variables().getNumberBulletSize_P1_OverView();
        Assert.assertEquals(supportMethod().asInt(defaultValue)-3, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        Assert.assertEquals(newValue, variables().getNumberBulletSize_P1_PageView());
    }


    @Test
    public void stageB1_changeFontFamily_P2(){
        supportMethod().waitAndClick(globalStyles().globalP2);
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(1));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(1));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getParagraphGlobalValue(2,"font family");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_P2FontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(1));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageB2_changeFontSize_P2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2Item,"font-size","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(2, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        Assert.assertEquals(newValue, variables().getFontSize_PageView());
    }
    @Test
    public void stageB3_changeLineHeight_P2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2LineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2LineHeight, "font-size","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(2,"line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        Assert.assertEquals(newValue, variables().getLineHeight_PageView());
    }
    @Test
    public void stageB4_changLetterSpacing_P2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2Item, "letter-spacing","1px"));
        String newValue = globalHelper().getParagraphGlobalValue(2, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        globalHelper().checkInPageViewMode(tinyMCE().p2FontSize, newValue,variables().getLetterSpacing_PageView());
    }
    @Test
    public void stageB5_changeParagraphSpacing_P2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2Item,"padding-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2Item,"padding-bottom","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(2,"paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        globalHelper().checkInPageViewMode(tinyMCE().p2FontSize, newValue,variables().getParagraphSpacing_ol());
    }
    @Test
    public void stageB6_changeFontColor_P2() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("dark color"));
        globalHelper().setDefaultColorValue();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().darkColor_p2,"color",constants().DEFAULT_COLOR_VALUE));
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = globalHelper().getParagraphGlobalValue(2, "dark color");
        action.click(globalHelper().getColors("dark color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().changeFontSize(tinyMCE().p1FontSize);
        String pageViewValue = globalHelper().getParagraphGlobalValue(2, "dark color");
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageB7_changeBulletSpacing_P2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(4), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2bullet,"padding-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(4).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(4)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p2bullet,"padding-bottom","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(2,"bullet spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        Assert.assertEquals(newValue, variables().getBulletSpacing_PageView());
    }
    @Test
    public void stageB8_changeBulletColor_P2() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("bullet color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = variables().getBulletColor_P2_OverView();
        action.click(globalHelper().getColors("bullet color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        String pageViewValue = variables().getBulletColor_P2_PageView();
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageB9_changeBulletColorWithPalette_P2() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("bullet color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        Thread.sleep(500);
        String newValue = variables().getBulletColor_P2_OverView();
        action.click(globalHelper().getColors("bullet color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        String pageViewValue = variables().getBulletColor_P2_PageView();
        Assert.assertEquals(newValue, pageViewValue);
        Assert.assertEquals(pageViewValue, paletteColorValue);
    }
    @Test
    public void stageBC1_changeBulletSize_P2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(5), "20");
        String defaultValue = variables().getBulletSize_P2_OverView();
        action.clickAndHold(globalHelper().getSliderRoles().get(5)).moveByOffset(-20,0).release().perform();
        String newValue = variables().getBulletSize_P2_OverView();
        Assert.assertEquals(supportMethod().asInt(defaultValue)-3, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        Assert.assertEquals(newValue, variables().getBulletSize_P2_PageView());
    }
    @Test
    public void stageBC2_changeNumberBulletColor_P1() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("number color"));
        action.moveToElement(globalStyles().globalP3).perform();
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = variables().getNumberBulletColor_P2_OverView();
        action.click(globalHelper().getColors("number color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        String pageViewValue = variables().getNumberBulletColor_P2_PageView();
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageBC3_changeNumberBulletColorWithPalette_P2() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("number color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        Thread.sleep(500);
        String newValue = variables().getNumberBulletColor_P2_OverView();
        action.click(globalHelper().getColors("number color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        String pageViewValue = variables().getNumberBulletColor_P2_PageView();
        Assert.assertEquals(newValue, pageViewValue);
        Assert.assertEquals(pageViewValue, paletteColorValue);
    }
    @Test
    public void stageBC4_changeNumberBulletSize_P2(){
        action.moveToElement(globalHelper().getInputGlobalStyles().get(6)).perform();
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(6), "20");
        String defaultValue = variables().getNumberBulletSize_P2_OverView();
        action.clickAndHold(globalHelper().getSliderRoles().get(6)).moveByOffset(-20,0).release().perform();
        String newValue = variables().getNumberBulletSize_P2_OverView();
        Assert.assertEquals(supportMethod().asInt(defaultValue)-3, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p2FontSize);
        Assert.assertEquals(newValue, variables().getNumberBulletSize_P2_PageView());
    }


    @Test
    public void stageC1_changeFontFamily_P3(){
        supportMethod().waitAndClick(globalStyles().globalP3);
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(2));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(2));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getParagraphGlobalValue(3,"font family");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_P3FontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(2));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageC2_changeFontSize_P3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3Item,"font-size","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(3, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        Assert.assertEquals(newValue, variables().getFontSize_PageView());
    }
    @Test
    public void stageC3_changeLineHeight_P3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3LineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3LineHeight, "font-size","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(3,"line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        Assert.assertEquals(newValue, variables().getLineHeight_PageView());
    }
    @Test
    public void stageC4_changLetterSpacing_P3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3Item, "letter-spacing","1px"));
        String newValue = globalHelper().getParagraphGlobalValue(3, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        globalHelper().checkInPageViewMode(tinyMCE().p3FontSize, newValue,variables().getLetterSpacing_PageView());
    }
    @Test
    public void stageC5_changeParagraphSpacing_P3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3Item,"padding-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3Item,"padding-bottom","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(3,"paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        globalHelper().checkInPageViewMode(tinyMCE().p3FontSize, newValue,variables().getParagraphSpacing_ol());
    }
    @Test
    public void stageC6_changeFontColor_P3() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("dark color"));
        globalHelper().setDefaultColorValue();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().darkColor_p3,"color",constants().DEFAULT_COLOR_VALUE));
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = globalHelper().getParagraphGlobalValue(3, "dark color");
        action.click(globalHelper().getColors("dark color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        String pageViewValue = globalHelper().getParagraphGlobalValue(3, "dark color");
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageC7_changeBulletSpacing_P3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(4), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3bullet,"padding-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(4).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(4)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().p3bullet,"padding-bottom","41px"));
        String newValue = globalHelper().getParagraphGlobalValue(3,"bullet spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        Assert.assertEquals(newValue, variables().getBulletSpacing_PageView());
        supportMethod().waitAndClick(globalStyles().overViewMode);
    }
    @Test
    public void stageC8_changeBulletColor_P3() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("bullet color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = variables().getBulletColor_P3_OverView();
        action.click(globalHelper().getColors("bullet color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        String pageViewValue = variables().getBulletColor_P3_PageView();
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageC9_changeBulletColorWithPalette_P3() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("bullet color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        Thread.sleep(500);
        String newValue = variables().getBulletColor_P3_OverView();
        action.click(globalHelper().getColors("bullet color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        String pageViewValue = variables().getBulletColor_P3_PageView();
        Assert.assertEquals(newValue, pageViewValue);
        Assert.assertEquals(pageViewValue, paletteColorValue);
    }
    @Test
    public void stageCD1_changeBulletSize_P3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(5), "20");
        String defaultValue = variables().getBulletSize_P3_OverView();
        action.clickAndHold(globalHelper().getSliderRoles().get(5)).moveByOffset(-20,0).release().perform();
        String newValue = variables().getBulletSize_P3_OverView();
        Assert.assertEquals(supportMethod().asInt(defaultValue)-3, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyBullet();
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        Assert.assertEquals(newValue, variables().getBulletSize_P3_PageView());
        supportMethod().waitAndClick(globalStyles().overViewMode);
    }
    @Test
    public void stageCD2_changeNumberBulletColor_P1() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("number color"));
        action.moveToElement(sidebar().sidebarBottom).perform();
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithColorPicker();
        Thread.sleep(500);
        String newValue = variables().getNumberBulletColor_P3_OverView();
        action.click(globalHelper().getColors("number color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        String pageViewValue = variables().getNumberBulletColor_P3_PageView();
        Assert.assertEquals(newValue, pageViewValue);
    }
    @Test
    public void stageCD3_changeNumberBulletColorWithPalette_P3() throws InterruptedException {
        supportMethod().waitAndClick(globalHelper().getColors("number color"));
        globalHelper().setDefaultColorValue();
        Thread.sleep(500);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        Thread.sleep(500);
        String newValue = variables().getNumberBulletColor_P3_OverView();
        action.click(globalHelper().getColors("number color")).perform();
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        String pageViewValue = variables().getNumberBulletColor_P3_PageView();
        Assert.assertEquals(newValue, pageViewValue);
        Assert.assertEquals(pageViewValue, paletteColorValue);
    }
    @Test
    public void stageCD4_changeNumberBulletSize_P3(){
        action.moveToElement(globalHelper().getInputGlobalStyles().get(6)).perform();
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(6), "20");
        String defaultValue = variables().getNumberBulletSize_P3_OverView();
        action.clickAndHold(globalHelper().getSliderRoles().get(6)).moveByOffset(-20,0).release().perform();
        String newValue = variables().getNumberBulletSize_P3_OverView();
        Assert.assertEquals(supportMethod().asInt(defaultValue)-3, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        globalHelper().applyNumberBullet();
        globalHelper().changeFontSize(tinyMCE().p3FontSize);
        Assert.assertEquals(newValue, variables().getNumberBulletSize_P3_PageView());
    }

    @After
    public void beforeTests(){
        supportMethod().waitAndClick(globalStyles().overViewMode);
    }
    @AfterClass
    public static void post() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
