package e1.pieces;

import e1.Pair;

public interface MovingPiece {

    Pair<Integer, Integer> getPosition();
    boolean hit(Pair<Integer, Integer> newPosition, Pair<Integer, Integer> pawn);
}
