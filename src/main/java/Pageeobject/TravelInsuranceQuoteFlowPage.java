package Pageeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class TravelInsuranceQuoteFlowPage extends BasePage{
    Actions action;
    By click_ = By.cssSelector("#abroadplus");
    WebElement clickPurchase = driver.findElement(By.cssSelector("#abroadplus"));
    By toContinue = By.cssSelector(".sc-papXJ");
    By continuation = By.cssSelector("[data-f='procceed']");
    By close = By.cssSelector("#acceptButton");
    By no = By.cssSelector("[data-f=\"first-time-no\"]");
    By yes = By.cssSelector("[data-f=\"already-purchased\"]");
    By header = By.cssSelector(".f-header");
    By noGoIsrael = By.cssSelector("[data-f=\"no\"]");
    By yesGoIsrael = By.cssSelector("[data-f=\"yes\"]");
    By continentSelection = By.cssSelector("[name=\"אירופה\"]");
    By goTo = By.cssSelector("[type=\"button\"] [data-f=\"continue\"]");
    By start = By.cssSelector(".react-datepicker__day--001:nth-child(1)");
    By end = By.cssSelector(".react-datepicker__day--011:nth-child(4)");
    By goNext = By.cssSelector("[class=\"sc-papXJ jyxUhb procceed\"]");
    By idNumber= By.cssSelector("[id=\"idNumber_0\"");
    By phoneNumber = By.cssSelector("[id=\"cellphoneNumber_0\"]");
    By firstNameHeb = By.cssSelector("[id=\"firstNameHeb_0\"]");
    By firstNameEng = By.cssSelector("[id=\"firstNameEng_0\"]");
    By lastNameHeb = By.cssSelector("[id=\"lastNameHeb_0\"]");
    By lastNameEng = By.cssSelector("[id=\"lastNameEng_0\"]");
    By dateOfBirth = By.cssSelector("[id=\"dateOfBirth_0\"]");
    By email = By.cssSelector("[id=\"emailAddressLabel_0\"]");
    By gender = By.cssSelector("[id=\"זכר\"]");
    By passengersSick = By.cssSelector("[for=\"לא_isPassengersSick\"]");
    By waitTo = By.cssSelector("[class=\"center\"]");
    By baggage = By.cssSelector("[aria-label=\"כיסויי פוליסה - כבודה (על מנת לבחור את שאר הכיסויים יש לבחור כיסוי זה)\"] [class=\"extra\"]");
    By xButton = By.cssSelector("[class=\"xButton\"]");
    By finalPriceLine = By.cssSelector("#root > div > div > div > main > div.sc-iAvgwm.bHukvr.price-container > div > div > span");
    public TravelInsuranceQuoteFlowPage(WebDriver driver){
        super(driver);
    }
    //TC_038
    public void clickPurchaseOnline(){
        action = new Actions(driver);
        action.scrollToElement(clickPurchase)
                .perform();
        click(click_);
        List<String> winHandles = getWinHandles();
        switchTo(winHandles.get(1));
        click(toContinue);
        click(close);
        switchTo(winHandles.get(0));
    }
    //TC_039
    public void letsContinue(){
        clickPurchaseOnline();
        click(continuation);
    }
    //TC_040
    public void firstTime(){
        letsContinue();
        click(no);
    }
    //TC_041
    public void clickToPurchase() {
        letsContinue();
        click(yes);
        waitForElementToBeVisible(header);
    }
    //TC_042
    public void handlePartialDepartureScenario(){
        firstTime();
        click(noGoIsrael);
    }
    //TC_043
    public void selectDestinationStep1(){
        firstTime();
        click(yesGoIsrael);
    }
    //TC_044
    public void selectDestinationStep2(){
        firstTime();
        click(yesGoIsrael);
        clickJS(continentSelection);
        click(goTo);
    }
    //TC_045
    public void selectDestinationStep3(){
        firstTime();
        click(yesGoIsrael);
        clickJS(continentSelection);
        click(goTo);
        click(start);
        click(end);
        click(goNext);
    }
    //TC_046
    public void selectDestinationStep4(){
        selectDestinationStep3();
        sendKeys(idNumber,"054008222");
        sendKeys(phoneNumber,"0545584778");
        sendKeys(firstNameHeb,"אור");
        sendKeys(firstNameEng,"or");
        sendKeys(lastNameHeb,"לוי");
        sendKeys(lastNameEng,"lavi");
        sendKeys(dateOfBirth,"25011998");
        sendKeys(email,"swrs@gmail.com");
        click(gender);
        click(goTo);
        waitForElementToBeVisible(waitTo);
    }
    //TC_047
    public void selectDestinationStep5() {
        selectDestinationStep4();
        click(baggage);
    }
    //TC_048
    public void selectDestinationStep6(){
        selectDestinationStep5();
        click(goTo);
        click(xButton);
        click(goTo);
        if (isElementDisplayed(xButton)) {
            click(xButton);
        }else {
            System.out.println("The element is not displayed.");
        }
        click(goTo);
    }
    //TC_048 C
    public String updateTextPrice(){
    return getText(finalPriceLine);
    }
    //TC_049
    public void selectDestinationStep7(){
        selectDestinationStep6();
        waitForElementToBeVisible(goTo);
        click(goTo);


    }
    //TC_050
    public void selectDestinationStep8() throws InterruptedException {
        selectDestinationStep7();
        click(passengersSick);
        Thread.sleep(2000);
        click(goTo);
        Thread.sleep(2000);
    }
    public void selectDestinationStep9() throws InterruptedException {
        selectDestinationStep8();
        click(goTo);
        Thread.sleep(2000);
    }







}
