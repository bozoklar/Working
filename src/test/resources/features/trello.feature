@smoke @regression

Feature:  Testing Login Functionality of Trello Website

  Background:Navigation to the website & Happy Path for trello Login
    Given User navigates to "https://www.trello.com/"
    When User click logIn button
    Then User provides "email" and click continue button
    Then User provides "password" click log button

  Scenario:Happy Path for a board creation and lists creation inside these board
    When User create a board named "VaultN"
    Then User create lists "Lists" the "VaultN" board

 Scenario:Happy Path for the cards' creation and migration between the lists
   When  User add the following cards to the "Todo" list:
     | Card Name              |
     | Sign up for Trello     |
     | Get key and token      |
     | Build a collection     |

    Then User move the cards as follows:
  | Card Name              | Move To |
  | Sign up for Trello     | Done   |
  | Get key and token      | Testing|
  | Build a collection     | Doing  |

  Scenario:Happy Path for the board closing and deletion
    And The board should be closed and deleted
