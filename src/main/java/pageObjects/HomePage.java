package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends CorePage {
    //Локатор кнопки заказа в шапке сайта
    private By orderButtonInHeadderLocator = By.cssSelector(".Header_Nav__AGCXC > button.Button_Button__ra12g");
    //Локатор кнопки заказа в теле сайта
    private By orderButtonInRoadmapLocator = By.className("Button_Middle__1CSJM");
    private By cookieConfirmButton = By.id("rcc-confirm-button");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public OrderPage clickOnOrderButton(boolean isInHeadderButton){
        if (isInHeadderButton)
            driver.findElement(orderButtonInHeadderLocator).click();
        else {
            driver.findElement(cookieConfirmButton).click();
            driver.findElement(orderButtonInRoadmapLocator).click();

        }
        return new OrderPage(driver);
    }

}
