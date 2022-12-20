import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stars for our colourful, star-filled space.
 * 
 * @author Felix Wu
 * @version December 2022
 */
public class Stars extends Actor
{
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Stars falls downwards
        int x = getX();
        int y = getY();
        setLocation(x, y);
        
        // Remove stars when it reaches bottom of screen
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
        }
    }   
    
    
}
