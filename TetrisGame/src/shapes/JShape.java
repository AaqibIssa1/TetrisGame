package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;
/**
 * Implementation of JShape.
 * 
 * @author Aaqib Issa
 */
public class JShape extends AbstractShape{
	/**
	 * Constructs an JShape with the given position and magic state.
	 * @param position
	 * 		position of this shape's upper left block
	 * @param magic
	 * 		true if the this shape's first cell should be magic
	 */
	public JShape(Position position, boolean magic) {
		super(position, magic);
		super.setJShape();
	}
	
	@Override
	public void transform() {
		// Same as AbstractShape just with different indices as the point of rotation
		// is not on the shape as in the other ones that transform ccw.
		
		int x = getCells()[0].getRow() - getPos().row();
		int y = getCells()[0].getCol() - getPos().col();
		x = -(getCells()[0].getCol() - getPos().col());
		y = getCells()[0].getRow() - getPos().row();
		getCells()[0].setRow(getPos().row() + x);
		getCells()[0].setCol(getPos().col() + y);
	    
		int x3 = getCells()[1].getRow() - getPos().row();
		int y3 = getCells()[1].getCol() - getPos().col();
		x3 = -(getCells()[1].getCol() - getPos().col());
		y3 = getCells()[1].getRow() - getPos().row();
		getCells()[1].setRow(getPos().row() + x3);
		getCells()[1].setCol(getPos().col() + y3);
	    
	    int x1 = getCells()[2].getRow() - getPos().row();
		int y1 = getCells()[2].getCol() - getPos().col();
		x1 = -(getCells()[2].getCol() - getPos().col());
		y1 = getCells()[2].getRow() - getPos().row();
		getCells()[2].setRow(getPos().row() + x1);
		getCells()[2].setCol(getPos().col() + y1);
	    
	    int x2 = getCells()[3].getRow() - getPos().row();
		int y2 = getCells()[3].getCol() - getPos().col();
		x2 = -(getCells()[3].getCol() - getPos().col());
		y2 = getCells()[3].getRow() - getPos().row();
		getCells()[3].setRow(getPos().row() + x2);
	    getCells()[3].setCol(getPos().col() + y2);
	}

	
	

}
