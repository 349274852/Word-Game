import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Word here.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class Word extends Actor
{
    private String word = "";
    
    String chopped = "";
    
    private int delay = 2;
    private int health = 0;
    
    private boolean powerup = false;
    
    private GreenfootImage ship;
    
    private boolean isDead = false;
    
    public Word() {
        ship = new GreenfootImage("enemy.png");
    }
    
    /**
     * Checks if this word is a power up
     */
    public boolean isPowerUp() {
        return powerup;
    }
    
    /**
     * Sets whether or not this word is a power up
     */
    public void setPowerUp(boolean flag) {
        powerup = flag;
    }
    
    /**
     * Returns the word object's corresponding word string
     */
    public String getString() {
        return word;
    }
    
    /**
     * Checks if the word is in the world or not
     */
    public boolean inWorld() {
        return getWorld() != null;
    }
    
    /**
     * Returns the first letter of the word
     */
    public Character getFirstLetter() {
        return word.charAt(0);
    }
    
    /**
     * Sets the health of the word to the length of it
     */
    public void setupHealth() {
        health = word.length();
    }
    
    /**
     * Sets the word's string
     */
    public void setString(String string) {
        word = string;
        chopped = string;
        GreenfootImage img = new GreenfootImage(word, 20, Color.WHITE, Color.BLACK);
        img.setTransparency(195);
        setImage(img);
    }
    
    /**
     * Removes the first letter of the word
     */
    public void chopWord() {
        if(chopped.length() <= 1) {
            chopped = "";
        }else{
            chopped = chopped.substring(1, chopped.length());
        }
        GreenfootImage img = new GreenfootImage(chopped, 20, Color.RED, Color.BLACK);
        img.setTransparency(245);
        setImage(img);
    }

    public void act() 
    {
        checkDeath();//Moves the word down the screen
        if(delay > 0) delay--;
        else{
            delay = 2;
            setLocation(getX(), getY() + 1);
        }
        //Checks when a laser hits the word
        Actor laser = getOneIntersectingObject(Laser.class);
        if(laser != null) {
            Laser shot = (Laser) laser;
            if(shot.getIntendedWord().equals(this)) {
                health--;
                getWorld().removeObject(shot);
            }
        }
        //Checks when the word's health is 0
        if(health == 0) {
            if(isPowerUp()) {
                activatePowerUp(word);
                return;
            }
            MyWorld w = (MyWorld) getWorld();
            w.removeWord(this);
        }
        die();
    }
    
    /**
     * Activates the given power up
     */
    public void activatePowerUp(String powerupType) {
        MyWorld w = (MyWorld) getWorld();
        switch(powerupType){
            case "nuclearstrike":
                for(Character c : w.getWordList().keySet()) {
                    w.getWordList().put(c, null);
                }
                for(Actor a : w.getObjects(Word.class)) {
                    w.removeObject(a);
                }
                for(Laser a : w.getObjects(Laser.class)) {
                    w.removeObject(a);
                }
                w.getTypingManager().setTypedWord(null);
                break;
        }
        w.removeWord(this);
    }
    
    /*
     * A method which checks if the spaceship intersects with other objects.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneIntersectingObject(clss);
        return actor != null;
    }
    
    /**
     * Check if the player is dead by examining whether there is any enemy 
     * touching the baseline.
     */
    public void checkDeath()
    {
        if(getY() >= getWorld().getHeight()-10)
        {
            isDead = true;
            //System.out.println("hello");
        }
        //if(canSee(Shooter.class))
        //{
            //isDead = true;
            //System.out.println("hello");
        //}
    }
    
    //if the player is dead, set the screen to the GameOver page.
    public void die()
    {
        if(isDead == true)
        {
            isDead = false;
            Greenfoot.setWorld(new GameOver());
        }
    }
}
