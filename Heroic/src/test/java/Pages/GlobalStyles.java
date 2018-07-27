package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalStyles {
    WebDriver webDriver;

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
    @FindBy (xpath = "//span[contains(@class,'switch-extra-sidebar__item')][contains(text(),'Overview Mode')]")
    public WebElement overViewMode;
    @FindBy (xpath = "//span[contains(@class,'switch-extra-sidebar__item')][contains(text(),'Page View')]")
    public WebElement pageViewMode;

    @FindBy (xpath = "//div[@class='select-panel-list__inner select-panel-list__inner_open']//div[@class='select-panel-list__item-value'][contains(text(),'Abril Fatface')]")
    public WebElement abril_Fatface_font;
    @FindBy (xpath = "//div[@class='select-panel-list__inner select-panel-list__inner_open']//div[@class='select-panel-list__item-value'][contains(text(),'Asap')]")
    public WebElement asap_font;
}
