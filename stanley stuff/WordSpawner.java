import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WordSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordSpawner extends Actor
{
    private int wordTimer = 100;
    private int wordTimerDef = 100;
    
    private int powerupTimer = 50;
    private int powerupTimerDef = 50;
    MyWorld world;
    
    private String[] powerups = {"nuclearstrike", "fastshooting", "slowenemy"};
    
    public WordSpawner(MyWorld theWorld) {
        world = theWorld;
    }
    
    /**
     * Subtracts the interval between word spawns
     */
    public void subtractTime(int modifier) {
        wordTimerDef -= modifier;
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
                if(world.getWordList().get(w.getFirstLetter()) == null) {
                    spawnWord(w, random, 30);
                    world.getDifficultyVocabulary().remove(i);
                    break;
                }
            }
        }
        if(powerupTimer > 0) powerupTimer--;
        else {
            String up = getRandomPowerup();
            //something wrong here
            if(world.getWordList().get(up.charAt(0)) == null) {
                powerupTimer = powerupTimerDef;
                int random = generateRandomNumber(world.getWidth());
                Word w = new Word();
                w.setString(up);
                w.setPowerUp(true);
                w.setupHealth();
                spawnWord(w, random, 30);
            }
        }
    }    
    
    public String getRandomPowerup() {
        int number = Greenfoot.getRandomNumber(powerups.length);
        return powerups[number];
    }
    
    public void spawnWord(Word w, int x, int y) {
        world.getWordList().put(w.getFirstLetter(), w);
        getWorld().addObject(w, x, y);
        TextImage img = new TextImage(w);
        getWorld().addObject(img, 0, 0);
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
