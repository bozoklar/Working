package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloPage {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
     WebElement loginButton;

    @FindBy(id = "user")
     WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
     WebElement ContinueButton;

    @FindBy(id = "password")
     WebElement passwordField;

    @FindBy(xpath = "//input[@name='login']")
     WebElement SubmitButton;

    @FindBy(xpath = "//button[@aria-label='Create new board']")
     WebElement createBoardButton;

    @FindBy(xpath = "//input[@placeholder='Board title']")
     WebElement boardTitleField;

    @FindBy(xpath = "//button[text()='Create Board']")
     WebElement createBoardSubmitButton;

    @FindBy(xpath = "//textarea[@placeholder='Add a list title']")
     WebElement listTitleField;

    @FindBy(xpath = "//div[@class='list-add-button']")
     WebElement addListButton;

    @FindBy(xpath = "//div[@class='js-add-card']")
     WebElement addCardButton;

    @FindBy(xpath = "//div[@class='card-composer-textarea']")
     WebElement cardTextField;

    // Constructor
    public TrelloPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login Methods
    public void loginButton(){
        loginButton.click();

    }
    public void emailField()  {
        emailField.sendKeys("aylibozoklar@gmail.com");
        ContinueButton.submit();
    }


    public void enterPassword(){
        passwordField.sendKeys("12155407Ab");
        SubmitButton.click();

    }

    // Board Creation Methods
    public void createBoard() {
        createBoardButton.click();
        boardTitleField.sendKeys("VaultN");
        createBoardSubmitButton.click();
    }

    // List Creation Methods
    public void createList(String listName)  {
        addListButton.click();
        listTitleField.sendKeys(listName);
        listTitleField.submit();

    }

    // Card Creation Methods
    public void addCard(String cardName, String listName)  {
        WebElement list = driver.findElement(By.xpath("//div[contains(text(),'"+ listName +"')]"));
        list.click();
        addListButton.click();
        cardTextField.sendKeys(cardName);
        addCardButton.submit();

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