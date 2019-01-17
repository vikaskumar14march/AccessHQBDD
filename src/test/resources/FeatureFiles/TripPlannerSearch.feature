@Tripplanner
Feature: Trip Planner Functionalality
  
 
Scenario: A trip request can be executed and results returned
     
Given Phileas is on the Home Page "https://transportnsw.info/trip" of Trip Planner Website
When he selects "North Sydney Station" station in From station
And he selects "Town Hall Station" station in To station
And he clicks Go Button
Then a list of trips should be provided