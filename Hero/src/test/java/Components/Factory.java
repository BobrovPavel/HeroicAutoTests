package Components;

import SupportClasses.*;
import org.openqa.selenium.WebDriver;

public class Factory {
    private WebDriver webDriver;

    public Factory (WebDriver driver){
        this.webDriver = driver;
    }
    public LoginPage loginPage(){
        return new LoginPage(webDriver);
    }
    public TinyMCE tinyMCE(){
        return new TinyMCE(webDriver);
    }
    public EditorPage editorPage(){
        return new EditorPage(webDriver);
    }
    public Sidebar sidebar(){
        return new Sidebar(webDriver);
    }
    public SupportMethod supportMethod(){
        return new SupportMethod(webDriver);
    }
    public GlobalStyles globalStyles(){
        return new GlobalStyles(webDriver);
    }
    public Variables variables(){
        return new Variables(webDriver);
    }
    public GlobalHelper globalHelper(){
        return  new GlobalHelper(webDriver);
    }
}
