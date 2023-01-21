import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Red alien.
 * 
 * @author Felix Wu 
 * @version January 2023
 */
public class Red extends Actor
{
    int speed = 2;
    GreenfootImage[] animateRed = new GreenfootImage[2];
    SimpleTimer animationTimer = new SimpleTimer();
    boolean hasExploded = false;
    boolean canShoot = true;
    int fireTimer = 120;
    
    public Red()
    {
        getImage().scale(40,40);
        
        for(int i = 0; i < animateRed.length; i++)
        {
            animateRed[i] = new GreenfootImage("images/red/red" + i + ".png");
            animateRed[i].scale(40,40);
        }
        animationTimer.mark();

    }
    public void act()
    {
        int x = getX();
        int y = getY() - speed;
        setLocation(x, y);
        
        if(hasExploded == false)
        {
            if(canShoot == true)
            {
                randomFire();
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
        
        if(isTouching(Laser.class))
        {
            removeTouching(Laser.class);
            createExplosion();
            hasExploded = true;
            World world = (World) getWorld();
            world.removeObject(this);
        }
        
        animateR();
    }
    
    int imageIndex = 0;
    public void animateR()
    {
        if(animationTimer.millisElapsed() < 350)
        {
            return;
        }
        animationTimer.mark();
        setImage(animateRed[imageIndex]);
        imageIndex = (imageIndex + 1) % animateRed.length;
    }
    
    public void createExplosion()
    {
        Explosion explosion = new Explosion();
        getWorld().addObject(explosion,getX(),getY());
    }
    
    public void randomFire()
    {
        int x = Greenfoot.getRandomNumber(35);
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
}
