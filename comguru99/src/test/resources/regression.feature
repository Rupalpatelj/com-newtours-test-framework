Feature: Check Login functionalty
  As a user
  I am on Login page
  So i can login successfully

  @Sp
  Scenario: Login
    Given as a User I am on HomePage
    When I enter Username as "eastham"
    And I enter password as "eastham"
    And I click on "Sign-On"
    Then I can view "Flight Finder" page

  @regression
  Scenario Outline: Flight Search
    Given as a User I am on Flight Search Page
    When I select journey type "<type>"
    And I select passengers "<passengers>"
    And i select  Departing From "<Departing From>"
    And I select Arriving In> "<Arriving In>"
    And I select Service Class "<Service Class>"
    And I click on CONTINUE
    And I can view "Select flight page"
    And i click continue
    And i should navigate to book flight page to get the ticket

    And i enter customer firstname "<First Name>"
    |Name    |
    |sanvi   |
    |shrey   |
    And i enter customer lastname "<Last Name>"
    |Last name|
    |patel    |
    |patel    |
    And i enter customer card number "<Number>"
    And i enter customer address "<Address>"
    And i enter customer city "<City>"
    And i enter customer postal code "<Postal code>"
    And i select customer country "<Country>"
    And i click on secure purchase
    Then i should navigate to "Departing"

    Examples:
      | type       | passengers | Departing From | Arriving In | Service Class  | First Name|Last Name|Number|Address   |City    |Postal code|Country|
      | Round Trip | 2          | London         | New York    | Economy class  |Rupal      |Patel    |8765  |merseywalk|Northolt|ub5 6th    |UNITED KINGDOM|
      | One way  | 2          | London         | New York    | Economy class  |Sudeep      |Patel    |1234  |SouthEsk Road|East Ham|E7 8LL    |UNITED KINGDOM|
