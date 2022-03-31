package task2;

public class Element {
    private int row;
    private int col;
    private int meaning;

    public Element(int row, int col, int meaning) {
        this.row = row;
        this.col = col;
        this.meaning = meaning;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getMeaning() {
        return meaning;
    }

    public void setMeaning(int meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "Element{" +
                "row=" + row +
                ", col=" + col +
                ", meaning=" + meaning +
                '}';
    }
}
