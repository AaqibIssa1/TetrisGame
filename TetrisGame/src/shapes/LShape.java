package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
/**
 * Implementation of LShape.
 * 
 * @author Aaqib Issa
 */
public class LShape extends AbstractShape{
	/**
	 * Constructs an LShape with the given position and magic state.
	 * @param position
	 * 		position of this shape's upper left block
	 * @param magic
	 * 		true if the this shape's first cell should be magic
	 */
	public LShape(Position position, boolean magic) {
		super(position, magic);
		super.setLShape();
	}


}
