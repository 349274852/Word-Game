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
    private int score = 0;
    
    private boolean powerup = false;
    
    public Word() {
        
    }
    
    /**
     * Returns the score of the word
     */
    public int getScore() {
        return score;
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
        score = health * 10;
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
        checkDeath();
        if(!inWorld()) return;
        //Moves the word down the screen
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
        
    }
    
    /**
     * Check if the player is dead or has lost a heart by examining whether there is an enemy
     * touching the baseline.
     */
    public void checkDeath() {
        MyWorld w = (MyWorld) getWorld();
        if(getY() >= getWorld().getHeight()-10) {
            if(isPowerUp()) {
                w.removeObject(this);
                w.getWordSpawner().powerupCount--;
            }
            
            else if (getWorld().getObjects(Lives.class).size() == 3)
            {
                w.firstL();
                w.removeObject(this);
            }
            
            else if (getWorld().getObjects(Lives.class).size() == 2)
            {
                w.secondL();
                w.removeObject(this);
            }
            
            else if(getWorld().getObjects(Lives.class).size() == 1)
            {
                w.die();
            }
            w.getWordList().put(getFirstLetter(), null);
        }
    }
    
    /**
     * Activates the given power up
     */
    public void activatePowerUp(String powerupType) {
        MyWorld w = (MyWorld) getWorld();
        w.removeWord(this);
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
    }
}
