package com.test.stepdefinitions;

import com.test.pages.TrelloPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;


public class TrelloStepDef {

    WebDriver driver = DriverHelper.getDriver(); // Get WebDriver instance;
    TrelloPage trelloPage = new TrelloPage(driver); // Initialize TrelloPage;

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {

        driver.get(url); // Navigate to URL

    }

    @When("User click logIn button")
    public void user_clicks_logIn_button() throws InterruptedException {
        trelloPage.loginButton();
        Thread.sleep(1000);
    }

    @Then("User provides {string} and click continue button")
    public void user_provides_email_and_click_continue_button(String email) {
        trelloPage.emailField(email);
    }

    @Then("User provides {string} click log button")
    public void user_provides_click_log_button(String password) {
        trelloPage.enterPassword(password);

    }

    // Scenario 1: Board Creation and List Creation
    @When("User create a board named {string}")
    public void user_create_board(String boardName) throws InterruptedException {
        trelloPage.createBoard(boardName);

    }

    // Step to create multiple lists using a DataTable
    @Then("User create multiple lists on the board")
    public void user_creates_multiple_lists_on_the_board(DataTable dataTable) throws InterruptedException {
        // Extract list names from the DataTable
        List<String> listNames = dataTable.asList(String.class);

        // Create each list using TrelloPage object
        for (String listName : listNames) {
            trelloPage.createList(listName);  // Calls the method in the Page Object
        }
    }

    // Scenario 2: Card Creation and Movement
//    @When("User add the following cards to the {string} list:")
//    public void user_adds_the_following_cards_to_the_list(String listName, DataTable dataTable) {
//        for (String cardName : dataTable.asList(String.class)) {
//            trelloPage.addCard(cardName, listName);
//        }
//    }

//    @Then("User add the following cards to the {string} list:")
//    public void user_adds_the_following_cards_to_the_list(String listName, DataTable dataTable) {
//        for (String cardName : dataTable.asList(String.class)) {
//            trelloPage.addCard(cardName, listName);
//        }
//    }

//    @Then("User move the cards as follows:")
//    public void user_move_the_cards_as_follows(DataTable dataTable) {
//        for (java.util.List<String> row : dataTable.asLists()) {
//            String cardName = row.get(0);
//            String moveTo = row.get(1);
//            trelloPage.moveCardToList(cardName, moveTo);
//        }
//    }
//
//  //   Scenario 3: Board Closing and Deletion
//    @Then("The board should be closed and deleted")
//    public void the_board_should_be_closed_and_deleted() {
//        trelloPage.closeBoard();
//        trelloPage.deleteBoard();
    }

