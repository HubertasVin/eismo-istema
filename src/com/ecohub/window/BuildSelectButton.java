package com.ecohub.window;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.ecohub.utils.Constants;
import com.ecohub.utils.DrawSelectEnum;

/**
 * Klasė skirta kurti mygtukus, kurie yra naudojami pasirinkti statomą objektą
 */
public class BuildSelectButton extends JButton {
    public BuildSelectButton(int x, int y, DrawSelectEnum tileType, Icon icon, JButton[] switchBtns) {
        this.setIcon(icon);
        this.setBounds(x, y, Constants.UI.BTN_DS_WIDTH, Constants.UI.BTN_DS_HEIGHT);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.addActionListener(e -> {
            DrawSelectEnum.tileType = tileType;
            for (JButton button : switchBtns) {
                // button.setBackground(new Color(240, 226, 231));
                button.setBorder(BorderFactory.createEmptyBorder());
            }
            this.setBorder(new LineBorder(Color.RED, 3, true));
            // this.setBackground(new Color(108, 174, 117));
        });
    }
}
