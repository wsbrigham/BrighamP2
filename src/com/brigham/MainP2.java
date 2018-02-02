package com.brigham;

/***************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROPGRAM TITLE: State Capitals Quiz (Quiz.java)
 * PROGRAM OBJECTIVE: To give a quiz of state capitals and report pass/fail status and issue a grade.
 ****************************************************************************************************/

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Random;

public class MainP2
{
    public static void main(String[] args)
    {
        QuizUI ui = new QuizUI();

        ui.run();
    }
}