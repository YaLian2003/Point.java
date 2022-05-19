//Yangyang Lian
class Board{
   ArrayList<Point> hits;
   ArrayList<Point> miss;
   int x;
   int y;
  
   Board(int length, int breath){
       this.x=breath;
       this.y=length;
       hits = new ArrayList<Point>();
       miss = new ArrayList<Point>();
      
   }
   //Keep track for hits
   public boolean isHits(int x, int y) {
       for(Point p : hits) {
           if(p.x==x && p.y==y) {
               return true;
           }
       }
       return false;
   }
   //Keep track of miss
   public boolean ismiss(int x , int y) {
       for(Point p : miss) {
           if(p.x==x && p.y==y) {
               return true;
           }
       }
       return false;
   }
   public void displayBoard() {
       for(int i=y-1;i>=0;i--) {
           System.out.print(i+" ");
           for(int j=x-1;j>=0;j--) {
               if(isHits(j,i)) {
                   System.out.print("X"+" ");
               }else if(ismiss(j,i)) {
                   System.out.print("."+" ");
               }else {
                   System.out.print("~"+" ");
               }
              
           }
           System.out.println();
       }
       System.out.print(" ");
       for(int i=x;i>0;i--) {
           System.out.print(i-1+" ");
       }
       System.out.println();
   }
}

public class Game {

   public static void main(String[] args) {
       //Let's create a Board
       Board b = new Board(10,10);
       //Lets create 5 ships
       Ship s1 = new Ship(new Point(2,1),true,3);
       Ship s2 = new Ship(new Point(5,3),false,2);
       Ship s3 = new Ship(new Point(3,5),true,2);
       Ship s4 = new Ship(new Point(4,1),true,1);
       Ship s5 = new Ship(new Point(7,1),true,1);
      
       Scanner sc = new Scanner(System.in);
       b.displayBoard();
       while(true) {
           System.out.println("Enter a coordinate: ");
           int x = sc.nextInt();
           int y = sc.nextInt();
           Point temp = new Point(x,y);
           s1.shotFiredAtPoint(temp);
           s2.shotFiredAtPoint(temp);
           s3.shotFiredAtPoint(temp);
           s4.shotFiredAtPoint(temp);
           s5.shotFiredAtPoint(temp);
          
           if(s1.isHitAtPoint(temp) || s2.isHitAtPoint(temp) || s3.isHitAtPoint(temp) || s4.isHitAtPoint(temp) || s5.isHitAtPoint(temp)) {
   System.out.println("Hit");  
   b.hits.add(temp);
           }else {
               System.out.println("Miss");
               b.miss.add(temp);
           }
          
           if(s1.isSunk() && s2.isSunk() && s3.isSunk() && s4.isSunk() && s5.isSunk()) {
               System.out.println("All the ship has been sunk ");
               break;
           }
           b.displayBoard();
          
          
       }
      
      

   }

}
