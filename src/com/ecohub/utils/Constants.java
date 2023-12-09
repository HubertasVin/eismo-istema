package com.ecohub.utils;

/**
 * Klasė, sauganti konstantas, kurios naudojamos simuliacijoje.
 */
public class Constants {
    // Tile name constants
    public static final int GRASS = 0;
    public static final int STRAIGHT_1 = 1;
    public static final int STRAIGHT_2 = 2;
    public static final int CORNER_1 = 3;
    public static final int CORNER_2 = 4;
    public static final int CORNER_3 = 5;
    public static final int CORNER_4 = 6;
    public static final int CROSS = 7;
    public static final int END_1 = 8;
    public static final int END_2 = 9;
    public static final int END_3 = 10;
    public static final int END_4 = 11;
    public static final int T_1 = 12;
    public static final int T_2 = 13;
    public static final int T_3 = 14;
    public static final int T_4 = 15;

    /**
     * Klasė, sauganti konstantas, kurios naudojamos simuliacijoje.
     */
    public static class UI {
        // Window
        public static final int WND_WIDTH = 1000;
        public static final int WND_HEIGHT = 1000;
        
        // Side panel
        public static final int SID_WIDTH = 400;
        public static final int SID_HEIGHT = WND_HEIGHT;

        // Error panel
        public static final int ERR_WIDTH = SID_WIDTH;
        public static final int ERR_HEIGHT = 70;
        
        // Simulation panel
        public static final int SIM_WIDTH = WND_WIDTH - SID_WIDTH;
        public static final int SIM_HEIGHT = WND_HEIGHT;
        public static final int SIM_GRID_SQUARE_H_COUNT = 26;
        public static final int SIM_GRID_SQUARE_V_COUNT = (SIM_HEIGHT - 34) / (SIM_WIDTH / SIM_GRID_SQUARE_H_COUNT);

        // Tile
        public static final int TIL_SIZE = SIM_WIDTH / SIM_GRID_SQUARE_H_COUNT;

        // Buttons
        public static final int BTN_WIDTH = 65;
        public static final int BTN_HEIGHT = 20;
        public static final int BTN_SAVE_X = 5;
        public static final int BTN_SAVE_Y = 5;
        public static final int BTN_LOAD_X = BTN_SAVE_X + BTN_WIDTH + 5;
        public static final int BTN_LOAD_Y = 5;

        // Draw switch buttons
        public static final int BTN_DS_WIDTH = 30;
        public static final int BTN_DS_HEIGHT = 30;
        public static final int BTN_DS_X = SID_WIDTH / 2 - BTN_DS_WIDTH - 5;
        public static final int BTN_DS_START_Y = 30 + BTN_HEIGHT + 20;
    }

    /**
     * Klasė, sauganti konstantas, kurios naudojamos simuliacijoje.
     */
    public static class IMG {
        // RoadUser textures
        public static final String ENT_CAR = "res/entities/car.png";
        public static final String ENT_BICYCLE = "res/entities/bicycle.png";

        // Road textures
        public static final String RD_CORNER_1 = "res/roads/RoadTexture_Corner_01.png";
        public static final String RD_CORNER_2 = "res/roads/RoadTexture_Corner_02.png";
        public static final String RD_CORNER_3 = "res/roads/RoadTexture_Corner_03.png";
        public static final String RD_CORNER_4 = "res/roads/RoadTexture_Corner_04.png";
        public static final String RD_CROSS = "res/roads/RoadTexture_Cross.png";
        public static final String RD_STRAIGHT_1 = "res/roads/RoadTexture_Straight_01.png";
        public static final String RD_STRAIGHT_2 = "res/roads/RoadTexture_Straight_02.png";
        public static final String RD_END_1 = "res/roads/RoadTexture_End_01.png";
        public static final String RD_END_2 = "res/roads/RoadTexture_End_02.png";
        public static final String RD_END_3 = "res/roads/RoadTexture_End_03.png";
        public static final String RD_END_4 = "res/roads/RoadTexture_End_04.png";
        public static final String RD_T_1 = "res/roads/RoadTexture_T_01.png";
        public static final String RD_T_2 = "res/roads/RoadTexture_T_02.png";
        public static final String RD_T_3 = "res/roads/RoadTexture_T_03.png";
        public static final String RD_T_4 = "res/roads/RoadTexture_T_04.png";

        // Random tile textures
        public static final String TIL_GRASS = "res/roads/RoadTexture_Grass.png";
    }
}
