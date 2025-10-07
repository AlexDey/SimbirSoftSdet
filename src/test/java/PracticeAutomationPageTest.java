import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeAutomationPageTest {
    WebDriver driver;
    PracticeAutomationPage page;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://practice-automation.com/form-fields/");
        page = new PracticeAutomationPage(driver);
    }

    @Test
    public void checkGoodAlert() {
        page
                .enterName("Alexandr")
                .enterPassword("A1ex@ndr") // в идеале пароль надо хранить вне системы и брать со стороны
                .enterEmail("name@example.com")
                .enterMessage(page.getToolsCount())
                .chooseCoffee()
                .chooseMilk()
                .chooseYellow()
                .chooseAutomation()
                .pressSubmit()
                .checkGoodAlert();
    }

    @Test()
    public void checkBadAlert() {
        page
                .pressSubmit()
                .checkBadAlert();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}