import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Actor
{
    public GameOver()
    {
        getImage().scale(500, 250);
    }
    
    public void act()
    {
       setLocation(getX(), getY() - 2); 
    }
}
