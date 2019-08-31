package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
/**
 * Implementation of TShape.
 * 
 * @author Aaqib Issa
 */
public class TShape extends AbstractShape{
	/**
	 * Constructs an TShape with the given position and magic state.
	 * @param position
	 * 		position of this shape's upper left block
	 * @param magic
	 * 		true if the this shape's first cell should be magic
	 */
	public TShape(Position position, boolean magic) {
		super(position, magic);
		super.setTShape();
	}

	@Override
	public void transform() {
		// Same as AbstractShape but with different indices.
		
		int x = getCells()[0].getRow() - getPos().row();
		int y = getCells()[0].getCol() - getPos().col();
		x = -(getCells()[0].getCol() - getPos().col());
		y = getCells()[0].getRow() - getPos().row();
		getCells()[0].setRow(getCells()[2].getRow() + x);
		getCells()[0].setCol(getCells()[2].getCol() + y);
	    
	    int x1 = getCells()[1].getRow() - getPos().row();
		int y1 = getCells()[1].getCol() - getPos().col();
		x1 = -(getCells()[1].getCol() - getPos().col());
		y1 = getCells()[1].getRow() - getPos().row();
		getCells()[1].setRow(getCells()[2].getRow() + x1);
		getCells()[1].setCol(getCells()[2].getCol() + y1);
		
		int x2 = getCells()[3].getRow() - getPos().row();
		int y2 = getCells()[3].getCol() - getPos().col();
		x2 = -(getCells()[3].getCol() - getPos().col());
		y2 = getCells()[3].getRow() - getPos().row();
		getCells()[3].setRow(getCells()[2].getRow() + x2);
		getCells()[3].setCol(getCells()[2].getCol() + y2);
	    
	}
	
}
