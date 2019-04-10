import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighScores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScores extends World
{

    UIRenderer renderer;
    
    private int width, height;
    Scores score;
    
    /**
     * Constructor for objects of class HighScores.
     * 
     */
    public HighScores()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1);
        renderer = new UIRenderer();
        width = getWidth();
        height = getHeight();
        makeImage();
        score = new Scores();
    }
    
    public void makeImage() {
        GreenfootImage image = new GreenfootImage("earth modified.jpg");
        
        Font font = new Font("Arial", false, false, 20);
        image.setFont(font);
        image.setColor(Color.WHITE);
        renderer.drawShadowString(image, "High Scores", width / 2 - 53, 25);
        setBackground(image);
    }
}