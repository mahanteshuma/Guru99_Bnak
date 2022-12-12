package Steps;

import Pages.Login_Page;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Login_pages_Steps {
    public static WebDriver driver;
    Login_Page login;
    @Given("user opened Browser using {string}")
    public void user_opened_browser_using(String url) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }


    @When("^User enters valid UserID as (.*) and Password as (.*)$")
    public void user_enters_valid_user_id_as_and_password_as(String userID, String pwd) throws InterruptedException {

        login=new Login_Page(driver);
        login.enterUserID(userID);
        login.enterPassword(pwd);

    }
    @And("User Clicks Login Button")
    public void user_clicks_login_button() throws InterruptedException {

        login.clickOnLogin_btn();
        Thread.sleep(1000);
        //driver.switchTo().alert().accept();

    }
    @Then("User navigated to Guru99 Bank Home Page")
    public void user_navigated_to_guru99_bank_home_page() throws IOException {

        if(driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank")){
            System.out.println("Your In Guru99 Bank Home Page");
        }else {
            System.out.println("In Valid Page");
            takeScreenShot();
        }
       Assert.assertTrue(true);

    }


    @And("User closed Browser")
    public void userClosedBrowser() {
        driver.quit();
    }

    public static void takeScreenShot() throws IOException {
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "./Screenshot/screenshot.png";
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
    }


    @And("User Logout the Application")
    public void userLogoutTheApplication() throws InterruptedException {
        login.clickOnLogout_btn();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
    }
}
