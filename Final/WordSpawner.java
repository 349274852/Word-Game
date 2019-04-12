import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class WordSpawner here.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class WordSpawner extends Actor
{
    private int wordTimer = 100;
    private int wordTimerDef = 100;
    
    private int maxCharacters = 5;
    
    private int powerupTimer = 1500;
    private int powerupTimerDef = 1500;
    MyWorld world;
    
    private String powerup = "";
    public int powerupCount = 0;
    
    public WordSpawner(MyWorld theWorld) {
        getImage().setTransparency(0);
        world = theWorld;
    }
    
    /**
     * Increases the max characters of the words that can be spawned
     */
    public void increaseMaxCharacters(int modifier) {
        maxCharacters += modifier;
    }
    
    /**
     * Returns the max characters of the words that can be spawned
     */
    public int getMaxCharacters() {
        return maxCharacters;
    }
    
    /**
     * Subtracts the interval between word spawns
     */
    public void subtractTime(int modifier) {
        wordTimerDef -= modifier;
    }
    
    /**
     * Returns the interval between spawning words
     */
    public int getInterval() {
        return wordTimerDef;
    }
    
    /**
     * Act - do whatever the WordSpawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(wordTimer > 0) wordTimer--;
        else {
            wordTimer = wordTimerDef;
            int random = generateRandomNumber(world.getWidth());
            for(int i = 0; i < world.getDifficultyVocabulary().size(); i++) {
                Word w = world.getDifficultyVocabulary().get(i);
                //Checks if there is already a word with the same first letter spawned
                if(world.getWordList().get(w.getFirstLetter()) == null && w.getString().length() <= maxCharacters) {
                    spawnWord(w, random, 30);
                    world.getDifficultyVocabulary().remove(i);
                    break;
                }
            }
        }
        if(powerupTimer > 0) powerupTimer--;
        else {
            if(powerup.equals("")) {
                powerup = "nuclearstrike";
            }
            if(world.getWordList().get(powerup.charAt(0)) == null && powerupCount < 3 && maxCharacters >= 7) {
                int random = generateRandomNumber(world.getWidth());
                Word w = new Word();
                w.setString(powerup);
                w.setPowerUp(true);
                w.setupHealth();
                spawnWord(w, random, 30);
                powerup = "";
                powerupCount++;
            }
            powerupTimer = powerupTimerDef;
        }
    }
    
    /**
     * Spawns a given word in the specified x-y location
     */
    public void spawnWord(Word w, int x, int y) {
        world.getWordList().put(w.getFirstLetter(), w);
        getWorld().addObject(w, x, y);
        TextImage img = new TextImage(w);
        getWorld().addObject(img, x, 0);
    }
    
    /**
     * Generates a random number between 0 and max, and subtracts or adds the number
     * by 50 in order for the word to fit in the world.
     */
    public int generateRandomNumber(int max) {
        int number = Greenfoot.getRandomNumber(max);
        if(number < 50) {
            number += 50;
        }else if(number > max - 50) {
            number -= 50;
        }
        return number;
    }
}
