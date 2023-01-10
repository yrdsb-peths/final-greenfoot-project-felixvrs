import greenfoot.*;

/**
 * Scrolling background.
 * 
 * @author danpost (Greenfoot user)
 * @version January 2023
 */
public class Background extends World
{
    private static final String bgImageName = "space.png";
    private static final double scrollSpeed = 2.5;
    private static final int picHeight = (new GreenfootImage(bgImageName)).getHeight();
 
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
     
    public Background()
    {    
        super(500, 650, 1);
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(getWidth(), picHeight);
        bgBase.drawImage(bgImage, 0, 0);
    }
     
    public void act()
    {
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picHeight) scrollPosition += picHeight;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picHeight;
        paint(scrollPosition);
    }
     
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picHeight, 0);
    }
}
