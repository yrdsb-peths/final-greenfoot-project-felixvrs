import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The laser your spaceship shoots.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Laser extends Actor
{
    int laserSpeed = 4;
    
    public void act() 
    {
        int x = getX();
        int y = getY() + laserSpeed;
    }    
}
