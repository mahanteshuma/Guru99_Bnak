import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils{


   public static WebDriver driver;
    public static void takeScreenShot() throws IOException {
        TakesScreenshot takesScreenshot=((TakesScreenshot)driver);
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path= System.getProperty("user.dir")+"./Screenshot/screenshot.png";
        File dest=new File(path);
        FileUtils.copyFile(src,dest);


    }


}
