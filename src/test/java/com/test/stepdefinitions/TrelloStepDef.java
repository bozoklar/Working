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



    @Given("User navigates to {string}")
    public void user_navigates_to() {
        WebDriver driver= DriverHelper.getDriver();
       new TrelloPage(driver);
    }

    @When("User click logIn button")
    public void user_clicks_logIn_button() {
    }

    @Then("User provides {string} and click continue button")
    public void user_provides_email_and_click_continue_button() {
        TrelloPage.login(ConfigReader.readProperty("email");
    }

    @Then("User provides {string} click log button")
    public void user_provides_click_log_button(){
        TrelloPage.login(ConfigReader.readProperty("password"));

    }

    // Scenario 1: Board Creation and List Creation
    @When("I create a board named {string}")
    public void i_create_a_board_named(String VaultN) {
        TrelloPage.createBoard(VaultN);
    }

    @Then("User create lists {string} the {string} board")
    public void user_create_lists_the_board(String listNames, String VaultN) {
        String[] lists = listNames.split(", ");
        for (String list : lists) {
            TrelloPage.createList(list);
        }
    }

    // Scenario 2: Card Creation and Movement
    @When("I add the following cards to the {string} list:")
    public void i_add_the_following_cards_to_the_list(String listName, DataTable dataTable) {
        for (String cardName : dataTable.asList(String.class)) {
            TrelloPage.addCard(cardName, listName);
        }
    }

    @Then("User move the cards as follows:")
    public void user_move_the_cards_as_follows(DataTable dataTable) {
        for (java.util.List<String> row : dataTable.asLists()) {
            String cardName = row.get(0);
            String moveTo = row.get(1);
            TrelloPage.moveCardToList(cardName, moveTo);
        }
    }

    // Scenario 3: Board Closing and Deletion
    @Then("The board should be closed and deleted")
    public void the_board_should_be_closed_and_deleted() {
        TrelloPage.closeBoard();
        TrelloPage.deleteBoard();
    }
}