import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeAutomationPage {
    private WebDriver driver;
    private Actions actions;

    @FindBy(xpath = "//*[@id=\"name-input\"]")
    private WebElement enterName;
    @FindBy(xpath = "//*[@id=\"feedbackForm\"]/label[2]/input")
    private WebElement enterPassword;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement enterEmail;
    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement enterMessage;

    @FindBy(css = "#drink2")
    private WebElement checkboxMilk;
    @FindBy(id = "drink3")
    private WebElement checkboxCoffee;

    @FindBy(xpath = "//*[@id=\"color3\"]")
    private WebElement radioYellow;

    @FindBy(xpath = "//*[@id=\"automation\"]")
    private WebElement dropdownAutomation;
    @FindBy(xpath = "//*[@id=\"automation\"]/option[2]")
    private WebElement valueYes;

    @FindBy(xpath = "//*[@id=\"feedbackForm\"]/ul/li")
    private List<WebElement> autoToolElements;

    @FindBy(xpath = "//*[@id=\"submit-btn\"]")
    private WebElement buttonSubmit;

    public PracticeAutomationPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public PracticeAutomationPage enterName(String arg1) {
        moveAndEnter(enterName,arg1);
        return this;
    }
    public PracticeAutomationPage enterPassword(String arg1) {
        moveAndEnter(enterPassword,arg1);
        return this;
    }
    public PracticeAutomationPage enterEmail(String arg1) {
        moveAndEnter(enterEmail,arg1);
        return this;
    }
    public PracticeAutomationPage enterMessage(String arg1) {
        moveAndEnter(enterMessage,arg1);
        return this;
    }

    private void moveAndEnter(WebElement element, String string) {
        actions.moveToElement(element).click().sendKeys(string).perform();

    }

    public PracticeAutomationPage chooseMilk(){
        moveAndClick(checkboxMilk);
        return this;
    }
    public PracticeAutomationPage chooseCoffee(){
        moveAndClick(checkboxCoffee);
        return this;
    }
    public PracticeAutomationPage chooseYellow(){
        moveAndClick(radioYellow);
        return this;
    }
    public PracticeAutomationPage chooseAutomation(){
        actions.moveToElement(dropdownAutomation).perform();
        valueYes.click();
        return this;

    }

    public String getToolsCount(){return String.valueOf(autoToolElements.size());}

    public PracticeAutomationPage pressSubmit() {
        moveAndClick(buttonSubmit);
        return this;
    }

    private void moveAndClick(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    public void checkGoodAlert() {
        // Переключаемся на алерт
        Alert alert = null;
        try {
            alert = driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            Assert.fail("no such alert");
        }
        Assert.assertEquals("Message received!", alert.getText());
    }

    public void checkBadAlert() {
        Assert.assertThrows(NoAlertPresentException.class, () -> driver.switchTo().alert());
    }

}
