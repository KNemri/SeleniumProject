package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.CommonMethods;

import java.util.List;

public class SearchPage extends CommonMethods {
    @FindBy(xpath = "//span[@class='block font-semibold text-sm-1/2 leading-none mt-6 mb-0 max-h-10 hover:max-h-full min-h-10 overflow-hidden hover:overflow-visible text-center']")
    public List<WebElement> prdTitles;

    @FindBy(xpath = "//input[@class='btn btn-cart btn-small']")
    public List<WebElement> items;
    @FindBy(xpath = "//div[@class='notification__content']")
    public WebElement popUp;
    @FindBy(xpath = "//a[@href='/viewcart.cfm']")
    public WebElement viewCartBtn;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    // this method to verify that all titles contains Table
    public void tableItems() {
        boolean allTitlesContainTable = true;
        for (WebElement prdtitle : prdTitles) {
            if (!prdtitle.getText().contains("Table")) {
                allTitlesContainTable = false;
                System.out.println("Product title without table: " + prdtitle.getText());
            }
        }

    }

    public void findLastItem() {
        if (!items.isEmpty()) {
            WebElement lastElement = items.get(items.size() - 1);
            lastElement.click();
        } else {
            System.out.println("No elements found matching the given XPath");
        }
    }

    public void addItemToCart() {
        CommonMethods.waitForlocatability(popUp);
        boolean isPopupDisplayed = popUp.isDisplayed();
        Assert.assertTrue(isPopupDisplayed, "Popup is not displayed");
        viewCartBtn.click();
    }


}
