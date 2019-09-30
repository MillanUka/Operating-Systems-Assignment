/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static task3.TrafficLight.ANSI_RESET;
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
            System.out.println(this);
            Thread.sleep(2500);
            
            tf.currentLight = Light.GREEN;
            semp.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(TrafficLightProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String toString() {
        String firstRedColour = "";
        String firstYellowColour = "";
        String firstGreenColour = "";

        String secondRedColour = "";
        String secondYellowColour = "";
        String secondGreenColour = "";

        switch (tf1.currentLight) {
            case RED:
                firstRedColour = TrafficLight.RED;
                break;
            case YELLOW:
                firstYellowColour = TrafficLight.YELLOW;
                break;
            case GREEN:
                firstGreenColour = TrafficLight.GREEN;
                break;
        }
        
        switch (tf2.currentLight) {
            case RED:
                secondRedColour = TrafficLight.RED;
                break;
            case YELLOW:
                secondYellowColour = TrafficLight.YELLOW;
                break;
            case GREEN:
                secondGreenColour = TrafficLight.GREEN;
                break;
        }
        String string = "";

        string += "\n"
                + "      []               []\n"
                + "    [____]           [____]\n"
                + ".----'  '----.   .----'  '----.\n"
                + "|    .==.    |   |    .==.    |   \n"
                + "|   /" + firstRedColour + "####" + ANSI_RESET + "\\   |   |   /" + secondRedColour + "####" + ANSI_RESET + "\\   |\n"
                + "|   \\" + firstRedColour + "####" + ANSI_RESET + "/   |   |   \\" + secondRedColour + "####" + ANSI_RESET + "/   |\n"
                + "|    `\"\"`    |   |    `\"\"`    |\n"
                + "|    .==.    |   |    .==.    |\n"
                + "|   /" + firstYellowColour + "####" + ANSI_RESET + "\\   |   |   /" + secondYellowColour + "####" + ANSI_RESET + "\\   |\n"
                + "|   \\" + firstYellowColour + "####" + ANSI_RESET + "/   |   |   \\" + secondYellowColour + "####" + ANSI_RESET + "/   |\n"
                + "|    `\"\"`    |   |    `\"\"`    |\n"
                + "|    .==.    |   |    .==.    |\n"
                + "|   /" + firstGreenColour + "####" + ANSI_RESET + "\\   |   |   /" + secondGreenColour + "####" + ANSI_RESET + "\\   |\n"
                + "|   \\" + firstGreenColour + "####" + ANSI_RESET + "/   |   |   \\" + secondGreenColour + "####" + ANSI_RESET + "/   |\n"
                + "|    `\"\"`    |   |    `\"\"`    |\n"
                + "'--.______.--'   '--.______.--'";
        
        return string;
    }
}
