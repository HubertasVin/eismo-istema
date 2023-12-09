package com.ecohub.road_users;

/**
 * Klasė skirta sukurti mašiną
 */
public class Car extends RoadUser {
    /**
     * Sukuria mašinos objektą
     * @param x - x koordinatė
     * @param y - y koordinatė
     */
    public Car(int x, int y) {
        super("Car", x, y, 64, 64);
        this.roadUserType = RoadUserEnum.CAR;
    }
}
