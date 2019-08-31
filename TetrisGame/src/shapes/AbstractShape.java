
package shapes;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 * 
 * @author Aaqib Issa
 */
public abstract class AbstractShape implements Shape
{
	/**
	 * Position variable that keeps track of the initial position that is given from the constructor
	 */
	private Position pos;
	/**
	 * Array of cells, and its positions that makes up a certain shape (IShape, SZShape, etc)
	 */
	private Cell[] cells;
	/**
	 * Boolean variable that keeps track of if there is a magic block in the shape or not
	 */
	private boolean isMagic;
	  
	/**
	 * Constructs an AbstractShape and intializes the position and magic state
	 * @param position
	 * 		position of this shape's upper left block
	 * @param magic
	 * 		true if the this shape's first cell should be magic
	 */
	  protected AbstractShape(Position position, boolean magic)
	  {
		  pos = position;
		  isMagic = magic;
	  }
	  /**
	   * Void method return the position
	   */
	  protected Position getPos() {
		  return pos;
	  }
	  /**
	   * Void method return the true if magic block, false otherwise
	   */
	  protected boolean getMagic() {
		  return isMagic;
	  }
	  /**
	   * Void method constructs the SZShape
	   */
	  protected void setSZShape() {
		    cells = new Cell[4];
		    cells[0] = new Cell(new Block(Color.GREEN, isMagic), pos);
	
		    Position position1 = new Position(pos.row() + 1, pos.col());
		    cells[1] = new Cell(new Block(Color.GREEN, false), position1);
		    
		    Position position2 = new Position(pos.row() + 1, pos.col() + 1);
		    cells[2] = new Cell(new Block(Color.GREEN, false), position2);
		    
		    Position position3 = new Position(pos.row() + 2, pos.col() + 1);
		    cells[3] = new Cell(new Block(Color.GREEN, false), position3);
	  }
	  /**
	   * Void method constructs the TShape
	   */
	  protected void setTShape() {
		    cells = new Cell[4];
		    cells[2] = new Cell(new Block(Color.MAGENTA, false), pos);

		    Position position1 = new Position(pos.row() - 1, pos.col());
		    cells[0] = new Cell(new Block(Color.MAGENTA, isMagic), position1);
		    
		    Position position2 = new Position(pos.row(), pos.col() - 1);
		    cells[1] = new Cell(new Block(Color.MAGENTA, false), position2);
		    
		    Position position3 = new Position(pos.row(), pos.col() + 1);
		    cells[3] = new Cell(new Block(Color.MAGENTA, false), position3);
	  }
	  /**
	   * Void method constructs the LShape
	   */
	  protected void setLShape() {
		    cells = new Cell[4];
		    cells[0] = new Cell(new Block(Color.ORANGE, isMagic), pos);

		    Position position1 = new Position(pos.row() + 1, pos.col() - 2);
		    cells[1] = new Cell(new Block(Color.ORANGE, false), position1);
		    
		    Position position2 = new Position(pos.row() + 1, pos.col() - 1);
		    cells[2] = new Cell(new Block(Color.ORANGE, false), position2);
		    
		    Position position3 = new Position(pos.row() + 1, pos.col());
		    cells[3] = new Cell(new Block(Color.ORANGE, false), position3);
	  }
	  /**
	   * Void method constructs the JShape
	   */
	  protected void setJShape() {
		    cells = new Cell[4];
		    Position position0 = new Position(pos.row(), pos.col() - 1);
		    cells[0] = new Cell(new Block(Color.BLUE, isMagic), position0);

		    Position position1 = new Position(pos.row() + 1, pos.col() - 1);
		    cells[1] = new Cell(new Block(Color.BLUE, false), position1);
		    
		    Position position2 = new Position(pos.row() + 1, pos.col());
		    cells[2] = new Cell(new Block(Color.BLUE, false), position2);
		    
		    Position position3 = new Position(pos.row() + 1, pos.col() + 1);
		    cells[3] = new Cell(new Block(Color.BLUE, false), position3);
	  }
	  /**
	   * Void method constructs the IShape
	   */
	  protected void setIShape() {
		    cells = new Cell[3];
		    cells[0] = new Cell(new Block(Color.CYAN, isMagic), pos);
		    
		    Position position1 = new Position(pos.row() + 1, pos.col());
		    cells[1] = new Cell(new Block(Color.CYAN, false), position1);
		    
		    Position position2 = new Position(pos.row() + 2, pos.col());
		    cells[2] = new Cell(new Block(Color.CYAN, false), position2);
	  }
	  /**
	   * Void method constructs the OShape
	   */
	  protected void setOShape() {
		    cells = new Cell[4];
		    cells[0] = new Cell(new Block(Color.YELLOW, isMagic), pos);
		    
		    Position position1 = new Position(pos.row(), pos.col() + 1);
		    cells[1] = new Cell(new Block(Color.YELLOW, false), position1);
		    
		    Position position2 = new Position(pos.row() + 1, pos.col());
		    cells[2] = new Cell(new Block(Color.YELLOW, false), position2);
		    
		    Position position3 = new Position(pos.row() + 1, pos.col() + 1);
		    cells[3] = new Cell(new Block(Color.YELLOW, false), position3);
	  }
	  
	 @Override
	 	public Cell[] getCells() {
		    return cells;
		} 
	
	@Override
	  public void shiftDown()
	  {
	      pos.setRow(pos.row() + 1);
	      for (int i = 0; i < cells.length; i++) {
	    	  cells[i].setRow(cells[i].getRow() + 1);
	      }
	  }

	  @Override
	  public void shiftLeft()
	  {
		  pos.setCol(pos.col() - 1);
		  for (int i = 0; i < cells.length; i++) {
			  cells[i].setCol(cells[i].getCol() - 1);
		  }
	  }

	  @Override
	  public void shiftRight()
	  {
		  pos.setCol(pos.col() + 1);
		  for (int i = 0; i < cells.length; i++) {
			  cells[i].setCol(cells[i].getCol() + 1);
		  }
	  }
	  
	  @Override
	  public void transform()
	  {
		  // What I did here was that I took the the row and column of the cell[1,2,or3]
		  // and subtracted from it the position's row and column so it goes to (0,0). Then
		  // I did the (-column, row) thing and then set the row to -column and column to row.
		  
		    int x1 = cells[1].getRow() - pos.row();
			int y1 = cells[1].getCol() - pos.col();
			x1 = -(cells[1].getCol() - pos.col());
			y1 = cells[1].getRow() - pos.row();
			cells[1].setRow(cells[0].getRow() + x1);
		    cells[1].setCol(cells[0].getCol() + y1);
		    
		    int x2 = cells[2].getRow() - pos.row();
			int y2 = cells[2].getCol() - pos.col();
			x2 = -(cells[2].getCol() - pos.col());
			y2 = cells[2].getRow() - pos.row();
			cells[2].setRow(cells[0].getRow() + x2);
		    cells[2].setCol(cells[0].getCol() + y2);
		    
		    int x3 = cells[3].getRow() - pos.row();
			int y3 = cells[3].getCol() - pos.col();
			x3 = -(cells[3].getCol() - pos.col());
			y3 = cells[3].getRow() - pos.row();
			cells[3].setRow(cells[0].getRow() + x3);
		    cells[3].setCol(cells[0].getCol() + y3);
	  }
	  
	  @Override
		public void cycle() {
		  // What I did here is that I get the index of the magic block in the for loop and set that to a,
		  // then I set the current Block to the block at index a (which is the one with the magic), then next
		  // Block is the next block after a so (a+1) and then I simply swapped the two. 
		  
		  int a = 0;
		  for (int i = 0; i < cells.length; i++) {
			  if (cells[i].getBlock().isMagic()) {
				  a = i;
			  }
		  } 
			  Block current = cells[a].getBlock();
			  Block next = cells[(a + 1)%cells.length].getBlock();
			  cells[(a+1)%cells.length].setBlock(current);
			  cells[a].setBlock(next);
		}
	  
  @Override
  public Shape clone()
  {
    try
    {
      AbstractShape s = (AbstractShape) super.clone();

      // TODO: make it into a deep copy
      s.pos = new Position(pos);
      s.cells = new Cell[cells.length];
      for (int i = 0; i < s.getCells().length; i++) {
    	  s.cells[i] = new Cell(cells[i]);
      }
      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }
  }
}
