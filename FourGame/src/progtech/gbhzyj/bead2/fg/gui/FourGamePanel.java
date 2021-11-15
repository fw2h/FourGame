package progtech.gbhzyj.bead2.fg.gui;

import progtech.gbhzyj.bead2.common.gui.TabletopGameButton;
import progtech.gbhzyj.bead2.fg.logic.FourGameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FourGamePanel extends JPanel {
    private FourGameLogic logic;
    private ActionListener gameButtonActionListener = new GameButtonActionListener();
    private InfoPanel infoPanel;

    public FourGamePanel(FourGameLogic fourGameLogic, InfoPanel infoPanel) {
        this.logic = fourGameLogic;
        this.infoPanel = infoPanel;
        newGame();
    }

    public void newGame() {
        setupGamePanel();
        refreshUI();
        infoPanel.updateLabels();
    }

    private void refreshUI() {
        for (Component component : getComponents()) {
            TabletopGameButton btn = (TabletopGameButton) component;
            int value = logic.getFieldColor(btn.getRow(), btn.getColumn());
            if (value != 0) {
                //btn.setEnabled(false);
                Color color = null;
                switch (value) {
                    case 1:
                        color = Color.BLUE;
                        break;
                    case 2:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.GREEN;
                }
                btn.setBackground(color);
            }

            int fieldValue = logic.getFieldValue(btn.getRow(), btn.getColumn());
            btn.setText(String.valueOf(fieldValue));


        }
    }

    private void setupGamePanel() {
        removeAll();
        int n = logic.getSize();
        setLayout(new GridLayout(n, n));
        for (int row = 0; row < n; ++row) {
            for (int column = 0; column < n; ++column) {
                final JButton btn = new TabletopGameButton(row, column);
                btn.setPreferredSize(new Dimension(40, 40));
                btn.addActionListener(gameButtonActionListener);

                //btn.addActionListener(gameButtonActionListener);
                add(btn);
            }
        }

        revalidate();
        repaint();
    }

    private void checkForEndGame() {
        if (logic.isGameEnd()) {
            JOptionPane.showMessageDialog(null, "Congratulation! " + logic.getWinnerPlayerName() +" won the game!", "Grats", JOptionPane.INFORMATION_MESSAGE);
            logic.newGame(logic.getSize());
            newGame();
        }
    }


    private class GameButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TabletopGameButton gameButton = (TabletopGameButton) e.getSource();
            logic.changeFieldValues(gameButton.getRow(), gameButton.getColumn());

            refreshUI();

            //logic.nextPlayer();
            infoPanel.updateLabels();
            checkForEndGame();



        }
    }
}
