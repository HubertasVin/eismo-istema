package com.ecohub.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Klasė skirta rasti kelią iš pradinės padėties į pabaiginę padėtį.
 */
public class PathFinder {
    
    /** 
     * Atranda kelią iš pradinės padėties į pabaiginę padėtį.
     * 
     * @param startPos
     * @param EndPos
     * @return LinkedList<CordPair>
     */
    public static LinkedList<CordPair> findPath(CordPair startPos, CordPair EndPos) {
        int startX = startPos.x, startY = startPos.y;
        int endX = EndPos.x, endY = EndPos.y;
        int Dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int IndivMap[][] = new int[Constants.UI.SIM_GRID_SQUARE_V_COUNT][];
    
        LinkedList<CordPair> path = new LinkedList<>();
    
        for (int i = 0; i < Constants.UI.SIM_GRID_SQUARE_V_COUNT; ++i) {
            IndivMap[i] = Arrays.copyOf(SandboxData.mapData[i], Constants.UI.SIM_GRID_SQUARE_H_COUNT);
        }
        Stack<CordPair> stack = new Stack<>();  // Use Stack instead of Queue
        stack.push(new CordPair(startX, startY));  // Use push() instead of add()
        
        System.out.println("startX: " + startX + " startY: " + startY);
        while (!stack.isEmpty()) {  // Use isEmpty() instead of isEmpty() == false
            CordPair p = stack.peek();  // Use peek() instead of peek()
            // System.out.println("x: " + p.x + " y: " + p.y);
            stack.pop();  // Use pop() instead of remove()
    
            IndivMap[p.y][p.x] = -1;
            path.add(new CordPair(p.x, p.y));
            System.out.println("x: " + p.x + " y: " + p.y);
            if (p.x == endX && p.y == endY) {
                return path;
            }
            
            for (int i = 0; i < 4; ++i) {
                int x = p.x + Dir[i][0];
                int y = p.y + Dir[i][1];
    
                if (x >= 0 && x < Constants.UI.SIM_GRID_SQUARE_H_COUNT && y >= 0 && y < Constants.UI.SIM_GRID_SQUARE_V_COUNT && IndivMap[y][x] > Constants.GRASS && IndivMap[y][x] <= Constants.T_4) {
                    if (x == endX && y == endY) {
                        /* path.forEach((cordPair) -> {
                            System.out.println("x: " + cordPair.x + " y: " + cordPair.y);
                        }); */
                        return path;
                    }
                    if (IndivMap[y][x] >= Constants.END_1 && IndivMap[y][x] <= Constants.END_4) {
                        System.out.println("Vyksta apkarpymas. x: " + x + " y: " + y);
                        CordPair tempPair = path.getLast();
                        path = new LinkedList<>();
                        path.add(tempPair);
                        continue;
                    }
                    // path.add(new CordPair(x, y));
                    stack.push(new CordPair(x, y));  // Use push() instead of add()
                }
            }
        }
        return null;
    }
    

    
    /** 
     * Sugeneruoja atsitiktinę padėtį žemėlapyje.
     * @return CordPair
     */
    public static CordPair randomRoadCordPair() {
        int x = (int) (Math.random() * Constants.UI.SIM_GRID_SQUARE_H_COUNT);
        int y = (int) (Math.random() * Constants.UI.SIM_GRID_SQUARE_V_COUNT);
        while (SandboxData.mapData[y][x] <= Constants.GRASS || SandboxData.mapData[y][x] > Constants.T_4) {
            x = (int) (Math.random() * Constants.UI.SIM_GRID_SQUARE_H_COUNT);
            y = (int) (Math.random() * Constants.UI.SIM_GRID_SQUARE_V_COUNT);
        }
        return new CordPair(x, y);
    }
}
