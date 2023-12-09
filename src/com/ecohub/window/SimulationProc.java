package com.ecohub.window;

import java.util.LinkedList;

import com.ecohub.exceptions.SimulationException;
import com.ecohub.road_users.RoadUser;
import com.ecohub.utils.CordPair;
import com.ecohub.utils.PathFinder;
import com.ecohub.utils.SandboxData;

/**
 * Klasė skirta vykdyti simuliaciją
 */
public class SimulationProc implements Runnable {
    /**
     * Vykdo simuliaciją
     */
    @Override
    public void run() {
        SandboxData.isRunningSimulation = true;

        while (SandboxData.isRunningSimulation == true) {
            // System.out.println("Simulation running");
            for (RoadUser roadUser : SandboxData.roadUsers) {
                if (roadUser.getHasCompletedPath() == true) {
                    if (roadUser.getWaitTimer() == 3) {
                        LinkedList<CordPair> path = new LinkedList<>();
                        System.out.println("setting path");
                        path = PathFinder.findPath(new CordPair(roadUser.getX(), roadUser.getY()), PathFinder.randomRoadCordPair());
                        while (path == null) {
                            path = PathFinder.findPath(new CordPair(roadUser.getX(), roadUser.getY()), PathFinder.randomRoadCordPair());
                            System.out.println("Found path");
                        }
                        roadUser.setCurrentPath(path);
                        // path.forEach((cordPair) -> {
                        //     System.out.println("x: " + cordPair.x + " y: " + cordPair.y);
                        // });
                        roadUser.setWaitTimer(0);
                        continue;
                    }
                    else {
                        roadUser.setWaitTimer(roadUser.getWaitTimer() + 1);
                        System.out.println("waiting");
                        
                        continue;
                    }
                }
                else {
                    if (roadUser.getCurrentPath().isEmpty()) {
                        roadUser.setHasCompletedPath(true);
                        // SandboxData.isRunningSimulation = false;
                        break;
                    }
                    CordPair tempPair = roadUser.getCurrentPath().pop();
                    // System.out.println("x: " + tempPair.x + " y: " + tempPair.y);
                    // System.out.println("x: " + roadUser.getX() + " y: " + roadUser.getY());
                    try {
                        roadUser.move(tempPair.x, tempPair.y);
                    } catch (SimulationException e) {
                        e.printStackTrace();
                    }
    
                    /* try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } */
                    SandboxData.simulationPanel.repaint();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
