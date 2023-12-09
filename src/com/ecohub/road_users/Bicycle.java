package com.ecohub.road_users;

/**
 * Klasė sukuria dviratininką
 */
public class Bicycle extends RoadUser {
    /**
     * Sukuria dviratininko objektą
     * @param x
     * @param y
     */
    public Bicycle(int x, int y) {
        super("Bicycle", x, y, 64, 64);
        this.roadUserType = RoadUserEnum.BICYCLE;
    }
}
