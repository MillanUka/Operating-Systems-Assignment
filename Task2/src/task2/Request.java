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
 * Represents a request by a customer for a resource
 * @author jcn0852
 */
public class Request extends Thread {
    public int customerNo;
    public int resourceNo;
    public Banker banker;
    public boolean isRun = true;
    
    /**
     * 
     * @param customerNo The customer making the request
     * @param resourceNo The resource being requested
     * @param banker The Banker that handles the resources and the customers
     */
    public Request(int customerNo, int resourceNo, Banker banker) {
        this.customerNo = customerNo;
        this.resourceNo = resourceNo;
        this.banker = banker;
    }
    
    @Override
    public void run()
    {
        if(isRun) {
            Random rand = new Random();
            try {
                // Wait for a random time between 1 second and 5 seconds
                Thread.sleep(rand.nextInt(4000)+1000);

                //Release the resource. And give it back to the banker
                banker.releaseResource(customerNo, resourceNo);
                isRun = false;
                interrupt();
            } catch (InterruptedException ex) {
                Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
}
