/***************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROPGRAM TITLE: State Capitals Quiz (QuizUI.java)
 * PROGRAM OBJECTIVE: To give a quiz of state capitals and report pass/fail status and issue a grade.
 ****************************************************************************************************/

package com.brigham;

import javax.swing.JOptionPane;


public class QuizUI {
    // Variables/Fields
    private String theme = "State Capitals Quiz";                                 //variable for storing the theme of the quiz
    private String playerName = "";                                               //variable for storing the quiz taker's name
    private String playerAnswer = "";                                              //variable for storing the quiz taker's answer
    public String letterGrade = "";                                               //variable for storing the quiz taker's letter grade
    public double numericalGrade = 0;                                             //variable for storing the quiz taker's numerical/percent grade
    private int playAgain;                                                        //variable for storing the quiz taker's choice of weather or not they want to anser more questions
    private int totalQuestions = 0;                                               //variable for storing the number of questions that are asked
    private int numRight = 0;                                                      //variable for storing the number of correct anwers
    private int numWrong = 0;                                                      //variable for storing the number of incorrect answers
    private Quiz quiz = new Quiz();



    // Constructor(s)
     public QuizUI() {
    }

    // Methods
    public void run() {
        //display program header
        JOptionPane.showMessageDialog(null, "                               NAME:  William Brigham\n\n           PROGRAM TITLE:  " + theme + "\n\nPROGRAM OBJECTIVE:  To give a quiz of state"
                + " capitals and report pass/fail status and issue a grade\n\nClick OK to Continue", "Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);

        //display a message asking the user for their name
        playerName = JOptionPane.showInputDialog(null, "What's your name?  ", "Capitals Quiz", JOptionPane.QUESTION_MESSAGE);

        //display a message greeting the user and welcoming to the quiz
        JOptionPane.showMessageDialog(null, "Hello, " + playerName + ".\n\nWelcome to Guess the State Capital Quiz!\n\nClick OK to continue.\n\n", "Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);

        //display a message to the user on how to take the quiz
        JOptionPane.showMessageDialog(null, "Here's how to take the Quiz:\n\n1. You'll be asked what's the capital of a state and you can answer"
                + " in upper-case, lower-case, or any combination of upper and lower-case letters.\n\n2. You'll be informed if your answer is correct.  If your answer is incorrect, the correct answer"
                + "will be displayed"
                + "\n\n3. You'll then be asked if you want to try another question. If you choose not to try again, your average will be calculated and your grade"
                + " will be displayed.\n\nClick OK to continue.\n", "Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);

        quiz.shuffle();

        //start a do...while loop that continues to run until the user choose not to answer more questions
        do {
            //start a do...while loop that continues to run as long as the user doesn't input a value for the capital
            do {

                //shuffle the indices of the questions array once 20 questions have been asked
                if (totalQuestions == 20)
                {
                   quiz.shuffle();
                    totalQuestions = 0;
                }

                //display a message asking the user what the capital of a state is and store the answer in the 'playerAnswer' variable
                playerAnswer = JOptionPane.showInputDialog(null, quiz.getQuestion(), "Capitals Quiz", JOptionPane.QUESTION_MESSAGE);


                //check if the user input a value and if not, display an error
                if (playerAnswer.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error\n\nYou Didn't input an answer.\n", "Capitals Quiz", JOptionPane.ERROR_MESSAGE);
                }

            } while (playerAnswer.equals(""));



            //if the user got the correct answer, display a message stating they got the answer correct
            if (playerAnswer.equalsIgnoreCase(quiz.getAnswer()))
            {
                JOptionPane.showMessageDialog(null, "Correct!\n\nYou got the right answer.\n", "Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);

                //increment the number of questions correct
                numRight++;
            }



            //if the user got the incorrect answer, display a message stating the answer is incorrect and show the correct answer
            if (!playerAnswer.equalsIgnoreCase(quiz.getAnswer()))
            {
                JOptionPane.showMessageDialog(null, "Incorrect!\n\nThe correct answer is " + quiz.getAnswer() + "\n\n", "Capitals Quiz", JOptionPane.ERROR_MESSAGE);
                numWrong++;
            }

            //increment the number of games played
            totalQuestions++;

            quiz.setTotalQuestions(totalQuestions);

            //display a message asking the user if they would like to answer another question.
            playAgain = JOptionPane.showConfirmDialog(null, "Do you want to try another question?", "Capitals Quiz", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            //if the user chooses 'Yes', restart the loop
        } while (playAgain == 0);

        Quiz quiz = new Quiz(totalQuestions, numRight);

        //call quiz class to calculate
        quiz.calculateNumericalGrade();

        quiz.calculateLetterGrade();

        String letterGrade = Quiz.letterGrade;

        //Display quiz summary and letter grade to the user
        JOptionPane.showMessageDialog(null, "              Tester's Name:    " + playerName + "\n\nTotal Questions Asked:    " + totalQuestions + "\n\n          Correct Answers:    "
                + numRight + "\n\n        Incorrect Answers:    " + numWrong + "\n\n                Percent Grade:    " + /*formatter.format*/(Quiz.numericalGrade) + "%\n\n                    Letter Grade:    "
                + Quiz.letterGrade + "\n", "Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);

        //display a good bye message
        JOptionPane.showMessageDialog(null, "Hope you enjoyed the quiz.\n\nGoodbye.", "Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);
    }
}