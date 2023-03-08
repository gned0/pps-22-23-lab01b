package e1.pieces;

import e1.Pair;

public interface MovingPiece {

    Pair<Integer, Integer> getPosition();
    void move(Pair<Integer, Integer> newPosition);
}
