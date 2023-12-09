package com.ecohub.utils;

/**
 * Klasė skirta parinkti kelio tipą pagal aplinkinių langelių tipus
 */
public class RoadTypeSelect {
    
    /** 
     * Parenka kelio tipa pagal aplinkiniu langeliu tipus
     * @param x
     * @param y
     * @return int
     */
    public static int roadType(int x, int y) {
        int roadType = Constants.STRAIGHT_1;
        
        if (y > 0 && x > 0 && y < Constants.UI.SIM_GRID_SQUARE_V_COUNT - 1 && x < Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1) {
            if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CROSS;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.T_2;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.T_1;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.T_3;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.T_4;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.STRAIGHT_1;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.STRAIGHT_2;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CORNER_1;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.CORNER_2;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CORNER_3;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.CORNER_4;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.END_1;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS) {
                roadType = Constants.END_2;
            } else if (SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.END_3;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.END_4;
            }
        }
        else if (y == 0 && x > 0 && x < Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1) {
            if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.T_4;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.CORNER_2;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CORNER_1;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.STRAIGHT_2;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.END_1;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.END_4;
            } else if (SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.END_3;
            }
        }
        else if (y == Constants.UI.SIM_GRID_SQUARE_V_COUNT - 1 && x > 0 && x < Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1) {
            if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.T_3;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.CORNER_4;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CORNER_3;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.STRAIGHT_2;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS) {
                roadType = Constants.END_2;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.END_4;
            } else if (SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.END_3;
            }
        }
        else if (y > 0 && x == 0 && y < Constants.UI.SIM_GRID_SQUARE_V_COUNT - 1 && x < Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1) {
            if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.T_1;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.STRAIGHT_1;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CORNER_3;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CORNER_1;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS) {
                roadType = Constants.END_2;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.END_1;
            } else if (SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.END_3;
            }
        }
        else if (y > 0 && x == Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1 && y < Constants.UI.SIM_GRID_SQUARE_V_COUNT - 1) {
            if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.T_2;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.STRAIGHT_1;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.CORNER_4;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.CORNER_2;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS) {
                roadType = Constants.END_2;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.END_1;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.END_4;
            }
        }
        else if (y == 0 && x == 0) {
            if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CORNER_1;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.END_1;
            } else if (SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.END_3;
            }
        }
        else if (y == 0 && x == Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1) {
            if (SandboxData.mapData[y + 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.CORNER_2;
            } else if (SandboxData.mapData[y + 1][x] > Constants.GRASS) {
                roadType = Constants.END_1;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.END_4;
            }
        }
        else if (y == Constants.UI.SIM_GRID_SQUARE_V_COUNT - 1 && x == 0) {
            if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.CORNER_3;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS) {
                roadType = Constants.END_2;
            } else if (SandboxData.mapData[y][x + 1] > Constants.GRASS) {
                roadType = Constants.END_3;
            }
        }
        else if (y == Constants.UI.SIM_GRID_SQUARE_V_COUNT - 1 && x == Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1) {
            if (SandboxData.mapData[y - 1][x] > Constants.GRASS && SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.CORNER_4;
            } else if (SandboxData.mapData[y - 1][x] > Constants.GRASS) {
                roadType = Constants.END_2;
            } else if (SandboxData.mapData[y][x - 1] > Constants.GRASS) {
                roadType = Constants.END_4;
            }
        }

        return roadType;
    }
}
