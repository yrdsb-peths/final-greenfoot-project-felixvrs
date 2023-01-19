import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Yellow alien.
 * 
 * @author Felix Wu 
 * @version January 2023
 */
public class Yellow extends Actor
{
    int speed = 2;
    GreenfootImage[] animateYellow = new GreenfootImage[2];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Yellow()
    {
        getImage().scale(35,30);
        
        for(int i = 0; i < animateYellow.length; i++)
        {
            animateYellow[i] = new GreenfootImage("images/yellow/yellow" + i + ".png");
            animateYellow[i].scale(35,30);
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
            createExplosion();
            World world = (World) getWorld();
            world.removeObject(this);
        }
        
        animateY();
    }
    
    int imageIndex = 0;
    public void animateY()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        setImage(animateYellow[imageIndex]);
        imageIndex = (imageIndex + 1) % animateYellow.length;
    }
    
    public void createExplosion()
    {
        Explosion explosion = new Explosion();
        getWorld().addObject(explosion,getX(),getY());
    }
}
