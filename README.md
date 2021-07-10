# **_BlackJack Program_**

## _Overview_
This was a school project from my Java II class.  

##**_How I accomplished this program_**

Before I could begin this project, I first had to have clear understanding the following: 
1. What are the overall rules for playing and winning at Blackjack.  
2. What were the rules around how dealers played Blackjack. 

I then broke the whole program into four distinct parts. 
  ### a. Container Preparation
    * First I made a mock up of the user screen and added any labels, buttons, graphics etc.  
    * then I created a list of needed containers and variables that would be needed 
    * After that I created pseudocode for the needed variables and container items.  
    * I transferred my psuedocode to JGrasp and began testing for consistency.  
      - Opened and closed window to ensure proper operation.
      - Minimized and Maximized to ensure container structure remained in tact.  
    * Finally debugged any issues
    
  ### b. Game Preparation
    _This portion of the project involved getting the game board set-up for player interaction._  
    #### **Problems identified**
    _Loading deck of cards and assigning value, suite and number to each card._
      **I used three arrays; two relational arrays to represent the four suites of cards, and the final was for any card that was used within the game.**  
      **Created a function to look at string value for choosen card and return value for that card.**  
    _Ensuring only unique cards are offered to player and dealer._ 
      **Created function to set unique element within my program.**  
          **- do While loop to continue to choose a random element as long as control is not met.**  
          **- nested within do while created for loop to traverse array of used elements.** 
          **- nested within for loop is an If else statement to analyze random and used elements 
            ** if found within the used element it will choose a new element and repeat process.  
            ** if not found in used element array the loop control is changed and returns unique element to game.**
      
      **This will continue to run choosing random numbers
      
    _

  c. Game Function
  d. Player Scoring