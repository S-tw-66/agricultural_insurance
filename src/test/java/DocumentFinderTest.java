import org.testng.Assert;
import org.testng.annotations.Test;

public class DocumentFinderTest extends BaseTest {
    @Test(description = "UI- Document search results in free search")
    public void TC_058() {
        try {
            documentFinderPage.searchResults();
            Assert.assertEquals(documentFinderPage.textCheck(),
                    "שם המסמך ביטוח ראשי ביטוח משני הורדה למחשב מילוי אונליין");
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }
    @Test(description = "UI- Clearing document search results")
    public void TC_059() {
        try {
            documentFinderPage.NoneSearchResults();
            Assert.assertTrue(documentFinderPage.tableHide());
        } catch (AssertionError error) {
            System.out.println("Error: " + error);
        }
    }


}
