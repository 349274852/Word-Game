import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Word here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Word extends Actor
{
    private String difficulty = "";
    private String word = "";
    
    private int delay = 2;
    private int health = 0;
    
    public String getString() {
        return word;
    }
    
    public Character getFirstLetter() {
        return word.charAt(0);
    }
    
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
    public void setupHealth() {
        health = word.length() - 1;
    }
    
    public void setString(String string) {
        word = string;
        setImage(new GreenfootImage(word, 20, Color.WHITE, Color.BLACK));
    }
    
    public Queue<String> getVocabulary(String difficulty){
        Queue<String> easyStage = new Queue<String>();
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner(difficulty + ".txt");
        while(scanner.hasNext()) {
            easyStage.enqueue(scanner.next());
        }
        
        return easyStage;
    }

    public void act() 
    {
        if(delay > 0) delay--;
        else{
            delay = 2;
            setLocation(getX(), getY() + 1);
        }
        Actor laser = getOneIntersectingObject(Laser.class);
        if(laser != null) {
            Laser shot = (Laser) laser;
            health--;
            getWorld().removeObject(shot);
        }
        if(health == 0) {
            MyWorld w = (MyWorld) getWorld();
            w.removeWord(this);
        }
    }    
}
