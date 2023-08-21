Feature: API Demos touch action
  Scenario: Drag and Drop
    Given App yuklensin
    And kullanici ana ekranda
    And kullanici API Demos butonuna tikladi
    Then kullanici API Demos ekraninda
    And kullanici Views butonuna tikladi
    Then kullanici Views ekraninda
    And kullanici Drag and Drop butonuna tikladi
    When kullanici birinci topu ikinci topun üstüne birakti
    Then kullanici dorduncu topu gordu