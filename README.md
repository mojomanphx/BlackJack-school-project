# **_BlackJack Program_**

## **_Overview_**
This was a school project from my Java II class.  

## **_How I accomplished this program_**

Before I could begin this project, I first had to have clear understanding the following: 
1. What are the overall rules for playing and winning at Blackjack.  
2. What were the rules around how dealers played Blackjack. 
3. I then broke the project down into four distinct parts, 

## **Four Parts** 

  ### a. Container Preparation
   * First I made a mock up of the user screen and added any labels, buttons, graphics etc.  
   * then I created a list of needed containers and variables 
   * Next I created pseudocode for the needed variables and container items.  
   * Then I programmed my psuedocode to JGrasp and began testing for consistency. 
     - Cleared any syntax errors. 
     - Opened and closed window to ensure proper operation.
     - Minimized and Maximized to ensure container structure remained in tact.  
   * Finally debugged any runtime issues
    
  ### b. Game Preparation
   **_This portion of the project involved getting the game board set-up for player interaction._** 
    
   **_Problems identified_**
     
   **Loading deck of cards and assigning value, suite and number to each card.**
   * I used three arrays; two of those were relational arrays to represent the four suites of cards, 
   and the final was for any card that was used within the game.  
   * Created a function to look at string value for choosen card and return value for that card.
      
   **_Ensuring only unique cards are offered to player and dealer._** 
      
   *_Created function to set unique element within my program._* 
   - do While loop to continue to choose a random element as long as control is not met.**  
   - nested within do while created for loop to traverse array of used elements.** 
   - nested within for loop is an If else statement to analyze random and used elements 
    *_if found within the used element array it will choose a new element and repeat process._ 
    *_if not found in used element array the loop control is changed and returns unique element to game._
      
   #### **This will continue to run choosing random numbers until a unique number is achieved.**
      
    _

  c. Game Function
  d. Player Scoring
