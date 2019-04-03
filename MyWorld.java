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

    private ArrayList<Word> easy = new ArrayList<Word>();
    private ArrayList<Word> medium = new ArrayList<Word>();
    
    private String difficulty = "easy";
    
    public HashMap<Character, Word> words = new HashMap<Character, Word>();
    private Shooter shooter;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
     //type "easy" or "medium" when trying to run game
    public MyWorld(String difficulty)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        this.difficulty = difficulty;
        easy = setupVocabulary("easy");
        medium = setupVocabulary("medium");
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
    
    public Shooter getShooter() {
        return shooter;
    }
    
    public ArrayList<Word> getEasyVocabulary() {
        return easy;
    }
    
    public ArrayList<Word> getMediumVocabulary() {
        return medium;
    }
    
    public ArrayList<Word> getDifficultyVocabulary() {
        if(difficulty.equals("easy")) return easy;
        if(difficulty.equals("medium")) return medium;
        return easy;
    }
    
    public HashMap<Character, Word> getWordList() {
        return words;
    }
    
    public void removeWord(Word w) {
        getWordList().put(w.getFirstLetter(), null);
        removeObject(w);
    }
    
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
        for(Word w : list) {
            number.add(w);
        }
        
        ArrayList<Word> l2 = new ArrayList<Word>();
        for(int i = 0; i < number.size(); i++) {
            int index = Greenfoot.getRandomNumber(number.size());
            l2.add(number.get(index));
            number.remove(number.get(index));
        }
        return l2;
    }
}
