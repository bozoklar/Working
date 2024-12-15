@smoke @regression

Feature:  Testing Login Functionality of Trello Website

  Background:Navigation to the website & Happy Path for trello Login
    Given User navigates to "https://www.trello.com/"
    When User click logIn button
    Then User provides "aylinbozoklar@gmail.com" and click continue button
    Then User provides "12155407Ab" click log button

  Scenario:Happy Path for a board creation and lists creation inside this board
    When User create a board named "VaultN"
    Then User create multiple lists on the board
      | Backlog |
      | Todo    |
      | Doing   |
      | Testing |
      | Done    |

 Scenario:Happy Path for the cards' creation and migration between the lists
   When  User add the following cards to the "Todo" list:
     | Card Name              |
     | Sign up for Trello     |
     | Get key and token      |
     | Build a collection     |
     | Working on Task        |

   Then  User add the following cards to the "Backlog" list:
     | UI Automation              |
     | Writing Test Scenarios     |

    And User move the cards as follows:
  | Card Name              | Move To |
  | Sign up for Trello     | Done   |
  | Get key and token      | Testing|
  | Build a collection     | Doing  |

  Scenario:Happy Path for the board closing and deletion
    And The board should be closed and deleted
