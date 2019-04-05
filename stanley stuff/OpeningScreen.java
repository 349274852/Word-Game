import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpeningScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpeningScreen extends World
{

    /**
     * Constructor for objects of class OpeningScreen.
     * 
     */
    public OpeningScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 338, 1); 
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if("space".equals(key)) { 
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
