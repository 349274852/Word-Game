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
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(String difficulty)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        this.difficulty = difficulty;
        vocabulary = setupVocabulary(difficulty);
        for(char ch = 'a'; ch <= 'z'; ++ch) {
            words.put(ch, null);
        }
        WordSpawner wordspawner = new WordSpawner(this);
        addObject(wordspawner, 0, 0);
        TypingManager typing = new TypingManager(this);
        addObject(typing, 0, 0);
        shooter = new Shooter();
        addObject(shooter, getWidth() / 2, getHeight());
    }
    
    public void setLaserPowerUp(boolean flag) {
        laserPowerUp = flag;
    }
    
    public int getLaserSpeed() {
        return laserSpeed;
    }
    
    public void setLaserSpeed(int speed) {
        laserSpeed = speed;
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
        getWordList().put(w.getFirstLetter(), null);
        removeObject(w);
    }
    
    /**
     * Saves the corresponding difficulty's words into an arraylist and randomizes it
     */
    public ArrayList<Word> setupVocabulary(String difficulty) {
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner(difficulty + ".txt");
        ArrayList<Word> list = new ArrayList<Word>();
        while(scanner.hasNext()) {
            Word word = new Word();
            word.setString(scanner.next());
            word.setupHealth();
            list.add(word);
        }
        
        ArrayList<Word> number = new ArrayList<Word>();
        for(int i = 0; i < list.size(); i++) {
            int index = Greenfoot.getRandomNumber(list.size());
            number.add(list.get(index));
            list.remove(list.get(index));
        }
        return number;
    }
    
    public void act() {
        if(laserPowerUp) {
            if(laserTimer > 0) laserTimer--;
            else{
                laserPowerUp = false;
                setLaserSpeed(5);
            }
        }
    }
}
