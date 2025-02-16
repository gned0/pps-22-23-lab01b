package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LogicsTest {

    private Logics logics;
    private final static int SIZE = 5;
    private final Pair<Integer, Integer> pawnInitialPosition = new Pair<>(0, 0);
    private final Pair<Integer, Integer> movingPieceInitialPosition = new Pair<>(1, 2);

    @BeforeEach
    void beforeEach() {
        this.logics = new LogicsImpl(SIZE, pawnInitialPosition, movingPieceInitialPosition);
    }

    @Test
    void testHit() {
        assertTrue(logics.hit(new Pair<>(0, 0)));
    }

    @Test
    void testMiss() {
        assertFalse(logics.hit(new Pair<>(2, 4)));
    }

    @Test
    void testMovementBoundaries() {
        assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(new Pair<>(-1, -1)));
        assertThrows(IndexOutOfBoundsException.class, ()->logics.hit(new Pair<>(SIZE+1, SIZE+1)));
    }

    @Test
    void testHasPawn() {
        assertTrue(logics.hasPawn(this.pawnInitialPosition.getX(), this.pawnInitialPosition.getY()));
    }

    @Test
    void testHasMovingPiece() {
        assertTrue(logics.hasMovingPiece(this.movingPieceInitialPosition.getX(),
                   this.movingPieceInitialPosition.getY()));
    }
}