package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    private final static int SIZE = 7;
    private final static int NUMBER_OF_MINES = 3;
    private Logics logics;
    private List<Pair<Integer, Integer>> minesPoisitions;

    @BeforeEach
    void setUp() {
        logics = new LogicsImpl(SIZE, NUMBER_OF_MINES);
    }

    @Test
    void testMineHit() {

    }
}