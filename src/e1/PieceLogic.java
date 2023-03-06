package e1;

public interface PieceLogic {

    boolean hit(Pair<Integer, Integer> movingPiece, Pair<Integer, Integer> pawn);

    boolean canMove(Pair<Integer, Integer> move, Pair<Integer, Integer> movingPiece);
}
