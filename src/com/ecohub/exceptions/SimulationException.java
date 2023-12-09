package com.ecohub.exceptions;

/**
 * Klasė skirta iškelti išimtis
 */
public class SimulationException extends Exception{
    /**
     * Sukuria išimties objektą
     * @param message - išimties pranešimas
     */
    public SimulationException(String message) {
        super(message);
    }
}
