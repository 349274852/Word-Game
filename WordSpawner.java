import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WordSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordSpawner extends Actor
{
    private int wordTimer = 0;
    MyWorld world;
    
    public WordSpawner(MyWorld theWorld) {
        world = theWorld;
    }
    
    /**
     * Act - do whatever the WordSpawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(wordTimer > 0) wordTimer--;
        else {
            wordTimer = 5000;
            getWorld().addObject(world.getEasyVocabulary().dequeue(), Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
        }
    }    
}
