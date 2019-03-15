import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Word here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Word extends Actor
{
    private boolean inWorld = false;
    private String difficulty = "";
    
    public Word(String difficulty) {
        this.difficulty = difficulty;
    }
    
    public void setInWorld(boolean flag) {
        inWorld = flag;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
