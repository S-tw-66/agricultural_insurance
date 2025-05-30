package Pageeobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    Select selectValue;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /*
protected WebElement waitForElementToBeVisible(By locator) {
        //אלמנט של טעינה של הדף יכול להכיל wait , progress
    By loaderLocator = By.id("loader");
    try {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.invisibilityOfElementLocated(loaderLocator),
                ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(loaderLocator))
        ));
    } catch (TimeoutException ignored) {
        System.out.println("Error: " + ignored);
    }

    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

     */
    protected void click(By locator) {
        waitForElementToBeVisible(locator).click();
    }


    protected void sendKeys(By locator, String text) {
        waitForElementToBeVisible(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitSleep() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // משחזר את מצב ההפרעה של התהליך
            System.err.println("Interrupted: " + e.getMessage());
        }
    }


    public void select(By locator, String text) {
        waitForElementToBeVisible(locator);
        selectValue = new Select(driver.findElement(locator));
        selectValue.selectByVisibleText(text);
    }


    protected String getUrl() {
        return driver.getCurrentUrl();
    }

    protected List<String> getWinHandles() {
        Set<String> handles = driver.getWindowHandles();
        return new ArrayList<>(handles);
    }

    public void switchTo(String handle) {
        driver.switchTo().window(handle);
    }

    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    protected void clickJS(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        js.executeScript("arguments[0].click();", element);
    }



}
