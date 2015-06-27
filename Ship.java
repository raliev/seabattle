import greenfoot.*;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
enum ShipStatusList {ALIVE, KILLED, INJURED};
public class Ship extends Actor
{
    ShipStatusList status;
    int size;
    Cell [] cells = new Cell[10];
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Ship(int size, int X, int Y, Side side) {
        
          for (int i = 0; i < size; i++)
            {
                Cell myCell;
                if (side == Side.HORIZONTAL) {
                         myCell = new Cell (X+i, Y);
                    } else 
                    {
                         myCell = new Cell (X, Y+i);
                    }
      
            cells [i] = myCell;
           
            }
        
            this.size = size;
            this.status = ShipStatusList.ALIVE;
            
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
