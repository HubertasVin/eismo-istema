package com.ecohub.utils;

import java.util.ArrayList;
import java.util.Timer;

import com.ecohub.road_users.RoadUser;
import com.ecohub.road_users.RoadUserEnum;
import com.ecohub.window.SidePanel;
import com.ecohub.window.SimulationPanel;

/**
 * Klasė skirta saugoti duomenis, kurie yra bendri visoms klasėms
 */
public class SandboxData {
    public static ArrayList<RoadUser> roadUsers = new ArrayList<RoadUser>();
    public static int mapData[][] = new int[Constants.UI.SIM_GRID_SQUARE_V_COUNT][Constants.UI.SIM_GRID_SQUARE_H_COUNT];
    public static SimulationPanel simulationPanel = new SimulationPanel();
    public static SidePanel sidePanel = new SidePanel();
    public static Timer timer = new Timer();
    public static boolean isRunningTimer = true;
    public static boolean isRunningSimulation = false;
    public static RoadUserEnum selectRoadUserEnum = RoadUserEnum.CAR;
}
