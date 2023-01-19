import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Green alien.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Green extends Actor
{
    int speed = 2;
    GreenfootImage[] animateGreen = new GreenfootImage[2];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Green()
    {
        getImage().scale(35,30);
        
        for(int i = 0; i < animateGreen.length; i++)
        {
            animateGreen[i] = new GreenfootImage("images/green/green" + i + ".png");
            animateGreen[i].scale(35,30);
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
        
        animateG();
    }
    
    int imageIndex = 0;
    public void animateG()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        setImage(animateGreen[imageIndex]);
        imageIndex = (imageIndex + 1) % animateGreen.length;
    }
}
