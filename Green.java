import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Green alien.
 * 
 * @author Felix Wu 
 * @version January 2023
 */
public class Green extends Actor
{
    int speed = 2;
    GreenfootImage[] animateGreen = new GreenfootImage[2];
    GreenfootImage[] animateBlue = new GreenfootImage[2];
    GreenfootSound deathSound = new GreenfootSound("death.mp3");
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer animationTimer2 = new SimpleTimer();
    boolean canShoot = true;
    boolean beenHit = false;
    int fireTimer = 120;
    
    public Green()
    {
        getImage().scale(40,40);
        
        for(int i = 0; i < animateGreen.length; i++)
        {
            animateGreen[i] = new GreenfootImage("images/green/green" + i + ".png");
            animateGreen[i].scale(40,40);
        }
        animationTimer.mark();
        
        for(int i = 0; i < animateBlue.length; i++)
        {
            animateBlue[i] = new GreenfootImage("images/blue/blue" + i + ".png");
            animateBlue[i].scale(40,40);
        }
        animationTimer2.mark();
        
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
        
        // If green alien is hit by a laser once, it becomes a blue alien 
        // If it is hit twice, it is "destroyed" and removed from world
        if(isTouching(Laser.class))
        {
            removeTouching(Laser.class);
            if(beenHit == false)
            {
                beenHit = true;
            }
            else
            {
                createExplosion();
                deathSound.play();
                increaseScore();
                World world = (World) getWorld();
                world.removeObject(this);
            }
        }
        
        // Changes to blue alien animation if green alien has "beenHit"
        if(beenHit == true)
        {
            animationChange();
        }
        else
        {
           animateG();
        }
    }
    
    int imageIndex = 0;
    /**
     * Animates green alien
     */
    public void animateG()
    {
        if(animationTimer.millisElapsed() < 350)
        {
            return;
        }
        animationTimer.mark();
        setImage(animateGreen[imageIndex]);
        imageIndex = (imageIndex + 1) % animateGreen.length;
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
    
    int imageChangeIndex = 0;
    /**
     * Animates blue alien
     */
    public void animationChange()
    {
        if(animationTimer2.millisElapsed() < 350)
        {
            return;
        }
        animationTimer2.mark();
        setImage(animateBlue[imageChangeIndex]);
        imageChangeIndex = (imageChangeIndex + 1) % animateBlue.length;
    }
    
    /**
     * Move green alien objects horizontally in-sync 
     */
    public void moveGreens()
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
     * Increase score by 100 if you destroy a green alien
     */
    public void increaseScore()
    {
        Background background = (Background) getWorld();
        background.score+=100;
        background.scoreLabel.setValue(background.score);
    }
}
