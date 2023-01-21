import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stage of aliens.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class Stage extends Actor
{
    public void act()
    {
        Yellow yellow = new Yellow();
        getWorld().addObject(yellow, 450, 175);
        
        Yellow yellow1 = new Yellow();
        getWorld().addObject(yellow1, 410, 175);
        
        Yellow yellow2 = new Yellow();
        getWorld().addObject(yellow2, 370, 175);
        
        Yellow yellow3 = new Yellow();
        getWorld().addObject(yellow3, 330, 175);
        
        Yellow yellow4 = new Yellow();
        getWorld().addObject(yellow4, 290, 175);
        
        Yellow yellow5 = new Yellow();
        getWorld().addObject(yellow5, 250, 175);
        
        Yellow yellow6 = new Yellow();
        getWorld().addObject(yellow6, 210, 175);
        
        Yellow yellow7 = new Yellow();
        getWorld().addObject(yellow7, 170, 175);
        
        Yellow yellow8 = new Yellow();
        getWorld().addObject(yellow8, 130, 175);
        
        Yellow yellow9 = new Yellow();
        getWorld().addObject(yellow9, 90, 175);
        
        Yellow yellow10 = new Yellow();
        getWorld().addObject(yellow10, 50, 175);
        
        //
        Red red = new Red();
        getWorld().addObject(red, 410, 135);
        
        Red red1 = new Red();
        getWorld().addObject(red1, 370, 135);
        
        Red red2 = new Red();
        getWorld().addObject(red2, 330, 135);
        
        Red red3 = new Red();
        getWorld().addObject(red3, 290, 135);
        
        Red red4 = new Red();
        getWorld().addObject(red4, 250, 135);
        
        Red red5 = new Red();
        getWorld().addObject(red5, 210, 135);
        
        Red red6 = new Red();
        getWorld().addObject(red6, 170, 135);
        
        Red red7 = new Red();
        getWorld().addObject(red7, 130, 135);
        
        Red red8 = new Red();
        getWorld().addObject(red8, 90, 135);
        
        //
        Green green = new Green();
        getWorld().addObject(green, 330, 95);
        
        Green green1 = new Green();
        getWorld().addObject(green1, 290, 95);
        
        Green green2 = new Green();
        getWorld().addObject(green2, 250, 95);
        
        Green green3 = new Green();
        getWorld().addObject(green3, 210, 95);
        
        Green green4 = new Green();
        getWorld().addObject(green4, 170, 95);
    }
}
