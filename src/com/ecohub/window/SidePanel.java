package com.ecohub.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.ecohub.application_essentials.LoadData;
import com.ecohub.application_essentials.SaveData;
import com.ecohub.utils.Constants;
import com.ecohub.utils.DrawSelectEnum;
import com.ecohub.utils.IconRefractorer;
import com.ecohub.utils.SandboxData;

/**
 * Klasė skirta kurti šoninį langą
 */
public class SidePanel extends JPanel {
    private LoadData loadData = new LoadData("save.dat");
    protected ErrorPanel errorPanel = new ErrorPanel();

    /**
     * Sukuria šoninio lango objektą
     */
    public SidePanel() {

        this.setPreferredSize(new Dimension(Constants.UI.SID_WIDTH, Constants.UI.SID_HEIGHT));
        this.setLayout(null);
        Thread simulationThread = new Thread(new SimulationProc());

        JButton saveButton = new JButton();
        saveButton.setBounds(Constants.UI.BTN_SAVE_X, Constants.UI.BTN_SAVE_Y, Constants.UI.BTN_WIDTH, Constants.UI.BTN_HEIGHT);
        saveButton.addActionListener(e -> {
            SaveData saveData = new SaveData("save.dat", SandboxData.roadUsers, SandboxData.mapData);
            Thread saveThread = new Thread(saveData);
            saveThread.start();
            try {
                saveThread.join(); // Wait for the thread to finish
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            saveThread.interrupt();
        });

        JButton loadButton = new JButton();
        loadButton.setBounds(Constants.UI.BTN_LOAD_X, Constants.UI.BTN_LOAD_Y, Constants.UI.BTN_WIDTH, Constants.UI.BTN_HEIGHT);
        loadButton.addActionListener(e -> {
            Thread loadThread = new Thread(loadData);
            loadThread.start();
            try {
                loadThread.join(); // Wait for the thread to finish
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            loadThread.interrupt();
            SandboxData.roadUsers = loadData.getRoadUsers();
            SandboxData.mapData = loadData.getMapData();
            
            SandboxData.simulationPanel.removeAll();
            SandboxData.simulationPanel.revalidate();
            SandboxData.simulationPanel.repaint();
        });

        JButton startButton = new JButton("Start");
        startButton.setBounds(Constants.UI.BTN_LOAD_X + Constants.UI.BTN_WIDTH + 5, Constants.UI.BTN_LOAD_Y, Constants.UI.BTN_WIDTH, Constants.UI.BTN_HEIGHT);
        startButton.addActionListener(e -> {
            if (simulationThread.isAlive()) {
                simulationThread.interrupt();
            }
            simulationThread.start();
        });

        JButton switchBtnArray[] = new JButton[4];
        Icon switchBtnIconArray[] = new Icon[4];
        {
        switchBtnIconArray[0] = IconRefractorer.IconResize(new ImageIcon(Constants.IMG.ENT_CAR), Constants.UI.BTN_DS_WIDTH, Constants.UI.BTN_DS_HEIGHT);
        switchBtnIconArray[1] = IconRefractorer.IconResize(new ImageIcon(Constants.IMG.ENT_BICYCLE), Constants.UI.BTN_DS_WIDTH, Constants.UI.BTN_DS_HEIGHT);
        switchBtnIconArray[2] = IconRefractorer.IconResize(new ImageIcon(Constants.IMG.TIL_GRASS), Constants.UI.BTN_DS_WIDTH, Constants.UI.BTN_DS_HEIGHT);
        switchBtnIconArray[3] = IconRefractorer.IconResize(new ImageIcon(Constants.IMG.RD_STRAIGHT_1), Constants.UI.BTN_DS_WIDTH, Constants.UI.BTN_DS_HEIGHT);
        }
        {
        switchBtnArray[0] = new BuildSelectButton(5, Constants.UI.BTN_DS_START_Y, DrawSelectEnum.CAR, switchBtnIconArray[0], switchBtnArray);
        switchBtnArray[0].setBorder(new LineBorder(Color.RED, 3, true));
        DrawSelectEnum.tileType = DrawSelectEnum.CAR;
        switchBtnArray[1] = new BuildSelectButton(5, Constants.UI.BTN_DS_START_Y + Constants.UI.BTN_DS_HEIGHT + 5, DrawSelectEnum.BICYCLE, switchBtnIconArray[1], switchBtnArray);
        switchBtnArray[2] = new BuildSelectButton(5, Constants.UI.BTN_DS_START_Y + (Constants.UI.BTN_DS_HEIGHT + 5) * 2, DrawSelectEnum.GRASS, switchBtnIconArray[2], switchBtnArray);
        switchBtnArray[3] = new BuildSelectButton(5, Constants.UI.BTN_DS_START_Y + (Constants.UI.BTN_DS_HEIGHT + 5) * 3, DrawSelectEnum.ROAD, switchBtnIconArray[3], switchBtnArray);
        }

        // JPanel errorPanel = new JPanel();
        // JLabel errorText = new JLabel();
        
        // errorPanel.setVisible(true);

        this.setBackground(new Color(63, 132, 229));
        loadButton.setText("Load");
        saveButton.setText("Save");
        this.add(errorPanel);
        this.add(saveButton);
        this.add(loadButton);
        this.add(startButton);
        for (JButton switchBtn : switchBtnArray) {
            this.add(switchBtn);
        }
    }

    
    /** 
     * piešia šoninį langą
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
    }

    
    /** 
     * grąžina errorPanel
     * @return JPanel
     */
    public JPanel getErrorPanel() {
        return errorPanel;
    }
}