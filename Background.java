import greenfoot.*;
import java.util.List;
/**
 * Background.
 * 
 * @author Felix Wu, danpost, Nosson1459
 * @version January 2023
 */
public class Background extends World
{
    public static final int WIDE = 500; // world width (viewport)
    public static final int HIGH = 650; // world height (viewport)
    
    private Scroller scroller; 
    private static final int SPD=1;
    private int num=10;
    private int speed;
    private boolean dir=false;
    private int counter=0;
    public int score = 0;
    public int scrollSpeed = 2;
    
    sLabel scoreLabel;
    GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
    
    public Background()
    {
        super(WIDE, HIGH, 1, false); // create an unbounded world
        GreenfootImage image = new GreenfootImage("space.png"); // the background image
        scroller = new Scroller(this, image); // create the Scoller object
        speed=dir?-SPD:SPD;
        
        Spaceship spaceship = new Spaceship(); 
        addObject(spaceship, 250, 550);
        
        Stage stage = new Stage();
        addObject(stage, 100, 100);
        
        scoreLabel = new sLabel("00", 40);
        addObject(scoreLabel, 40, 40);
    }
    
    public void act()
    {
        scroll();
        counter++;
        speed=dir?-SPD:SPD;
        
        // Move all yellow alien objects horizontally in-sync
        List <Yellow> yellows=getObjects(Yellow.class);
        for(Yellow yellow:yellows)
        {
            yellow.moveYellows();
        }
        
        // Move all red alien objects horizontally in-sync
        List <Red> reds=getObjects(Red.class);
        for(Red red:reds)
        {
            red.moveReds();
        }
        
        // Move all green alien objects horizontally in-sync
        List <Green> greens=getObjects(Green.class);
        for(Green green:greens)
        {
            green.moveGreens();
        }
        
        // If spaceship is destroyed, create game over image and stop world scrolling
        if(getObjects(Spaceship.class).isEmpty())
        {
            GameOver gameOver = new GameOver();
            addObject(gameOver, 250, 325);
            gameOverSound.play();
            scrollSpeed = 0;
        }
    }
    
    private void scroll()
    {
        scroller.scroll(0, -scrollSpeed);
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public boolean getDir()
    {
        return dir;
    }
    
    public int getCounter()
    {
        return counter;
    }
    
    public void setZero()
    {
        counter=0;
    }
    
    public void setDir(boolean direction)
    {
        dir=direction;
    }
}
