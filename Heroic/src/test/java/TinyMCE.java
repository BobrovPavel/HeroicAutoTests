import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sql.XAConnection;
import javax.sql.rowset.CachedRowSet;

public class TinyMCE {

    WebDriver webDriver;

    public TinyMCE(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }




    @FindBy(xpath = ".mce-tinymce-inline:not([style*=\"display: none\"])")
    WebElement toolBar;


    @FindBy(css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-bold")
    WebElement bold;
    @FindBy(css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-italic")
    WebElement italic;
    @FindBy(css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-underline")
    WebElement underLine;
    @FindBy (xpath = "//i[@class='mce-ico mce-i-textquote']/parent::*[@role='presentation']")
    WebElement quote;
    @FindBy (xpath = "//button//i[@class='mce-ico mce-i-unlink']")
    WebElement removeLink;
    @FindBy (css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-textlink")
    WebElement insertLink;
    @FindBy (css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-aligncenter")
    WebElement alignment;
    @FindBy (css = ".mce-tinymce-inline:not([style*=\"display: none\"]) .mce-ico.mce-i-textcolor")
    WebElement color;
    @FindBy (xpath = "//i[@class='mce-ico mce-i-textfont']")
    WebElement size;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-alignleft']")
    WebElement alignmentLeft;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-aligncenter']")
    WebElement alignCenter;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-alignright']")
    WebElement alignRight;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-alignjustify']")
    WebElement alignJustify;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-textclose']")
    WebElement alignClose;
    @FindBy (xpath = "//button[@class='button-close']")
    WebElement closeButton;
    @FindBy (css = ".font-toolbar-slider-background__input")
    WebElement pasteLink;
    @FindBy (xpath = "//div[@class='font-toolbar-slider-background__field']//button")
    WebElement saveLink;
    @FindBy (xpath = "//div[contains(@class,'toggleElement')]")
    WebElement openInNewWindow;

    @FindBy(xpath = "//h1[@class='header-type__huge']")
    WebElement h1FontSize;
    @FindBy(xpath = "//h2[@class='header-type__v_large']")
    WebElement h2FontSize;
    @FindBy(xpath = "//h3[@class='header-type__large']")
    WebElement h3FontSize;
    @FindBy(xpath = "//h4[@class='header-type__med']")
    WebElement h4FontSize;
    @FindBy(xpath = "//h5[@class='header-type__small']")
    WebElement h5FontSize;
    @FindBy(xpath = "//h6[@class='header-type__tiny']")
    WebElement h6FontSize;
    @FindBy (xpath = "//li[contains(text(), 'BioRhyme Regular')]")
    WebElement fontFamily1;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce-tmp_headline')]//div//div//span[@class='fontfamily-BioRhyme-Regular']")
    WebElement fontFamilyAssert1;

    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//strong")
    WebElement boidAssert;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//em")
    WebElement italicAssert;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//span[@style='text-decoration: underline;']")
    WebElement underLineAssert;
    @FindBy (xpath = "//blockquote")
    WebElement quoteAssert;
    @FindBy (xpath = "//div[@class='mce-left-aligment']")
    WebElement leftAlignmentAssert;
    @FindBy (xpath = "//div[@class='mce-center-aligment']")
    WebElement centerAlignmentAssert;
    @FindBy (xpath = "//div[@class='mce-right-aligment']")
    WebElement rightAlignmentAssert;
    @FindBy (xpath = "//div[@class='mce-full-aligment']")
    WebElement fullAlignmentAssert;



    //div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-textclose']
    //.mce-tinymce-inline:not([style*="display: none"]) .mce-ico.mce-i-alignleft


}
