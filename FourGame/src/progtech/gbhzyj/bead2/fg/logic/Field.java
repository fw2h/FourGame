package progtech.gbhzyj.bead2.fg.logic;

public class Field {
    private int color;
    private int value;
    public Field(int color, int value) {
        this.color = color;
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }


    public void increase() {
        this.value++;
    }
}
