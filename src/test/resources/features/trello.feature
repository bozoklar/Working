@smoke @regression

Feature:  Testing Login Functionality of Trello Website

  Scenario:Navigation to the website & Happy Path for trello Login
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

    |  Sign up for Trello  | UI Automation           |
    |  Get key and token   | Writing Test Scenarios  |
    |  Build a collection  |       null              |
    |   Working on Task    |       null              |


#    And User move the cards as follows:
#  | Card Name              | Move To |
#  | Sign up for Trello     | Done   |
#  | Get key and token      | Testing|
#  | Build a collection     | Doing  |
#
#  Scenario:Happy Path for the board closing and deletion
#    And The board should be closed and deleted
