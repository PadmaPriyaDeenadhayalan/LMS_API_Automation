#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: POST request
 
  @createNewBatch
  Scenario Outline: Create new Batch eithout header
  Given call the "url"/batches save endpoint
  When with out initialize the header send Post request with new Batch deatials from sheetname "<SheetName>" and rownumber <RowNumber> and request sent
  Then validatebnew batch ststus code
  Then Received response from the response body
  
  Examples: 
      | SheetName    | RowNumber | 
      | POST_BATCH   |     0     | 
  
  
  Scenario Outline: Create New Batch
   
   Given Call the "https://lms-backend-service.herokuapp.com/lms/batches" 
   When Set request Header with POSt Batch details from shetname "<SheetName>" and rownumber <RowNumber> and Sent POST HTTP request 
   Then Receive vaid HTTP response code 201 for Batch POST request
   And  The Response should fetch the detail of  Created New Batch 
 Examples: 
      | SheetName    | RowNumber | 
      | POST_BATCH   |     0     | 
      | POST_BATCH   |     1     | 
      | POST_BATCH   |     2     | 
      | POST_BATCH   |     3     | 
  		| POST_BATCH   |     4     | 
  		| POST_BATCH   |     5     | 
  		| POST_BATCH   |     6     | 
  		| POST_BATCH   |   	 7     | 
  		
  
  
  
  
 		
  
  
  
  