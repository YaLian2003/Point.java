//Yangyang Lian
class Point{
   //Data members
   int x;
   int y;
   //Constructor
   Point(int x,int y){
       this.x=x;
       this.y=y;
      
   }
}
class Ship{
   ArrayList<Point> ship;
   ArrayList<Point> hits;
   Point origin;
   boolean isVertical;
   int length;
   Ship(Point origin, boolean isVertical, int length){
       ship = new ArrayList<Point>();
       hits = new ArrayList<Point>();
       this.origin=origin;
       this.isVertical=isVertical;
       this.length=length;
      
      
       int x=origin.x;
       int y=origin.y;
      
       for(int i=0;i<length;i++) {
           if(isVertical) {
               //For vertical ship
               Point p = new Point(x,y+i);
               ship.add(p);
           }else {
               //For horizontal ship
               Point p = new Point(x+i,y);
               ship.add(p);
           }
          
       }
      
      
   }
   //Returns true if a Ship covers a point on the board, false if it does not
   boolean containsPoint(Point p) {
       return false;
      
   }
   //Returns true if the receiving ship shares a point with the argument ship. Collides with it, so to speak
   boolean collidesWith(Ship s) {
       for(Point p : ship) {
           for(Point p2 : s.ship) {
               if((p.x==p2.x)&&(p.y==p2.y)){
                   return true;
               }
           }
       }
       return false;
   }
  
   //if the ship contains the point, it should remember that it has been hit at that point. It could do this with a second PointCollection, or some other data strategy
   void shotFiredAtPoint(Point p) {
       for(Point p1 : ship) {
           if((p1.x==p.x)&&(p1.y==p.y)) {
               hits.add(p);
           }
       }
   }
  
   //returns true if shotFiredAtPoint has been called for this point in the ship. False if it has not, or if the point is not in the ship
   boolean isHitAtPoint(Point p) {
       for(Point p1 : hits) {
           if((p1.x==p.x)&&(p1.y==p.y)) {
               return true;
           }
       }
       return false;
   }
   //returns the number of points in the ship that have been hit. When the hitCount is equal to the length of the ship the ship is considered to be sunk.
   int hitCount() {
       return hits.size();
   }
  
   boolean isSunk(){
       return ship.size()== hits.size();
   }
  
   }
