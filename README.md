# **_Blackjack Program_**

## **_Overview_**
This was a school project from my Java II class. The goal was to complete a Blackjack program with some enhancements. I could not locate the initial instructions and what were the enhancements. There was a brief explanation of the game of Blackjack. I received all the available points for this project.  

## **_How I accomplished this program_**

Before I could begin this project, I first had to have clear understanding the following: 
1. What are the overall rules for playing and winning at Blackjack?  
2. What were the rules around how dealers played Blackjack?
3. I then broke the project down into four distinct parts.

## **Four Parts** 

  ### A. Container Preparation
   * First, I made a mockup of the user screen and added any labels, buttons, graphics etc.  
   * Then I created a list of needed containers and variables 
   * Next, I created pseudocode for the needed variables and container items.  
   * Then I programmed my pseudocode to JGrasp and began testing for consistency. 
     - Cleared any syntax errors. 
     - Opened and closed window to ensure proper operation.
     - Minimized and maximized to ensure container structure remained intact.  
   * Finally debugged any runtime issues
    
  ### B. Game Preparation
   **_This portion of the project involved getting the game board set-up for player interaction. _** 
    
   **_Problems identified_**
     
   **Loading deck of cards and assigning value, suite, and number to each card.**
   * I used two arrays; one of those represents the deck of cards, 
   and the final was for any card that was used within the game.  
   * Created a function to look at string value for chosen card and return value for that card.
   * If statement to assign suite dependent upon which array location of the unique value.  
      
   **_Ensuring only unique cards are offered to player and dealer._** 
      
   *_Created function to set unique element within my program._* 
   * Do While loop to continue to choose a random element as long as control is not met.  
   * Nested within do while created for loop to traverse array of used elements.
   * Nested within for loop is an If else statement to analyze random and used elements 
     - _if found within the used element array it will choose a new element and repeat process._ 
     - _if not found in used element array the loop control is changed and returns unique element to game._
      
   #### **This will continue to run choosing random numbers until a unique number is achieved.**
      
  ### C. Game Function
  
  _This portion of the project was mainly bringing the previous two sections together to function upon user interaction with the game board._
  
  This was accomplished by creating a function that called the unique element function and assigned appropriate suite.
    Program then adjusts game board to reflect the unique card chosen for the player.  
      When the player is finished the game then progresses the dealers hand based on the rules established 
      for casino dealers in Las Vegas.  
        
    
  ### D. Scoring
  
  _This portion of the project involved analyzing game board after each interaction and make appropriate decisions about game continuation and conclusion._
  
  There were several functions that were needed to analyze/complete the following
   * Check player score to ensure they did not exceed 21.  
   * Analyze game board upon completion to decide winner.  
   * Track wins by both player and dealer. 

## Thoughts   
**_I really feel like this project is the best use of my overall skills as a programmer._**
1. _It combines the concepts of object orientations in the way that I built the program._ 
 * _Each section/function began with pseudocode, then written, finally tested and debugged before being added to the final product._ 
 * _This decreased my overall debugging time._  
2. _It features a firm understanding of decision making processes._ 
 * _Showcases several do...while, if...else, and for loops both seperately and nested to make many decisions throughout the game process._
3. _It has a robust container system that utilizes many different nested container types to ensure a clean look and consistent play while ensuring full_
_user interaction._    

**_I only had a week to work on three programs so there are several things I would have improved._**
1. _I feel like the container could be more polished offering animations and graphics for suites and cards._
2. _The Ace of any suite is solely worth 11 instead of either the normal 11 or 1._






