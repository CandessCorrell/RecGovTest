Feature: Lookup a location
  In order to make sure that the locations I retrieve with my search are relatively close to the places being searched

  Scenario: Looking up the place 'Yosemite'
    Given the user is on the Recs.gov home page
    When the user looks up the place 'Yosemite'
    Then they should see at least a park 'Near Yosemite National Park, CA'

  Scenario: Looking up the place 'Grand Canyon'
    Given the user is on the Recs.gov home page
    When the user looks up the place 'Grand Canyon'
    Then they should see at least a park 'Near Grand Canyon, AZ'