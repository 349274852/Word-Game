import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleText here.
 * 
 * @author Steven Lin
 * @version (a version number or a date)
 */
public class TitleText extends Actor
{
    /**
     * Act - do whatever the TitleText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    public TitleText()
    {
        setImage(new GreenfootImage("TitleText.png"));
        getImage().scale(getImage().getWidth() / 3 + 70  , getImage().getHeight() / 2 + 20  );
    }
}
