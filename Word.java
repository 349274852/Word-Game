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
    
    String chopped = "";
    
    private int delay = 2;
    private int health = 0;
    
    private GreenfootImage ship;
    
    public Word() {
        ship = new GreenfootImage("enemy.png");
    }
    
    public String getString() {
        return word;
    }
    
    public boolean inWorld() {
        return getWorld() != null;
    }
    
    public Character getFirstLetter() {
        return word.charAt(0);
    }
    
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
    public void setupHealth() {
        health = word.length();
    }
    
    public void setString(String string) {
        word = string;
        chopped = string;
        setImage(new GreenfootImage(word, 20, Color.WHITE, Color.BLACK));
    }
    
    public void chopWord() {
        if(chopped.length() == 1) {
            chopped = "";
        }else{
            chopped = chopped.substring(1, chopped.length());
        }
        setImage(new GreenfootImage(chopped, 20, Color.RED, Color.BLACK));
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
        //moves the word down the screen
        if(delay > 0) delay--;
        else{
            delay = 2;
            setLocation(getX(), getY() + 1);
        }
        //checks when a laser hits the word
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
