import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author Yameen Abba
 * @version (a version number or a date)
 */
public class Shooter extends Actor
{
    private Word lockedOn;
    
    public Shooter() {
        setImage(new GreenfootImage("spaceship.png"));
    }
    
    /**
     * Locks the shooter on a word
     */
    public void setLockedOn(Word word) {
        lockedOn = word;
    }
    
    /**
     * Fires a laser
     */
    public void fire() {
        if(lockedOn.inWorld()) {
            Greenfoot.playSound("shoot.wav");
            turnTowards(lockedOn.getX(), lockedOn.getY());
            setRotation(getRotation() + 90);
            Laser l = new Laser(lockedOn);
            getWorld().addObject(l, getX(), getY() - 50);
        }
    }
}
