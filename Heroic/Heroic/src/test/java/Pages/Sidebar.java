package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sidebar {
    WebDriver webDriver;

    public Sidebar(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//div[@class='animationSidebar']//button[@class='button-add-element']")
    public WebElement newPageButton;
    @FindBy (css = ".page-menu-dropdown")
    public WebElement threeDots;


}
