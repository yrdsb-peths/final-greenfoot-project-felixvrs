import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player's vehicle, a spaceship. Defeat your enemies by shooting lasers!
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Spaceship extends Actor
{
    GreenfootSound fireSound = new GreenfootSound("fire.mp3");
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
        
        // If spaceship is at the edge of viewport, stops it moving further
        if(isAtEdge())
        {
            move(0);
        }
        
        // Spaceship controls
        if(Greenfoot.isKeyDown("left") && (getX() >= 0))
        {
            move(-4);
        }
        else if(Greenfoot.isKeyDown("right") && (getX() <= 500))
        {
            move(4);
        }
        
        // If player clicks space, shoots laser (if timer equals 0)
        if(Greenfoot.isKeyDown("space"))
        {
            if(canShoot == true)
            {
                shootLaser();
                canShoot = false;
                fireTimer = 40;
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
        
        // If spaceship is hit by alien laser, removes it from world and 
        // creates explosion
        if(isTouching(aLaser.class))
        {
            removeTouching(aLaser.class);
            createsExplosion();
            World world = (World) getWorld();
            world.removeObject(this);
        }
    }
    
    /**
     * Creates and shoots laser object in the world
     */
    public void shootLaser()
    {
        Laser laser = new Laser();
        getWorld().addObject(laser,getX(),getY()-40);
        fireSound.play();
    }
    
    /**
     * Creates explosion in the world
     */
    public void createsExplosion()
    {
        sExplosion explosion = new sExplosion();
        getWorld().addObject(explosion,getX(),getY());
    }
}
