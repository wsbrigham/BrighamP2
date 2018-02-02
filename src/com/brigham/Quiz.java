/***************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROPGRAM TITLE: State Capitals Quiz (Quiz.java)
 * PROGRAM OBJECTIVE: To give a quiz of state capitals and report pass/fail status and issue a grade.
 ****************************************************************************************************/

package com.brigham;

import java.text.DecimalFormat;
import java.util.Random;

public class Quiz
{
    public static String letterGrade = "";                                              //variable for storing the quiz taker's letter grade
    public static double numericalGrade = 0;                                            //variable for storing the quiz taker's numerical/percent grade
    private int totalQuestions;                                               //variable for storing the number of questions that are asked
    private int numRight;                                                     //variable for storing the number of correct answers


    // Constructor(s)
     Quiz(int totalQuestions, int numRight)
    {
        this.totalQuestions = totalQuestions;
        this.numRight = numRight;
    }

    public double getNumericalGrade()
    {
        return numericalGrade;
    }

    public String getLetterGrade()
    {
        return letterGrade;
    }

    public void calculate ()
    {
        //calculate the numerical grade
        numericalGrade = ((double) numRight / (double) totalQuestions) * 100;

        //calculate letter grade
        //if the numerical grade is greater than or equal to 91, set 'letterGrade' to "A"*
        if(numericalGrade >= 91)
        {
            letterGrade = "A";
        }

        //if the numerical grade is greater than or equal to 81 and less than or equal to 90, set 'letterGrade' to "B"
        if(numericalGrade >= 81 && numericalGrade <= 90)
        {
            letterGrade = "B";
        }

        //if the numerical grade is greater than or equal to 71 and less than or equal to 80, set 'letterGrade' to "C"
        if(numericalGrade >= 71 && numericalGrade <= 80)
        {
            letterGrade = "C";
        }

        //if the numerical grade is greater than or equal to 61 and less than or equal to 70, set 'letterGrade' to "D"
        if(numericalGrade >= 61 && numericalGrade <= 70)
        {
            letterGrade = "D";
        }

        //if the numerical grade is less than 60, set 'letterGrade to "F"
        if(numericalGrade < 61)
        {
            letterGrade = "F";
        }
    }
}