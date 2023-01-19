import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Red alien.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Red extends Actor
{
    int speed = 2;
    GreenfootImage[] animateRed = new GreenfootImage[2];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Red()
    {
        getImage().scale(35,30);
        
        for(int i = 0; i < animateRed.length; i++)
        {
            animateRed[i] = new GreenfootImage("images/red/red" + i + ".png");
            animateRed[i].scale(35,30);
        }
        
        animationTimer.mark();
    }
    public void act()
    {
        int x = getX();
        int y = getY() - speed;
        setLocation(x, y);
        
        if(isTouching(Laser.class))
        {
            removeTouching(Laser.class);
            World world = (World) getWorld();
            world.removeObject(this);
        }
        
        animateR();
    }
    
    int imageIndex = 0;
    public void animateR()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        setImage(animateRed[imageIndex]);
        imageIndex = (imageIndex + 1) % animateRed.length;
    }
}
