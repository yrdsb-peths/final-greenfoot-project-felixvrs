import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Felix Wu
 * @version December 2022
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(500, 650, 1);
        
        createStar();
    }
    
    public void createStar()
    {
        Stars star = new Stars();
        int x = Greenfoot.getRandomNumber(500);
        int y = 0;
        addObject(star, x, y);
    }  
}
