/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcn0852
 */
public class Task3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instaniate the two traffic lights. And create the Traffic Light Problem
        TrafficLight tf1 = new TrafficLight();
        TrafficLight tf2 = new TrafficLight();
        TrafficLightProblem problem = new TrafficLightProblem(tf1, tf2);

        String input;
        Scanner scan = new Scanner(System.in);
        // This loop handles all the input and output
        do {
            //Print the problem. WIth the two traffic lights. It in their current state
            System.out.println(problem);

            System.out.println("Which light would you like to turn green?(1/2/exit)");
            input = scan.nextLine();
            try {
                //Parse the input as an int
                int lightNumber = Integer.parseInt(input);
                TrafficLight chosenTrafficLight = null;

                if (lightNumber == 1) {
                    chosenTrafficLight = new TrafficLight();
                    problem.tf1 = chosenTrafficLight;
                } else if (lightNumber == 2) {
                    chosenTrafficLight = new TrafficLight();
                    problem.tf2 = chosenTrafficLight;
                }
                
                if (chosenTrafficLight != null) {
                    chosenTrafficLight.setSemp(problem.semp);
                    chosenTrafficLight.setProblem(problem);
                    
                    chosenTrafficLight.isRun = true;
                    chosenTrafficLight.start();

                }
            } catch (NumberFormatException ex) {}

        } while (!input.equals("exit"));
    }
}
