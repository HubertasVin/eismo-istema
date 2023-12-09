package com.ecohub.road_users;

import java.io.Serializable;
import java.util.LinkedList;

import com.ecohub.exceptions.SimulationException;
import com.ecohub.utils.Constants;
import com.ecohub.utils.CordPair;

/**
 * Klasė, kuri suteikia bendro funkcionalumo visiems simuliacijos veikėjams
 */
public class RoadUser implements Serializable {
    protected int x, y;
    protected int prevX, prevY;
    protected int width, height;
    protected String name;
    protected RoadUserEnum roadUserType = RoadUserEnum.CAR;
    protected LinkedList<CordPair> currentPath = new LinkedList<>();
    protected boolean hasCompletedPath;
    protected int waitTimer;
    protected int textureRotate;

    /**
     * Sukuria simuliacijos eismo dalyvį
     */
    public RoadUser(String name, int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.prevX = x;
        this.prevY = y;
        this.width = width;
        this.height = height;
        this.name = name;
        this.hasCompletedPath = true;
        this.waitTimer = 3;
        this.textureRotate = 0;
    }

    
    /** 
     * Judina eismo dalyvį
     * @param x
     * @param y
     * @throws SimulationException
     */
    public void move(int x, int y) throws SimulationException {
        if (x >= 0 && x <= Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1 && y >= 0 && y <= Constants.UI.SIM_GRID_SQUARE_V_COUNT - 1) {
            this.prevX = this.x;
            this.prevY = this.y;
            this.x = x;
            this.y = y;

            if (this.y > this.prevY)
                this.textureRotate = 0;
            else if (this.y < this.prevY)
                this.textureRotate = 180;
            else if (this.x > this.prevX)
                this.textureRotate = 270;
            else if (this.x < this.prevX)
                this.textureRotate = 90;
            else
                this.textureRotate = 0;
        }
        else
            throw new SimulationException("Out of bounds");
    }
    
    
    /** 
     * grąžina eismo dalyvio tipą
     * @return RoadUserEnum
     */
    public RoadUserEnum getType() {
        return roadUserType;
    }
    
    /** 
     * gražina eismo dalyvio x koordinatę
     * @return int
     */
    public int getX() {
        return this.x;
    }
    
    /** 
     * gražina eismo dalyvio y koordinatę
     * @return int
     */
    public int getY() {
        return this.y;
    }
    
    /** 
     * nustato eismo dalyvio vardą
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
     * grąžina eismo dalyvio vardą
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /** 
     * nustato eismo dalyvio kelią, kurį jis keliauja
     * @param path
     */
    public void setCurrentPath(LinkedList<CordPair> path) {
        this.currentPath = path;
        this.hasCompletedPath = false;
    }
    
    /** 
     * grąžina eismo dalyvio kelią, kurį jis keliauja
     * @return LinkedList<CordPair>
     */
    public LinkedList<CordPair> getCurrentPath() {
        return currentPath;
    }
    
    /** 
     * grąžina ar eismo dalyvis yra pasiekęs savo tikslą
     * @return boolean
     */
    public boolean getHasCompletedPath() {
        return hasCompletedPath;
    }
    
    /** 
     * nustato ar eismo dalyvis yra pasiekęs savo tikslą
     * @param hasCompletedPath
     */
    public void setHasCompletedPath(boolean hasCompletedPath) {
        this.hasCompletedPath = hasCompletedPath;
    }
    
    /** 
     * nustato laiką, kurį eismo dalyvis praleis stovėdamas
     * @param waitTimer
     */
    public void setWaitTimer(int waitTimer) {
        this.waitTimer = waitTimer;
    }
    
    /** 
     * grąžina laiką, kurį eismo dalyvis praleis stovėdamas
     * @return int
     */
    public int getWaitTimer() {
        return waitTimer;
    }
    
    /** 
     * grąžina eismo dalyvio buvusią x koordinatę
     * @return int
     */
    public int getPrevX() {
        return prevX;
    }
    
    /** 
     * grąžina eismo dalyvio buvusią y koordinatę
     * @return int
     */
    public int getPrevY() {
        return prevY;
    }
    
    /** 
     * grąžina eismo dalyvio textūros pasukimo kampą
     * @return int
     */
    public int getTextureRotate() {
        return textureRotate;
    }

    
    /** 
     * Klonuoja eismo dalyvį
     * @return Object
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        RoadUser roadUser = (RoadUser) super.clone();
        // roadUser.movementHandler = (MovementHandler) this.movementHandler.clone();
        return roadUser;
    }

    
    /** 
     * Grąžina eismo dalyvio informaciją String formatu
     * @return String
     */
    public String toString() {
        return roadUserType + " at (" + this.x + "," + this.y + ") ";
    }
}
