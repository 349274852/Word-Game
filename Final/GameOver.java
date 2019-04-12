import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class GameOver here.
 * 
 * @author Kelvin Mo 
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
        super(500, 600, 1); 
        setBackground(new GreenfootImage("game over page resized.png"));
    }
    
    public void act() {
        startWorld();
    }
    
    public void startWorld(){
        if("c".equals(Greenfoot.getKey())) {
            Greenfoot.setWorld(new MainMenu2());
        }
    }
}
