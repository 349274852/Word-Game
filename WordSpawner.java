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
    MyWorld world;
    
    public WordSpawner(MyWorld theWorld) {
        world = theWorld;
    }
    
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
            int random = Greenfoot.getRandomNumber(getWorld().getWidth());
            if(random < 50) {
                random += 50;
            }else if(random > getWorld().getWidth() - 50) {
                random -= 50;
            }
            for(int i = 0; i < world.getDifficultyVocabulary().size(); i++) {
                Word w = world.getDifficultyVocabulary().get(i);
                if(world.getWordList().get(w.getFirstLetter()) == null) {
                    world.getWordList().put(w.getFirstLetter(), w);
                    getWorld().addObject(w, random, 0);
                    world.getDifficultyVocabulary().remove(i);
                    break;
                }
            }
        }
    }    
}
