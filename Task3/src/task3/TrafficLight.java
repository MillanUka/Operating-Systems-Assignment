/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcn0852
 */
public class TrafficLight extends Thread {

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public enum Light {
        RED, YELLOW, GREEN
    };

    public Light currentLight = Light.RED;
    public boolean isRun = false;
    public Semaphore semp;
    public
            
    @Override
    public void run() {
        while(isRun) {
            turnGreen(Task3.problem);
            isRun =false;
        }
    }
    
    public void turnGreen(TrafficLightProblem problem) {
        try {
            semp.acquire();            
            currentLight = Light.GREEN;
            
            System.out.println(problem);
            Thread.sleep(2500);
            currentLight = Light.YELLOW;
            System.out.println(problem);
            Thread.sleep(2500);
            currentLight = Light.RED;
            semp.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(TrafficLightProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSemp(Semaphore semp) {
        this.semp = semp;
    }
}
