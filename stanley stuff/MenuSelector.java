import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuSelector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuSelector extends Actor
{
    
    public MenuSelector() {
        GreenfootImage img = getImage();
        img.scale(img.getWidth() / 3, img.getHeight() / 3);
        setImage(img);
    }
    
    public void moveDown() {
        setLocation(getX(), getY() + 50);
    }
    
    public void moveUp() {
        setLocation(getX(), getY() - 50);
    }
    
    /**
     * Act - do whatever the MenuSelector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
