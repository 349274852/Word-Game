import greenfoot.*;

/**
 * Write a description of class UIRenderer here.
 * 
 * @author Stanley Chan 
 * @version (a version number or a date)
 */
public class UIRenderer  
{

    /**
     * Constructor for objects of class UIRenderer
     */
    public UIRenderer()
    {
    }
    
    public void drawShadowString(GreenfootImage img, String string, int x, int y) {
        img.setColor(Color.BLACK);
        img.drawString(string, x+2, y+2);
        img.setColor(Color.WHITE);
        img.drawString(string, x, y);
    }
}
