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
    public static void main(String[] args) {
        // TODO code application logic here
        TrafficLightProblem problem = new TrafficLightProblem();
        
        String input = "";
        Scanner scan = new Scanner(System.in);
        
        do {
            System.out.println(problem);
            
            System.out.println("Which light would you like to turn green?(1/2/exit)");
            input = scan.nextLine();
            
            int lightNumber = Integer.parseInt(input);
            
            TrafficLight chosenTrafficLight = null;
            
            if(lightNumber == 1)
                chosenTrafficLight = problem.tf1;
            else if(lightNumber == 2)
                chosenTrafficLight = problem.tf2;
            
            if(chosenTrafficLight != null)
                problem.turnGreen(chosenTrafficLight);
            
        } while(!input.equals("exit"));
    }
    
}
