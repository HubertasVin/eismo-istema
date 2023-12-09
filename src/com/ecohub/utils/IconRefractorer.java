package com.ecohub.utils;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Klasė skirta koreguoti Icon objektus
 */
public class IconRefractorer {
    
    /** 
     * Pakeičia Icon dydį
     * @param icon
     * @param width
     * @param height
     * @return Icon
     */
    public static Icon IconResize(Icon icon, int width, int height) {
        Image img = ((ImageIcon) icon).getImage();
        Image newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}
