import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author Stanley Chan 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private ArrayList<Word> vocabulary = new ArrayList<Word>();
    
    public HashMap<Character, Word> words = new HashMap<Character, Word>();
    private Shooter shooter;
    
    private TypingManager typing;
    private ScoreManager score;
    private UIRenderer renderer;
    private WordSpawner wordspawner;
    
    private int highestLetters = 0;
    
    private Lives firstLife = new Lives();
    private Lives secondLife = new Lives();
    private Lives thirdLife = new Lives();
    
    private Queue<Word> wordsKilled = new Queue<Word>();
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {   
        super(500, 600, 1); 
        vocabulary = setupVocabulary();
        for(char ch = 'a'; ch <= 'z'; ++ch) {
            words.put(ch, null);
        }
        wordspawner = new WordSpawner(this);
        addObject(wordspawner, -50, -50);
        typing = new TypingManager(this);
        score = new ScoreManager(this);
        addObject(typing, -50, -50);
        shooter = new Shooter();
        renderer = new UIRenderer();
        addObject(shooter, getWidth() / 2, getHeight());
        addObject(score, getWidth() / 2, getHeight() / 2);
        
        addObject(thirdLife, 10, 75);
        addObject(secondLife, 30, 75);
        addObject(firstLife, 50, 75);
        
        setBackground(new GreenfootImage("earth modified.jpg"));
    }
    
    /**
     * Sets the world to the enter name screen.
     */
    public void die() {
        Greenfoot.setWorld(new EnterName(getScoreManager().getScore(), wordsKilled));
    }
    
    /**
     * Returns the typing manager
     */
    public TypingManager getTypingManager() {
        return typing;
    }
    
    /**
     * Returns the score manager
     */
    public ScoreManager getScoreManager() {
        return score;
    }
    
    /**
     * Returns the shooter object
     */
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
     * Returns the words the player has killed
     */
    public Queue<Word> getWordsKilled() {
        return wordsKilled;
    }
    
    /**
     * Removes a word from the world and the HashMap
     */
    public void removeWord(Word w) {
        if(getWordList().get(w.getFirstLetter()) == w) {
            getWordList().put(w.getFirstLetter(), null);
        }
        score.addScore(w.getScore());
        Explosion explosion = new Explosion();
        addObject(explosion, w.getX(), w.getY());
        removeObject(w);
        wordsKilled.enqueue(w);
    }
    
    /**
     * Randomizes the words
     */
    public ArrayList<Word> setupVocabulary() {
        Reader reader = new Reader();
        Scanner scanner = reader.getScanner("allwords.txt");
        ArrayList<Word> list = new ArrayList<Word>();
        while(scanner.hasNext()) {
            String str = scanner.next().toLowerCase();
            if(str.length() > highestLetters) {
                highestLetters = str.length();
            }
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
    
    /**
     * Returns the word spawner object
     */
    public WordSpawner getWordSpawner() {
        return wordspawner;
    }
    
    /**
     * Following two methods are used to remove the first heart and second heart for the Word class.
     */
    public void firstL()
    {
        removeObject(firstLife);
    }
    
    public void secondL()
    {
        removeObject(secondLife);
    }
    
    int noRepeatingDecreaseSpawn = 0;
    int noRepeatingDecreaseChar = 0;
    
    public void act() {
        //For every multiple of 500, increase the rate at which enemies spawn.
        if(score.getCounterValue() % 500 == 0 && score.getCounterValue() != noRepeatingDecreaseSpawn) {
            if(wordspawner.getInterval() > 55) {
                wordspawner.subtractTime(5);
                noRepeatingDecreaseSpawn = score.getCounterValue();
                score.addLevel(1);
            }
        }
        //For every multiple of 750, increase the maximum characters of a word.
        if(score.getCounterValue() % 750 == 0 && score.getCounterValue() != noRepeatingDecreaseChar) {
            if(wordspawner.getMaxCharacters() < highestLetters) {
                wordspawner.increaseMaxCharacters(1);
                noRepeatingDecreaseChar = score.getCounterValue();
            }
        }
    }
}
