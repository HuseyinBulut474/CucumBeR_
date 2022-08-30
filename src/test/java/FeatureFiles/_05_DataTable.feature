Feature: Datatable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

    Scenario: Create Country
      And Click on the element in the left Nav
        | setupOne  |
        | parameters|
        | countries |

      And Click on the element in the Dialog
        | addButton |

      And User sending the keys in Dialog content
        | nameInput | Nairobi47498 |
        | codeInput | nairobi987 |

      And Click on the element in the Dialog
        | saveButton |

      And Success message should be displayed

  Scenario: Create a Nationality
    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | nationalities |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | cloud791 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | cloud791 |

    And Success message should be displayed

  Scenario: Create a Fee, delete Fee
    And Click on the element in the fees
      | setupOne      |
      | parameters    |
      | fees          |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | Nairobi74509|
      | codeInput | 698747809   |
      |integrationCode |37009   |
      |priorityCode |    19709  |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | Nairobi7456 |

    And Success message should be displayed