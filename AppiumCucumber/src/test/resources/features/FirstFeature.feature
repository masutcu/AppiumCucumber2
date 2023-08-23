@deneme
Feature: API Demos test
 Scenario Outline: Text box data gönderme
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici API Demos butonuna tikladi
    Then kullanici API Demos ekraninda
    And kullanici Preference butonuna tikladi
    Then kullanici Preference ekraninda
    And kullanici Preference dependencies tikladi
    And kullaici WiFi check box secmis olacak
    And kullanici WiFi Settings tikladi
    Then WiFi Settings popup geldi
    And kullanici "<text>" yazdi
    And kullanici ok butonuna tikladi
   Examples:
     | text  |
     | mali  |
     | sutcu |


