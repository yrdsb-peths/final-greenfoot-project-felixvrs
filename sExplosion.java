import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates explosion when spaceship is destroyed.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class sExplosion extends Actor
{
    GreenfootImage[] animateExplosion = new GreenfootImage[4];
    SimpleTimer explosionTimer = new SimpleTimer();
    
    public sExplosion()
    {
        getImage().scale(50,50);
        
        for(int i = 0; i < animateExplosion.length; i++)
        {
            animateExplosion[i] = new GreenfootImage("images/sExplosion/sExplosion" + i + ".png");
            animateExplosion[i].scale(50,50);
        }
        explosionTimer.mark();
        
    }
    
    public void act()
    {
        sExplosion();  
    }
    
    int explosionIndex = 0;
    public void sExplosion()
    {
        if(explosionTimer.millisElapsed() < 150)
        {
            return;
        }
        explosionTimer.mark();
        setImage(animateExplosion[explosionIndex]);
        explosionIndex = (explosionIndex + 1) % animateExplosion.length;
    }
}
