/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcn0852
 */
public class Task2 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Inistiante the banker and a Random object
        Banker banker = new Banker();
        Random rand = new Random();
        
        while(true) {
            //Sleep for 300 milliseconds
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Make a random request for a random resource, with a random customer
            banker.requestResource(rand.nextInt(5), rand.nextInt(3));
        }
    }

}
