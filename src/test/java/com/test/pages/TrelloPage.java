package com.test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverHelper.driver;


public class TrelloPage {


    @FindBy(xpath = "//*[@id=\"BXP-APP\"]/header[1]/div/div[1]/div[2]/a[1]")
     WebElement loginButton;

    @FindBy(xpath="//input[@placeholder='Enter your email']")
     WebElement emailField;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
     WebElement ContinueButton;

    @FindBy(xpath="//input[@placeholder='Enter password']")
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
    public TrelloPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Login Methods
    public void loginButton() throws InterruptedException {
        loginButton.click();
    }

    public void emailField(String email)  {
        emailField.sendKeys(email);
        ContinueButton.submit();
    }

    public void enterPassword(String password){
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
        // Locate the input field for the list name
        listNameField.sendKeys(listName);
        Thread.sleep(3000);

        addList.click();
        Thread.sleep(1000);
    }


public void addCardToList(String cardName,String targetListName) throws InterruptedException {
    addCardButton.click();
    // Locate the input field for the list name
cardTextField.sendKeys(cardName);
Thread.sleep(3000);
  addList.click();
    Thread.sleep(3000);
    Actions action = new Actions(driver);
 //   action.dragAndDrop(cardElement, targetListElement).perform();
}




//  Card Creation Methods
// public void addCardToList(String listName, String cardName) {
//     addCardButton.click();
//
//        cardTextField.sendKeys(cardName);
//        addCardToList.click();
////
    }

    // Card Move Methods (Drag and Drop)
 //   public void moveCardToList(String cardName, String moveToList) {
    //    new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(card, targetList).perform();
//    cardField.click();
//    move.click();
//    listScroll.click();
//    positionScroll.click();
//    moveButton.click();
//    CloseIcon.click();

 //   }

//    // Board Closing and Deletion Methods
//    public void closeBoard() {
//        WebElement boardMenu = driver.findElement(By.xpath("//button[@aria-label='Show menu']"));
//        Boards.click();
//        WebElement closeBoardButton = driver.findElement(By.xpath("//span[text()='More']"));
//        closeBoardButton.click();
//        WebElement closeBoardConfirmButton = driver.findElement(By.xpath("//span[text()='Close Board']"));
//        closeBoardConfirmButton.click();
//
//    }
//
//    public void deleteBoard() {
//        WebElement deleteButton = driver.findElement(By.xpath("//span[text()='Delete Board']"));
//        deleteButton.click();
//        WebElement confirmDeleteButton = driver.findElement(By.xpath("//button[@class='js-confirm full negate']"));
//        confirmDeleteButton.click();
//
//    }