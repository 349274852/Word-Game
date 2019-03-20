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
            wordTimer = 100;
            int random = Greenfoot.getRandomNumber(getWorld().getWidth());
            if(random < 50) {
                random += 50;
            }else if(random > getWorld().getWidth() - 50) {
                random -= 50;
            }
            getWorld().addObject(world.getMediumVocabulary().dequeue(), random, 0);
        }
    }    
}
