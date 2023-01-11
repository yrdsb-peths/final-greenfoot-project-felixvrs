import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player's vehicle, a spaceship. Defeat your enemies by shooting lasers!
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Spaceship extends Actor
{
    int speed = 2;
    /**
     * Act - do whatever the Spaceship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Spaceship moves at constant speed to keep up with background
        int x = getX();
        int y = getY() - speed;
        setLocation(x, y);
    }
}
