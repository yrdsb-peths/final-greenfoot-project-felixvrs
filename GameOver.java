import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Actor
{
    public int scrollSpeed = 2;
    
    public GameOver()
    {
        getImage().scale(600, 600);
    }
    
    public void act()
    {
       setLocation(getX(), getY() - scrollSpeed); 
       if(getWorld().getObjects(Spaceship.class).isEmpty())
        {
            scrollSpeed = 0;
        }
    }
}
