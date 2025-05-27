import org.testng.Assert;
import org.testng.annotations.Test;

public class TravelInsuranceQuoteFlowTest extends BaseTest {


    @Test(description = "UI - Online offer for overseas insurance details")
    public void TC_038() {
        try {
            travelInsuranceQuoteFlowPage.clickPurchaseOnline();
            Assert.assertEquals(driver.getTitle(),
                    "ביטוח חקלאי - ביטוח נסיעות לחו״ל");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }

    @Test(description = "UI- Have you purchased insurance in the past?")
    public void TC_039() {
        try {
            travelInsuranceQuoteFlowPage.letsContinue();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/returned");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }


    @Test(description = "UI - Are all passengers departing from Israel?")
    public void TC_040() {
        try {
            travelInsuranceQuoteFlowPage.firstTime();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/departureFromIsrael");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI - Are all passengers departing from Israel?")
    public void TC_041() {
        try {
            travelInsuranceQuoteFlowPage.clickToPurchase();
            Assert.assertEquals(driver.getTitle(),
                    "ביטוח חקלאי");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- End of process when selecting that not all passengers are leaving Israel")
    public void TC_042() {
        try {
            travelInsuranceQuoteFlowPage.handlePartialDepartureScenario();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/stopProcess");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 1- Where are you going")
    public void TC_043() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep1();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/destination");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 2- When are you traveling")
    public void TC_044() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep2();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/travelRange");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 3- Passenger details")
    public void TC_045() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep3();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/passengers");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 4- Covers for you")
    public void TC_046() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep4();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/extras");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 4- Calculation of coverages")
    public void TC_047() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep5();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/extras");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 5- Special covers")
    public void TC_048() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep6();
            Assert.assertEquals(travelInsuranceQuoteFlowPage.updateTextPrice(),
                    "מחיר הביטוח $26.4");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 6- Health declaration")
    public void TC_049() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep7();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/sportsCovers");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 7- Proposal Summary")
    public void TC_050() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep8();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/sum");
        } catch (AssertionError | InterruptedException error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Step 8- Payment and confirmation")
    public void TC_051() {
        try {
            travelInsuranceQuoteFlowPage.selectDestinationStep9();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://digital.bth.co.il/abroad/payment");
        } catch (AssertionError | InterruptedException error) {
            System.out.println("Error: " + error);
        }
    }







}


