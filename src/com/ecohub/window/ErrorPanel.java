package com.ecohub.window;

import java.awt.Color;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ecohub.utils.Constants;
import com.ecohub.utils.SandboxData;

/**
 * Klasė skirta kurti klaidų langą
 */
public class ErrorPanel extends JPanel {
    protected JLabel errorText;
    /**
     * Sukuria klaidų lango objektą
     */
    public ErrorPanel() {
        this.setBounds(0, Constants.UI.SID_HEIGHT - Constants.UI.ERR_HEIGHT - 36, Constants.UI.ERR_WIDTH, Constants.UI.ERR_HEIGHT);
        this.setLayout(null);
        errorText = new JLabel("<html>Error field</html>");
        errorText.setForeground(Color.RED);
        errorText.setBounds(10, 0, Constants.UI.ERR_WIDTH - 20, Constants.UI.ERR_HEIGHT);
        this.setBackground(new Color(240, 226, 231));
        this.add(errorText);
        SandboxData.timer = new Timer();
    }

    
    /** 
     * nustato klaidos tekstą
     * @param text
     * @param timer
     */
    public void setErrorText(String text, int timer) {
        errorText.setText("<html>Error: " + text + "</html>");
        // Keep the error message on screen for a set amount of time. After that, reset the error message.
        if (SandboxData.isRunningTimer == true) {
            SandboxData.isRunningTimer = false;
            SandboxData.timer.cancel();
            SandboxData.timer.purge();
            SandboxData.timer = new Timer();
        }
        SandboxData.isRunningTimer = true;
        SandboxData.timer.schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    if (SandboxData.isRunningTimer == true) {
                        resetErrorText();
                        SandboxData.isRunningTimer = false;
                        System.out.println("Place 2");
                    }
                }
            }, 
            timer
        );
    }
    
    /** 
     * grąžina klaidos tekstą
     * @return String
     */
    public String getErrorText() {
        return errorText.getText();
    }
    /**
     * Nustato klaidos tekstą į pradinę reikšmę
     */
    public void resetErrorText() {
        errorText.setText("<html>Error field</html>");
    }
}
