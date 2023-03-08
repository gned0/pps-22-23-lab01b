package e1;

import e1.pieces.Knight;
import e1.pieces.MovingPiece;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private final Random random = new Random();
	private final int size;
	private final MovingPiece movingPiece;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
		this.movingPiece = new Knight(this.randomEmptyPosition());
    }

	public LogicsImpl(int size, Pair<Integer,Integer> pawnInitialPosition,
					  Pair<Integer,Integer> knightInitialPosition){
		this.size = size;
		this.pawn = pawnInitialPosition;
		this.movingPiece = new Knight(knightInitialPosition);
	}

	private Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(Pair<Integer,Integer> newPosition) {
		if (newPosition.getX()<0 || newPosition.getY()<0 ||
				newPosition.getX() >= this.size || newPosition.getY() >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		this.movingPiece.move(newPosition);
		return this.movingPiece.getPosition().equals(pawn);
	}

	@Override
	public boolean hasMovingPiece(int row, int col) {
		return this.movingPiece.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

}
