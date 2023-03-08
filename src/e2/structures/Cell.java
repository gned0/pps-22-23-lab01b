package e2.structures;

enum CellType{
    MINE,
    COUNTER,
    FLAG;
}

public interface Cell {

    public Pair<Integer, Integer> getPosition();
    public CellType getCellType();

}
