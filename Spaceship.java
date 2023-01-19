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
    int fireTimer = 120;
    boolean canShoot = true;
    
    public Spaceship()
    {
        getImage().scale(50,50);
    }
    public void act() 
    {
        // Spaceship moves at constant speed to keep up with background
        int x = getX();
        int y = getY() - speed;
        setLocation(x, y);
        
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(4);
        }
        if(Greenfoot.isKeyDown("space"))
        {
            if(canShoot == true)
            {
                shootLaser();
                canShoot = false;
                fireTimer = 20;
            }
            else
            {
                if(fireTimer <= 0)
                {
                    canShoot = true;
                }
            }
        }
        fireTimer--;
    }
    
    public void shootLaser()
    {
        Laser laser = new Laser();
        getWorld().addObject(laser,getX(),getY()-40);
    }
     
}
