import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseTest {
    @Epic("UI Tests")
    @Feature("Contact Form")
    @Story("Contact Screen")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "UI- Contact Screen")
    public void TC_094() {
        try {
            contactFormPage.contactUs();
            Allure.step("Assertion Check title name exists");
            Assert.assertEquals(contactFormPage.checkText(), "בואו נדבר!\n" +
                    "צרו עימנו קשר בכל עניין");
        } catch (AssertionError error) {
            Allure.step("Error: " + error.getMessage());
        }
    }
    @Test(description = "UI- Check Contact Fields")
    public void TC_095() {
        try {
            contactFormPage.sendContactUs();
            Allure.step("Assertion Check error name exists");
            Assert.assertEquals(contactFormPage.checkTextError(),
                    "חובה למלא שדה זה");
        } catch (AssertionError error) {
            Allure.step("Error: " + error.getMessage());
        }
    }
    @Test(description = "UI- Confirmation screen for leaving a request")
    public void TC_096() {
        try {
            contactFormPage.fillDetails();
            Allure.step("Assertion Check error name exists");
            Assert.assertEquals(contactFormPage.checkTextSend(),
                    "חובה למלא שדה זה");
        } catch (AssertionError error) {
            Allure.step("Error: " + error.getMessage());
        }
    }




}
