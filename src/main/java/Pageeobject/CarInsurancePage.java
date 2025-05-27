package Pageeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarInsurancePage extends BasePage {
    By carCheck = By.cssSelector("[class=\"quick__item\"] [alt=\"טופס עבר ביטוח\"]");
    By numCar = By.cssSelector("[id=\"license-number\"]");
    By date = By.cssSelector("[data-date=\"7\"]");
    By choice = By.cssSelector("#search-date");
    By checkSub = By.cssSelector("#check-sub");
    By textCheck = By.cssSelector(".error-msg");
    By textCheck2 = By.cssSelector(".success-msg");

    public CarInsurancePage(WebDriver driver) {
        super(driver);
    }

    //TC-054
    public void checkCar(String text) {
        clickJS(carCheck);
        sendKeys(numCar, text);
        click(choice);
        click(date);
        click(checkSub);
    }

    //TC-054 C
    public String textCheck() {
        return getText(textCheck);
    }

    public String orderTexCheck() {
        return getText(textCheck2);
    }
}
