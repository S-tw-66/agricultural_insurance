package Pageeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactFormPage extends BasePage{
    By contact = By.id("menu-item-6129");
    By contactHeader = By.className("contact__header");
    By submit = By.cssSelector("[class=\"contact__column\"] [type='submit']");
    By errorFullName = By.id("error-fullname");
    By fullName = By.id("fullname");
    By phoneNum = By.id("phone");
    By email = By.id("email");
    By allSubjects = By.id("subject");
    By message = By.name("your-message");
    By sendMessage = By.className("notfound__header");
    public ContactFormPage(WebDriver driver){
        super(driver);
    }
    //TC_094
    public void contactUs(){
        click(contact);
    }
    //TC_094 C
    public String checkText(){
        return getText(contactHeader);
    }
    //TC095
    public void sendContactUs(){
        contactUs();
        click(submit);
    }
    //TC095 C
    public String checkTextError(){
        return getText(errorFullName);
    }
    //TC096
    public void fillDetails(){
        contactUs();
        sendKeys(fullName,"משה כהן");
        sendKeys(phoneNum,"0548874958");
        sendKeys(email,"israel@gamil.com");
        click(allSubjects);
        select(allSubjects,"ביטוח רכב");
        sendKeys(message,"שירות טוב");
        click(submit);
        waitSleep();

    }
    //TC096 C
    public String checkTextSend(){
        return getText(sendMessage);
    }

}
