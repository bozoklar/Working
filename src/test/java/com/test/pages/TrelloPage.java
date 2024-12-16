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

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[1]/main[1]/section[3]/ul[1]/li[2]/div[1]/div[1]/a[1]/div[2]']")
    WebElement boardClick;

    @FindBy(xpath = "//div[@class='XpRtBItFRSeuWI']")
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

    @FindBy(xpath = "//p[@class='nNvJhnERHVQb9o']")
    WebElement Boards;

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
}
//
//
//
//  //   Card Move Methods (Drag and Drop)
//    public void moveCardToList(String cardName, String moveToList) {
//        new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(card, targetList).perform();
//    cardField.click();
//    move.click();
//    listScroll.click();
//    positionScroll.click();
//    moveButton.click();
//    CloseIcon.click();
//
//    }
//
//    // Board Closing and Deletion Methods
//    public void closeBoard() {
//        Boards.click();
//        closeBoardButton.click();
//        closeBoardConfirmButton.click();

//    public void deleteBoard() {
//        deleteButton.click();
//        confirmDeleteButton.click();
