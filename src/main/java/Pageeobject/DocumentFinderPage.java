package Pageeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DocumentFinderPage extends BasePage {
    By topic = By.cssSelector("[class=\"quick__item\"] [href=\"https://www.bth.co.il/forms/\"]");
    By search = By.cssSelector("[class=\"search\"] [type=\"submit\"]");
    By text = By.cssSelector("[class=\"table__head\"] [class=\"table__row\"]");

    public DocumentFinderPage(WebDriver driver) {
        super(driver);
    }


    public void searchResults() {
        clickJS(topic);
        selectValue = new Select(driver.findElement(By.cssSelector("[id=\"primary\"]")));
        selectValue.selectByVisibleText("רכב");
        click(search);
    }

    public String textCheck() {
        return getText(text);
    }


}
