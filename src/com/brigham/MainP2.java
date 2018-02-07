/***********************************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROGRAM TITLE: State Capitals Quiz (MainP2.java)
 * CLASS OBJECTIVE: To drive the Quiz and QuizUI classes
 **********************************************************************************************************************/

package com.brigham;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Random;

//**********************************************************************************************************************
//
public class MainP2
{
    public static void main(String[] args) {

    //Create a new Quiz instance called 'ui'
        QuizUI ui = new QuizUI();

    //Run the new UI instance
        ui.run();
    }
}