package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.testng.Assert.assertTrue;


public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@type = 'email']")
    public WebElement inputUsername;

    @FindBy(xpath = "//span[text() = 'Далее']")
    public WebElement pressContinue;

    @FindBy(xpath = "//input[@autocomplete = 'current-password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//div[@class = 'T-I J-J5-Ji T-I-KE L3']")
    public WebElement buttonWrite;

    @FindBy(xpath = "//textarea[@name='to']")
    public WebElement inputAdress;

    @FindBy(xpath = "//input[@name='subjectbox']")
    public WebElement inputTheme;

    @FindBy(xpath = "//div[@role = 'textbox']")
    public WebElement inputTextMessage;

    @FindBy(xpath = "//img[@class = 'Ha']")
    public WebElement closeAndSave;

    @FindBy(xpath = "//span[@class = 'oG aOy']")
    public WebElement massageisSaved;


    @FindBy(xpath = "//*[contains (@href, '#drafts')]")
    public WebElement pressDraft;

    @FindBy(xpath = "//*[@class = 'BltHke nH oy8Mbf']//*[@class='bog'][1]")
    public WebElement pressThemeText;

    @FindBy(xpath = "//*[@class = 'zA yO']//*[@class = 'y6']")
    public WebElement themeSendText;


    @FindBy(xpath = "//div[@class = 'T-I J-J5-Ji aoO T-I-atl L3']")
    public WebElement pressSendBtn;


    @FindBy(xpath = "//*[contains(@href, '#sent')]")
    public WebElement sendingMesg;

    @FindBy(xpath = "//span[text() = 'Hello']")
    public WebElement adrSends;

    @FindBy(xpath = "//span[@email = 'aleksandr.b")
    public WebElement adrMes;

    @FindBy(xpath = "//span[text() = 'Тest text']")
    public WebElement themeMes;



    public void open(String url) {
        driver.get(url);
    }

    public LoginPage fillUserName(String text) {
        inputUsername.sendKeys(text);
        return this;
    }

    public LoginPage fillPassword(String text) {
        inputPassword.sendKeys(text);
        return this;
    }

    public LoginPage fillAdress(String text) {
        inputAdress.sendKeys(text);
        return this;
    }

    public LoginPage fillTheme(String text) {
        inputTheme.sendKeys(text);
        return this;
    }

    public void waiterClicker(WebElement web) {
        WebElement waiterClicker = (new WebDriverWait(driver, 10))
                .until(elementToBeClickable(web));

    }
    public void waiterVision(WebElement web){
        WebElement waiterVision = (new WebDriverWait(driver, 8))
                .until(visibilityOf(web));
    }

    public void fillTextMessage(String test) {
        if (true) {
            waiterClicker(inputTextMessage);
            inputTextMessage.sendKeys(test);
        } else{
            System.out.println("Don't save message");
        }
    }

    public void submit() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pressContinue.click();

    }

    public void write() {
        waiterClicker(buttonWrite);
        buttonWrite.click();
    }

    public void closeAndSave() {
       if (true) {
            closeAndSave.click();
           System.out.println("Message is save");
        } else {
           System.out.println("Don't save message");
        }
    }

    public void pressDraft() {
        if(true) {
            waiterVision(pressDraft);
            pressDraft.click();
        } else  {
            System.out.println("Lost draft");

        }
    }


    public void pressThemeText() {
        if(true) {
            waiterClicker(pressThemeText);
            pressThemeText.click();
        } else {
            System.out.println("Lost themes");
        }
    }


    public void pressSendBtn()  {
        if(true) {
            waiterClicker(pressSendBtn);
            pressSendBtn.click();

        } else  {
            System.out.println("Cant send message");
        }
    }


    public void sendMessageOrNot() {

        if(true) {
            WebElement waittSendingMessage = (new WebDriverWait(driver, 8))
                    .until(new ExpectedCondition<WebElement>() {
                        @Nullable
                        @Override
                        public WebElement apply(@Nullable WebDriver driver) {
                            return driver.findElement(By.xpath("//span[text()='Письмо отправлено.']"));
                        }
                    });

            assertTrue(waittSendingMessage.getText().equals("Письмо отправлено."));
            System.out.println("Message is send");
        } else {
            System.out.println("Sorry, I lost it");
        }
    }

    public void sendsMessage() {
        if (true) {
            waiterClicker(sendingMesg);
            sendingMesg.click();
        } else {
            System.out.println("Sorry, isnt send");
        }
    }


    public void themeSendMessg() {

        if (true){
            waiterVision(pressThemeText);
            pressThemeText.click();
            assertTrue(adrMes.getText().equals("aleksandr.b"));
            assertTrue(themeMes.getText().equals("Тest text"));
            assertTrue(adrSends.getText().equals("Hello"));
        } else {
            System.out.println("It's not that message");

    }}



    public LoginPage(WebDriver driver) {
        super(driver);
    }

}