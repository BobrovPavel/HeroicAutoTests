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

    @FindBy (xpath = "//h4[@class='cart-element__item-title'][contains(text(),'Blank Canvas')]//preceding::*[contains(@class,'cart-element__image')]")
    WebElement blankCanvas;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-subtitle'][contains(text(),'Full Width Layout Option')]")
    WebElement fullWidthSection;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'Full Width Column')]")
    WebElement fullWidthColumn;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'Header')]")
    WebElement elementHeader;
    @FindBy (xpath = "//span[@class='dropdown-modal__item-title'][contains(text(),'Paragraph')]")
    WebElement elementParagraph;
    @FindBy (css = ".mce-content-body")
    WebElement headerText;
    @FindBy (xpath = "//div[@class='editorGridPanel element-panel ']//li[@data-panel-type='delete']")
    WebElement deleteElement;
    @FindBy (xpath = "//button[@class='button-add-element button-add-element_without_icon button-add-element_cancel']")
    WebElement submitDelete;
    @FindBy (xpath = "//button[contains(@id,'plus')]")
    WebElement plusIntoRow;
}
