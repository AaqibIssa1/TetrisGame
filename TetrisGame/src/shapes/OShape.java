package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;
/**
 * Implementation of OShape.
 * 
 * @author Aaqib Issa
 */
public class OShape extends AbstractShape {
	/**
	 * Constructs an OShape with the given position and magic state.
	 * @param position
	 * 		position of this shape's upper left block
	 * @param magic
	 * 		true if the this shape's first cell should be magic
	 */
	public OShape(Position position, boolean magic) {
		super(position, magic);
		super.setOShape();
	}
	
	@Override
	public void transform() {
		// Overridden as OShape shouldn't transform
	}

	
}
