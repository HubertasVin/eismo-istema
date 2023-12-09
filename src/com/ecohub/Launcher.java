package com.ecohub;

import java.io.IOException;

import com.ecohub.exceptions.OutOfBoundsException;
import com.ecohub.window.WindowFrame;

/**
 * Klasė, kuri paleidžia programą
 */
public class Launcher {
    
    /** 
     * Main metodas
     * @param args
     * @throws OutOfBoundsException
     * @throws CloneNotSupportedException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws OutOfBoundsException, CloneNotSupportedException, IOException, ClassNotFoundException {
        new WindowFrame();
    }
}