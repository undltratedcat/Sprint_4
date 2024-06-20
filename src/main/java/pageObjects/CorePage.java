package pageObjects;

import org.openqa.selenium.WebDriver;

public abstract class CorePage {
    protected WebDriver driver;

    public CorePage(WebDriver driver) {
        this.driver = driver;
    }
}
