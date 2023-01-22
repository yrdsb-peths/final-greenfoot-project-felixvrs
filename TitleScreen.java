import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen.
 * 
 * @author Felix Wu
 * @version January 2023
 */
public class TitleScreen extends World
{
    public TitleScreen()
    {    
        super(500, 650, 1); 

        logo();
        menu();
        menuScore();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Background gameWorld = new Background();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    private void logo()
    {
        Logo logo = new Logo();
        addObject(logo,250,210);
    }
    
    private void menu()
    {
        Menu menu = new Menu();
        addObject(menu,255,460);
    }
    
    private void menuScore()
    {
        MenuScore menuScore = new MenuScore();
        addObject(menuScore,260,60);
    }
}
