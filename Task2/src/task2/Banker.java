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

    //There are 3 customer and 5 resources
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

        //Set all the elements in the available array to 20. This means that all available resources of all resource is 20
        for (int i = 0; i < available.length; ++i) {
            available[i] = 20;
        }

        //Set the maximum allocated resources of every customer to a random number between 1 and 20(The availabilty)
        //The max doesn't neccessary need to be random. We just did to showcase the banker algoritm
        for (int i = 0; i < customerNo; ++i) {
            for (int j = 0; j < resourceNo; ++j) {
                max[i][j] = rand.nextInt(20)+1;
            }
        }
    }
    
    /**
     * This method is control the request for a resource from a particular customer
     * @param customerNo The number of the customer making the request
     * @param resourceNo The number of the resource that the customer is requesting
     */
    public synchronized void requestResource(int customerNo, int resourceNo) {
        //Checking if the customer request meet the criteria
        if (rule(customerNo, resourceNo)) {
            //add one to the reserved for that customer and resource. To show that it is reserved
            //also minus from the available as the resource is reserved for the customer
            // We then generate the request and start the thread for the request.
            ++reserved[customerNo][resourceNo];
            --available[resourceNo];
            Request res = new Request(customerNo, resourceNo, this);
            res.start();
        } else { // If the rules are not meet display a message
            System.out.println("Customer " + (customerNo+1) + " cannot make this request. The max allowed is " + max[customerNo][resourceNo] + " for resource " + resourceNo + ". There is " + available[resourceNo] + " available of this resource");
        }
            
    }

    /**
     * Control the release of the resource
     * @param customerNo The customer that is doesn't require the resource anymore
     * @param resourceNo The resource of the customer that is to be returned to the banker
     */
    public synchronized void releaseResource(int customerNo, int resourceNo) {
        //minus one from reserved as the customer doesn't need it no more
        --reserved[customerNo][resourceNo];
        ++available[resourceNo];
        
        //Display the current availability of the resources.
        System.out.println("R1\tR2\tR3");
        System.out.println(available[0]+"\t"+available[1]+"\t"+available[2]+"\n");
    }

    /**
     * This method check if the customer's request is valid and can be made
     * @param customerNo The customer making the request
     * @param resourceNo THe resource that is being requested
     * @return a boolean indicating whether or not they meet the rule requirements
     */
    private synchronized boolean rule(int customerNo, int resourceNo) {
        int numberOfAvailable = available[resourceNo];
        int maxNumber = max[customerNo][resourceNo];
        int reservedResource = reserved[customerNo][resourceNo];

        // If availabilty of the resource is more than 0. We then check the max
        if (numberOfAvailable > 0) {
            //Checking if the customer current allocated resources is less or equal to the max that they are allowed.
            //If they do then they meet all requirements
            if (reservedResource <= maxNumber) {
                return true;
            }
        }
        
        //If they don't meet the requirements
        return false;
    }
}
