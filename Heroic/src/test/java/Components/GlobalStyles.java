package Components;

import com.sun.org.apache.regexp.internal.RE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlobalStyles {
    private WebDriver webDriver;

    public GlobalStyles (WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);

    }
    @FindBy(xpath = "//div[contains(text(),'H1')]")
    public WebElement globalH1;
    @FindBy (xpath = "//div[contains(text(),'H2')]")
    public WebElement globalH2;
    @FindBy (xpath = "//div[contains(text(),'H3')]")
    public WebElement globalH3;
    @FindBy (xpath = "//div[contains(text(),'H4')]")
    public WebElement globalH4;
    @FindBy (xpath = "//div[contains(text(),'H5')]")
    public WebElement globalH5;
    @FindBy (xpath = "//div[contains(text(),'H6')]")
    public WebElement globalH6;

    @FindBy (xpath = "//div[contains(text(),'P1')]")
    public WebElement globalP1;
    @FindBy (xpath = "//div[contains(text(),'P2')]")
    public WebElement globalP2;
    @FindBy (xpath = "//div[contains(text(),'P3')]")
    public WebElement globalP3;

    @FindBy (xpath = "//span[contains(text(),'Overview Mode')]")
    public WebElement overViewMode;
    @FindBy (xpath = "//span[contains(text(),'Page View')]")
    public WebElement pageViewMode;

    @FindBy (xpath = "//div[@class='select-panel-list__inner select-panel-list__inner_open']//div[@class='select-panel-list__item-value'][contains(text(),'Abril Fatface')]")
    public WebElement abril_Fatface_font;
    @FindBy (xpath = "//div[@class='select-panel-list__inner select-panel-list__inner_open']//div[@class='select-panel-list__item-value'][contains(text(),'Asap')]")
    public WebElement asap_font;
    @FindBy (xpath = "//div[@class='accordion-panel__inner accordion-panel__inner_open']//span[@class='select-color-section__button']")
    public WebElement lightTextColor;
    @FindBy (xpath = "//div[@class='accordion-panel__inner accordion-panel__inner_open']//span[@class='select-color-section__button']/following::*/span[@class='select-color-section__button']")
    public WebElement darkTextColor;
    @FindBy (xpath = "//div[@class='custom-color-picker']//input")
    public WebElement colorInput;
    @FindBy (xpath = "//span[contains(@class,'custom-choosed-color__col')]")
    public WebElement inputColorLable;

    @FindBy (css = ".editorSectionsWripper .handle-size-headline-h1 .line-height-element-style:not(.not-global-element)")
    public WebElement h1lineHeight;
    @FindBy (css = ".editorSectionsWripper .handle-size-headline-h2 .line-height-element-style:not(.not-global-element)")
    public WebElement h2lineHeight;
    @FindBy (css = ".editorSectionsWripper .handle-size-headline-h3 .line-height-element-style:not(.not-global-element)")
    public WebElement h3lineHeight;
    @FindBy (css = ".editorSectionsWripper .handle-size-headline-h4 .line-height-element-style:not(.not-global-element)")
    public WebElement h4lineHeight;
    @FindBy (css = ".editorSectionsWripper .handle-size-headline-h5 .line-height-element-style:not(.not-global-element)")
    public WebElement h5lineHeight;
    @FindBy (css = ".editorSectionsWripper .handle-size-headline-h6 .line-height-element-style:not(.not-global-element)")
    public WebElement h6lineHeight;

    @FindBy (xpath = "//div[contains(@class,'text-element-p1')]//div[@class='line-height-element-style']")
    public WebElement p1LineHeight;
    @FindBy (xpath = "//div[contains(@class,'text-element-p2')]//div[@class='line-height-element-style']")
    public WebElement p2LineHeight;
    @FindBy (xpath = "//div[contains(@class,'text-element-p3')]//div[@class='line-height-element-style']")
    public WebElement p3LineHeight;

    @FindBy (xpath = "//h1[@class='headline-item']")
    public WebElement h1Item;
    @FindBy (xpath = "//h2[@class='headline-item']")
    public WebElement h2Item;
    @FindBy (xpath = "//h3[@class='headline-item']")
    public WebElement h3Item;
    @FindBy (xpath = "//h4[@class='headline-item']")
    public WebElement h4Item;
    @FindBy (xpath = "//h5[@class='headline-item']")
    public WebElement h5Item;
    @FindBy (xpath = "//h6[@class='headline-item']")
    public WebElement h6Item;

    @FindBy (xpath = "//div[contains(@class,'text-element-p1')]//p")
    public WebElement p1Item;
    @FindBy (xpath = "//div[contains(@class,'text-element-p2')]//p")
    public WebElement p2Item;
    @FindBy (xpath = "//div[contains(@class,'text-element-p3')]//p")
    public WebElement p3Item;

    @FindBy (xpath = "//div[contains(@class,'text-element-p1')]//ul/li")
    public WebElement p1bullet;
    @FindBy (xpath = "//div[contains(@class,'text-element-p2')]//ul/li")
    public WebElement p2bullet;
    @FindBy (xpath = "//div[contains(@class,'text-element-p3')]//ul/li")
    public WebElement p3bullet;

    @FindBy (css = ".editorSectionsWripper .text-element-p1")
    public WebElement darkColor_p1;
    @FindBy (css = ".editorSectionsWripper .text-element-p2")
    public WebElement darkColor_p2;
    @FindBy (css = ".editorSectionsWripper .text-element-p3")
    public WebElement darkColor_p3;

    @FindBy (xpath = "//div[contains(@class,'insert-elements handle-size-headline-h1 headline-element')]//div[contains(@class,'dark-color font-size-element-style')]")
    public WebElement h1Paragraph;
    @FindBy (xpath = "//div[contains(@class,'insert-elements handle-size-headline-h2 headline-element')]//div[contains(@class,'dark-color font-size-element-style')]")
    public WebElement h2Paragraph;
    @FindBy (xpath = "//div[contains(@class,'insert-elements handle-size-headline-h3 headline-element')]//div[contains(@class,'dark-color font-size-element-style')]")
    public WebElement h3Paragraph;
    @FindBy (xpath = "//div[contains(@class,'insert-elements handle-size-headline-h4 headline-element')]//div[contains(@class,'dark-color font-size-element-style')]")
    public WebElement h4Paragraph;
    @FindBy (xpath = "//div[contains(@class,'insert-elements handle-size-headline-h5 headline-element')]//div[contains(@class,'dark-color font-size-element-style')]")
    public WebElement h5Paragraph;
    @FindBy (xpath = "//div[contains(@class,'insert-elements handle-size-headline-h6 headline-element')]//div[contains(@class,'dark-color font-size-element-style')]")
    public WebElement h6Paragraph;

    @FindBy (xpath = "//div[contains(@class,'fontfamily-Abril-Fatface-H1')]")
    public WebElement pageView_H1fontFamilyAssert;
    @FindBy (xpath = "//div[contains(@class,'fontfamily-Abril-Fatface-H2')]")
    public WebElement pageView_H2fontFamilyAssert;
    @FindBy (xpath = "//div[contains(@class,'fontfamily-Abril-Fatface-H3')]")
    public WebElement pageView_H3fontFamilyAssert;
    @FindBy (xpath = "//div[contains(@class,'fontfamily-Abril-Fatface-H4')]")
    public WebElement pageView_H4fontFamilyAssert;
    @FindBy (xpath = "//div[contains(@class,'fontfamily-Abril-Fatface-H5')]")
    public WebElement pageView_H5fontFamilyAssert;
    @FindBy (xpath = "//div[contains(@class,'fontfamily-Abril-Fatface-H6')]")
    public WebElement pageView_H6fontFamilyAssert;

    @FindBy (xpath = "//div[contains(@class,'accordion-panel__inner_open')]//span[contains(text(),'P1 Large')]")
    public WebElement fields_FontStyle_P1;
    @FindBy (xpath = "//div[contains(@class,'accordion-panel__inner_open')]//span[contains(text(),'P2 Medium')]")
    public WebElement fields_FontStyle_P2;
    @FindBy (xpath = "//div[contains(@class,'accordion-panel__inner_open')]//span[contains(text(),'P3 Small')]")
    public WebElement fields_FontStyle_P3;

    @FindBy (xpath = "//div[contains(@class,'accordion-panel__inner_open')]//button[contains(text(),'Edit Regular')]")
    public WebElement editRegular;
    @FindBy (xpath = "//div[contains(@class,'accordion-panel__inner_open')]//button[contains(text(),'Edit Hover')]")
    public WebElement editHover;

    @FindBy (xpath = "//h4[contains(text(),'Large Field')]/parent::*//span[contains(text(),'Normal')]/parent::*")
    public WebElement normalLargeField;
    @FindBy (xpath = "//h4[contains(text(),'Large Field')]/parent::*//span[contains(text(),'Normal')]/parent::*//input")
    public WebElement normalLargeFieldInput;
    @FindBy (xpath = "//h4[contains(text(),'Large Field')]/parent::*//span[contains(text(),'Selected')]/parent::*")
    public WebElement selectedLargeField;
    @FindBy (xpath = "//h4[contains(text(),'Large Field')]/parent::*//span[contains(text(),'Selected')]/parent::*//input")
    public WebElement selectedLargeFieldSInput;

    public List<WebElement> getInputElements(){
        return webDriver.findElements(By.xpath("//div[contains(@class,'de-input-block')]"));
    }
    public List<WebElement> getDropListElements(){
        return webDriver.findElements(By.xpath("//div[contains(@class,'tmp_droplist')]"));
    }
    public List<WebElement> getCheckRadioElements(){
        return webDriver.findElements(By.xpath("//div[contains(@class,'check-radio-element')]"));
    }
}
