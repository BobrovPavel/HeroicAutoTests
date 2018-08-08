package SupportClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Variables {
    private WebDriver webDriver;

    public Variables (WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
    public static final String THREE_SIMPLE_TEXT = "Three Simple Text";
    
    public static String textValue = "One Simple Text Two Simple Text Three Simple Text ";
    public static String oneLine = "One simple line of text";
    public static String severalLinesAssert = "One simple line of text\n" +
                                              "One simple line of text\n" +
                                              "One simple line of text";
    public static String threePart = "//span[contains(text(),'Three Simple Text')]";
    public static String textPart = "Three Simple Text ";

    public static String colorsInPalette = "//div[@class='color-picker-item__palette']//i";


    public static String assert_h1 = "//h1[@class='  font-shadow-none  undefined  headline-item ']";
    public static String assert_h2 = "//h2[@class='  font-shadow-none  undefined  headline-item ']";
    public static String assert_h3 = "//h3[@class='  font-shadow-none  undefined  headline-item ']";
    public static String assert_h4 = "//h4[@class='  font-shadow-none  undefined  headline-item ']";
    public static String assert_h5 = "//h5[@class='  font-shadow-none  undefined  headline-item ']";
    public static String assert_h6 = "//h6[@class='  font-shadow-none  undefined  headline-item ']";

    public static String assert_p1 = ".text-element-p1";
    public static String assert_p2 = ".text-element-p2";
    public static String assert_p3 = ".text-element-p3";

    public static String fontSizeWithSliderAssert_p = "font-size: 9px;";
    public static String fontSizeWithSliderAssert_h = "font-size: 52px;";

    public static String href = "//div[contains(@id,'rect-tinymce')]//a";
    public static String boidAssert = "//div[contains(@id,'rect-tinymce')]//strong";
    public static String quoteAssert = "//div[contains(@id,'rect-tinymce')]//blockquote";
    public static String elementSpan = "//div[contains(@id,'rect-tinymce')]//span";
    public static String italicAssert = "//div[contains(@id,'rect-tinymce')]//em";
    public static String numberedListAssert = "//div[contains(@id,'rect-tinymce')]//ol//li";
    public static String bulletedListAssert = "//div[contains(@id,'rect-tinymce')]//ul//li";
    public static String listAndFontSizeAssert = "//ul[contains(@class,'bullet-size-inherit')]";
    public static String elementStyle = "//div[contains(@id,'rect-tinymce')]//span[@style]";
    public static String underLineAssert = "//div[contains(@id,'rect-tinymce')]//span[@style='text-decoration: underline;']";
    public static String fontFamilyAssert1 = "//span[@class='fontfamily-BioRhyme-Regular']";
    public static String startColorValue = "color: rgb(0, 0, 0);";

    public static String pageView_H1fontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-H1')]";
    public static String pageView_H2fontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-H2')]";
    public static String pageView_H3fontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-H3')]";
    public static String pageView_H4fontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-H4')]";
    public static String pageView_H5fontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-H5')]";
    public static String pageView_H6fontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-H6')]";

    public static String pageView_P1FontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-P1')]";
    public static String pageView_P2FontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-P2')]";
    public static String pageView_P3FontFamilyAssert = "//div[contains(@class,'fontfamily-Abril-Fatface-P3')]";

    public String getFontSize_PageView(){
        return webDriver.findElement(By.xpath("//div[contains(@class,'font-size-element-style')]")).getCssValue("font-size");
    }
    public String getLineHeight_PageView(){
        return webDriver.findElement(By.xpath("//div[@class='line-height-element-style']")).getCssValue("font-size");
    }
    public String getBulletSpacing_PageView(){
        return webDriver.findElement(By.xpath("//div[@class='mce-content-body']//ul//li")).getCssValue("padding-bottom");
    }
    public String getLetterSpacing_PageView(){
        return webDriver.findElement(By.xpath("//div[contains(@id,'rect-tinymce')]")).getCssValue("letter-spacing");
    }
    public String getParagraphSpacing_PageView(){
        return webDriver.findElement(By.xpath("//div[contains(@class,'font-size-element-style')]")).getCssValue("margin-bottom");
    }
    public String getParagraphSpacing_P(){
        return webDriver.findElement(By.xpath("//div[contains(@id,'rect-tinymce-tmp_text')]//p")).getCssValue("padding-bottom");
    }
    public String getParagraphSpacing_ol(){
        return webDriver.findElement(By.xpath("//div[contains(@id,'rect-tinymce-tmp_text')]//ol")).getCssValue("padding-bottom");
    }


    public String getBulletSize_P1_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p1 ul li'),':before').getPropertyValue('font-size')");
    }
    public String getBulletSize_P1_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p1 ul li'),':before').getPropertyValue('font-size')");
    }
    public String getBulletSize_P2_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p2 ul li'),':before').getPropertyValue('font-size')");
    }
    public String getBulletSize_P2_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p2 ul li'),':before').getPropertyValue('font-size')");
    }
    public String getBulletSize_P3_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p3 ul li'),':before').getPropertyValue('font-size')");
    }
    public String getBulletSize_P3_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p3 ul li'),':before').getPropertyValue('font-size')");
    }
    public String getNumberBulletSize_P1_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p1 ol li'),':before').getPropertyValue('font-size')");
    }
    public String getNumberBulletSize_P1_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p1 ol li'),':before').getPropertyValue('font-size')");
    }
    public String getNumberBulletSize_P2_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p2 ol li'),':before').getPropertyValue('font-size')");
    }
    public String getNumberBulletSize_P2_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p2 ol li'),':before').getPropertyValue('font-size')");
    }
    public String getNumberBulletSize_P3_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p3 ol li'),':before').getPropertyValue('font-size')");
    }
    public String getNumberBulletSize_P3_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p3 ol li'),':before').getPropertyValue('font-size')");
    }

    public String getBulletColor_P1_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p1 ul li'),':before').getPropertyValue('color')");
    }
    public String getBulletColor_P1_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p1 ul li'),':before').getPropertyValue('color')");
    }
    public String getBulletColor_P2_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p2 ul li'),':before').getPropertyValue('color')");
    }
    public String getBulletColor_P2_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p2 ul li'),':before').getPropertyValue('color')");
    }
    public String getBulletColor_P3_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p3 ul li'),':before').getPropertyValue('color')");
    }
    public String getBulletColor_P3_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p3 ul li'),':before').getPropertyValue('color')");
    }

    public String getNumberBulletColor_P1_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p1 ol li'),':before').getPropertyValue('color')");
    }
    public String getNumberBulletColor_P1_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p1 ol li'),':before').getPropertyValue('color')");
    }
    public String getNumberBulletColor_P2_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p2 ol li'),':before').getPropertyValue('color')");
    }
    public String getNumberBulletColor_P2_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p2 ol li'),':before').getPropertyValue('color')");
    }
    public String getNumberBulletColor_P3_OverView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p3 ol li'),':before').getPropertyValue('color')");
    }
    public String getNumberBulletColor_P3_PageView(){
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        return (String) js.executeScript("return window.getComputedStyle(document.querySelector('.text-element-p3 ol li'),':before').getPropertyValue('color')");
    }




    public static String newSectionModale = "//div[@class='dropdown-modal ']";

    public String getH1GlobalFontSize(){
        return webDriver.findElement(By.xpath("//h1[@class='headline-item']")).getCssValue("font-size");
    }
    public String getH1GlobalFontFamily(){
        return webDriver.findElement(By.xpath("//h1[@class='headline-item']")).getCssValue("font-family");
    }
    public String getH1GlobalFontWeight(){
        return webDriver.findElement(By.xpath("//h1[@class='headline-item']")).getCssValue("font-weight");
    }

//    public static String JqueryWithText_forButton = ".dropdown-modal__item-title:contains(‘Button’)";
}
