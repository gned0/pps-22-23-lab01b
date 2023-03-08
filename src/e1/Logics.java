package e1;

public interface Logics{


    /**
     * @param move
     * @return
     */
    boolean hit(Pair<Integer,Integer> move);
    
    /**
     * @param row
     * @param col
     * @return whether position row,col has the knight
     */
    boolean hasMovingPiece(int row, int col);
    
    /**
     * @param row
     * @param col
     * @return whether position row,col has the pawn
     */
    boolean hasPawn(int row, int col);

}
