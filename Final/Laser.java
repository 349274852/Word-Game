import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author Stanley Chan, Yameen Abba
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
        setImage(new GreenfootImage("laser.png"));
        getImage().scale(getImage().getWidth() * 2, getImage().getHeight() * 2);
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
        if(directed.inWorld()) {
         turnTowards(directed.getX(), directed.getY());
         move(10);
        }else{
            getWorld().removeObject(this);
        }
    }    
    
    /**
     * Moves the laser on an angular path (Taken from Greenfoot website)
     */
    public void move(double distance) {
        double angle = Math.toRadians(getRotation());
        int x = (int) Math.round(getX() + Math.cos(angle) * distance);
        int y = (int) Math.round(getY() + Math.sin(angle) * distance);
        
        setLocation(x, y);
    }
}
