import greenfoot.*;


/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        Ship myShip = new Ship(size,Greenfoot.getRandomNumber(10),Greenfoot.getRandomNumber(10));
        ships [shipCount++] = myShip;
        
    }
}

