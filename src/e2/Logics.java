package e2;

import java.util.Collection;
import java.util.List;

public interface Logics {

    List<Pair<Integer, Integer>> getMinesPoisitions();
    boolean hit(Pair<Integer, Integer> position);

    List<Pair<Integer, Integer>> computeAdjacentMines(Pair<Integer, Integer> position);
}
