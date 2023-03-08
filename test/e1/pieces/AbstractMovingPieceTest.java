package e1.pieces;

import e1.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMovingPieceTest {

    private AbstractMovingPiece piece;
    private Pair<Integer, Integer> startingPosition;
    private Pair<Integer, Integer> targetPosition;

    @BeforeEach
    void setUp() {
        startingPosition = new Pair<>(0, 0);
        targetPosition = new Pair<>(1, 2);
        piece = new Knight(startingPosition);
    }
    @Test
    void getPosition() {
        assertEquals(this.startingPosition,piece.getPosition());
    }

    @Test
    void testAllowedMovement() {
        assertTrue(this.piece.canMove(this.targetPosition));
    }

    @Test
    void testUnallowedMovement() {
        assertFalse(this.piece.canMove(new Pair<>(1, 1)));
    }

    @Test
    void move() {
        this.piece.move(this.targetPosition);
        assertEquals(this.targetPosition, piece.getPosition());
    }
}