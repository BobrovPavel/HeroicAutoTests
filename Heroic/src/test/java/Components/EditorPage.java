package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EditorPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions action;

    public EditorPage(WebDriver driver){
        webDriver = driver;
        action = new Actions(webDriver);
        wait = new WebDriverWait(webDriver, 45, 300);
        js = (JavascriptExecutor)webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//h4[@class='cart-element__item-title'][contains(text(),'Blank Canvas')]")
    public WebElement blankCanvas;
    @FindBy (xpath = "//button[contains(@class,'button-add-new_green')]")
    public WebElement addNewRowPlus;

    @FindBy (xpath = "//span[@class='dropdown-modal__item-subtitle'][contains(text(),'Full Width Layout Option')]")
    public WebElement fullWidthSection;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'Full Width Column')]")
    public WebElement fullWidthColumn;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'3 Column Row')]")
    public WebElement threeColumnRow;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'8 Columns')]")
    public WebElement eightColumnRow;


    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Header')]")
    public WebElement elementHeader;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Paragraph')]")
    public WebElement elementParagraph;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Image')]")
    public WebElement elementImage;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Video')]")
    public WebElement elementVideo;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Divider')]")
    public WebElement elementDivider;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Button')]")
    public WebElement elementButton;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Map')]")
    public WebElement elementMap;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Input')]")
    public WebElement elementInput;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Text Area')]")
    public WebElement elementTextArea;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Droplist')]")
    public WebElement elementDroplist;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Checkbox')]")
    public WebElement elementCheckbox;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Radiobox')]")
    public WebElement elementRadiobox;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Submit Button')]")
    public WebElement elementSubmitButton;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Timer')]")
    public WebElement elementTimer;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Social')]")
    public WebElement elementSocial;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'HTML/JS')]")
    public WebElement elementHTML;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Comments')]")
    public WebElement elementComments;
    @FindBy (xpath = "//div[contains(@class,'insert-new_active')]//span[@class='dropdown-modal__item-title'][contains(text(),'Navigation')]")
    public WebElement elementNavigation;


    @FindBy (css = ".mce-content-body")
    public WebElement headerText;
    @FindBy (xpath = "//div[@class='editorGridPanel element-panel ']//li[@data-panel-type='delete']")
    public WebElement deleteElement;
    @FindBy (xpath = "//button[@class='button-add-element button-add-element_without_icon button-add-element_cancel']")
    public WebElement submitDelete;
    @FindBy (xpath = "//button[contains(@id,'plus')]")
    public WebElement plusIntoRow;
    @FindBy (xpath = "//div[@class='dropdown-modal ']")
    public WebElement newSectionModale;
    @FindBy (xpath = "//button[contains(@class,'button-add-new button-add-new_active')]")
    public WebElement addSectionPlus;

    public void threeColumnRowClick(){
        wait.until(ExpectedConditions.elementToBeClickable(fullWidthColumn));
        action.moveToElement(threeColumnRow).click().perform();
//        wait.until(ExpectedConditions.elementToBeClickable(threeColumnRow)).click();
    }
    public void elementHeaderClick(){
        action.moveToElement(elementHeader).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementHeader)).click();
    }
    public void elementParagraphClick(){
        action.moveToElement(elementParagraph).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementParagraph)).click();
    }
    public void elementImageClick(){
        action.moveToElement(elementImage).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementImage)).click();
    }
    public void elementVideoClick(){
        action.moveToElement(elementVideo).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementVideo)).click();
    }
    public void elementDividerClick(){
        action.moveToElement(elementDivider).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementDivider)).click();
    }
    public void elementButtonClick(){
        action.moveToElement(elementButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementButton)).click();
    }
    public void elementMapClick(){
        action.moveToElement(elementMap).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementMap)).click();
    }
    public void elementInputClick(){
        action.moveToElement(elementInput).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementInput)).click();
    }
    public void elementTextAreaClick(){
        action.moveToElement(elementTextArea).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementTextArea)).click();
    }
    public void elementDroplistClick(){
        action.moveToElement(elementDroplist).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementDroplist)).click();
    }
    public void elementCheckboxClick(){
        action.moveToElement(elementCheckbox).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementCheckbox)).click();
    }
    public void elemenRadioboxClick(){
        action.moveToElement(elementRadiobox).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementRadiobox)).click();
    }
    public void elementSubmitButtonClick(){
        action.moveToElement(elementSubmitButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementSubmitButton)).click();
    }
    public void elementTimerClick(){
        action.moveToElement(elementTimer).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementTimer)).click();
    }
    public void elementSocialClick(){
        action.moveToElement(elementSocial).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementSocial)).click();
    }
    public void elementHTMLClick(){
        action.moveToElement(elementHTML).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementHTML)).click();
    }
    public void elemenCommentsClick(){
        action.moveToElement(elementComments).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementComments)).click();
    }
    public void elementNavigationClick(){
        action.moveToElement(elementHeader).perform();
        wait.until(ExpectedConditions.elementToBeClickable(elementNavigation)).click();
    }


    public void addNewElementClick(){
        js.executeScript("document.querySelector('.button-add-new_dark').click()");
    }
    public void addNewRowClick(){
        js.executeScript("document.querySelector('.button-add-new_green').click()");
    }

    public List<WebElement> getPlusAddNewRow(){
        return webDriver.findElements(By.xpath("//button[contains(@class,'button-add-new_green')]"));
    }
    public List<WebElement> getThreeColumnsRow(){
        return webDriver.findElements(By.xpath("//span[@class='dropdown-modal__item-title'][contains(text(),'3 Column Row')]"));
    }
}
