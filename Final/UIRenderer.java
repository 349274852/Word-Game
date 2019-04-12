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
     * Draws a string with a shadow onto the image.
     */
    public void drawShadowString(GreenfootImage img, String string, int x, int y) {
        img.setColor(Color.BLACK);
        img.drawString(string, x+2, y+2);
        img.setColor(Color.WHITE);
        img.drawString(string, x, y);
    }
}
