/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L2;

import java.util.Iterator;
import java.util.LinkedList;

public class AirFieldSimulator_2 {
    private static final double CHANCE_OF_START_OR_LANDING  = 0.05;
    private static final int    LANDING_OR_STARTING_TIME    = 20;
    private static final int    SIM_YEARS                   = 10;
    private static final int    MINUTES_PER_ITERATION       = 5;
    
    private static double maxStartWaitTime                  = 0;
    private static double maxLandWaitTime                   = 0;
    private static double avgStartWaitTime                  = 0;
    private static double avgLandWaitTime                   = 0;
    private static double totStartWaitTime                  = 0;
    private static double totLandWaitTime                   = 0;
    private static int started                              = 0;
    private static int landed                               = 0;
    private static Plane activePlane                        = null;
    private static int iterations; 
    private static QueueCircularArr<Plane> landingQueue;
    private static QueueCircularArr<Plane> startingQueue;
    private static int time                                = 0;
    
    private enum PlaneState {
        STARTING , LANDING;
    }
    
    private class Plane {
        int timeStampQueueTime;
        int timeStampWorkTime;
        PlaneState type;
        
        Plane(PlaneState planeState) {
            this.timeStampQueueTime = time;
            this.timeStampWorkTime = time;
            this.type = planeState;
            
            // Add to proper queue
            if (planeState == PlaneState.LANDING) {
                landingQueue.offer(this);
            } else {
                startingQueue.offer(this);
            }
        }
        
        void touchQueueTime() {
            timeStampQueueTime = time;
        }
        
        void touchWorkTime() {
            timeStampWorkTime = time;
        }
        
        int getQueueTime() {
            return time - timeStampQueueTime;
        }
        
        int getWorkTime() {
            return time - timeStampWorkTime;
        }
    }
    
    private AirFieldSimulator_2() {
        landingQueue = new QueueCircularArr<>();
        startingQueue = new QueueCircularArr<>();
    }
    
    static void simulate() {
        AirFieldSimulator_2 sim = new AirFieldSimulator_2();
        System.out.println("Simulator configurations............ ");
        System.out.println("Number of years..................... " + SIM_YEARS);
        System.out.println("Number of days...................... " +  SIM_YEARS*365);
        System.out.println("Number of hours..................... " +  SIM_YEARS*365*24);
        System.out.println("Number of minutes................... " +  SIM_YEARS*365*24*60);
        iterations = SIM_YEARS*365*24*60/MINUTES_PER_ITERATION;
        for (int i = 0; i <iterations; i++) {
            sim.runSimulation(i);
        }
        System.out.println(".................................... ");
        System.out.println("Results............................. ");
        System.out.println("Landed planes....................... " + landed);
        System.out.println("Started planes...................... " + started);
        System.out.println("Total starting queue time........... " + totStartWaitTime);
        System.out.println("Total landing queue time............ " + totLandWaitTime);
        System.out.println("Average start queue time............ " + (double) totStartWaitTime/started);
        System.out.println("Average landing queue time.......... " + (double) totLandWaitTime/landed);
        System.out.println("Record starting delay............... " + maxStartWaitTime);
        System.out.println("Record landing delay................ " + maxLandWaitTime);
    }
    
    private void runSimulation(int i) {
        
   
        
        if (randomCondition()) {
            newLandingPlane();
        }
        if (randomCondition()) {
            newStartingPlane();
        }
        
        if (activePlane == null) {
            activePlane = getNewActivePlane();
        } 
        else {
            if (activePlane.getWorkTime() >= LANDING_OR_STARTING_TIME) {
                activePlane = getNewActivePlane();    
            } 
        }    
        time += MINUTES_PER_ITERATION;
    }

    private Plane getNewActivePlane() {
        Plane plane = null;
        if (landingQueue.size() > 0) {
            plane = landingQueue.poll();
            // Handle statistics
            plane.touchWorkTime();
            int waitTime = plane.getQueueTime();
            totLandWaitTime += waitTime;
            if (waitTime > maxLandWaitTime) {
                maxLandWaitTime = waitTime;
            }
            landed++;
        } else if (startingQueue.size() > 0){
            plane = startingQueue.poll();
            // Handle statistics
            plane.touchWorkTime();
            int waitTime = plane.getQueueTime();
            totStartWaitTime += waitTime;
            if (waitTime > maxStartWaitTime) {
                maxStartWaitTime = waitTime;
            }
            started++;
        }
        return plane;
    }

    private void newStartingPlane() {
        Plane plane  = new Plane(PlaneState.STARTING);
    }
    
    private void newLandingPlane() {
        Plane plane  = new Plane(PlaneState.LANDING);
    }

    private static boolean randomCondition() {
        return Math.random() < CHANCE_OF_START_OR_LANDING;
    }
}
