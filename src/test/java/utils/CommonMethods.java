package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonMethods extends PageInitializers {
    public static WebDriver driver;
    public static Properties prop;


    public CommonMethods() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/test/java/Configs/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
        initializePageObjects();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

    }
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }
  public static void waitForlocatability(WebElement element){

      getWait().until(ExpectedConditions.visibilityOf(element));
  }
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }
   @AfterSuite(alwaysRun = true)
   public void closeBrowser(){
      driver.quit();
   }
}
