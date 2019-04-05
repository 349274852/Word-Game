import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 338, 1); 
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if("n".equals(key)) { 
            Greenfoot.setWorld(new MyWorld("easy"));
        }else if("a".equals(key)) {
            Greenfoot.setWorld(new MyWorld("medium"));
        }else if("c".equals(key)) {
            Greenfoot.setWorld(new MyWorld("hard"));
        }
    }
}
