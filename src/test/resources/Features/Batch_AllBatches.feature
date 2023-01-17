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
Feature: Get all Batches, Get Batches by Id,Get Batches by Batch Name, 
Get Batches by Program Id, Create Batch, Update Batch by Id,Delete Batch by Id

@GetAllBatches
Scenario: Verify the list of Batches as a Response
    Given Call "url" endpoint
    When Get request for Batch is sent	
   Then Status Code should be "200 OK"	
   And The Response should fetch all the batches which includes Batch Id, Batch Name, Batch Description,Batch Status,Creation Time and Last Modified Time.
   

   

      
  



  
   
