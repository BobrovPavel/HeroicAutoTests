package Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sidebar {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public Sidebar(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

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
    @FindBy (xpath = "//div[contains(@class,'sidebarSettingsContainer SIDEBAR_TEXT_GLOBAL_BODY')]//div//div[contains(@class,'sidebar-helper-wrapper')]")
    public WebElement sidebarBottom;


    public void ParagraphStylesClick(){
        wait = new WebDriverWait(webDriver, 45, 300);
        wait.until(ExpectedConditions.elementToBeClickable(paragraphStyles)).click();
    }



}
