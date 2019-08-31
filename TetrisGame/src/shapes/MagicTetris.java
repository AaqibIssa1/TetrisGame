
package shapes;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation. This class is responsible for updating the score and finding a completed
 * row and removing it, and knowing when to go into gravity mode.
 * 
 * @author Aaqib Issa
 */
public class MagicTetris extends AbstractGame
{	
	/**
	 * Variable that sees if the game is in gravity mode or not
	 */
	private boolean isGravity;
	/**
	 * Variable that keeps track of the score
	 */
	private int score;
	 /**
	   * Constructs a game with the given width (columns) and height (rows).
	   * This game will use a new instance of BasicGenerator to 
	   * generate new shapes.
	   * @param width
	   *   width of the game grid (number of columns)
	   * @param height
	   *   height of the game grid (number of rows)
	   */
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
  }

  @Override
  public List<Position> determinePositionsToCollapse()
  {
    // What happens here is that if it is in gravity mode and Block at i,j is null and the one above it is not null, then
	// add that to the positions, check to see if row is filled, and update score, then gravity mode is turned off.
	// If not in gravity mode, and Block at i,j is not null then numBlocks goes up 1, and if it is magic then numMagicBlocks
	// goes up one. If numMagicBlocks = 3 and the row is filled, go into gravity mode. If not then see if row is filled, if it
	// is then add that position, and update score. Then set numBlocks and numMagicBlocks to 0.
	  
		Position P;
	    int numBlocks = 0;
	    int numMagicBlocks = 0;
	    List<Position> positions = new ArrayList<>();
	    if (isGravity) {
			  for (int i = 1; i < getHeight(); i++) {
				  for (int j = 0; j < getWidth(); j++) {
					  if (getBlock(i,j) == null && getBlock(i-1,j) != null) {
						  P = new Position(i,j);
						  positions.add(P);
						  if (numBlocks == getWidth()) {
							  for (int k = 0; k < getWidth(); k++) {
								  P = new Position(i,k);
								  positions.add(P);
							  }
							  score += Math.pow(2, numMagicBlocks);
					  }
				  }
			  }
		  }
			  isGravity = false;
	    }
		  else {
			  for (int i = 0; i < getHeight(); i++) {
				  for (int j = 0; j < getWidth(); j++) {
					  if (getBlock(i,j) != null) {
						  numBlocks++;
						  if (getBlock(i,j).isMagic()) {
							  numMagicBlocks++;
						  }
						  if (numMagicBlocks >= 3 && numBlocks == getWidth()) {
							  isGravity = true;
						  }
					  }
				  }
				  if (numBlocks == getWidth()) {
					  for (int j = 0; j < getWidth(); j++) {
						  P = new Position(i,j);
						  positions.add(P);
					  }
					  score += Math.pow(2, numMagicBlocks);
				  }
				  numBlocks = 0;
				  numMagicBlocks = 0;
			  }
		  }
	    return positions;
  }

  @Override
  public int determineScore()
  {
    return score;
  }

}
