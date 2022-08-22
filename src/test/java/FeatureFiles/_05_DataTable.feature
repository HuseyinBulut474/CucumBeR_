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
        | nameInput | Nairobi474 |
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
      | nameInput | cloud747362 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | cloud74736 |

    And Success message should be displayed