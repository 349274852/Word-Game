import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private UIRenderer renderer;
    
    private int width, height;
    
    public String playerName;
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 378, 1); 
        renderer = new UIRenderer();
        width = getWidth();
        height = getHeight();
        makeImage();
    }
    
    public void makeImage(){
        GreenfootImage image = new GreenfootImage("NEW Game Over page.png");
        //Font font = new Font("Arial", false, false, 18);
        //image.setFont(font);
        //image.setColor(Color.WHITE);
        //renderer.drawShadowString(image, "Please type in your name", 50, 150);
        playerName = JOptionPane.showInputDialog("Your name: ");
        
        setBackground(image);
    }
    
    public void act(){
        if ("c".equals(Greenfoot.getKey())){
            Greenfoot.setWorld(new NewOpeningScreen());
        }
    }   
}
