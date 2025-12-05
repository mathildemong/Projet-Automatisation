package utils;

import javax.swing.*;

public class Pause_Popup {
    public static void showContinuePopup() {
        JOptionPane.showMessageDialog(
                null,
                "Cliquer ici pour continuer",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
