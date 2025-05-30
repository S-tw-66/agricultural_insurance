import Pageeobject.CarInsurancePage;
import Pageeobject.ContactFormPage;
import Pageeobject.DocumentFinderPage;
import Pageeobject.TravelInsuranceQuoteFlowPage;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class BaseTest {
    public static WebDriver driver;
    public static String reportPath = "src/tetsData/Config.xml";
    static TravelInsuranceQuoteFlowPage travelInsuranceQuoteFlowPage;
    static CarInsurancePage carInsurancePage;
    static DocumentFinderPage documentFinderPage;
    static ContactFormPage contactFormPage;
    @BeforeMethod
    public static void setUp() throws ParserConfigurationException, IOException, SAXException {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("198.7.58.79\n" +
                "\n:8080");
        proxy.setSslProxy("198.7.58.79\n" +
                "\n:8080");
        ChromeOptions options = new ChromeOptions();
//        options.setProxy(proxy);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--start-maximized");  // מקסום החלון
        options.addArguments("--incognito");// מצב אנונימי (incognito)
//        options.addArguments("--headless");
        String browser = readFromFile("browser", reportPath);
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver(options);
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.get(readFromFile("url", reportPath));
        travelInsuranceQuoteFlowPage = new TravelInsuranceQuoteFlowPage(driver);
        carInsurancePage = new CarInsurancePage(driver);
        documentFinderPage = new DocumentFinderPage(driver);
        contactFormPage = new ContactFormPage(driver);
    }

    @AfterMethod
    public void afterTest() {
        takeScreenShot();
        if (driver != null) {
            driver.quit();
        }
    }

    public static String readFromFile(String keyData, String pathName) throws ParserConfigurationException, IOException, SAXException {
        String data = "";
        try {
            // Load the XML file
            File xmlFile = new File(pathName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            // Normalize the document
            doc.getDocumentElement().normalize();
            // Extract values from XML
            data = doc.getElementsByTagName(keyData).item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void takeScreenShot() {
        try {
            String timeStamp = new SimpleDateFormat("dd.MM.yyyy_HHmm").format(new Date());
            String fileName = timeStamp + "_" + System.currentTimeMillis() + ".png";
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            Path destinationPath = new File("src/tetsData/" + fileName).toPath();
            Files.createDirectories(destinationPath.getParent());
            Files.copy(screenShotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            // Add to allure report
            Allure.addAttachment("Screenshot - " + timeStamp,
                    Files.newInputStream(screenShotFile.toPath()));
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}

