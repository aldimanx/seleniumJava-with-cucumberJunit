
Feature: i want to create booking Hotel

	Background: user at hotel order main menu
    Given user at hotel section
		
  Scenario Outline: cari tiket Hotel
    When user input location <location> detail
    When user input tanggal <dateA> and <dateB>
    And click cari hotel button
    Then user will be directed to hotel list<location>
    
    Examples:
  	  | location  | guest						 | dateA 					 | 		dateB 			 |
      | Jakarta 	| 1 Kamar • 3 Tamu | 27 Agustus 2023 | 28 Agustus 2023 |
      | Bandung	| 1 Kamar • 4 Tamu | 27 Agustus 2023 | 28 Agustus 2023 |
    
  #Scenario: cek pencarian terakhir
    #When user click pencarian terakhir
    #Then user will see pop up pencarian terakhir