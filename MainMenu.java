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
        super(500, 600, 1); 
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if("e".equals(key)) { 
            Greenfoot.setWorld(new MyWorld("easy"));
        }else if("m".equals(key)) {
            Greenfoot.setWorld(new MyWorld("medium"));
        }else if("h".equals(key)) {
            Greenfoot.setWorld(new MyWorld("hard"));
        }
    }
}
