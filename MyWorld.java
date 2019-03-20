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
    private Queue<Word> medium = new Queue<Word>();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        easy = setupVocabulary("easy");
        medium = setupVocabulary("medium");
        WordSpawner wordspawner = new WordSpawner(this);
        addObject(wordspawner, 0, 0);
    }
    
    public Queue<Word> getEasyVocabulary() {
        return easy;
    }
    
    public Queue<Word> getMediumVocabulary() {
        return medium;
    }
    
    public Queue<Word> setupVocabulary(String difficulty) {
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner(difficulty + ".txt");
        Queue<Word> queue = new Queue<Word>();
        while(scanner.hasNext()) {
            Word word = new Word();
            word.setString(scanner.next());
            queue.enqueue(word);
        }
        
        HashMap<Integer, Word> map = new HashMap<Integer, Word>();
        ArrayList<Word> number = new ArrayList<Word>();
        for(Word w : queue) {
            //int count = Greenfoot.getRandomNumber(queue.getSize());
            //map.put(count, w);
            number.add(w);
        }
        
        Queue<Word> q2 = new Queue<Word>();
        for(int i = 0; i < number.size(); i++) {
            int index = Greenfoot.getRandomNumber(number.size());
            q2.enqueue(number.get(index));
            number.remove(number.get(index));
        }
        return q2;
    }
}
