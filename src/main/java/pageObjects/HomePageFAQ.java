package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HomePageFAQ extends CorePage{
    //Текст для локатора панели
    private final String textForPanelLocator = "#accordion__heading-%d";
    //Текст для локатора текста, открывшегося при нажатии на панель
    private final String textForTextLocator = "#accordion__panel-%d > p";


    public HomePageFAQ(WebDriver driver) {
        super(driver);
    }



    public String getTextFromAccordion(int accordionNumber){
        //Локатор панели
        By panelLocator = By.cssSelector(String.format(textForPanelLocator, accordionNumber));
        //Локатор текста
        By textLocator = By.cssSelector(String.format(textForTextLocator, accordionNumber));
        WebElement element = driver.findElement(panelLocator);

        //Имитируем нажатие по панели
        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById(\"accordion__heading-"+ accordionNumber +"\").click()");
        //Ожидаем появления выпадающего текста
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(textLocator)));
        //Возвращаем открывшийся текст
        return driver.findElement(textLocator).getText();
    }
}
