import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (your name) 
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
        if(lockedOn != null) {
            int xdiff = lockedOn.getX() - getX();
            int ydiff = lockedOn.getY();
            /*double quotient = xdiff / ydiff;
            double angle = Math.atan(quotient);
            int angleInt = (int) angle;
            System.out.println(ydiff + "/" + xdiff + " = " + quotient);
            System.out.println(angle);
            setRotation(getRotation() + angleInt);
            lockedOn = null;*/
        }
    }    
}
