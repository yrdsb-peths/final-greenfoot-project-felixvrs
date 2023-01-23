import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Yellow alien.
 * 
 * @author Felix Wu 
 * @version January 2023
 */
public class Yellow extends Actor
{
    int speed = 2;
    GreenfootImage[] animateYellow = new GreenfootImage[2];
    GreenfootSound deathSound = new GreenfootSound("death.mp3");
    SimpleTimer animationTimer = new SimpleTimer();
    boolean canShoot = true;
    int fireTimer = 120;
    
    public Yellow()
    {
        getImage().scale(40,40);
        
        for(int i = 0; i < animateYellow.length; i++)
        {
            animateYellow[i] = new GreenfootImage("images/yellow/yellow" + i + ".png");
            animateYellow[i].scale(40,40);
        }
        animationTimer.mark();

    }
    
    public void act()
    {
        // Keep alien "moving"
        int x = getX();
        int y = getY() - speed;
        setLocation(x, y);
        
        // Checks if enough time has passed to attempt to fire a laser
        if(canShoot == true)
        {
            randomFire();
            canShoot = false;
            fireTimer = 25;
        }
        else if(fireTimer <= 0)
        {
            canShoot = true;
        }
        fireTimer--;
        
        // "Destroys" alien if hit by laser
        if(isTouching(Laser.class))
        {
            removeTouching(Laser.class);
            deathSound.play();
            createExplosion();
            increaseScore();
            World world = (World) getWorld();
            world.removeObject(this);
        }
        
        // Animates alien
        animateY();
    }
    
    int imageIndex = 0;
    /**
     * Animates alien
     */
    public void animateY()
    {
        if(animationTimer.millisElapsed() < 350)
        {
            return;
        }
        animationTimer.mark();
        setImage(animateYellow[imageIndex]);
        imageIndex = (imageIndex + 1) % animateYellow.length;
    }
    
    /**
     * Creates explosion in the world
     */
    public void createExplosion()
    {
        Explosion explosion = new Explosion();
        getWorld().addObject(explosion,getX(),getY());
    }
    
    /**
     * Randomly fire a laser
     */
    public void randomFire()
    {
        int x = Greenfoot.getRandomNumber(40);
        if(x == 5)
        {
            shootaLaser();
        }
    }
    
    /**
     * Creates an alien laser object in the world
     */
    public void shootaLaser()
    {
        aLaser alaser = new aLaser();
        getWorld().addObject(alaser,getX(),getY()+30);
    }
    
    /**
     * Move yellow alien objects horizontally in-sync 
     */
    public void moveYellows()
    {
        Background background = (Background) getWorld();
        setLocation(getX() + background.getSpeed(),getY());
        if(isAtEdge() && background.getCounter()>1)
        {
            background.setDir(background.getDir()?false:true);
            background.setZero();
        }
    }
    
    /**
     * Increase score by 50 if you destroy a yellow alien
     */
    public void increaseScore()
    {
        Background background = (Background) getWorld();
        background.score+=50;
        background.scoreLabel.setValue(background.score);
    }
}
