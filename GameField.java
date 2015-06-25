import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class GameField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameField extends World
{
    Board humanBoard;
    Board computerBoard;
    Board currentBoard;
    // размер ячейки
    final static int CELLSIZE = 20;
    // отступ слева для поля человека
    final static int LEFT_X_HUMAN_BOARD = 20;
    // отступ от верха для поля человека
    final static int TOP_Y_HUMAN_BOARD = 30;
    // аналогично для поля компьютера
    final static int LEFT_X_COMPUTER_BOARD = 300;
    final static int TOP_Y_COMPUTER_BOARD = 30;

    /**
     * Constructor for objects of class GameField.
     * 
     */
    public GameField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        // создаем поле для человека и компьютера
        humanBoard    = new Board ();
        computerBoard = new Board ();
        // выставляем первый ход у человека
        currentBoard  = humanBoard;
        
        // создаем корабли на поле человека
        humanBoard.createShip(3);
        humanBoard.createShip(4);
        humanBoard.createShip(2);
        
        // создаем корабли на поле компьютера
        computerBoard.createShip(3);
        computerBoard.createShip(4);
        computerBoard.createShip(2);
        
        // отрисовываем поля человека и компьютера
        drawBoard(humanBoard);
        drawBoard(computerBoard);
       
    }
    
    
    // отрисовка поля. Параметр - какое поле рисуем (обычно humanBoard или computerBoard)
    public void drawBoard (Board board)
    {
        // проходимся по всем 100 ячейкам и вызываем для каждой drawCell
        for (int x = 0; x < 10; x++)
        {
           for (int y = 0; y < 10; y++)
            {
               drawCell(board, x, y);
            }
        }
        // рисуем корабли поверх поля
        // проходимся по всем кораблям и рисуем каждый через drawShips
        for (int i = 0; i < board.shipCount; i++) {
             drawShip(board, i);
         }

    }
    
    // отрисовка одной ячейки поля. В параметрах передается поле (humanBoard или computerBoard), а также координаты ячейки (0..9,0..9)
    public void drawCell (Board board, int x, int y)
    {
        
       // вычисляем отступы. Они разые для разных полей 
       final  int LEFT_X = (board == humanBoard) ? LEFT_X_HUMAN_BOARD : LEFT_X_COMPUTER_BOARD;
       final  int TOP_Y  = (board == humanBoard) ? TOP_Y_HUMAN_BOARD : TOP_Y_COMPUTER_BOARD;
     
       getBackground().setColor(new Color(0,0,0));
       // рисуем черный прямоугольник в ячейке
       getBackground().fillRect(LEFT_X  + x * CELLSIZE, 
                                TOP_Y   + y * CELLSIZE, 
                                CELLSIZE-2, 
                                CELLSIZE-2);
       //TODO: отрисовывать иначе ячейки, в которые стреляли (status)                         
    }
    
    //отрисовка i-го корабля
    public void drawShip(Board board, int shipID)
    {
        int sizeOfShip = humanBoard.ships[shipID].size;
        for (int i = 0; i< sizeOfShip; i++) 
          {
            drawShipCell(board,
                    board.ships[shipID].cells[i].X, 
                    board.ships[shipID].cells[i].Y);
         }   
         // отрисовывать иначе корабль, который убит полностью (status)
    }
    
    // отрисовка ячейки i-го корабля с координатами x,y
    public void drawShipCell(Board board, int x, int y)
    {
       final  int LEFT_X = (board == humanBoard) ? LEFT_X_HUMAN_BOARD : LEFT_X_COMPUTER_BOARD;
       final  int TOP_Y  = (board == humanBoard) ? TOP_Y_HUMAN_BOARD : TOP_Y_COMPUTER_BOARD;
       // ячейка корабля - красная
       getBackground().setColor(new Color(255,0,0));
       getBackground().fillRect(LEFT_X  + x * CELLSIZE, 
                                TOP_Y   + y * CELLSIZE, 
                                CELLSIZE-2, 
                                CELLSIZE-2);
       //TODO: отрисовывать иначе убитые ячейки
                                
    }
    
}
