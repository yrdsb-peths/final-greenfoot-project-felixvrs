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
    SimpleTimer animationTimer = new SimpleTimer();
    boolean hasExploded = false;
    boolean canShoot = true;
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
        
        animateG();
    }
    
    int imageIndex = 0;
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
