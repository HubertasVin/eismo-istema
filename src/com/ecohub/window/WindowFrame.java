package com.ecohub.window;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.ecohub.utils.Constants;
import com.ecohub.utils.SandboxData;

/**
 * Sukuria pagrindinį langą
 */
public class WindowFrame extends JFrame {
    /**
     * Sukuria pagrindinį langą
     */
    public WindowFrame() {
        SwingUtilities.invokeLater(() -> {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(Constants.UI.WND_WIDTH, Constants.UI.WND_HEIGHT);
            this.setLayout(new BorderLayout());
            this.add(SandboxData.sidePanel, BorderLayout.WEST);
            this.add(SandboxData.simulationPanel, BorderLayout.EAST);
            this.setVisible(true);
        });
    }
}
