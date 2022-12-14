Feature:  Citizenship with scenario Outline

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly
    And Navigate to Citizenship page

    Scenario Outline: Citizenship create and
      When User a Citizenship name as "<CitizenShipName>" short name as "<shortName>"
      Then Success message should be displayed

      When User a Citizenship name as "<CitizenShipName>" short name as "<shortName>"
      Then Already exist message should be displayed
      And Click on close button

      When User delete the "<CitizenShipName>"
      Then Success message should be displayed

      Examples:
        |CitizenShipName | shortName |
        |Nairobi999       | nameless979  |
        |Nairobi988       | nameless967 |
        |Nairobi991       | nameless954  |
