package e1;

public class KnightLogic implements PieceLogic{

    @Override
    public boolean hit(Pair<Integer, Integer> movingPiece, Pair<Integer, Integer> pawn) {
        return pawn.equals(movingPiece);
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> move, Pair<Integer, Integer> movingPiece) {
        int x = move.getX()-movingPiece.getX();
        int y = move.getY()-movingPiece.getY();
        return (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3);
    }

}
