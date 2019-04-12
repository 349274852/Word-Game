import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowTo here.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class HowTo extends World
{

    /**
     * Constructor for objects of class HowTo.
     * 
     */
    public HowTo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        setBackground(new GreenfootImage("howto.png"));
    }
    
    public void act() {
        if("escape".equals(Greenfoot.getKey())) {
            Greenfoot.setWorld(new MainMenu2());
        }
    }
}
