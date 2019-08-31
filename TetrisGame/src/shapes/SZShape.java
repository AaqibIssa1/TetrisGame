package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
/**
 * Implementation of SZShape.
 * 
 * @author Aaqib Issa
 */
public class SZShape extends AbstractShape{
	/**
	 * Constructs an SZShape with the given position and magic state.
	 * @param position
	 * 		position of this shape's upper left block
	 * @param magic
	 * 		true if the this shape's first cell should be magic
	 */
	public SZShape(Position position, boolean magic) {
		super(position, magic);
		super.setSZShape();
	}
	
	@Override
	public void transform() {
		// What I did here is that I have conditionals that check if the shape is green or red. 
		// Then I simply move the blocks to where they should go. Then I create a new block for each
		// of the blocks but with red or green so that the color changes, and then I assign the 
		// old blocks the new blocks, so that green becomes red, and red becomes green.
		
		if (getCells()[0].getBlock().getColorHint() == Color.GREEN) {
			getCells()[0].setCol(getCells()[0].getCol() + 1);
			getCells()[1].setCol(getCells()[1].getCol() + 1);
			getCells()[2].setCol(getCells()[2].getCol() - 1);
			getCells()[3].setCol(getCells()[3].getCol() - 1);
			Block a = new Block(Color.RED, getCells()[0].getBlock().isMagic());
			Block b = new Block(Color.RED, getCells()[1].getBlock().isMagic());
			Block c = new Block(Color.RED, getCells()[2].getBlock().isMagic());
			Block d = new Block(Color.RED, getCells()[3].getBlock().isMagic());
			getCells()[0].setBlock(a);
			getCells()[1].setBlock(b);
			getCells()[2].setBlock(c);
			getCells()[3].setBlock(d);
		}
		else {
			if (getCells()[0].getBlock().getColorHint() == Color.RED) {
				getCells()[0].setCol(getCells()[0].getCol() - 1);
				getCells()[1].setCol(getCells()[1].getCol() - 1);
				getCells()[2].setCol(getCells()[2].getCol() + 1);
				getCells()[3].setCol(getCells()[3].getCol() + 1);
				Block a = new Block(Color.GREEN, getCells()[0].getBlock().isMagic());
				Block b = new Block(Color.GREEN, getCells()[1].getBlock().isMagic());
				Block c = new Block(Color.GREEN, getCells()[2].getBlock().isMagic());
				Block d = new Block(Color.GREEN, getCells()[3].getBlock().isMagic());
				getCells()[0].setBlock(a);
				getCells()[1].setBlock(b);
				getCells()[2].setBlock(c);
				getCells()[3].setBlock(d);
			}
		}
	}


}
