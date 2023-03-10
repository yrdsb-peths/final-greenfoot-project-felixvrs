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
    GreenfootSound newStage = new GreenfootSound("levelstart.mp3"); 
    boolean firstInstance = true;
    
    public Stage()
    {
        stageTimer.mark();
    }
    
    public void act()
    {
        // Checks if this is the first stage being created
        if(firstInstance == true)
        {
            if(stageTimer.millisElapsed() > 1000)
            {
                makeStage();
                newStage.play();
                stageTimer.mark();
                firstInstance = false;
            }
        }
        newLevel();
    }
    
    /**
     * Creates yellow alien
     */
    public void makeYellow(int x, int y)
    {
        Yellow yellow = new Yellow();
        getWorld().addObject(yellow, x, y);
    }
    
    /**
     * Creates red alien
     */
    public void makeRed(int x, int y)
    {
        Red red = new Red();
        getWorld().addObject(red, x, y);
    }
    
    /**
     * Creates green alien
     */
    public void makeGreen(int x, int y)
    {
        Green green = new Green();
        getWorld().addObject(green, x, y);
    }
    
    /**
     * Creates stage of aliens
     */
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
    
    /**
     * Creates a new stage if all alien objects are destroyed
     */
    public void newLevel()
    {
        if(getWorld().getObjects(Green.class).isEmpty() && getWorld().getObjects(Red.class).isEmpty() && getWorld().getObjects(Yellow.class).isEmpty() && firstInstance == false)
        {
            if(stageTimer.millisElapsed() >= 1000)
            {
                makeStage();
                newStage.play();
                stageTimer.mark();
            }
        }
    }
}
