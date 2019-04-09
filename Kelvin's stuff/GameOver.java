import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 378, 1); 
    }
    
    public void act(){
        startWorld();
    }
    
    public void startWorld(){
        if ("c".equals(Greenfoot.getKey())){
            Greenfoot.setWorld(new NewOpeningScreen());
        }
    }   
}
