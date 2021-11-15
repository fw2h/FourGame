package progtech.gbhzyj.bead2.fg.gui;

import progtech.gbhzyj.bead2.fg.logic.FourGameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FourGameFrame extends JFrame {
    private final FourGameLogic fourGameLogic;
    private final FourGamePanel fourGamePanel;
    private final InfoPanel infoPanel;


    public FourGameFrame(final FourGameLogic fourGameLogic) {
        this.fourGameLogic = fourGameLogic;
        
        initFramePoperties();

        fourGameLogic.newGame(5);

        this.infoPanel = new InfoPanel(fourGameLogic);
        getContentPane().add(infoPanel, BorderLayout.NORTH);

        this.fourGamePanel = new FourGamePanel(fourGameLogic, infoPanel);
        getContentPane().add(fourGamePanel, BorderLayout.CENTER);

        setJMenuBar(new FourGameMenuBar());

        pack();
    }

    private void initFramePoperties() {
        setTitle("4-es játék");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100,100);
    }



    private class FourGameMenuBar extends JMenuBar {
        public FourGameMenuBar () {
            JMenu gameMenu = new JMenu("Game");

            JMenuItem newGameItem = new JMenuItem(newGameAction);

            //infopanel

            gameMenu.add(newGameItem);
            add(gameMenu);
        }

        private final Action newGameAction = new AbstractAction("New Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                final Integer[] gameSizes = new Integer[]{3, 5, 7};

                final Object resultObject =
                        JOptionPane.showInputDialog(rootPane, "Select a new game table size (NxN)",
                                "New game", JOptionPane.QUESTION_MESSAGE, null, gameSizes, gameSizes[1]);

                if (resultObject != null) {
                    int gameSize = (int) resultObject;
                    fourGameLogic.newGame(gameSize);
                    fourGamePanel.newGame();
                    pack();
                }

            }
        };
    }
}
