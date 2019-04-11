import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Highscore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscore extends Actor
{
    /**
     * Act - do whatever the Highscore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       click();
       
    }   
    private void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new NewOpeningScreen());
        }
        
    }
    public Highscore()
    {
        getImage().scale(getImage().getWidth() / 2  , getImage().getHeight() / 2  );
    }
}