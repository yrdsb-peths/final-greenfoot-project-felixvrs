import greenfoot.*;
import java.util.List;
/**
 * Non-stop scrolling background.
 * 
 * @author danpost (Greenfoot user)
 * @version January 2023
 */
public class Background extends World
{
    public static final int WIDE = 500; // world width (viewport)
    public static final int HIGH = 650; // world height (viewport)
    
    private Scroller scroller;
    
    private static final int SPD=1;
    private int num=10;
    private int speed;
    private boolean dir=false;
    private int counter=0;
    private int amntAliens=0;
    
    public Background()
    {
        super(WIDE, HIGH, 1, false); // create an unbounded world
        GreenfootImage image = new GreenfootImage("space.png"); // the background image
        scroller = new Scroller(this, image); // create the Scoller object
        speed=dir?-SPD:SPD;
        
        Spaceship spaceship = new Spaceship(); 
        addObject(spaceship, 250, 550);
        
        Stage stage = new Stage();
        addObject(stage, 100, 100);
    }
    
    public void act()
    {
        scroll();
        counter++;
        speed=dir?-SPD:SPD;
        List <Yellow> yellows=getObjects(Yellow.class);
        for(Yellow yellow:yellows)
        {
            yellow.moveYellows();
        }
        
        List <Red> reds=getObjects(Red.class);
        for(Red red:reds)
        {
            red.moveReds();
        }
        
        List <Green> greens=getObjects(Green.class);
        for(Green green:greens)
        {
            green.moveGreens();
        }
    }
    
    private void scroll()
    {
        int speed = 2;
        scroller.scroll(0, -speed);
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public boolean getDir()
    {
        return dir;
    }
    
    public int getCounter()
    {
        return counter;
    }
    
    public void setZero()
    {
        counter=0;
    }
    
    public void setDir(boolean direction)
    {
        dir=direction;
    }
}
