import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewOpeningScreen here.
 * 
 * @author Stanley Chan, Kelvin Mo
 * @version (a version number or a date)
 */
public class NewOpeningScreen extends World
{

    private UIRenderer renderer;
    
    private int width, height;
    
    /**
     * Constructor for objects of class NewOpeningScreen.
     * 
     */
    public NewOpeningScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        renderer = new UIRenderer();
        width = getWidth();
        height = getHeight();
        makeImage();
    }
    
    public void makeImage() {
        GreenfootImage image = new GreenfootImage("milky way modified.jpg");
        
        Font font = new Font("Arial", false, false, 18);
        image.setFont(font);
        image.setColor(Color.WHITE);
        renderer.drawShadowString(image, "Somewhere in the Milky Way Galaxy exists a", 50, 150);
        renderer.drawShadowString(image, "gang of illiterate aliens. They have never", 50, 200);
        renderer.drawShadowString(image, "practiced using languages, and despise any", 50, 250);
        renderer.drawShadowString(image, "who use them. Now they've come for Earth, in", 50, 300);
        renderer.drawShadowString(image, "hopes to annihilate all the existing English words.", 50, 350);
        renderer.drawShadowString(image, "They have come to you and asked for your help.", 50, 400);
        renderer.drawShadowString(image, "Press Enter to begin the mission!", 50, 500);
        
        setBackground(image);
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if("enter".equals(key)) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
