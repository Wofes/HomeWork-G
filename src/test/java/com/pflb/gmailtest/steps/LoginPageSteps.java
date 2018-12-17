package com.pflb.gmailtest.steps;

import com.pflb.gmailtest.MainPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;


public class LoginPageSteps {
    private WebDriver driver = null;
    private MainPage MainPage;
    private LoginPage loginPage;


    @Before
    public void getDriver() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void closeDriver() {
        DriverManager.closeDriver();
    }


    @Пусть("^открыта страница входа на сайт \"(.+)\"$")
    public void openLoginPage(String url) {
        loginPage.open(url);
    }


    @И("^пользователь вводит в поле \"([^\"]*)\" значение \"([^\"]*)\"$")
    public void setTextToInput(String fidelName, String value) {
        switch (fidelName) {
            case "имя пользователя":
                loginPage.fillUserName(value);
                break;

            default:
                throw new IllegalArgumentException("Invalid name:" + fidelName);
        }
    }

    @Тогда("^нажимает кнопку$")
    public void pressButton() {
        loginPage.submit();
    }

    @И("^пользователь вводит \"Введите пароль\" значение \"([^\"]*)\"$")
    public void setPassword(String value) {
        loginPage.fillPassword(value);
    }

    @И("^пользлователь нажимает кнопку 'Написать' для создания письма$")
    public void pressWritingButton() {
        loginPage.write();
    }

    @Тогда("^введем адрес \"([^\"]*)\", в теме напишим \"([^\"]*)\" и теле письма запишем \"([^\"]*)\"$")
    public void letter(String adr, String theme, String text) {
        loginPage.fillAdress(adr);
        loginPage.fillTheme(theme);
        loginPage.fillTextMessage(text);
    }


    @И("^нажимается кнопка 'Закрыть'$")
    public void pressCloseAndSave() {
        loginPage.closeAndSave();


    }

    @Тогда("^пользователь заходит в 'Черновики' и открывает последний черновик$")
    public void draftOpen() {
        loginPage.pressDraft();
        if (true) {
            loginPage.pressThemeText();
            System.out.println("I found message!");
        } else {
            System.out.println("Not my message");
        }
    }

    @И("^нажимается кнопку 'Отправить'$")
    public void sendingToAdr() {
        loginPage.pressSendBtn();
    }

    @Если("^сообщение отправлено получим тект 'Message is send', а если нет 'Sorry, I lost it'$")
    public void messageSendOrNot() {
        loginPage.sendMessageOrNot();

    }

    @Если("^сообщение отправлено, то заходим в 'Отправленные'$")
    public void sendMessages() {
        loginPage.sendsMessage();
    }

    @И("^проведем проверку на адрес, тему и тело письма$")
    public void rightOrNotMessage() {

        if (true) {
            loginPage.themeSendMessg();

        } else {
            System.out.println("Oh no! This not my message. Wrong text message");
        }
    }

    @И("^пишем, что вы молодец$")
    public void congrats() {
        System.out.println("Your Welcome");
    }


}

