package Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.cert.X509Certificate;

public class Sidebar {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public Sidebar(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 45, 300);
        PageFactory.initElements(webDriver, this);
    }


    @FindBy (xpath = "//*[contains(@class,'icon-svg-pages')]/parent::*")
    public WebElement pages;

    @FindBy (xpath = "//div[@class='animationSidebar']//button[@class='button-add-element']")
    public WebElement newPageButton;
    @FindBy (css = ".page-menu-dropdown")
    public WebElement threeDots;
    @FindBy (css = ".sidebar-main-menu__item:nth-child(4)")
    public WebElement globalStyles;
    @FindBy (xpath = "//a[contains(text(),'Header Styles')]")
    public WebElement headerStyles;
    @FindBy (xpath = "//a[contains(text(),'Paragraph Styles')]")
    public WebElement paragraphStyles;
    @FindBy (xpath = "//a[contains(text(),'Field Styles')]")
    public WebElement fieldStyles;

    @FindBy (xpath = "//span[contains(text(), 'Content')]")
    public WebElement contentTab;
    @FindBy (xpath = "//span[contains(text(), 'Design')]")
    public WebElement designTab;
    @FindBy (xpath = "//span[contains(text(), 'Advanced')]")
    public WebElement advancedTab;

    @FindBy (xpath = "//div[contains(text(),'Large Field')]")
    public WebElement largeField;
    @FindBy (xpath = "//div[contains(text(),'Medium Field')]")
    public WebElement mediumField;
    @FindBy (xpath = "//div[contains(text(),'Small Field')]")
    public WebElement smallField;

    @FindBy (xpath = "//div[contains(text(),'Large Fields')]")
    public WebElement largeFieldsSettings;
    @FindBy (xpath = "//div[contains(text(),'Medium Fields')]")
    public WebElement mediumFieldsSettings;
    @FindBy (xpath = "//div[contains(text(),'Small Fields')]")
    public WebElement smallFieldsSettings;

    @FindBy (xpath = "//div[contains(@class,'sidebarSettingsContainer SIDEBAR_TEXT_GLOBAL_BODY')]//div//div[contains(@class,'sidebar-helper-wrapper')]")
    public WebElement sidebarBottom;

    @FindBy (xpath = "//div[@class ='sidebarElement sidebarElement__select']//div[@class ='select-panel-list__header-button']")
    public WebElement sizeDropDown;
    @FindBy (xpath = "//div[contains(text(),'Large')]")
    public WebElement largeSize;
    @FindBy (xpath = "//div[contains(text(),'Medium')]")
    public WebElement mediumSize;
    @FindBy (xpath = "//div[contains(text(),'Small')]")
    public WebElement smallSize;


    public void paragraphStylesClick(){
        wait.until(ExpectedConditions.elementToBeClickable(paragraphStyles)).click();
    }
    public void fieldStylesClick(){
        wait.until(ExpectedConditions.elementToBeClickable(fieldStyles)).click();
    }



}
