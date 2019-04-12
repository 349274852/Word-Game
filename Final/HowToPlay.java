import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay here.
 * 
 * @author Steven Lin 
 * @version (a version number or a date)
 */
public class HowToPlay extends Actor
{
    /**
     * Act - do whatever the HowToPlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       click();
       
    }   
    private void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new HowTo());
        }
        
    }
    public HowToPlay()
    {
        setImage(new GreenfootImage("Howtoplay.png"));
        getImage().scale(getImage().getWidth() / 2 , getImage().getHeight() / 2  );
    }
}
