Feature: feature

  Background:
    Given user landed webpage

  Scenario: User added favs to favorites
    When user at favorites page
    And user click stars to add favorites
    Then papers are added to favorites

  Scenario: User delete favs from favorites
    When user at favorites page
    And user click stars to delete from favorites
    Then papers are deleted from favorites
