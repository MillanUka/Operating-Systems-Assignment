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

    public final String RED = "\u001B[31m";
    public final String GREEN = "\u001B[32m";
    public final String YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public enum Light {
        RED, YELLOW, GREEN
    };

    public Light currentLight = Light.RED;

    @Override
    public String toString() {
        String redColour = "";
        String yellowColour = "";
        String greenColour = "";

        switch (currentLight) {
            case RED:
                redColour = RED;
                break;
            case YELLOW:
                yellowColour = YELLOW;
                break;
            case GREEN:
                greenColour = GREEN;
                break;
        }
        String string = "";

        string += "\n"
                + "                   []_\n"
                + "                 [____]\n"
                + "             .----'  '----.\n"
                + "             |    .==.    |\n"
                + "             |   /" + redColour + "####" + ANSI_RESET + "\\   |\n"
                + "             |   \\" + redColour + "####" + ANSI_RESET + "/   |\n"
                + "             |    `\"\"`    |\n"
                + "             |    .==.    |\n"
                + "             |   /" + yellowColour + "####" + ANSI_RESET + "\\   |\n"
                + "             |   \\" + yellowColour + "####" + ANSI_RESET + "/   |\n"
                + "             |    `\"\"`    |\n"
                + "             |    .==.    |\n"
                + "             |   /" + greenColour + "####" + ANSI_RESET + "\\   |\n"
                + "             |   \\" + greenColour + "####" + ANSI_RESET + "/   |\n"
                + "             |    `\"\"`    |\n"
                + "             '--.______.--'";
        return string;
    }
}
