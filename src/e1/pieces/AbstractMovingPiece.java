package e1.pieces;

import e1.Pair;

public abstract class AbstractMovingPiece implements MovingPiece{

    Pair<Integer, Integer> position;

    public AbstractMovingPiece(Pair<Integer, Integer> startingPosition){
        this.position = startingPosition;
    }
    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
    public void setPosition(Pair<Integer, Integer> newPosition) {
        this.position = newPosition;
    }

    @Override
    public boolean hit(Pair<Integer, Integer> newPosition, Pair<Integer, Integer> pawn) {
        if(this.canMove(newPosition)) {
            this.position = newPosition;
            return this.position.equals(pawn);
        }
        return false;
    }

    protected abstract boolean canMove(Pair<Integer, Integer> newPosition);
}
