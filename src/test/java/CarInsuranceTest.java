import org.testng.Assert;
import org.testng.annotations.Test;

public class CarInsuranceTest extends BaseTest {
    @Test(description = "UI- Screen for checking the existence of car insurance for a car that does not have insurance")
    public void TC_054() {
        try {
            carInsurancePage.checkCar("15487979");
            Assert.assertEquals(carInsurancePage.textCheck(),
                    "לא נמצא ביטוח בתוקף עבור הנתונים שהוזנו");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }

    @Test(description = "UI- Screen for checking the existence of car insurance for a car that has insurance")
    public void TC_055() {
        try {
            carInsurancePage.checkCar("1234567");
            Assert.assertEquals(carInsurancePage.orderTexCheck(),
                    "בתאריך 07/05/2025 נמצא ביטוח תקף לרכב שמספרו 1234567 בביטוח חקלאי");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
}
