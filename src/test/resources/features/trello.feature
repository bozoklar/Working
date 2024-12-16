@smoke @regression

Feature:  Testing Login Functionality of Trello Website

  Background:Navigation to the website & Happy Path for trello Login
    Given User navigates to "https://www.trello.com/"
    When User click logIn button
    Then User provides "aylinbozoklar@gmail.com" and click continue button
    Then User provides "12155407Ab" click log button
    When User create a board named "VaultN"
    Then User create multiple lists on the board
      | Backlog |
      | Todo    |
      | Doing   |
      | Testing |
      | Done    |

   When User create multiple cards on the List
     |    card Name               | List Name |
     | Sign up for Trello         |   Todo    |
     | Get key and token          |   Todo    |
     | Build a collection         |   Todo    |
     | Working on Task            |   Todo    |
     | UI Automation              |  Backlog  |
     | Writing Test Scenarios     |  Backlog  |

#
#    And User move the cards as follows:
#  | Card Name              | Move To |
#  | Sign up for Trello     | Done   |
#  | Get key and token      | Testing|
#  | Build a collection     | Doing  |
#
#  Scenario:Happy Path for the board closing and deletion
#    And The board should be closed and deleted
