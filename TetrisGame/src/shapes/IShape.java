package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;
/**
 * Implementation of IShape.
 * 
 * @author Aaqib Issa
 */
public class IShape extends AbstractShape {
	/**
	 * Constructs an IShape with the given position and magic state.
	 * @param position
	 * 		position of this shape's upper left block
	 * @param magic
	 * 		true if the this shape's first cell should be magic
	 */
	public IShape(Position position, boolean magic) {
		super(position, magic);
		super.setIShape();
	}

	@Override
	public void transform() {
		// Same as AbstractShape but with different indices.
		
		int x = getCells()[1].getRow() - getPos().row();
		int y = getCells()[1].getCol() - getPos().col();
		x = -(getCells()[1].getCol() - getPos().col());
		y = getCells()[1].getRow() - getPos().row();
		getCells()[1].setRow(getCells()[0].getRow() + x);
		getCells()[1].setCol(getCells()[0].getCol() + y);

		int x1 = getCells()[2].getRow() - getPos().row();
		int y1 = getCells()[2].getCol() - getPos().col();
		x1 = -(getCells()[2].getCol() - getPos().col());
		y1 = getCells()[2].getRow() - getPos().row();
		getCells()[2].setRow(getCells()[0].getRow() + x1);
		getCells()[2].setCol(getCells()[0].getCol() + y1);

	}

	@Override
	public Shape clone()
	{

		AbstractShape s = (AbstractShape) super.clone();

		// TODO: make it into a deep copy
		Position a = s.getPos();
		Cell[] b = new Cell[3];

		a = new Position(getPos());
		b[0] = s.getCells()[0];
		b[1] = s.getCells()[1];
		b[2] = s.getCells()[2];
		b[0] = new Cell(getCells()[0]);
		b[1] = new Cell(getCells()[1]);
		b[2] = new Cell(getCells()[2]);
		return s;
		
	}

}
