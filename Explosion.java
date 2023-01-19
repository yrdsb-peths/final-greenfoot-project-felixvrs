import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates explosion when laser hits alien.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Explosion extends Actor
{
    GreenfootImage[] animateExplosion = new GreenfootImage[4];
    SimpleTimer explosionTimer = new SimpleTimer();
    
    public Explosion()
    {
        getImage().scale(30,30);
        
        for(int i = 0; i < animateExplosion.length; i++)
        {
            animateExplosion[i] = new GreenfootImage("images/explosion/explosion" + i + ".png");
            animateExplosion[i].scale(40,40);
        }
        explosionTimer.mark();
        
    }
    
    public void act()
    {
        explosion();
    }
    
    int explosionIndex = 0;
    public void explosion()
    {
        if(explosionTimer.millisElapsed() < 100)
        {
            return;
        }
        explosionTimer.mark();
        setImage(animateExplosion[explosionIndex]);
        explosionIndex = (explosionIndex + 1) % animateExplosion.length;
    }
}
