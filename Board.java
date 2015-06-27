import greenfoot.*;


/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
enum Side {HORIZONTAL, VERTICAL};
public class Board extends Actor
{
    int shipCount;
    Ship[] ships = new Ship[10];
    Cell [][] cells = new Cell [10][10];
    /**
     * Act - do whatever the Board wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
       
    public void createShip (int size)
    {
        
        int guessX, guessY;
        Side side;
        boolean[][] unavailableCells  = new boolean [10][10];
        System.out.println("creating list...");
        createUnavailableCellsList (unavailableCells);
        
        System.out.println("creating ship...");
        do {
            guessY = Greenfoot.getRandomNumber(10);
            guessX = Greenfoot.getRandomNumber(10);
     
            side   = Greenfoot.getRandomNumber(2)==1 ? Side.HORIZONTAL : Side.VERTICAL; 
            System.out.println(guessX+":"+guessY+":"+size+":" + ((side == Side.HORIZONTAL) ? "H" : "V" ));
         }  while (!availableForShip(unavailableCells, size, guessX, guessY, side));
           System.out.println("found ("+shipCount+")!"+guessX+":"+guessY+":"+size+":"+ ((side == Side.HORIZONTAL) ? "H" : "V" ));
           Ship myShip = new Ship(size, guessX, guessY, side);
           ships [shipCount++] = myShip;  
           
    }
    public void test()        
        {
           boolean[][] unavailableCells  = new boolean [10][10];                     
           
           createUnavailableCellsList (unavailableCells); 
           Ship myShip = new Ship(4, 5, 5, Side.HORIZONTAL);
           ships [shipCount++] = myShip; 
           createUnavailableCellsList (unavailableCells);
           
           System.out.println("MUST BE FALSE: "+(availableForShip(unavailableCells, 1, 5, 5, Side.HORIZONTAL) ? "TRUE" : "FALSE"));
           System.out.println("MUST BE FALSE: "+(availableForShip(unavailableCells, 1, 4, 4, Side.HORIZONTAL) ? "TRUE" : "FALSE"));
           System.out.println("MUST BE FALSE: "+(availableForShip(unavailableCells, 1, 5, 4, Side.HORIZONTAL) ? "TRUE" : "FALSE"));
           System.out.println("MUST BE FALSE: "+(availableForShip(unavailableCells, 1, 5, 6, Side.HORIZONTAL) ? "TRUE" : "FALSE"));           
           System.out.println("MUST BE FALSE: "+(availableForShip(unavailableCells, 1, 4, 6, Side.HORIZONTAL) ? "TRUE" : "FALSE"));             
        }
        
        
   public boolean availableForShip (boolean[][] unavailableCells, int size, int guessX, int guessY, Side side)
   {
      if (side == Side.HORIZONTAL) {
            if (guessX + size -1  > 9) { return false; }
            for (int i = guessX; i <= guessX + size -1 ; i ++ ) 
             {
                 System.out.println("un["+i+","+guessY+"]");
                 if (unavailableCells[i][guessY] == false) { return false; }
             }
            return true;
        }
      if (side == Side.VERTICAL) {
            if (guessY + size -1  > 9) { return false; }
            for (int i = guessY; i <= guessY + size -1 ; i ++ ) 
             {              
                 System.out.println("un["+guessX+","+i+"]");
                 if (unavailableCells[guessX][i] == false) { return false; }
             }
            return true;
        }  
      return true; 
   }
   public void createUnavailableCellsList (boolean[][] unavailableCells)
    {
        System.out.println("filling with false...");
        for (int x = 0; x < 10; x++)
        {
           for (int y = 0; y < 10; y++)
            {
               unavailableCells [x][y] = true;
            }
        }
        //перебираем все корабли и их cells (ячейки) 
      // помечаем как false все ячейки с корабями + все вокруг 
      System.out.println("filling with ships..");
        for (Ship ship : ships)
        {
            
            if (ship != null) 
            for (Cell cell : ship.cells)
            {
                if (cell != null)
                 {
                    System.out.println(cell.X + "," + cell.Y);
                    if (cell.X > 9 || cell.Y > 9 || cell.X < 0 || cell.Y < 0) { continue; }
                     unavailableCells [cell.X] [cell.Y] = false;
                    if (cell.X > 0) {
                        unavailableCells [cell.X-1] [cell.Y] = false;
                        if (cell.Y > 0) unavailableCells [cell.X-1] [cell.Y-1] = false;
                        if (cell.Y < 9) unavailableCells [cell.X-1] [cell.Y+1] = false;
                    }
                    if (cell.Y > 0) {
                        unavailableCells [cell.X] [cell.Y-1] = false;
                    }
                    if (cell.X < 9) {
                        unavailableCells [cell.X+1] [cell.Y] = false;
                        if (cell.Y > 0) unavailableCells [cell.X+1] [cell.Y-1] = false;
                        if (cell.Y < 9) unavailableCells [cell.X+1] [cell.Y+1] = false;
                    }
                    if (cell.Y < 9) {
                        unavailableCells [cell.X] [cell.Y+1] = false;
                    }
                }
            }
        }
         System.out.println("DONE");
    }
   
    
}

