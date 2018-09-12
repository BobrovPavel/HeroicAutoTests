package Tests.GlobalStyles;

import Components.*;
import SupportClasses.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
//import org.junit.runners.MethodSorters;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GlobalStyles_HeadlineTest {

    private static WebDriver webDriver;
    private static WebDriverWait wait;
    private static Actions action;
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
        webDriver.get(Constants.QA_GLOBALSTYLES_HEADLINE);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
        supportMethod().createElements("header",6);
        supportMethod().changeFontSize(variables().getHeadlineFontSize());
        supportMethod().waitAndClick(sidebar().globalStyles);
        supportMethod().waitAndClick(sidebar().headerStyles);
        wait = new WebDriverWait(webDriver, 10, 300);
    }
    @Test
    public void stageA1_changeFontFamily_H1(){
        supportMethod().waitAndClick(globalStyles().globalH1);
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(0));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(0));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getHeadlineGlobalValue(1,"font family");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_H1fontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(0));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageA2_changeFontSize_H1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1Item,"font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(1, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineFontSize_PageView(1));
    }
    @Test
    public void stageA3_changeLineHeight_H1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1lineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1lineHeight, "font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(1, "line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLineHeight_PageView(1));
    }
    @Test
    public void stageA4_changLetterSpacing_H1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1Item, "letter-spacing","1px"));
        String newValue = globalHelper().getHeadlineGlobalValue(1, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLetterSpacing_PageView(1));
    }
    @Test
    public void stageA5_changeParagraphSpacing_H1(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1Paragraph,"margin-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h1Paragraph,"margin-bottom","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(1, "paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineParagraphSpacing_PageView(1));
    }


    @Test
    public void stageB1_changeFontFamily_H2(){
        supportMethod().waitAndClick(globalStyles().globalH2);
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(1));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(1));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getHeadlineGlobalValue(2,"z");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_H2fontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(1));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageB2_changeFontSize_H2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2Item,"font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(2, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineFontSize_PageView(2));
    }
    @Test
    public void stageB3_changeLineHeight_H2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2lineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2lineHeight, "font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(2, "line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLineHeight_PageView(2));
    }
    @Test
    public void stageB4_changLetterSpacing_H2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2Item, "letter-spacing","1px"));
        String newValue = globalHelper().getHeadlineGlobalValue(2, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLetterSpacing_PageView(2));
    }
    @Test
    public void stageB5_changeParagraphSpacing_H2(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2Paragraph,"margin-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h2Paragraph,"margin-bottom","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(2, "paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineParagraphSpacing_PageView(2));
    }


    @Test
    public void stageC1_changeFontFamily_H3(){
        supportMethod().waitAndClick(globalStyles().globalH3);
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(2));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(2));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getHeadlineGlobalValue(3,"font family");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_H3fontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(2));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageC2_changeFontSize_H3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3Item,"font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(3, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineFontSize_PageView(3));
    }
    @Test
    public void stageC3_changeLineHeight_H3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3lineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3lineHeight, "font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(3, "line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLineHeight_PageView(3));
    }
    @Test
    public void stageC4_changLetterSpacing_H3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3Item, "letter-spacing","1px"));
        String newValue = globalHelper().getHeadlineGlobalValue(3, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLetterSpacing_PageView(3));
    }
    @Test
    public void stageC5_changeParagraphSpacing_H3(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3Paragraph,"margin-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h3Paragraph,"margin-bottom","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(3, "paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineParagraphSpacing_PageView(3));
    }


    @Test
    public void stageD1_changeFontFamily_H4(){
        supportMethod().waitAndClick(globalStyles().globalH4);
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(3));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(3));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getHeadlineGlobalValue(4,"font family");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_H4fontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(3));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageD2_changeFontSize_H4(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4Item,"font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(4, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineFontSize_PageView(4));
    }
    @Test
    public void stageD3_changeLineHeight_H4(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4lineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4lineHeight, "font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(4, "line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLineHeight_PageView(4));
    }
    @Test
    public void stageD4_changLetterSpacing_H4(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4Item, "letter-spacing","1px"));
        String newValue = globalHelper().getHeadlineGlobalValue(4, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLetterSpacing_PageView(4));
    }
    @Test
    public void stageD5_changeParagraphSpacing_H4(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4Paragraph,"margin-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h4Paragraph,"margin-bottom","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(4, "paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineParagraphSpacing_PageView(4));
    }


    @Test
    public void stageE1_changeFontFamily_H5() throws InterruptedException {
        supportMethod().waitAndClick(globalStyles().globalH5);
        Thread.sleep(500);
        List<WebElement> list = webDriver.findElements(By.xpath("//div[@class='select-panel-list__inner']"));
        supportMethod().waitAndClick(list.get(4));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(4));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getHeadlineGlobalValue(5,"font family");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_H5fontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(4));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageE2_changeFontSize_H5(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5Item,"font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(5, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineFontSize_PageView(5));
    }
    @Test
    public void stageE3_changeLineHeight_H5(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5lineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5lineHeight, "font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(5, "line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLineHeight_PageView(5));
    }
    @Test
    public void stageE4_changLetterSpacing_H5(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5Item, "letter-spacing","1px"));
        String newValue = globalHelper().getHeadlineGlobalValue(5, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLetterSpacing_PageView(5));
    }
    @Test
    public void stageE5_changeParagraphSpacing_H5(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5Paragraph,"margin-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h5Paragraph,"margin-bottom","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(5, "paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineParagraphSpacing_PageView(5));
    }


    @Test
    public void stageF1_changeFontFamily_H6() throws InterruptedException {
        supportMethod().waitAndClick(globalStyles().globalH6);
        Thread.sleep(500);
        List<WebElement> list = webDriver.findElements(By.xpath("//div[@class='select-panel-list__inner']"));
        supportMethod().waitAndClick(list.get(5));
        supportMethod().waitAndClick(globalStyles().asap_font);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6Item,"font-family", "Asap"));
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(5));
        supportMethod().waitAndClick(globalStyles().abril_Fatface_font);
        String newFontFamily = globalHelper().getHeadlineGlobalValue(6,"font family");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6Item,"font-family", "\"Abril Fatface\""));
        Assert.assertEquals("\"Abril Fatface\"", newFontFamily);
        Assert.assertEquals(2, webDriver.findElements(By.xpath(Variables.pageView_H6fontFamilyAssert)).size());
        supportMethod().waitAndClick((WebElement) globalHelper().getFontFamilyDropdown().get(5));
        supportMethod().waitAndClick(globalStyles().asap_font);
    }
    @Test
    public void stageF2_changeFontSize_H6(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6Item,"font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6Item,"font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(6, "font size");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineFontSize_PageView(6));
    }
    @Test
    public void stageF3_changeLineHeight_H6(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6lineHeight, "font-size","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6lineHeight, "font-size","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(6, "line height");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLineHeight_PageView(6));
    }
    @Test
    public void stageF4_changLetterSpacing_H6(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(2), "1.5");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6Item, "letter-spacing","1.5px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(2).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(2)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6Item, "letter-spacing","1px"));
        String newValue = globalHelper().getHeadlineGlobalValue(6, "letter spacing");
        Assert.assertEquals(String.valueOf(supportMethod().asDouble(defaultValue)-0.5), String.valueOf(supportMethod().asDouble(newValue)));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineLetterSpacing_PageView(6));
    }
    @Test
    public void stageF5_changeParagraphSpacing_H6(){
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(3), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6Paragraph,"margin-bottom","50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(3).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(3)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().h6Paragraph,"margin-bottom","41px"));
        String newValue = globalHelper().getHeadlineGlobalValue(6, "paragraph spacing");
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, variables().getHeadlineParagraphSpacing_PageView(6));
    }

    @After
    public void afterTests(){
        supportMethod().waitAndClick(globalStyles().overViewMode);
    }
    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
