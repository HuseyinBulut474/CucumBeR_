Feature: Datatable Employee

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create a Fee, delete Fee
    And Click on the element in the fees
      | humanResources |
      | employees      |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | firstName  | <FirstName>  |
      | lastName   | <LastName>   |
      | middleName | <MiddleName> |

    And Click on the element in the Form Content
      | dateOfBirth       |
      | dateOfBirthOption |
      | gender            |
      | genderOption      |

    And User sending the keys in Dialog content
      | employeeID     | <EmployeeId> |
      | documentNumber | <document>   |

    And Click on the element in the Form Content
      | documentType   |
      | personalOption |

    And Click on the element in the Form Content
      | contact |

    And User sending the keys in Dialog content
      | country | <count> |

    And Click on the element in the Form Content
      | India |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And Click on the element in the Dialog
      | deleteButton |
      | deleteOption |

    And Success message should be displayed

    Examples:
      | FirstName | LastName | MiddleName | EmployeeId | document | count |
      | Fatma     | Bulut    | Helin      | 099        | no34     | India |


