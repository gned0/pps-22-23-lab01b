package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    private final static int SIZE = 7;
    private final static int NUMBER_OF_MINES = 1;
    private Logics logics;
    private List<Pair<Integer, Integer>> minesPoisitions;

    @BeforeEach
    void setUp() {
        minesPoisitions = new ArrayList<Pair<Integer, Integer>>();
        minesPoisitions.add(new Pair<>(0, 0));
        minesPoisitions.add(new Pair<>(1, 1));
        logics = new LogicsImpl(SIZE, minesPoisitions);
    }

    @Test
    void testMineHit() {
        assertTrue(logics.hit(new Pair<>(0, 0)));
    }
    @Test
    void testMineMiss() {
        assertFalse(logics.hit(new Pair<>(0, 1)));
    }

    @Test
    void testBoundaries() {
        assertThrows(IndexOutOfBoundsException.class, ()-> logics.hit(new Pair<>(-1, -1)));
        assertThrows(IndexOutOfBoundsException.class, ()-> logics.hit(new Pair<>(SIZE+1, SIZE+1)));
    }

    @Test
    void testComputeAdjacentMines() {
        assertEquals(2, logics.computeAdjacentMines(new Pair<>(0, 1)).size());
        assertEquals(minesPoisitions, logics.computeAdjacentMines(new Pair<>(0, 1)));
    }
}