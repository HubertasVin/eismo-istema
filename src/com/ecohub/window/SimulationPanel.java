package com.ecohub.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.ecohub.road_users.Bicycle;
import com.ecohub.road_users.Car;
import com.ecohub.road_users.RoadUser;
import com.ecohub.utils.Constants;
import com.ecohub.utils.DrawSelectEnum;
import com.ecohub.utils.RoadTypeSelect;
import com.ecohub.utils.SandboxData;

/**
 * Simuliacijos langas
 */
public class SimulationPanel extends JPanel {
    private Image image;
    private boolean roadUserFound = false;
    /**
     * Sukuria simuliacijos langą
     */
    public SimulationPanel() {
        SwingUtilities.invokeLater(() -> {
            this.setPreferredSize(new Dimension(Constants.UI.SIM_WIDTH, Constants.UI.SIM_HEIGHT));
            // this.setLayout(null);
            this.setBounds(Constants.UI.SID_WIDTH, 0, Constants.UI.SIM_WIDTH, Constants.UI.SIM_HEIGHT);
            this.setBackground(new Color(240, 226, 231));
            this.revalidate();
            this.repaint();

            this.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int gridSquareSize = Constants.UI.SIM_WIDTH / Constants.UI.SIM_GRID_SQUARE_H_COUNT;
                    removeAll();
                    updateUI();
                    int x = (e.getX() / gridSquareSize);// * (Constants.UI.SIM_WIDTH / Constants.UI.SIM_GRID_SQUARE_COUNT);
                    int y = (e.getY() / gridSquareSize);// * (Constants.UI.SIM_WIDTH / Constants.UI.SIM_GRID_SQUARE_COUNT);
                    
                    // Create and add a new Car object at the clicked location
                    switch (DrawSelectEnum.tileType) {
                        case CAR:
                            roadUserFound = false;
                            if (!SandboxData.roadUsers.isEmpty()) {
                                for (RoadUser roadUser : SandboxData.roadUsers) {
                                    if (roadUser.getX() == x && roadUser.getY() == y) {
                                        SandboxData.sidePanel.errorPanel.setErrorText("The tile is already occupied by a road user.", 10000);
                                        roadUserFound = true;
                                        break;
                                    }
                                }
                            }
                            if (roadUserFound)
                                break;
                            
                            if (SandboxData.mapData[y][x] < Constants.STRAIGHT_1 || SandboxData.mapData[y][x] > Constants.T_4) {
                                SandboxData.sidePanel.errorPanel.setErrorText("You can place cars only on roads.", 10000);
                            }
                            else {
                                SandboxData.roadUsers.add(new Car(x, y));
                            }
                            break;
                        case BICYCLE:
                            roadUserFound = false;
    
                            if (!SandboxData.roadUsers.isEmpty()) {
                                for (RoadUser roadUser : SandboxData.roadUsers) {
                                    if (roadUser.getX() == x && roadUser.getY() == y) {
                                        SandboxData.sidePanel.errorPanel.setErrorText("The tile is already occupied by a road user.", 10000);
                                        roadUserFound = true;
                                        break;
                                    }
                                }
                            }
                            if (roadUserFound)
                                break;

                            if (SandboxData.mapData[y][x] < Constants.STRAIGHT_1 || SandboxData.mapData[y][x] > Constants.T_4) {
                                SandboxData.sidePanel.errorPanel.setErrorText("You can place bicycles only on roads.", 10000);
                            }
                            else {
                                SandboxData.roadUsers.add(new Bicycle(x, y));
                            }
                            break;
                        case GRASS:
                            SandboxData.mapData[y][x] = Constants.GRASS;
                            break;
                        case ROAD:
                            SandboxData.mapData[y][x] = RoadTypeSelect.roadType(x, y);
                            if (y > 0 && SandboxData.mapData[y - 1][x] != Constants.GRASS)
                                SandboxData.mapData[y - 1][x] = RoadTypeSelect.roadType(x, y - 1);
                            if (y < Constants.UI.SIM_GRID_SQUARE_V_COUNT - 1 && SandboxData.mapData[y + 1][x] != Constants.GRASS)
                                SandboxData.mapData[y + 1][x] = RoadTypeSelect.roadType(x, y + 1);
                            if (x > 0 && SandboxData.mapData[y][x - 1] != Constants.GRASS)
                                SandboxData.mapData[y][x - 1] = RoadTypeSelect.roadType(x - 1, y);
                            if (x < Constants.UI.SIM_GRID_SQUARE_H_COUNT - 1 && SandboxData.mapData[y][x + 1] != Constants.GRASS)
                                SandboxData.mapData[y][x + 1] = RoadTypeSelect.roadType(x + 1, y);
                            break;
                        default:
                            break;
                    }
                    
                    // Repaint the panel to update the display
                    revalidate();
                    repaint();
                }
            });
        });
    }

    
    /** 
     * piešia ant simulacijos lango
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics g2d = (Graphics2D) g;
        // System.out.println(SandboxData.roadUsers);
        for (int i = 0; i < Constants.UI.SIM_GRID_SQUARE_V_COUNT; ++i) {
            for (int j = 0; j < Constants.UI.SIM_GRID_SQUARE_H_COUNT; ++j) {
                switch (SandboxData.mapData[i][j]) {
                    case Constants.GRASS:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.TIL_GRASS);
                        break;
                    case Constants.STRAIGHT_1:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_STRAIGHT_1);
                        break;
                    case Constants.STRAIGHT_2:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_STRAIGHT_2);
                        break;
                    case Constants.CORNER_1:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_CORNER_1);
                        break;
                    case Constants.CORNER_2:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_CORNER_2);
                        break;
                    case Constants.CORNER_3:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_CORNER_3);
                        break;
                    case Constants.CORNER_4:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_CORNER_4);
                        break;
                    case Constants.CROSS:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_CROSS);
                        break;
                    case Constants.END_1:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_END_1);
                        break;
                    case Constants.END_2:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_END_2);
                        break;
                    case Constants.END_3:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_END_3);
                        break;
                    case Constants.END_4:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_END_4);
                        break;
                    case Constants.T_1:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_T_1);
                        break;
                    case Constants.T_2:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_T_2);
                        break;
                    case Constants.T_3:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_T_3);
                        break;
                    case Constants.T_4:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.RD_T_4);
                        break;

                    default:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.TIL_GRASS);
                        break;
                }
                g2d.drawImage(image, j * (Constants.UI.SIM_WIDTH / Constants.UI.SIM_GRID_SQUARE_H_COUNT), i * (Constants.UI.SIM_WIDTH / Constants.UI.SIM_GRID_SQUARE_H_COUNT), Constants.UI.TIL_SIZE, Constants.UI.TIL_SIZE, this);
            }
        }

        if (!SandboxData.roadUsers.isEmpty()) {
            SandboxData.roadUsers.forEach((roadUser) -> {
                switch (roadUser.getType()) {
                    case CAR:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.ENT_CAR);

                        // Rotate the image by 90 degrees clockwise
                        AffineTransform transform = new AffineTransform();
                        transform.rotate(Math.toRadians(roadUser.getTextureRotate()), image.getWidth(this) / 2, image.getHeight(this) / 2);
        
                        // Create a new image with rotated dimensions
                        Image rotatedImage = new BufferedImage(image.getHeight(this), image.getWidth(this), BufferedImage.TYPE_INT_ARGB);
        
                        // Draw the rotated image
                        Graphics2D g2dRotated = (Graphics2D) rotatedImage.getGraphics();
                        g2dRotated.setTransform(transform);
                        g2dRotated.drawImage(image, 0, 0, this);
                        g2dRotated.dispose();
        
                        // Use the rotated image for drawing
                        image = rotatedImage;
                        break;
                    case BICYCLE:
                        image = Toolkit.getDefaultToolkit().getImage(Constants.IMG.ENT_BICYCLE);
                        break;
                    default:
                        break;
                }
                g2d.drawImage(image, roadUser.getX() * (Constants.UI.SIM_WIDTH / Constants.UI.SIM_GRID_SQUARE_H_COUNT), roadUser.getY() * (Constants.UI.SIM_WIDTH / Constants.UI.SIM_GRID_SQUARE_H_COUNT), Constants.UI.TIL_SIZE, Constants.UI.TIL_SIZE, this);
            });
        }
        paintGrid(g);
    }

    
    /** 
     * nupiešia tinklelį
     * @param g
     */
    public void paintGrid(Graphics g) {
        Graphics g2d = (Graphics2D) g;
        int gridSquareSize = Constants.UI.SIM_WIDTH / Constants.UI.SIM_GRID_SQUARE_H_COUNT;
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < Constants.UI.SIM_WIDTH; i += gridSquareSize) {
            g2d.drawLine(i, 0, i, Constants.UI.SIM_HEIGHT);
        }
        for (int i = 0; i < Constants.UI.SIM_HEIGHT; i += gridSquareSize) {
            g2d.drawLine(0, i, Constants.UI.SIM_WIDTH, i);
        }
    }
}
