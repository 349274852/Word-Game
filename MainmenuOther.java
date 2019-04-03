import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Mainmenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mainmenu extends World
{

    
    
    /**
     * Constructor for objects of class Mainmenu.
     * 
     */
    public Mainmenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MyWorld(0));
        }else if(Greenfoot.isKeyDown("backspace")) {
            Greenfoot.setWorld(new HowToPlay());
        }
    }
    
}
