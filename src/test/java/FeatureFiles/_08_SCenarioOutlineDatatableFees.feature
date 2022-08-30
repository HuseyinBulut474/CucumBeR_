Feature: Datatable Fee

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create a Fee, delete Fee
    And Click on the element in the fees
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput       | <ExamName>          |
      | codeInput       | <CodeInputOption>   |
      | integrationCode | <integrationOption> |
      | priorityCode    | <priorityOption>    |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | <ExamName> |

    And Success message should be displayed
    Examples:
      | ExamName    | CodeInputOption | integrationOption | priorityOption |
      | Nairobi1248 | 067945250       | 7847911           | 9495           |
      | Nairobi1207 | 067845100       | 7847643           | 6814           |
      | Nairobi1226 | 069845129       | 7847587           | 7043           |
      | Nairobi1215 | 079843234       | 7847494           | 2402           |