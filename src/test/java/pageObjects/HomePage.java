package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class HomePage extends CommonMethods {


    @FindBy(xpath = "//input[@id='searchval'][1]")
    public WebElement searchText;

    @FindBy(xpath = "//button[@type='submit'and@value='Search'][1]")
    public WebElement searchButton;

    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public  void  searchForItem(String str) {
       sendText(searchText,str);
       click(searchButton);

    }




}
