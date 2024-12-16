package com.test.stepdefinitions;

import com.test.pages.TrelloPage;
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
        Map<String,String>Todo=dataTable.asMap();
       String cardName= Todo.get("card Name");
        String listName= Todo.get("List Name");
        trelloPage.addCardToList(cardName);
        trelloPage.addCardToList(listName);

    }

//        @When("User create multiple cards on the list")
//        public void userCreateMultipleCardsOnTheList(List<List<String>> cardDetails) {
//            // Loop over the table and create cards for each row
//            for (List<String> cardName : ListName) {
//                String cardName = row.get(0);
//                String listName = row.get(1);
//                trelloPage.openList(listName); // Open the appropriate list
//                trelloPage.addCardTodo(cardName); // Add the card
//            }
//        }

//        @When("User create multiple cards on the {string} List")
//        public void user_create_multiple_cards_on_the_Todo_list(String listName, DataTable dataTable)
////            List<String> cardNames = dataTable.asList(String.class,String.class);
//
//            for (String cardName : cardNames) {
//                trelloPage.addCardToList("Todo", cardName);
//            }
//        }
//    }

            //   List<List<String>> rows = dataTable.asLists(String.class);
            // Iterate through each row and move the card to the target list
            //      for (List<String> row : rows) {
            //      String cardName = row.get(0);
            //      String targetList = row.get(1);
            //       trelloPage.moveCardToList(cardName, targetList);  // Move the card
            //   }

            //   Scenario 3: Board Closing and Deletion
            //   @Then("The board should be closed and deleted")
            //   public void the_board_should_be_closed_and_deleted() {
//        trelloPage.closeBoard();
//        trelloPage.deleteBoard();
        }
//    }


