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
    
    public Word(String difficulty) {
        this.difficulty = difficulty;
    }
    
    public void setInWorld(boolean flag) {
        inWorld = flag;
    }
    
    public Queue<String> easyVocabulary(String difficulty){
        Queue<String> easyStage = new Queue<String>();
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner("easy.txt");
        while(scanner.hasNext()) {
            easyStage.enqueue(scanner.next());
        }
        
        return easyStage;
    }
    
    public Queue<String> mediumVocabulary(String difficulty){
        Queue<String> mediumStage = new Queue<String>();
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner("medium.txt");
        while(scanner.hasNext()) {
            mediumStage.enqueue(scanner.next());
        }
        
        return mediumStage;
    }
        
    public Queue<String> crazyVocabulary(String difficulty){
        Queue<String> crazyStage = new Queue<String>();
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner("crazy.txt");
        while(scanner.hasNext()) {
            crazyStage.enqueue(scanner.next());
        }
        
        return crazyStage;
    }

    public void act() 
    {
        
    }    
}
