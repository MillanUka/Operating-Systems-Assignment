/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import java.util.Random;

/**
 *
 * @author jcn0852
 */
public class Banker {

    int customerNo = 5;
    int resourceNo = 3;

    //how many resources are already allocated to each customer
    int[][] reserved = new int[customerNo][resourceNo];
    //maximum how many resources each customer can request for
    int[][] max = new int[customerNo][resourceNo];
    //currently available resources
    int[] available = new int[resourceNo]; //set availability of all resources to 20 

    public Banker() {

        Random rand = new Random();

        for (int i = 0; i < available.length; ++i) {
            available[i] = 20;
        }

        for (int i = 0; i < customerNo; ++i) {
            for (int j = 0; j < resourceNo; ++j) {
                max[i][j] = rand.nextInt(20);
            }
        }
    }

    public void requestResource(int customerNo, int resourceNo) {
        if (rule(customerNo, resourceNo)) {
            ++reserved[customerNo][resourceNo];
            --available[resourceNo];
            Request res = new Request(customerNo, resourceNo, this);
            res.start();
        } else {
            System.out.println("This resource is busy please wait...");
        }
            
    }

    public void releaseResource(int customerNo, int resourceNo) {
        --reserved[customerNo][resourceNo];
        ++available[resourceNo];
        
        System.out.println("R1\tR2\tR3");
        System.out.println(available[0]+"\t"+available[1]+"\t"+available[2]+"\n");
    }

    private boolean rule(int customerNo, int resourceNo) {
        int numberOfAvailable = available[resourceNo];
        int maxNumber = max[customerNo][resourceNo];
        int resservedResource = reserved[customerNo][resourceNo];

        if (numberOfAvailable > 0) {
            if (resservedResource <= maxNumber) {
                return true;
            }
        }

        return false;
    }
}
