import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private Queue<Word> easy = new Queue<Word>();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        setupVocabulary("easy", easy);
        WordSpawner wordspawner = new WordSpawner(this);
        addObject(wordspawner, 0, 0);
    }
    
    public Queue<Word> getEasyVocabulary() {
        return easy;
    }
    
    public void setupVocabulary(String difficulty, Queue<Word> queue) {
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner(difficulty + ".txt");
        while(scanner.hasNext()) {
            Word word = new Word();
            word.setString(scanner.next());
            queue.enqueue(word);
        }
    }
}
