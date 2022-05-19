//Yangyang Lian
import java.util.ArrayList;

public class Ship {
   boolean isVertical;
   int size;
   Point origin;
   int hits;
   boolean sunk = false;
  
   ArrayList<Point> ship = new ArrayList<Point>();

//   this constructor accepts the origin or the ship (its lowest, or leftmost point),
//   its length, and its orientation (vertical, or horizontal).
   Ship(Point myOrigin, boolean vertical, int length)
   {
       origin = new Point(myOrigin.getX(), myOrigin.getY());
       isVertical = vertical;
       size = length;
      
       if (isVertical)
       {
           for (int index = 0; index < size; index++)
           {
               ship.add(new Point(origin.getX(), origin.getY() + index));      
           }
       }
       else
       {
           for (int index = 0; index < size; index++)
           {
               ship.add(new Point(origin.getX() + index, origin.getY()));      
           }
       }
   }

   //   Returns true if a Ship covers a point on the board, false if it does not.
   boolean containsPoint(Point p)
   {
//       for (int index = 0; index)
//       return this.origin.getX() == p.getX() && this.origin.getY() == p.getX();
       return true;
   }
  
//   Returns true if the receiving ship shares a point with the argument ship. Collides with it, so to speak.
   public boolean collidesWith(Ship s)
   {
       return true;
   }
  
//   This is a verb in the game. When the user enters a coordinate, this method can be called on each ship.
//   If the ship contains the point, it should remember that it has been hit at that point. It could
//   do this with a second PointCollection, or some other data strategy
   public boolean shotFiredAtPoint(Point p)
   {
       boolean wasHit = false;
      
       for(int i = 0; i < size; i++)
       {
           if (ship.get(i).equals(p))
           {
               hits++;
               wasHit = true;
           }
       }
       if (hits == size)
           sunk = true;
      
       return wasHit;
   }
  
//   Returns true if shotFiredAtPoint has been called for this point in the ship.
//   False if it has not, or if the point is not in the ship.
   public boolean isHitAtPoint(Point p)
   {
       return false;
   }
  
//   Returns the number of points in the ship that have been hit.
//   When the hitCount is equal to the length of the ship the ship is considered to be sunk.
   public int hitCount()
   {
       return hits;
   }
}
