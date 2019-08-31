
package shapes;

import java.util.ArrayList;
import java.util.Random;

import api.Generator;
import api.Position;
import api.Shape;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 * 
 * @author Aaqib Issa
 */
public class BasicGenerator implements Generator
{
  @Override
  public Shape getNext(int width)
  {
	  boolean isMagic = false;
	  Random rand = new Random();
	  Random rand1 = new Random();
	  int[] arr = {1, 2, 3, 4, 5};
	  int a = arr[rand1.nextInt(arr.length)];
	  if (a == 3) {
		  isMagic = true;
	  }
	  
	  // Create the shapes
	  Shape L = new LShape(new Position(-1, (width / 2) + 1), isMagic);
	  Shape J = new JShape(new Position(-1, width / 2), isMagic);
	  Shape I = new IShape(new Position(-2, width / 2), isMagic);
	  Shape O = new OShape(new Position(-1, width / 2), isMagic);
	  Shape T = new TShape(new Position(0, width / 2), isMagic);
	  Shape SZ = new SZShape(new Position(-1, width / 2), isMagic);
	  
	  // Add shapes to ArrayList
	  ArrayList<Shape> array = new ArrayList<Shape>();
      array.add(L); array.add(J); array.add(I); array.add(O); 
	  array.add(T);
      array.add(SZ);
	  int x = rand.nextInt(array.size());
	  Shape shape = array.get(x);
	  
    return shape;
  }
}
