package com.ecohub.application_essentials;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.ecohub.road_users.*;

/**
 * Klasė užkrauna duomenis iš failo
 */
public class LoadData implements Runnable {
    private String fileName;
    private ArrayList<RoadUser> roadUsers;
    private int mapData[][];

    /**
     * Sukuria užkrovimo objektą
     * @param fileName
     */
    public LoadData(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Užkrauna duomenis iš failo
     */
    @Override
    @SuppressWarnings("unchecked")
    public void run() {
        File file = new File(fileName);
        if (file.length() != 0) {
            try {
                FileInputStream fin = new FileInputStream(fileName);
                ObjectInputStream oin = new ObjectInputStream(fin);
                
                roadUsers = (ArrayList<RoadUser>) oin.readObject();
                mapData = (int[][]) oin.readObject();
                fin.close();
                oin.close();
                System.out.println("Loaded road users from save file.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Save file is empty.");
        }
    }

    
    /** 
     * @return ArrayList<RoadUser>
     */
    public ArrayList<RoadUser> getRoadUsers() {
        return roadUsers;
    }

    
    /** 
     * @return int[][]
     */
    public int[][] getMapData() {
        return mapData;
    }
}
