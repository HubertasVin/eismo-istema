package com.ecohub.exceptions;

import com.ecohub.road_users.RoadUser;

/**
 * Klasė skirta iškelti išimtį, kai eismo dalyvis yra už ribų
 */
public class OutOfBoundsException extends SimulationException {
    public RoadUser roadUser;

    /**
     * Sukuria išimties objektą
     * @param roadUser - eismo dalyvis
     */
    public OutOfBoundsException(RoadUser roadUser) {
        super("Road user is out of bounds: " + roadUser + ". X=" + roadUser.getX() + ", Y=" + roadUser.getY() + ".");
    }
}
