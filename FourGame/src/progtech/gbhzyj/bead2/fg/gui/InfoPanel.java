package progtech.gbhzyj.bead2.fg.gui;

import progtech.gbhzyj.bead2.fg.logic.FourGameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class InfoPanel extends JPanel {
    private final FourGameLogic logic;

    private final JLabel player1ScoreLabel;
    private final JLabel player2ScoreLabel;

    private final JLabel player1Name;
    private final JLabel player2Name;

    public InfoPanel(FourGameLogic logic) {
        this.logic = logic;

        setPreferredSize(new Dimension(100, 50));

        player1ScoreLabel = new JLabel("");
        player2ScoreLabel = new JLabel("");

        player1Name = new JLabel("");
        player2Name = new JLabel("");

        add(player1Name);
        add(player1ScoreLabel);

        add(player2Name);
        add(player2ScoreLabel);
    }

    public void updateLabels() {
        player1Name.setText(logic.getNthPlayer(0).getName() + ":");
        player1Name.setForeground(Color.BLUE);
        player1ScoreLabel.setText(String.valueOf(logic.getNthPlayer(0).getScore()));

        player2Name.setText(logic.getNthPlayer(1).getName() + ":");
        player2Name.setForeground(Color.RED);
        player2ScoreLabel.setText(String.valueOf(logic.getNthPlayer(1).getScore()));


        if (logic.getPlayerIndex() == 0) {
            Font font = player1Name.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            player1Name.setFont(font.deriveFont(attributes));

            Font font2 = player2Name.getFont();
            Map attributes2 = font2.getAttributes();
            attributes2.put(TextAttribute.UNDERLINE, -1);
            player2Name.setFont(font2.deriveFont(attributes2));
        }
        else {
            Font font = player1Name.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, -1);
            player1Name.setFont(font.deriveFont(attributes));

            Font font2 = player2Name.getFont();
            Map attributes2 = font2.getAttributes();
            attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            player2Name.setFont(font2.deriveFont(attributes2));
        }

    }

}
