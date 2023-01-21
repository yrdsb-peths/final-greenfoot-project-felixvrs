import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stage of aliens.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Stage extends Actor
{
    SimpleTimer stageTimer = new SimpleTimer();
    
    public Stage()
    {
        stageTimer.mark();
    }
    
    public void act()
    {
        newLevel();
    }
    
    public void makeYellow(int x, int y)
    {
        Yellow yellow = new Yellow();
        getWorld().addObject(yellow, x, y);
    }
    
    public void makeRed(int x, int y)
    {
        Red red = new Red();
        getWorld().addObject(red, x, y);
    }
    
    public void makeGreen(int x, int y)
    {
        Green green = new Green();
        getWorld().addObject(green, x, y);
    }
    
    public void makeStage()
    {
        for(int x=0; x<11; x++)
        {
            makeYellow(50+(x*40),175);
        }
        for(int x=0; x<9; x++)
        {
            makeRed(90+(x*40),135);
        }
        for(int x=0; x<5; x++)
        {
            makeGreen(170+(x*40),95);
        }
    }
    
    public void newLevel()
    {
        if(getWorld().getObjects(Green.class).isEmpty() && getWorld().getObjects(Red.class).isEmpty() && getWorld().getObjects(Yellow.class).isEmpty())
        {
            if(stageTimer.millisElapsed() > 2000)
            {
                makeStage();
                stageTimer.mark();
            }
        }
    }
}
