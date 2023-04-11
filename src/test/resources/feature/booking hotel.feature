
Feature: i want to create booking Hotel

	Background: user at hotel order main menu
    Given user at hotel section
		
  Scenario Outline: cari tiket Hotel
    When user input location <location> & guest <people> detail
    And click cari hotel button
    Then user will be directed to hotel list<location>
    
    Examples:
    | location  | guest |
      | Jakarta | 2 |
      | Bandung | 3 |
    
  Scenario: cek pencarian terakhir
    When user click pencarian terakhir
    Then user will see pop up pencarian terakhir
