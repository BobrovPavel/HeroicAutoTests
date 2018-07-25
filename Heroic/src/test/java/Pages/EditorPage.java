package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditorPage {
    WebDriver webDriver;

    public EditorPage(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//h4[@class='cart-element__item-title'][contains(text(),'Blank Canvas')]")
    public WebElement blankCanvas;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-subtitle'][contains(text(),'Full Width Layout Option')]")
    public WebElement fullWidthSection;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'Full Width Column')]")
    public WebElement fullWidthColumn;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'Header')]")
    public WebElement elementHeader;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'Paragraph')]")
    public WebElement elementParagraph;
    @FindBy (css = ".mce-content-body")
    public WebElement headerText;
    @FindBy (xpath = "//div[@class='editorGridPanel element-panel ']//li[@data-panel-type='delete']")
    public WebElement deleteElement;
    @FindBy (xpath = "//button[@class='button-add-element button-add-element_without_icon button-add-element_cancel']")
    public WebElement submitDelete;
    @FindBy (xpath = "//button[contains(@id,'plus')]")
    public WebElement plusIntoRow;
}
