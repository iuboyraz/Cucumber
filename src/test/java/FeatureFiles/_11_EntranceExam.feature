#Senaryo :
#  Entrance Exams Formunun �al��mas�n� test ediniz
#  1 s�nav giri�i yap�p
#  sonras�nda silmesini yap�n�z

Feature: Exam functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create an Exam and Delete
    And Click on the element in the LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the DialogContent
      | addButton |

    And User sends the keys into the DialogBox
      | nameInput | Alicabbarexam01 |

    And Click on the element in the DialogContent
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in the DialogContent
      | saveButton |

    Then Success message should be displayed

    # Silme ekran�na ula�mak i�in tekrar navigate yap�ld�
    And Click on the element in the LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the DialogContent
      | searchAcademicPeriod |
      | academicPeriod1      |

    And User deletes the element from the DialogBox
      | Alicabbarexam01 |

    Then Success message should be displayed

