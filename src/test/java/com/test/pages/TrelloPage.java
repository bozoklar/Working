package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloPage {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private WebElement loginButton;

    @FindBy(id = "user")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//button[@aria-label='Create new board']")
    private WebElement createBoardButton;

    @FindBy(xpath = "//input[@placeholder='Board title']")
    private WebElement boardTitleField;

    @FindBy(xpath = "//button[text()='Create Board']")
    private WebElement createBoardSubmitButton;

    @FindBy(xpath = "//textarea[@placeholder='Add a list title']")
    private WebElement listTitleField;

    @FindBy(xpath = "//div[@class='list-add-button']")
    private WebElement addListButton;

    @FindBy(xpath = "//div[@class='js-add-card']")
    private WebElement addCardButton;

    @FindBy(xpath = "//div[@class='card-composer-textarea']")
    private WebElement cardTextField;

    // Constructor
    public TrelloPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login Methods
    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickContinueButton() {
        emailField.submit();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginSubmitButton() {
        loginSubmitButton.click();
    }

    // Board Creation Methods
    public void createBoard(String boardName) {
        createBoardButton.click();
        boardTitleField.sendKeys(boardName);
        createBoardSubmitButton.click();
    }

    // List Creation Methods
    public void createList(String listName) {
        addListButton.click();
        listTitleField.sendKeys(listName);
        listTitleField.submit();
    }

    // Card Creation Methods
    public void addCard(String cardName, String listName) {
        WebElement list = driver.findElement(By.xpath("//div[contains(text(),'"+ listName +"')]"));
        list.click();
        login.click();
        cardTextField.sendKeys(cardName);
        cardTextField.submit();
    }

    // Card Move Methods (Drag and Drop)
    public void moveCardToList(String cardName, String moveToList) {
        WebElement card = driver.findElement(By.xpath("//span[text()='" + cardName + "']"));
        WebElement targetList = driver.findElement(By.xpath("//div[text()='" + moveToList + "']"));
        new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(card, targetList).perform();
    }

    // Board Closing and Deletion Methods
    public void closeBoard() {
        WebElement boardMenu = driver.findElement(By.xpath("//button[@aria-label='Show menu']"));
        boardMenu.click();
        WebElement closeBoardButton = driver.findElement(By.xpath("//span[text()='More']"));
        closeBoardButton.click();
        WebElement closeBoardConfirmButton = driver.findElement(By.xpath("//span[text()='Close Board']"));
        closeBoardConfirmButton.click();
    }

    public void deleteBoard() {
        WebElement deleteButton = driver.findElement(By.xpath("//span[text()='Delete Board']"));
        deleteButton.click();
        WebElement confirmDeleteButton = driver.findElement(By.xpath("//button[@class='js-confirm full negate']"));
        confirmDeleteButton.click();
    }
}