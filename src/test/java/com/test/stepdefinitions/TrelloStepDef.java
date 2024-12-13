package com.test.stepdefinitions;

import com.test.pages.TrelloPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class TrelloStepDef {

    WebDriver driver;
    TrelloPage trelloPage;

    @Given("User navigates to {string}")
    public void user_navigates_to() {
        driver = DriverHelper.getDriver(); // Get WebDriver instance
        driver.get("https://trello.com/"); // Navigate to URL
        trelloPage = new TrelloPage(driver); // Initialize TrelloPage
    }

    @When("User click logIn button")
    public void user_clicks_logIn_button() {
        trelloPage.loginButton();
    }

    @Then("User provides {string} and click continue button")
    public void user_provides_email_and_click_continue_button() {
        trelloPage.emailField();
    }

    @Then("User provides {string} click log button")
    public void user_provides_click_log_button(){
        trelloPage.enterPassword();

    }
    // Scenario 1: Board Creation and List Creation
    @Then("User creates a board and adds lists {string}")
    public void user_creates_board_and_adds_lists(String listNames) {
        // Create lists from comma-separated values
        trelloPage.createBoard();
        String[] lists = listNames.split(",");
        for (String list : lists) {
            trelloPage.createList(list); // Call TrelloPage to create each list
        }
    }

    // Scenario 2: Card Creation and Movement
    @When("I add the following cards to the {string} list:")
    public void i_add_the_following_cards_to_the_list(String listName, DataTable dataTable) {
        for (String cardName : dataTable.asList(String.class)) {
            trelloPage.addCard(cardName, listName);
        }
    }

    @Then("User move the cards as follows:")
    public void user_move_the_cards_as_follows(DataTable dataTable) {
        for (java.util.List<String> row : dataTable.asLists()) {
            String cardName = row.get(0);
            String moveTo = row.get(1);
            trelloPage.moveCardToList(cardName, moveTo);
        }
    }

    // Scenario 3: Board Closing and Deletion
    @Then("The board should be closed and deleted")
    public void the_board_should_be_closed_and_deleted() {
        trelloPage.closeBoard();
        trelloPage.deleteBoard();
    }
}