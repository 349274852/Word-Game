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
    private boolean inWorld = false;
    private String difficulty = "";
    private String word = "";
    
    public String getString() {
        return word;
    }
    
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    
    public void setString(String string) {
        word = string;
    }
    
    public void setInWorld(boolean flag) {
        inWorld = flag;
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
        setLocation(getX(), getY() + 1);
    }    
}
