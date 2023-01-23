import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates explosion when laser hits alien.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Explosion extends Actor
{
    GreenfootImage[] animateExplosion = new GreenfootImage[5];
    SimpleTimer explosionTimer = new SimpleTimer();
    int hasExploded = 4;
    
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
        if(hasExploded >= 0)
        {   
            explosion();  
        }
    }
    
    int explosionIndex = 0;
    public void explosion()
    {
        if(explosionTimer.millisElapsed() < 150)
        {
            return;
        }
        explosionTimer.mark();
        setImage(animateExplosion[explosionIndex]);
        explosionIndex = (explosionIndex + 1) % animateExplosion.length;
        hasExploded--;
    }
}
