package com.test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.DriverHelper.driver;


public class TrelloPage {


    @FindBy(xpath = "//*[@id=\"BXP-APP\"]/header[1]/div/div[1]/div[2]/a[1]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    WebElement emailField;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement ContinueButton;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    WebElement passwordField;

    @FindBy(css = "#login-submit")
    WebElement SubmitButton;

    @FindBy(xpath = "//span[contains(text(),'Create new board')]")
    WebElement createBoardButton;

    @FindBy(css = ".fMvxkh4DHKJGnq")
    WebElement boardTitleField;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    WebElement createBoardSubmitButton;


    @FindBy(xpath = "//*[@id=\"board\"]/div[1]/form/textarea")
    WebElement listNameField;

    @FindBy(xpath = "//button[contains(text(),'Add list')]")
    WebElement addList;

    @FindBy(xpath = "//button[@data-testid='list-add-card-button']")
    WebElement addCardButton;

    @FindBy(xpath = "//textarea[@placeholder='Enter a title or paste a link']")
    WebElement cardTextField;

    @FindBy(xpath = "//button[@class='bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc']")
    WebElement addCard;

    @FindBy(xpath = "//textarea[@class='rZbD0IuG2SfEkv']")
    WebElement cardField;

    @FindBy(xpath = "//button[@data-testid='quick-card-editor-move']")
    WebElement move;

    @FindBy(xpath = "//div[contains(@data-testid,'move-card-popover-select-list-destination')]//div[contains(@class,'css-1tbvomj')]")
    WebElement listScroll;

    @FindBy(xpath = "//div[@data-testid='move-card-popover-select-position']//span[@aria-label='open']")
    WebElement positionScroll;

    @FindBy(xpath = "//button[@class='KtU9vsf84ToZn6 bxgKMAm3lq5BpA SdamsUKjxSBwGb u0Qu04nzhYsVX_ SEj5vUdI3VvxDc']")
    WebElement moveButton;

    @FindBy(xpath = "//span[@data-testid='CloseIcon']")
    WebElement CloseIcon;

    @FindBy(xpath = "//li[5]//div[1]//div[3]//button[1]")
    WebElement targetList;

    @FindBy(xpath = "//p[@class='nNvJhnERHVQb9o']")
    WebElement Boards;

    @FindBy(xpath = "//button[@class='vog49kU3sQ8CdC Gdb3ZRORJhWznf frrHNIWnTojsww bxgKMAm3lq5BpA HAVwIqCeMHpVKh SEj5vUdI3VvxDc']")
    WebElement closeBoard;

    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/section[1]/div[1]/div[1]/button[1]/span[1]")
    WebElement close;

    @FindBy(xpath = "//button[@class='bxgKMAm3lq5BpA KpU415sFFvOzGZ PnEv2xIWy3eSui SEj5vUdI3VvxDc']")
    WebElement closeButton;

    @FindBy(xpath = "//button[@class='bxgKMAm3lq5BpA SEj5vUdI3VvxDc']")
    WebElement closeBoardButton;

    @FindBy(xpath = "//button[@class='Bp80TGmc9hQIdE bxgKMAm3lq5BpA KpU415sFFvOzGZ SEj5vUdI3VvxDc']")
    WebElement deleteButton;

    @FindBy(xpath = "//span[@data-testid='CloseIcon']")
    WebElement crossIcon;

    // Constructor
    public TrelloPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Login Methods
    public void loginButton() throws InterruptedException {
        loginButton.click();
    }

    public void emailField(String email) {
        emailField.sendKeys(email);
        ContinueButton.submit();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        SubmitButton.click();
    }

    // Board Creation Methods
    public void createBoard(String boardName) throws InterruptedException {
        createBoardButton.click();
        Thread.sleep(1000);
        boardTitleField.click();
        boardTitleField.sendKeys(boardName);
        Thread.sleep(1000);
        createBoardSubmitButton.click();
        Thread.sleep(3000);
    }

    // Method to create a new list on the board
    public void createList(String listName) throws InterruptedException {
        listNameField.click();
        Thread.sleep(2000);
        listNameField.sendKeys(listName);
        Thread.sleep(2000);
        addList.click();
        Thread.sleep(3000);
    }


    public void addCardToList(String cardName) throws InterruptedException {
        addCardButton.click();
        // Locate the input field for the list name
        Thread.sleep(2000);
        cardTextField.click();
        cardTextField.sendKeys(cardName);
        Thread.sleep(2000);
        addCard.click();
        Thread.sleep(3000);
    }


    // Card Move Methods (Drag and Drop)
//    public void moveCardToList(String cardName, String targetList) throws InterruptedException {
//        //      new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(cardName,targetList).perform();
//      //  Actions actions = new Actions(driver);
//      //  actions.dragAndDrop(cardField, targetList).perform();
//        //   cardField.click();
//        Thread.sleep(2000);
//        move.click();
//        Thread.sleep(2000);
//        listScroll.click();
//        Thread.sleep(2000);
//        positionScroll.click();
//        Thread.sleep(2000);
//        moveButton.click();
//
//    }
//
    // Board Closing and Deletion Methods
//    public void closeBoard() {
//        Boards.click();
//        closeBoard.click();
//        closeButton.click();
//
//    }
//        public void deleteBoard () {
//            closeBoardButton.click();
//            deleteButton.click();
//            crossIcon.click();
//            close.click();
//        }
    }
