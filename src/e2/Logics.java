package e2;

import java.util.List;

public interface Logics {

    List<Pair<Integer, Integer>> getMines();
    List<Pair<Integer, Integer>> getCounters();
    List<Pair<Integer, Integer>> getFlags();
    boolean hit(Pair<Integer, Integer> position);
    List<Pair<Integer, Integer>> computeAdjacentMines(Pair<Integer, Integer> position);
    List<Pair<Integer, Integer>> computeAdjacentTiles(Pair<Integer, Integer> position);
    void addCounters(Pair<Integer, Integer> position);
    void addFlag(Pair<Integer, Integer> position);

}
