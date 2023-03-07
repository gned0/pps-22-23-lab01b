package e2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LogicsImpl implements Logics {

    private final int size;
    @Override
    public List<Pair<Integer, Integer>> getMinesPoisitions() {
        return minesPoisitions;
    }

    private List<Pair<Integer, Integer>> minesPoisitions;
    public LogicsImpl(int size, int numberOfMines) {
        this.size = size;
    }
    public LogicsImpl(int size, List<Pair<Integer, Integer>> minesPoisitions) {
        this.size = size;
        this.minesPoisitions = minesPoisitions;
    }

    @Override
    public boolean hit(Pair<Integer, Integer> position) {
        if (position.getX()<0 || position.getY()<0 ||
                position.getX() >= this.size || position.getY() >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        for(Pair<Integer, Integer> elem : minesPoisitions){
            if(elem.equals(position)) return true;
        }
        return false;
    }

    @Override
    public List<Pair<Integer, Integer>> computeAdjacentMines(Pair<Integer, Integer> position) {
        List<Pair<Integer, Integer>> adjacentMines = new ArrayList<Pair<Integer, Integer>>();
        for(var elem : minesPoisitions) {
            if(Math.abs(elem.getX()-position.getX())<=1 &&
                    Math.abs(elem.getY()-position.getY())<=1) {
                adjacentMines.add(elem);
            }
        }
        return adjacentMines;
    }
}
