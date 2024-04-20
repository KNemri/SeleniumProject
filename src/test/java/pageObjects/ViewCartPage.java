package pageObjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import utils.CommonMethods;

public class ViewCartPage extends CommonMethods {
    @FindBy(xpath = "//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")
    public WebElement emptyCartBtn;

    @FindBy(xpath = "//footer[@data-testid='modal-footer']//button[@type='button'][1]")
    WebElement confirmationBtn;
    @FindBy(xpath = "//p[@class='header-1']")
    WebElement messageElement;


    public ViewCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void clearCart() {
        click(emptyCartBtn);
        click(confirmationBtn);
        waitForlocatability(messageElement);
        Assert.assertTrue(messageElement.isDisplayed(), "Message 'Your cart is empty.' is not displayed.");

    }
}
