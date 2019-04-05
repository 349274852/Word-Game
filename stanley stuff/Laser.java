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
    
    private int speed;
    
    public Laser(Word w, int speed) {
        this.directed = w;
        this.speed = speed;
    }
    
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
    }    
}
