package progtech.gbhzyj.bead2.fg;


import progtech.gbhzyj.bead2.fg.gui.FourGameFrame;
import progtech.gbhzyj.bead2.fg.logic.FourGameLogic;

import javax.swing.*;


public class Boot {

    private static final String NIMBUS_THEME = "Nimbus";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            applyNimbusTheme();

            new FourGameFrame(new FourGameLogic()).setVisible(true);
        });
    }

    private static void applyNimbusTheme() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals(NIMBUS_THEME)) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        }
        catch (Exception exception) {
            System.out.println("Failed to use Nimbus Theme. Exception message: " + exception);
        }
    }
}
