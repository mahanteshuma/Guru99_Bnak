package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    WebDriver driver;
    public Login_Page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='uid']")
    private WebElement user_id;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="btnLogin")
    private WebElement login_btn;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement logout_btn;

    public void enterUserID(String userID){user_id.sendKeys(userID);
    }

    public void enterPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void clickOnLogin_btn(){
        login_btn.click();
    }


    public void clickOnLogout_btn(){ logout_btn.click(); }



}
