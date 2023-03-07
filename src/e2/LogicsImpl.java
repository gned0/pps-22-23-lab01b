package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

    private final int size;
    private List<Pair<Integer, Integer>> mines;
    List<Pair<Integer, Integer>> counters = new ArrayList<>();
    List<Pair<Integer, Integer>> flags = new ArrayList<>();
    public LogicsImpl(int size, int numberOfMines) {
        this.size = size;
    }
    public LogicsImpl(int size, List<Pair<Integer, Integer>> mines) {
        this.size = size;
        this.mines = mines;
    }

    @Override
    public List<Pair<Integer, Integer>> getMines() {
        return mines;
    }

    public List<Pair<Integer, Integer>> getCounters() {
        return counters;
    }

    public List<Pair<Integer, Integer>> getFlags() {
        return flags;
    }

    @Override
    public boolean hit(Pair<Integer, Integer> position) {
        if (!this.isInBoundaries(position)) {
            throw new IndexOutOfBoundsException();
        }
        for(Pair<Integer, Integer> elem : mines){
            if(elem.equals(position)) return true;
        }
        return false;
    }

    @Override
    public List<Pair<Integer, Integer>> computeAdjacentMines(Pair<Integer, Integer> position) {
        List<Pair<Integer, Integer>> adjacentTiles = this.computeAdjacentTiles(position);
        return mines.stream().filter(adjacentTiles::contains).collect(Collectors.toList());
    }

    @Override
    public List<Pair<Integer, Integer>> computeAdjacentTiles(Pair<Integer, Integer> position) {
        List<Pair<Integer, Integer>> adjacentTiles = new ArrayList<>();
        for(int i = position.getX() - 1; i <= position.getX() + 1; i++) {
            for(int j = position.getY() - 1; j <= position.getY() + 1; j++) {
                var tile = new Pair<>(i, j);
                if(this.isInBoundaries(tile)) {
                    adjacentTiles.add(tile);
                    adjacentTiles.remove(position);
                }
            }
        }
        return adjacentTiles;
    }
    @Override
    public void addCounters(Pair<Integer, Integer> position) {
        this.counters.add(position);
        var adjacentTiles = this.computeAdjacentTiles(position);
        if(this.computeAdjacentMines(position).size() == 0) {
            for(var elem : adjacentTiles) {
                if(!this.counters.contains(elem)){
                    this.addCounters(elem);
                    this.counters.add(elem);
                }

            }
        }
    }

    @Override
    public void addFlag(Pair<Integer, Integer> position) {
        this.flags.add(position);
    }

    private boolean isInBoundaries(Pair<Integer, Integer> position) {
        return !(position.getX()<0 || position.getY()<0 ||
                position.getX() >= this.size || position.getY() >= this.size);
    }
}
