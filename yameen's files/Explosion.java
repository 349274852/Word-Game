import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author Stanley Chan 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int currentSprite = 0;
    private int timeInterval = 2;
    private int timeIntervalDef = 2;
    
    public Explosion() {
        GreenfootImage img = new GreenfootImage("explosion_" + currentSprite + ".png");
        img.scale(img.getWidth() / 2 + 25, img.getHeight() / 2 + 25);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timeInterval > 0) {
            timeInterval--;
        }else{
            if(currentSprite < 30) {
                currentSprite++;
                GreenfootImage img = new GreenfootImage("explosion_" + currentSprite + ".png");
                img.scale(img.getWidth() / 2 + 25, img.getHeight() / 2 + 25);
                setImage(img);
                timeInterval = timeIntervalDef;
            }else{
                getWorld().removeObject(this);
            }
        }
    }
}
