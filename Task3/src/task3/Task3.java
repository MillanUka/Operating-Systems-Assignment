/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.util.Scanner;

/**
 *
 * @author jcn0852
 */
public class Task3 {

    /**
     * @param args the command line arguments
     */
    static TrafficLightProblem problem; 
    public static void main(String[] args) {
        // TODO code application logic here
        TrafficLight tf1 = new TrafficLight();
        TrafficLight tf2 = new TrafficLight();
        
        problem = new TrafficLightProblem(tf1, tf2);
        
        tf1.setSemp(problem.semp);
        tf2.setSemp(problem.semp);
        
        tf1.start();
        tf2.start();
        
        String input = "";
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println(problem);

            System.out.println("Which light would you like to turn green?(1/2/exit)");
            input = scan.nextLine();

            try {
                int lightNumber = Integer.parseInt(input);
                TrafficLight chosenTrafficLight = null;

                if (lightNumber == 1) {
                    chosenTrafficLight = tf1;
                } else if (lightNumber == 2) {
                    chosenTrafficLight = tf2;
                }

                if (chosenTrafficLight != null) {
                    problem.turnGreen(chosenTrafficLight);
                    chosenTrafficLight.isRun = true;
                    chosenTrafficLight.run();
                }
            } catch (NumberFormatException ex) {

            }

        } while (!input.equals("exit"));
    }
}
