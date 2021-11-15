package progtech.gbhzyj.bead2.fg.logic;


public class Player {
    private int score = 0;
    private final String name;
    private final int color;

    public Player(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore() {
        this.score++;
    }

    public String getName() {
        return name;
    }

}
