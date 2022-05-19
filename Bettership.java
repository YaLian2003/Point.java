//Yangyang Lian
import java.util.Scanner;

public class Battleship {
   public static void main(String[] args)
   {
       boolean gameRunning = true;
      
       Ship submarine = new Ship(new Point(1,1), false, 3);
       Ship destroyer = new Ship(new Point(5,5), false, 4);
       Ship carrier = new Ship(new Point(10,1), true, 5);
       Ship patrol = new Ship(new Point(2,6),true,2);
       Ship battleship = new Ship(new Point(3,7),false,4);
          
       Board newBoard = new Board();      
      
       newBoard.display();
      
       newBoard.addShip(submarine);
       newBoard.addShip(destroyer);
       newBoard.addShip(carrier);
       newBoard.addShip(patrol);
       newBoard.addShip(battleship);
      
       while (gameRunning)
       {
           Scanner keyboard = new Scanner(System.in);
          
           System.out.println("\nEnter two coordinates separated by a space: ");
           String inputX = keyboard.next();
           String inputY = keyboard.next();
          
           int xValue = Integer.parseInt(inputX);
           int yValue = Integer.parseInt(inputY);
      
           Point shot = new Point (xValue, yValue);
          
           if (submarine.shotFiredAtPoint(shot) ||
               destroyer.shotFiredAtPoint(shot) ||
               carrier.shotFiredAtPoint(shot) ||
               patrol.shotFiredAtPoint(shot) ||
               battleship.shotFiredAtPoint(shot)) // YOU HIT
           {
               System.out.println("Hit!");
               if (submarine.sunk)
                   System.out.println("You sunk the submarine!");
               else if (destroyer.sunk)
                   System.out.println("You sunk the destroyer!");
               else if (carrier.sunk)
                   System.out.println("You sunk the carrier!");
               else if (patrol.sunk)
                   System.out.println("You sunk the patrol!");
               else if (battleship.sunk)
                   System.out.println("You sunk the battleship!");
              
               newBoard.hitBoard.add(shot);
               newBoard.shipBoard.add(shot);
               newBoard.display();
              
               System.out.print("HITS = ");
               for (int i = 0; i < newBoard.hitBoard.size(); i++)
               {
                   System.out.print(" [" + newBoard.hitBoard.get(i).getX() + " " + newBoard.hitBoard.get(i).getY() + "] ");
               }
                  
           }
           else // YOU MISSED
           {
               System.out.println("Miss! Try again...");
               newBoard.missBoard.add(shot);
               newBoard.display();
               System.out.print("MISSES = ");

               for (int i = 0; i < newBoard.missBoard.size(); i++)
               {
                   System.out.print(" [" + newBoard.missBoard.get(i).getX() + " " + newBoard.missBoard.get(i).getY() + "] ");
               }
           }
       }
   }

}
