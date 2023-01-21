import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lasers the aliens fire.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class aLaser extends Actor
{
    int aLaserSpeed = 5;
    public aLaser()
    {
        getImage().scale(13,15);
    }
    
    public void act() 
    {
        int x = getX();
        int y = getY() + aLaserSpeed;
        setLocation(x,y);
        
        World world = (World) getWorld();
        if(getY() <= 0)
        {
            world.removeObject(this);
        }
    } 
}

