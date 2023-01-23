import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The laser your spaceship shoots.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Laser extends Actor
{
    int laserSpeed = 15;
    public Laser()
    {
        getImage().scale(10,20);
    }
    
    public void act() 
    {
        // Keeps laser constantly "moving"
        int x = getX();
        int y = getY() - laserSpeed;
        setLocation(x,y);
        
        // Removes laser object if it reaches the world height
        World world = (World) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
        }
    } 
    
}
