package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


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

    @FindBy(xpath = "//span[@class = 'y6']//*[@class ='bog'][1]")
    public WebElement themeSendText;


    @FindBy(xpath = "//div[@class = 'T-I J-J5-Ji aoO T-I-atl L3']")
    public WebElement pressSendBtn;


    @FindBy(xpath = "//*[contains (@href, '#sent')]")
    public WebElement sendingMesg;

    @FindBy(xpath = "//span[text = 'aleksandr.barov13@gmail.com']")
    public WebElement addrSends;

    @FindBy(xpath = "//span [@email = 'aleksandr.barov13@gmail.com']")
    public WebElement adrMes;

    @FindBy(xpath = "//*[@aria-label = 'Тема']")
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
            waiterVision(massageisSaved);
            closeAndSave.click();
           System.out.println("Message is save");
        } else {
           System.out.println("Don't save message");
        }
    }

    public void pressDraft() {
        if(true) {
            waiterClicker(pressDraft);
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

            Assert.assertTrue(waittSendingMessage.getText().equals("Письмо отправлено."));
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
        } else {
            System.out.println("It's not that message");
        }
    }



    //    public void rightOrNotTheme () {
//        try {
//            waiterClicker(themeMes);
//            WebElement waitTheme = (new WebDriverWait(driver, 10))
//                    .until(elementToBeClickable(themeMes));
//            String mes = new String(themeMes.getText());
//            Assert.assertEquals(mes,("Test text"));
//        }catch (NoSuchElementException e){
//            System.out.println("It's not that message");
//            e.printStackTrace();
////            wait.until(ExpectedConditions.elementToBeClickable(inputTextMessage));
////            wait.until(ExpectedConditions.elementToBeClickable(inputAdress));
//    }}
//
//    public void rightOrNotAdr () {
//        try {
//            WebElement waitAdr = (new WebDriverWait(driver, 6))
//                .until(elementToBeClickable(adrMes));
//
//
//        }catch (NoSuchElementException e){
//            System.out.println("It's not that message");
//            e.printStackTrace();}}
//
//    public void rightOrNotText(){
//        try {WebElement waitText = (new WebDriverWait(driver, 6))
//                .until(elementToBeClickable(inputTextMessage));
//
//    }catch (NoSuchElementException e){
//            System.out.println("It's not that message");
//            e.printStackTrace();}
//    }
    public LoginPage(WebDriver driver) {
        super(driver);
    }

}