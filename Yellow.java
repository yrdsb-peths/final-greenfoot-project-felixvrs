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
        int x = getX();
        int y = getY() - speed;
        setLocation(x, y);
        
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
        
        if(isTouching(Laser.class))
        {
            removeTouching(Laser.class);
            createExplosion();
            increaseScore();
            World world = (World) getWorld();
            world.removeObject(this);
        }
        
        animateY();
    }
    
    int imageIndex = 0;
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
    
    public void createExplosion()
    {
        Explosion explosion = new Explosion();
        getWorld().addObject(explosion,getX(),getY());
    }
    
    public void randomFire()
    {
        int x = Greenfoot.getRandomNumber(40);
        if(x == 5)
        {
            shootaLaser();
        }
    }
    
    public void shootaLaser()
    {
        aLaser alaser = new aLaser();
        getWorld().addObject(alaser,getX(),getY()+30);
    }
    
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
    
    public void increaseScore()
    {
        Background background = (Background) getWorld();
        background.score+=50;
        background.scoreLabel.setValue(background.score);
    }
}
