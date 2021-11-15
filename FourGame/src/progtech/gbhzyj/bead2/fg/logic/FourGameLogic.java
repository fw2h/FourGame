package progtech.gbhzyj.bead2.fg.logic;

//import java.awt.*;

public class FourGameLogic {
    private Field[][] fields;
    //private Color[][] colors; // 1 - Color.BLUE, 2 - Color.RED
    private int size;
    private static final Player[] players = {new Player("player-1", 1), new Player("player-2", 2)};
    private int playerIndex = 0;


    public void newGame(int size) {
        this.size = size;
        this.fields = new Field[size][size];
        //this.colors = new Color[size][size];
        playerIndex = 0;
        fillField();

        resetPlayerScore();
    }

    public int getPlayerIndex() {
        return playerIndex;
    }


    private void fillField() {
        for (int row = 0; row < size; ++row) {
            for (int column = 0; column < size; ++column) {
                fields[row][column] = new Field(0,0);
            }
        }
    }

    public int getFieldValue(int row, int column) {
        return fields[row][column].getValue();
    }


    public int getFieldColor(int row, int column) {
        return fields[row][column].getColor();
    }

    public Player getNthPlayer(int n) {
        return players[n];
    }

    public void changeFieldValues(int row, int column) {
        if (fields[row][column].getValue() != 4) {
            changeSingleFieldValue(row, column);
            changeSingleFieldValue(row - 1, column);
            changeSingleFieldValue(row + 1, column);
            changeSingleFieldValue(row, column - 1);
            changeSingleFieldValue(row, column + 1);
            nextPlayer();
        }

    }

    private void changeSingleFieldValue(int row, int column) {
        if (!(row < 0 || column < 0 || row >= size || column >= size || fields[row][column].getValue() > 3)) {
            fields[row][column].increase();

            if (fields[row][column].getValue() == 4) {
                players[playerIndex].increaseScore();
                fields[row][column].setColor(getCurrentColorByPlayer());
            }
        }
    }

    public void nextPlayer() {
        playerIndex++;
        playerIndex %= players.length;
    }

    public String getWinnerPlayerName() {
        if (players[0].getScore() > players[1].getScore()) {
            return players[0].getName();
        }
        return players[1].getName();
    }

    private void resetPlayerScore() {
        for (Player p : players) {
            p.setScore(0);
        }
    }

    public int getCurrentColorByPlayer() {
        return players[playerIndex].getColor();
    }

    public int getSize() {
        return size;
    }

    public boolean isGameEnd() {
        for (int row = 0; row < size; ++row) {
            for (int column = 0; column < size; ++column) {
                if (fields[row][column].getValue() != 4) {
                    return false;
                }
            }
        }
        return true;
    }


}
