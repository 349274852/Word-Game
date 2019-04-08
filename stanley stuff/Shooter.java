import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author Yameen Abba, Stanley Chan
 * @version (a version number or a date)
 */
public class Shooter extends Actor
{
    private Word lockedOn;
    
    public Shooter() {
        
    }
    
    public void setLockedOn(Word word) {
        lockedOn = word;
    }
    
    /**
     * Act - do whatever the Shooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
    
    public void fire() {
        turnTowards(lockedOn.getX(), lockedOn.getY());
        setRotation(getRotation() + 90);
        Laser l = new Laser(lockedOn);
        getWorld().addObject(l, getX(), getY() - 5);
    }
}
