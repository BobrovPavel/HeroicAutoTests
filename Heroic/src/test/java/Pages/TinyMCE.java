package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TinyMCE {

    WebDriver webDriver;

    public TinyMCE(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = ".mce-tinymce-inline:not([style*=\"display: none\"])")
    WebElement toolBar;

    @FindBy(css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-bold")
    public WebElement bold;
    @FindBy(css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-italic")
    public WebElement italic;
    @FindBy(css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-underline")
    public WebElement underLine;
    @FindBy (xpath = "//i[@class='mce-ico mce-i-textquote']/parent::*[@role='presentation']")
    public WebElement quote;
    @FindBy (xpath = "//button//i[@class='mce-ico mce-i-unlink']")
    public WebElement removeLink;
    @FindBy (css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-textlink")
    public WebElement insertLink;
    @FindBy (css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-aligncenter")
    public WebElement alignment;
    @FindBy (css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-textcolor")
    public WebElement color;
    @FindBy (xpath = "//i[@class='mce-ico mce-i-textfont']")
    public WebElement size;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-alignleft']")
    public WebElement alignmentLeft;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-aligncenter']")
    public WebElement alignCenter;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-alignright']")
    public WebElement alignRight;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-alignjustify']")
    public WebElement alignJustify;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-textclose']")
    public WebElement alignClose;
    @FindBy (xpath = "//button[@class='button-close']")
    public WebElement closeButton;
    @FindBy (css = ".font-toolbar-slider-background__input")
    public WebElement pasteLink;
    @FindBy (xpath = "//div[@class='font-toolbar-slider-background__field']//button")
    public WebElement saveLink;
    @FindBy (xpath = "//div[contains(@class,'toggleElement')]")
    public WebElement openInNewWindow;

    @FindBy(xpath = "//h1[@class='header-type__huge']")
    public WebElement h1FontSize;
    @FindBy(xpath = "//h2[@class='header-type__v_large']")
    public WebElement h2FontSize;
    @FindBy(xpath = "//h3[@class='header-type__large']")
    public WebElement h3FontSize;
    @FindBy(xpath = "//h4[@class='header-type__med']")
    public WebElement h4FontSize;
    @FindBy(xpath = "//h5[@class='header-type__small']")
    public WebElement h5FontSize;
    @FindBy(xpath = "//h6[@class='header-type__tiny']")
    public WebElement h6FontSize;

    @FindBy(xpath = "//span[@class='text-type__large']")
    public WebElement p1FontSize;
    @FindBy(xpath = "//span[@class='text-type__medium']")
    public WebElement p2FontSize;
    @FindBy(xpath = "//span[@class='text-type__small']")
    public WebElement p3FontSize;



    @FindBy (xpath = "//li[contains(text(), 'BioRhyme Regular')]")
    public WebElement fontFamily1;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce-tmp_headline')]//div//div//span[@class='fontfamily-BioRhyme-Regular']")
    public WebElement fontFamilyAssert1;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce-tmp_text')]//span[@class='fontfamily-BioRhyme-Regular']")
    public WebElement fontFamilyAssert1_p;

    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//strong")
    public WebElement boidAssert;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//em")
    public WebElement italicAssert;
    @FindBy (xpath = "//span[contains(@style,'text-decoration: underline;')]")
    public WebElement underLineAssert;
    @FindBy (xpath = "//blockquote")
    public WebElement quoteAssert;
    @FindBy (xpath = "//div[@class='mce-left-aligment']")
    public WebElement leftAlignmentAssert;
    @FindBy (xpath = "//div[@class='mce-center-aligment']")
    public WebElement centerAlignmentAssert;
    @FindBy (xpath = "//div[@class='mce-right-aligment']")
    public WebElement rightAlignmentAssert;
    @FindBy (xpath = "//div[@class='mce-full-aligment']")
    public WebElement fullAlignmentAssert;
    @FindBy (xpath = "//h2[@class='  font-shadow-none  undefined  headline-item ']")
    public WebElement h2GlobalAssert;

    @FindBy (xpath = "//p[@class='mce-left-aligment']")
    public WebElement leftAlignmentAssert_p;
    @FindBy (xpath = "//p[@class='mce-center-aligment']")
    public WebElement centerAlignmentAssert_p;
    @FindBy (xpath = "//p[@class='mce-right-aligment']")
    public WebElement rightAlignmentAssert_p;
    @FindBy (xpath = "//p[@class='mce-full-aligment']")
    public WebElement fullAlignmentAssert_p;
    @FindBy (xpath = "//div[@class='custom-color-picker__color']")
    public WebElement colorpicker;




    //div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-textclose']
    //.mce-tinymce-inline:not([style*="display: none"]) .mce-ico.mce-i-alignleft


}
