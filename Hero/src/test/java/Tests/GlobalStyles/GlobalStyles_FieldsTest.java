package Tests.GlobalStyles;

import Components.*;
import SupportClasses.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
//import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GlobalStyles_FieldsTest {
    private static WebDriver webDriver;
    private static WebDriverWait wait;
    private static Actions action;
    private static JavascriptExecutor js;

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
    public static void setupClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 45, 300);
        action = new Actions(webDriver);
        js = (JavascriptExecutor)webDriver;
        webDriver.get(Constants.QA_GLOBALSTYLES_FIELD);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logger")));
        supportMethod().createThreeColumnRowAndAddElements_firstSection(editorPage().elementInput);
        supportMethod().createThreeColumnRowAndAddElements_anySection(editorPage().elementTextArea,0);
//        supportMethod().createThreeColumnRowAndAddElements_anySection(editorPage().elementDroplist,1);
//        supportMethod().createThreeColumnRowAndAddElements_anySection(editorPage().elementCheckbox,2);
//        supportMethod().createThreeColumnRowAndAddElements_anySection(editorPage().elementRadiobox,3);
        supportMethod().waitAndClick(sidebar().globalStyles);
        globalHelper().setInputFieldsType();
//        globalHelper().setElementsType();
        supportMethod().waitAndClick(sidebar().globalStyles);
        sidebar().paragraphStylesClick();
        init();
        print();
        // 20
        // 18
        // 16
        supportMethod().waitAndClick(sidebar().globalStyles);
        sidebar().fieldStylesClick();
        wait = new WebDriverWait(webDriver, 10, 300);
    }



    @Test
    public void stageA1_changeFontStyle_P1_OverView() {
        supportMethod().waitAndClick(sidebar().largeFieldsSettings);
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P1);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeField, Constants.FONT_SIZE, p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeFieldInput, Constants.FONT_FAMILY, p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().normalLargeField.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p1FontFamily, globalStyles().normalLargeFieldInput.getCssValue(Constants.FONT_FAMILY));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(p1FontSize, globalStyles().largeField_PageView.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p1FontFamily, globalStyles().largeFieldInput_PageView.getCssValue(Constants.FONT_FAMILY));
    }
    /* 14.08 Тест проходит ложноположительно. Таск заведен, ожидает фикса */
    @Test
    public void stageA2_changeFontStyle_P1_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P1);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeField, Constants.FONT_SIZE, p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeFieldInput, Constants.FONT_FAMILY, p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedLargeField.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedLargeFieldInput.getCssValue(Constants.FONT_FAMILY));
        Assert.assertEquals(p1FontSize, GlobalHelper.getLargeFieldFocusCss(Constants.FONT_SIZE));
        Assert.assertEquals(p1FontFamily, GlobalHelper.getLargeFieldFocusCss(Constants.FONT_FAMILY));
    }
    @Test
    public void stageA3_changeFontStyle_P2_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P2);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeField, Constants.FONT_SIZE, p2FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeFieldInput, Constants.FONT_FAMILY, p2FontFamily));
        Assert.assertEquals(p2FontSize, globalStyles().normalLargeField.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p2FontFamily, globalStyles().normalLargeFieldInput.getCssValue(Constants.FONT_FAMILY));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(p2FontSize, globalStyles().largeField_PageView.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p2FontFamily, globalStyles().largeFieldInput_PageView.getCssValue(Constants.FONT_FAMILY));
        supportMethod().waitAndClick(globalStyles().largeField_PageView);
        Assert.assertEquals(p2FontSize, GlobalHelper.getLargeFieldFocusCss(Constants.FONT_SIZE));
        Assert.assertEquals(p2FontFamily, GlobalHelper.getLargeFieldFocusCss(Constants.FONT_FAMILY));
    }
    @Test
    public void stageA4_changeFontStyle_P2_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P2);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeField, Constants.FONT_SIZE, p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeFieldInput, Constants.FONT_FAMILY, p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedLargeField.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedLargeFieldInput.getCssValue(Constants.FONT_FAMILY));
    }
    @Test
    public void stageA5_changeFontStyle_P3_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P3);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeField, Constants.FONT_SIZE, p3FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeFieldInput, Constants.FONT_FAMILY, p3FontFamily));
        Assert.assertEquals(p3FontSize, globalStyles().normalLargeField.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p3FontFamily, globalStyles().normalLargeFieldInput.getCssValue(Constants.FONT_FAMILY));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(p3FontSize, globalStyles().largeField_PageView.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p3FontFamily, globalStyles().largeFieldInput_PageView.getCssValue(Constants.FONT_FAMILY));
        supportMethod().waitAndClick(globalStyles().largeField_PageView);
        Assert.assertEquals(p3FontSize, GlobalHelper.getLargeFieldFocusCss(Constants.FONT_SIZE));
        Assert.assertEquals(p3FontFamily, GlobalHelper.getLargeFieldFocusCss(Constants.FONT_FAMILY));
    }
    @Test
    public void stageA6_changeFontStyle_P3_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P3);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeField, Constants.FONT_FAMILY, p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeFieldInput, Constants.FONT_FAMILY, p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedLargeField.getCssValue("font-size"));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedLargeFieldInput.getCssValue(Constants.FONT_FAMILY));
    }
    @Test
    public void stageA7_changeFillColorWithPalette_Large_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("fill color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalLargeFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("fill Color")).perform();
        String newValue = globalStyles().normalLargeFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().largeFieldInput_PageView.getCssValue(Constants.BACKGROUND_COLOR));
    }
    @Test
    public void stageA8_changeFillColorWithPalette_Large_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("fill color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedLargeFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("fill Color")).perform();
        String newValue = globalStyles().selectedLargeFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().largeField);
        Assert.assertEquals(newValue, supportMethod().toRGBA(GlobalHelper.getLargeFieldFocusCss(Constants.BACKGROUND_COLOR)));
    }
    @Test
    public void stageA9_changeFontColorWithPalette_Large_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("font color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalLargeFieldInput.getCssValue(Constants.COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().normalLargeFieldInput.getCssValue(Constants.COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().largeFieldInput_PageView.getCssValue(Constants.COLOR));
    }
    @Test
    public void stageAB1_changeFontColorWithPalette_Large_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("font color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedLargeFieldInput.getCssValue(Constants.COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().selectedLargeFieldInput.getCssValue(Constants.COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().largeField);
        Assert.assertEquals(newValue, supportMethod().toRGBA(GlobalHelper.getLargeFieldFocusCss(Constants.COLOR)));
    }
    @Test
    public void stageAB2_changeBorderColorWithPalette_Large_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("border color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalHelper().getDefaultColorValue();
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalLargeFieldInput.getCssValue("border-color");
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().normalLargeFieldInput.getCssValue("border-color");
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().largeFieldInput_PageView.getCssValue(Constants.BORDER_COLOR));
    }
    @Test
    public void stageAB3_changeBorderColorWithPalette_Large_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("border color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalHelper().getDefaultColorValue();
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedLargeFieldInput.getCssValue(Constants.BORDER_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().selectedLargeFieldInput.getCssValue(Constants.BORDER_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().largeField);
        Assert.assertEquals(newValue, GlobalHelper.getLargeFieldFocusCss(Constants.BORDER_COLOR));
    }
    @Test
    public void stageAB4_changeBorderThickness_Large_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "10");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeFieldInput,Constants.BORDER_WIDTH,"10px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeFieldInput,Constants.BORDER_WIDTH,"8px"));
        String newValue = globalStyles().normalLargeFieldInput.getCssValue(Constants.BORDER_WIDTH);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-2, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().largeFieldInput_PageView.getCssValue(Constants.BORDER_WIDTH));
    }
    @Test
    public void stageAB5_changeBorderThickness_Large_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "10");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeFieldInput,Constants.BORDER_WIDTH,"10px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeFieldInput,Constants.BORDER_WIDTH,"8px"));
        String newValue = globalStyles().selectedLargeFieldInput.getCssValue(Constants.BORDER_WIDTH);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-2, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().largeField);
        Assert.assertEquals(newValue, GlobalHelper.getLargeFieldFocusCss(Constants.BORDER_WIDTH));
    }
    @Test
    public void stageAB6_changeBorderRadius_Large_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeFieldInput,Constants.BORDER_RADIUS,"50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalLargeFieldInput,Constants.BORDER_RADIUS,"41px"));
        String newValue = globalStyles().normalLargeFieldInput.getCssValue(Constants.BORDER_RADIUS);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().largeFieldInput_PageView.getCssValue(Constants.BORDER_RADIUS));
    }
    @Test
    public void stageAB7_changeBorderRadius_Large_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeFieldInput,Constants.BORDER_RADIUS,"50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedLargeFieldInput,Constants.BORDER_RADIUS,"41px"));
        String newValue = globalStyles().selectedLargeFieldInput.getCssValue(Constants.BORDER_RADIUS);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().largeField);
        Assert.assertEquals(newValue, GlobalHelper.getLargeFieldFocusCss(Constants.BORDER_RADIUS));
    }






    @Test
    public void stageA1_changeFontStyle_P1__Medium_OverView(){
        supportMethod().waitAndClick(sidebar().mediumFieldsSettings);
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P1);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumField, "font-size", p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumFieldInput, "font-family", p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().normalMediumField.getCssValue("font-size"));
        Assert.assertEquals(p1FontFamily, globalStyles().normalMediumFieldInput.getCssValue("font-family"));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(p1FontSize, globalStyles().mediumField_PageView.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p1FontFamily, globalStyles().mediumFieldInput_PageView.getCssValue(Constants.FONT_FAMILY));
    }
    /* 14.08 Тест проходит ложноположительно. Таск заведен, ожидает фикса */
    @Test
    public void stageA2_changeFontStyle_P1__Medium_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P1);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumField, "font-size", p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumFieldInput, "font-family", p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedMediumField.getCssValue("font-size"));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedMediumFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA3_changeFontStyle_P2__Medium_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P2);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumField, "font-size", p2FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumFieldInput, "font-family", p2FontFamily));
        Assert.assertEquals(p2FontSize, globalStyles().normalMediumField.getCssValue("font-size"));
        Assert.assertEquals(p2FontFamily, globalStyles().normalMediumFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA4_changeFontStyle_P2__Medium_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P2);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumField, "font-size", p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumFieldInput, "font-family", p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedMediumField.getCssValue("font-size"));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedMediumFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA5_changeFontStyle_P3__Medium_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P3);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumField, "font-size", p3FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumFieldInput, "font-family", p3FontFamily));
        Assert.assertEquals(p3FontSize, globalStyles().normalMediumField.getCssValue("font-size"));
        Assert.assertEquals(p3FontFamily, globalStyles().normalMediumFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA6_changeFontStyle_P3__Medium_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P3);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumField, "font-size", p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumFieldInput, "font-family", p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedMediumField.getCssValue("font-size"));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedMediumFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA7_changeFillColorWithPalette_Medium_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("fill color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalMediumFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithPalette();
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("fill Color")).perform();
        String newValue = globalStyles().normalMediumFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().mediumFieldInput_PageView.getCssValue(Constants.BACKGROUND_COLOR));
    }
    @Test
    public void stageA8_changeFillColorWithPalette_Medium_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("fill color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedMediumFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithPalette();
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("fill Color")).perform();
        String newValue = globalStyles().selectedMediumFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().mediumField);
        Assert.assertEquals(newValue, supportMethod().toRGBA(GlobalHelper.getMediumFieldFocusCss(Constants.BACKGROUND_COLOR)));
    }
    @Test
    public void stageA9_changeFontColorWithPalette_Medium_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("font color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalMediumFieldInput.getCssValue(Constants.COLOR);
        globalHelper().changeColorWithPalette();
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().normalMediumFieldInput.getCssValue(Constants.COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().mediumFieldInput_PageView.getCssValue(Constants.COLOR));
    }
    @Test
    public void stageAB1_changeFontColorWithPalett_Medium_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("font color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedMediumFieldInput.getCssValue(Constants.COLOR);
        globalHelper().changeColorWithPalette();
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().selectedMediumFieldInput.getCssValue(Constants.COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().mediumField);
        Assert.assertEquals(newValue, supportMethod().toRGBA(GlobalHelper.getMediumFieldFocusCss(Constants.COLOR)));
    }
    @Test
    public void stageAB2_changeBorderColorWithPalett_Medium_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("border color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalHelper().getDefaultColorValue();
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalMediumFieldInput.getCssValue(Constants.BORDER_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().normalMediumFieldInput.getCssValue(Constants.BORDER_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().mediumFieldInput_PageView.getCssValue(Constants.BORDER_COLOR));
    }
    @Test
    public void stageAB3_changeBorderColorWithPalett_Medium_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("border color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalHelper().getDefaultColorValue();
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedMediumFieldInput.getCssValue(Constants.BORDER_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().selectedMediumFieldInput.getCssValue(Constants.BORDER_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().mediumField);
        Assert.assertEquals(newValue, GlobalHelper.getMediumFieldFocusCss(Constants.BORDER_COLOR));
    }
    @Test
    public void stageAB4_changeBorderThickness_Medium_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "10");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumFieldInput,Constants.BORDER_WIDTH,"10px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumFieldInput,Constants.BORDER_WIDTH,"8px"));
        String newValue = globalStyles().normalMediumFieldInput.getCssValue(Constants.BORDER_WIDTH);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-2, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().mediumFieldInput_PageView.getCssValue(Constants.BORDER_WIDTH));
    }
    @Test
    public void stageAB5_changeBorderThickness_Medium_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "10");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumFieldInput,Constants.BORDER_WIDTH,"10px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumFieldInput,Constants.BORDER_WIDTH,"8px"));
        String newValue = globalStyles().selectedMediumFieldInput.getCssValue(Constants.BORDER_WIDTH);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-2, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().mediumField);
        Assert.assertEquals(newValue, GlobalHelper.getMediumFieldFocusCss(Constants.BORDER_WIDTH));
    }
    @Test
    public void stageAB6_changeBorderRadius_Medium_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumFieldInput,Constants.BORDER_RADIUS,"50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalMediumFieldInput,Constants.BORDER_RADIUS,"41px"));
        String newValue = globalStyles().normalMediumFieldInput.getCssValue(Constants.BORDER_RADIUS);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().mediumFieldInput_PageView.getCssValue(Constants.BORDER_RADIUS));
    }
    @Test
    public void stageAB7_changeBorderRadius_Medium_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumFieldInput,Constants.BORDER_RADIUS,"50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedMediumFieldInput,Constants.BORDER_RADIUS,"41px"));
        String newValue = globalStyles().selectedMediumFieldInput.getCssValue(Constants.BORDER_RADIUS);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().mediumField);
        Assert.assertEquals(newValue, GlobalHelper.getMediumFieldFocusCss(Constants.BORDER_RADIUS));
    }






    @Test
    public void stageA1_changeFontStyle_P1_Small_OverView(){
        supportMethod().waitAndClick(sidebar().smallFieldsSettings);
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P1);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallField, Constants.FONT_SIZE, p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallFieldInput, Constants.FONT_FAMILY, p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().normalSmallField.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p1FontFamily, globalStyles().normalSmallFieldInput.getCssValue(Constants.FONT_FAMILY));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(p1FontSize, globalStyles().smallField_PageView.getCssValue(Constants.FONT_SIZE));
        Assert.assertEquals(p1FontFamily, globalStyles().smallFieldInput_PageView.getCssValue(Constants.FONT_FAMILY));
    }
    /* 14.08 Тест проходит ложноположительно. Таск заведен, ожидает фикса */
    @Test
    public void stageA2_changeFontStyle_P1_Small_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P1);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallField, "font-size", p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallFieldInput, "font-family", p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedSmallField.getCssValue("font-size"));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedSmallFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA3_changeFontStyle_P2_Small_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P2);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallField, "font-size", p2FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallFieldInput, "font-family", p2FontFamily));
        Assert.assertEquals(p2FontSize, globalStyles().normalSmallField.getCssValue("font-size"));
        Assert.assertEquals(p2FontFamily, globalStyles().normalSmallFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA4_changeFontStyle_P2_Small_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P2);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallField, "font-size", p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallFieldInput, "font-family", p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedSmallField.getCssValue("font-size"));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedSmallFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA5_changeFontStyle_P3_Small_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P3);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallField, "font-size", p3FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallFieldInput, "font-family", p3FontFamily));
        Assert.assertEquals(p3FontSize, globalStyles().normalSmallField.getCssValue("font-size"));
        Assert.assertEquals(p3FontFamily, globalStyles().normalSmallFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA6_changeFontStyle_P3_Small_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalStyles().fields_FontStyle_P3);
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallField, "font-size", p1FontSize));
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallFieldInput, "font-family", p1FontFamily));
        Assert.assertEquals(p1FontSize, globalStyles().selectedSmallField.getCssValue("font-size"));
        Assert.assertEquals(p1FontFamily, globalStyles().selectedSmallFieldInput.getCssValue("font-family"));
    }
    @Test
    public void stageA7_changeFillColorWithPalette_Small_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("fill color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalSmallFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("fill Color")).perform();
        String newValue = globalStyles().normalSmallFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().smallFieldInput_PageView.getCssValue(Constants.BACKGROUND_COLOR));
    }
    @Test
    public void stageA8_changeFillColorWithPalette_Small_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("fill color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedSmallFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("fill Color")).perform();
        String newValue = globalStyles().selectedSmallFieldInput.getCssValue(Constants.BACKGROUND_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().smallField);
        Assert.assertEquals(newValue, supportMethod().toRGBA(GlobalHelper.getSmallFieldFocusCss(Constants.BACKGROUND_COLOR)));
    }
    @Test
    public void stageA9_changeFontColorWithPalette_Small_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("font color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalSmallFieldInput.getCssValue(Constants.COLOR);
        globalHelper().changeColorWithPalette();
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().normalSmallFieldInput.getCssValue(Constants.COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().smallFieldInput_PageView.getCssValue(Constants.COLOR));
    }
    @Test
    public void stageAB1_changeFontColorWithPalette_Small_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("font color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalStyles().inputColorLable.getCssValue(Constants.BACKGROUND_COLOR);
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedSmallFieldInput.getCssValue(Constants.COLOR);
        globalHelper().changeColorWithPalette();
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getPaletteColors().get(1).getCssValue(Constants.BACKGROUND_COLOR);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().selectedSmallFieldInput.getCssValue(Constants.COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().smallField);
        Assert.assertEquals(newValue, supportMethod().toRGBA(GlobalHelper.getSmallFieldFocusCss(Constants.COLOR)));
    }
    @Test
    public void stageAB2_changeBorderColorWithPalett_Small_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        supportMethod().waitAndClick(globalHelper().getFieldColors("border color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalHelper().getDefaultColorValue();
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().normalSmallFieldInput.getCssValue(Constants.BORDER_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().normalSmallFieldInput.getCssValue(Constants.BORDER_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().smallFieldInput_PageView.getCssValue(Constants.BORDER_COLOR));
    }
    @Test
    public void stageAB3_changeBorderColorWithPalette_Small_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        supportMethod().waitAndClick(globalHelper().getFieldColors("border color"));
        globalHelper().setDefaultColorValue();
        String defaultValue = globalHelper().getDefaultColorValue();
        globalHelper().changeColorWithColorPicker();
        String afterPickValue = globalStyles().selectedSmallFieldInput.getCssValue(Constants.BORDER_COLOR);
        globalHelper().changeColorWithPalette();
        String paletteColorValue = globalHelper().getColorPalette(1);
        action.click(globalHelper().getFieldColors("font color")).perform();
        String newValue = globalStyles().selectedSmallFieldInput.getCssValue(Constants.BORDER_COLOR);
        Assert.assertEquals(paletteColorValue, newValue);
        Assert.assertTrue(!defaultValue.equals(afterPickValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().smallField);
        Assert.assertEquals(newValue, GlobalHelper.getSmallFieldFocusCss(Constants.BORDER_COLOR));
    }
    @Test
    public void stageAB4_changeBorderThickness_Small_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "10");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallFieldInput,Constants.BORDER_WIDTH,"10px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallFieldInput,Constants.BORDER_WIDTH,"8px"));
        String newValue = globalStyles().normalSmallFieldInput.getCssValue(Constants.BORDER_WIDTH);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-2, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().smallFieldInput_PageView.getCssValue(Constants.BORDER_WIDTH));
    }
    @Test
    public void stageAB5_changeBorderThickness_Small_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(0), "10");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallFieldInput,Constants.BORDER_WIDTH,"10px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(0).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(0)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallFieldInput,Constants.BORDER_WIDTH,"8px"));
        String newValue = globalStyles().selectedSmallFieldInput.getCssValue(Constants.BORDER_WIDTH);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-2, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().smallField);
        Assert.assertEquals(newValue, GlobalHelper.getSmallFieldFocusCss(Constants.BORDER_WIDTH));
    }
    @Test
    public void stageAB6_changeBorderRadius_Small_OverView(){
        supportMethod().waitAndClick(globalStyles().editRegular);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallFieldInput,Constants.BORDER_RADIUS,"50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().normalSmallFieldInput,Constants.BORDER_RADIUS,"41px"));
        String newValue = globalStyles().normalSmallFieldInput.getCssValue(Constants.BORDER_RADIUS);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        Assert.assertEquals(newValue, globalStyles().smallFieldInput_PageView.getCssValue(Constants.BORDER_RADIUS));
    }
    @Test
    public void stageAB7_changeBorderRadius_Small_OverView_Hover(){
        supportMethod().waitAndClick(globalStyles().editHover);
        globalHelper().setDefaultValue(globalHelper().getInputGlobalStyles().get(1), "50");
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallFieldInput,Constants.BORDER_RADIUS,"50px"));
        String defaultValue = globalHelper().getInputGlobalStyles().get(1).getAttribute("value");
        action.clickAndHold(globalHelper().getSliderRoles().get(1)).moveByOffset(-20,0).release().perform();
        wait.until(ExpectedConditions.attributeToBe(globalStyles().selectedSmallFieldInput,Constants.BORDER_RADIUS,"41px"));
        String newValue = globalStyles().selectedSmallFieldInput.getCssValue(Constants.BORDER_RADIUS);
        Assert.assertEquals(supportMethod().asInt(defaultValue)-9, supportMethod().asInt(newValue));
        supportMethod().waitAndClick(globalStyles().pageViewMode);
        supportMethod().focus(globalStyles().smallField);
        Assert.assertEquals(newValue, GlobalHelper.getSmallFieldFocusCss(Constants.BORDER_RADIUS));
    }



    @After
    public void postCondition(){
        supportMethod().goToSmallFieldSettings();
        supportMethod().waitAndClick(globalStyles().overViewMode);
    }

    @AfterClass
    public static void post(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }





    private static String p1FontSize;
    private static String p1FontFamily;
    private static String p1LineHeight;
    private static String p1LetterSpacing;
    private static String p1ParagraphSpacing;
    private static String p2FontSize;
    private static String p2FontFamily;
    private static String p2LineHeight;
    private static String p2LetterSpacing;
    private static String p2ParagraphSpacing;
    private static String p3FontSize;
    private static String p3FontFamily;
    private static String p3LineHeight;
    private static String p3LetterSpacing;
    private static String p3ParagraphSpacing;

    public static void init(){
        p1FontSize = globalHelper().getParagraphGlobalValue(1, "font size");
        p1FontFamily = globalHelper().getParagraphGlobalValue(1, "font family");
        p1LineHeight = globalHelper().getParagraphGlobalValue(1, "line height");
        p1LetterSpacing = globalHelper().getParagraphGlobalValue(1, "letter spacing");
        p1ParagraphSpacing = globalHelper().getParagraphGlobalValue(1, "paragraph spacing");

        p2FontSize = globalHelper().getParagraphGlobalValue(2, "font size");
        p2FontFamily = globalHelper().getParagraphGlobalValue(2, "font family");
        p2LineHeight = globalHelper().getParagraphGlobalValue(2, "line height");
        p2LetterSpacing = globalHelper().getParagraphGlobalValue(2, "letter spacing");
        p2ParagraphSpacing = globalHelper().getParagraphGlobalValue(2, "paragraph spacing");

        p3FontSize = globalHelper().getParagraphGlobalValue(3, "font size");
        p3FontFamily = globalHelper().getParagraphGlobalValue(3, "font family");
        p3LineHeight = globalHelper().getParagraphGlobalValue(3, "line height");
        p3LetterSpacing = globalHelper().getParagraphGlobalValue(3, "letter spacing");
        p3ParagraphSpacing = globalHelper().getParagraphGlobalValue(3, "paragraph spacing");
    }
    public static void print(){
        System.out.println(p1FontSize);
        System.out.println(p1FontFamily);
        System.out.println(p1LineHeight);
        System.out.println(p1LetterSpacing);
        System.out.println(p1ParagraphSpacing);
        System.out.println("\n");
        System.out.println(p2FontSize);
        System.out.println(p2FontFamily);
        System.out.println(p2LineHeight);
        System.out.println(p2LetterSpacing);
        System.out.println(p2ParagraphSpacing);
        System.out.println("\n");
        System.out.println(p3FontSize);
        System.out.println(p3FontFamily);
        System.out.println(p3LineHeight);
        System.out.println(p3LetterSpacing);
        System.out.println(p3ParagraphSpacing);
    }

}
