package Pageeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DocumentFinderPage extends BasePage {
    By topic = By.cssSelector("[class=\"quick__item\"] [href=\"https://www.bth.co.il/forms/\"]");
    By search = By.cssSelector("[class=\"search\"] [type=\"submit\"]");
    By text = By.cssSelector("[class=\"table__head\"] [class=\"table__row\"]");
    By clear = By.cssSelector("[type=\"reset\"]");
    By table = By.cssSelector("[class=\"table__table table--hide\"]");

    public DocumentFinderPage(WebDriver driver) {
        super(driver);
    }

    //TC_058
    public void searchResults() {
        clickJS(topic);
        selectValue = new Select(driver.findElement(By.cssSelector("[id=\"primary\"]")));
        selectValue.selectByVisibleText("רכב");
        click(search);
    }

    //TC_058 C
    public String textCheck() {
        return getText(text);
    }

    //TC_059
    public void NoneSearchResults() {
        searchResults();
        click(clear);
    }

    //TC_059 C
    public boolean tableHide() {
        isElementDisplayed(table);
        return true;
    }


}
