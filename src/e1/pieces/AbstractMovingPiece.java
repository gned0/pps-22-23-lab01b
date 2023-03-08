package e1.pieces;

import e1.Pair;

public abstract class AbstractMovingPiece implements MovingPiece{

    private Pair<Integer, Integer> position;

    public AbstractMovingPiece(Pair<Integer, Integer> startingPosition){
        this.position = startingPosition;
    }
    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public void move(Pair<Integer, Integer> newPosition) {
        if(this.canMove(newPosition)) {
            this.position = newPosition;
        }
    }

    /**
     * This method is used within template method "move" and will be implemented by concrete classes
     * that extend this abstract class
     * @param newPosition position in which to move
     * @return True if according to piece logic it can move to newPosition, false otherwise
     */
    protected abstract boolean canMove(Pair<Integer, Integer> newPosition);
}
