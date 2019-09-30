/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

/**
 *
 * @author jcn0852
 */
public class TrafficLight {

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public enum Light {
        RED, YELLOW, GREEN
    };

    public Light currentLight = Light.RED;

    
}
