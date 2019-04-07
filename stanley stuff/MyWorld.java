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

    private ArrayList<Word> vocabulary = new ArrayList<Word>();
    
    private String difficulty = "easy";
    
    public HashMap<Character, Word> words = new HashMap<Character, Word>();
    private Shooter shooter;
    
    private int laserSpeed = 5;
    private boolean laserPowerUp = false;
    
    private int laserTimer = 150;
    private int laserTimerDef = 150;
    
    private TypingManager typing;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(String difficulty)
    {   
        super(500, 600, 1); 
        this.difficulty = difficulty;
        vocabulary = setupVocabulary(difficulty);
        for(char ch = 'a'; ch <= 'z'; ++ch) {
            words.put(ch, null);
        }
        WordSpawner wordspawner = new WordSpawner(this);
        addObject(wordspawner, 0, 0);
        typing = new TypingManager(this);
        addObject(typing, 0, 0);
        shooter = new Shooter();
        addObject(shooter, getWidth() / 2, getHeight());
    }
    
    public TypingManager getTypingManager() {
        return typing;
    }
    
    public Shooter getShooter() {
        return shooter;
    }
    
    /**
     * Returns the arraylist that contains the corresponding difficulty's words
     */
    public ArrayList<Word> getDifficultyVocabulary() {
        return vocabulary;
    }
    
    /**
     * Returns the HashMap that contains the current words that have been spawned
     */
    public HashMap<Character, Word> getWordList() {
        return words;
    }
    
    /**
     * Removes a word from the world and the HashMap
     */
    public void removeWord(Word w) {
        if(getWordList().get(w.getFirstLetter()) == w) {
            getWordList().put(w.getFirstLetter(), null);
        }
        removeObject(w);
    }
    
    /**
     * Saves the corresponding difficulty's words text file into an arraylist and randomizes it
     */
    public ArrayList<Word> setupVocabulary(String difficulty) {
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner("allwords.txt");
        ArrayList<Word> list = new ArrayList<Word>();
        while(scanner.hasNext()) {
            String str = scanner.next().toLowerCase();
            Word word = new Word();
            word.setString(str);
            word.setupHealth();
            list.add(word);
        }
        
        ArrayList<Word> number = new ArrayList<Word>();
        
        while(list.size() > 0) {
            int index = Greenfoot.getRandomNumber(list.size());
            number.add(list.get(index));
            list.remove(list.get(index));
        }
        
        return number;
    }
}
