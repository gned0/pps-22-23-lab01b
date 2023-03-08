package e1.pieces;

import e1.Pair;

public class Knight extends AbstractMovingPiece {

    public Knight(Pair<Integer, Integer> startingPosition) {
        super(startingPosition);
    }

    @Override
    protected boolean canMove(Pair<Integer, Integer> newPosition) {
        int x = newPosition.getX()-this.getPosition().getX();
        int y = newPosition.getY()-this.getPosition().getY();
        return (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3);
    }
}
