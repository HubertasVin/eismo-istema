package com.ecohub.application_essentials;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ecohub.road_users.RoadUser;

/**
 * Klasė saugo duomenis į failą
 */
public class SaveData implements Runnable {
    private String fileName;
    private ArrayList<RoadUser> roadUsers;
    private int[][] mapData;

    /**
     * Sukuria saugojimo objektą
     * @param fileName
     * @param roadUsers
     * @param mapData
     */
    public SaveData(String fileName, ArrayList<RoadUser> roadUsers, int[][] mapData) {
        this.fileName = fileName;
        this.roadUsers = roadUsers;
        this.mapData = mapData;
    }

    /**
     * Saugo duomenis į failą
     */
    @Override
    public void run() {
        try {
            System.out.println("Saugojimas pradetas");
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream dout = new ObjectOutputStream(fout);
            dout.writeObject(roadUsers);
            dout.writeObject(mapData);
            fout.close();
            dout.close();
            System.out.println("Saved users to a save file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
