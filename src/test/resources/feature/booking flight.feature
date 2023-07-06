Feature: i want to create booking flight

  Background: user at ticket order main menu
    Given user at flight section

  Scenario Outline: cari tiket pesawat
    When user input <passengers> order pesawat detail
    And click cari tiket button
    Then user will be directed to ticket list

    Examples: 
      | passengers | total    |
      |          1 | 1 Dewasa |
      |          2 | 2 Dewasa |
      |          3 | 3 Dewasa |

  Scenario: cek pesanan
    When user click cek pesanan
    Then user will be directed to cek pesanan form
