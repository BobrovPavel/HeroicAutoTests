package SupportClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Variables {
    WebDriver webDriver;

    public Variables (WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
    public static String textValue = "One Simple Text Two Simple Text Three Simple Text ";
    public static String oneLine = "One simple line of text";
    public static final String THREE_SIMPLE_TEXT = "Three Simple Text";
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

    public String getHeadlineGlobalValue(int headlineType, String value){
        String result = null;
        switch (value.toLowerCase()){
            case "font family":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("font-family");
                break;
            case "font size":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("font-size");
                break;
            case "line height":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("line-height");
                break;
            case "letter spacing":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("letter-spacing");
                break;
            case "paragraph spacing":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("margin-bottom");
                break;
            case "dark color":
                result = webDriver.findElement(By.xpath("//h"+headlineType+"[@class='headline-item']")).getCssValue("color");
                break;
        }
        return result;
    }
//    public static String JqueryWithText_forButton = ".dropdown-modal__item-title:contains(‘Button’)";
}
