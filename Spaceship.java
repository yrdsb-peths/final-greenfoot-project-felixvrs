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
        
        if(isAtEdge())
        {
            move(0);
        }
        if(Greenfoot.isKeyDown("left") && (getX() >= 0))
        {
            move(-4);
        }
        else if(Greenfoot.isKeyDown("right") && (getX() <= 500))
        {
            move(4);
        }
        if(Greenfoot.isKeyDown("space"))
        {
            if(canShoot == true)
            {
                shootLaser();
                canShoot = false;
                fireTimer = 25;
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
        
        if(isTouching(aLaser.class))
        {
            removeTouching(aLaser.class);
            createsExplosion();
            World world = (World) getWorld();
            world.removeObject(this);
            gameOver();
        }
    }
    
    public void shootLaser()
    {
        Laser laser = new Laser();
        getWorld().addObject(laser,getX(),getY()-40);
    }
     
    public void createsExplosion()
    {
        sExplosion explosion = new sExplosion();
        getWorld().addObject(explosion,getX(),getY());
    }
    
    private void gameOver()
    {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver,250,325);
    }
}
