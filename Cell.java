import greenfoot.*;

/**
 * Write a description of class Cell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
enum StatusList {INJURED, ALIVE};
public class Cell extends Actor
{
    int X;
    int Y;
    StatusList status;
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // 
    }    
    public void setStatus (StatusList status)
    {
       this.status = status;
    }
    Cell (int X, int Y) 
    {
        this.X = X;
        this.Y = Y;
        this.status = StatusList.ALIVE;
    }
    
}
