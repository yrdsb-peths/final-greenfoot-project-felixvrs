import greenfoot.*;

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
    
    public Background()
    {
        super(WIDE, HIGH, 1, false); // create an unbounded world
        GreenfootImage image = new GreenfootImage("space.png"); // the background image
        scroller = new Scroller(this, image); // create the Scoller object
        
        Spaceship spaceship = new Spaceship(); 
        addObject(spaceship, 250, 550);
    }
    
    public void act()
    {
        scroll();
    }
    
    private void scroll()
    {
        int speed = 2;
        scroller.scroll(0, -speed);
    }
}
