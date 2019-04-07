import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    Word directed;
    
    private int speed = 5;
    private Shooter s;
    
    public Laser(Word w) {
        this.directed = w;
        this.speed = speed;
        this.s = s;
        //setRotation(s.getRotation() - 10);
    }
    
    /**
     * Returns the word that corresponds to the laser
     */
    public Word getIntendedWord() {
        return directed;
    }
    
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         setLocation(getX(), getY() - speed);
         //move(5.0);
    }    
    
    public void move(double distance) {
        double angle = Math.toRadians(getRotation());
        int x = (int) Math.round(getX() + Math.cos(angle) * distance);
        int y = (int) Math.round(getY() + Math.sin(angle) * distance);
        
        setLocation(x, y);
    }
}
