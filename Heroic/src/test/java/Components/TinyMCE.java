package Components;

import SupportClasses.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TinyMCE {

    private WebDriver webDriver;
    private Actions action;

    public TinyMCE(WebDriver driver){
        webDriver = driver;
        action = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    private Variables variables(){;
        return new Variables(webDriver);
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
    @FindBy (xpath = "//i[contains(@class,'mce-ico mce-i-textlist')]")
    public WebElement lists;
    @FindBy (xpath = "//div[contains(@class,'tinymce-item-text-align__icon')]//i[contains(@class,'mce-ico mce-i-numlist')]")
    public WebElement numberedList;
    @FindBy (xpath = "//div[contains(@class,'tinymce-item-text-align__icon')]//i[contains(@class,'mce-ico mce-i-bullist')]")
    public WebElement bulletedList;
    @FindBy (xpath = "//div[contains(@class,'tinymce-item-text-align__icon')]//i[contains(@class,'mce-ico mce-i-textclose')]")
    public WebElement closeLists;
    @FindBy (xpath = "//div[@class='modal-extra__btn-close']")
    public WebElement closeFontSize;
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
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce-tmp_text')]")
    public WebElement textBody;
    @FindBy (xpath = "//span[contains(text(),'Or Select Page')]")
    public WebElement selectLinkPage;
    @FindBy (xpath = "//div[contains(text(),'Blank Canvas')]")
    public WebElement dropDownBlankPage;

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


    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//span")
    public WebElement elementSpan;
    @FindBy (xpath = "//li[contains(text(), 'BioRhyme Regular')]")
    public WebElement fontFamily1;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//span[@class='fontfamily-BioRhyme-Regular']")
    public WebElement fontFamilyAssert;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]")
    public WebElement textElement;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//strong")
    public WebElement boidAssert;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//em")
    public WebElement italicAssert;
    @FindBy (xpath = "//div[contains(@id,'rect-tinymce')]//blockquote")
    public WebElement quoteAssert;
    @FindBy (xpath = "//span[contains(@style,'text-decoration: underline;')]")
    public WebElement underLineAssert;
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
    @FindBy (css = ".text-element-p3")
    public WebElement p3GlobalAssert;

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
    @FindBy (xpath = "//div[@class='rc-slider-handle']")
    public WebElement sizeSlider;

    public List<WebElement> getTinyMCEFontSizeButtons(){
        return webDriver.findElements(By.xpath(variables().fontSizeTinyMCE));
    }
    public List<WebElement> getListsButtons(){
        return webDriver.findElements(By.xpath("//i[contains(@class,'mce-ico mce-i-textlist')]"));
    }

    public void dropDownBlankPageClick(){
        try {
            Thread.sleep(500);
            action.moveToElement(dropDownBlankPage).click().perform();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    //div[contains(@id,'rect-tinymce')]//div[contains(@class,'tinymce-item-text-align__icon')]//i[@class='mce-ico mce-i-textclose']
    //.mce-tinymce-inline:not([style*="display: none"]) .mce-ico.mce-i-alignleft


}
