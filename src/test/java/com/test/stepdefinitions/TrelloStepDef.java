package com.test.stepdefinitions;

import com.test.pages.TrelloPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;


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

    // Board Creation and List Creation
    @When("User create a board named {string}")
    public void user_create_board(String boardName) throws InterruptedException {
        trelloPage.createBoard(boardName);

    }

    // Step to create multiple lists using a DataTable
    @Then("User create multiple lists on the board")
    public void user_create_multiple_lists_on_the_board(DataTable dataTable) throws InterruptedException {
        // Extract list names from the DataTable
        List<String> listNames = dataTable.asList(String.class);

        // Create each list using TrelloPage object
        for (String listName : listNames) {
            trelloPage.createList(listName);  // Calls the method in the Page Object
        }
    }

    @When("User create multiple cards on the List")
    public void user_create_multiple_cards_on_the_list(DataTable dataTable) throws InterruptedException {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> row : rows) {
            String todo = row.get(0);
            String backlog = row.get(1);
            trelloPage.addCardToList(backlog);
            trelloPage.addCardToList(todo);

        }
    }

    @When("User move the cards as follows:")
    public void user_move_the_cards_as_follows(DataTable dataTable) throws InterruptedException {
        // Iterate through each row and move the card to the target list
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        // Loop through each row in the DataTable
        for (Map<String, String> row : rows) {
            String cardName = row.get("card Name");
            String targetList = row.get("Target List");

            // Call the method to move the card to the target list
            //      trelloPage.moveCardToList(cardName, targetList);

        }
    }
//    @And("The board should be closed and deleted")
//    public void the_board_should_be_closed_and_deleted() {
//            trelloPage.closeBoard();
//            trelloPage.deleteBoard();
//        }
    }




