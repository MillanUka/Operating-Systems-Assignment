/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import task3.TrafficLight.Light;

/**
 *
 * @author jcn0852
 */
public class TrafficLightProblem {
    public TrafficLight tf1;
    public TrafficLight tf2;
    public Semaphore semp;
    
    public TrafficLightProblem() {
        tf1 = new TrafficLight();
        tf2 = new TrafficLight();
        semp = new Semaphore(1);
    }
    
    public void turnGreen(TrafficLight tf) {
        try {
            semp.acquire();
            
            Thread.sleep(2500);
            tf.currentLight = Light.YELLOW;
            Thread.sleep(2500);
            
            tf.currentLight = Light.GREEN;
            semp.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(TrafficLightProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
