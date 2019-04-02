import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TypingManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TypingManager extends Actor
{
    boolean typingWord = false;
    String curWord = "";
    Word typedWord;
    MyWorld world;
    
    public TypingManager(MyWorld world) {
        this.world = world;
    }
    /**
     * Act - do whatever the TypingManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!typingWord) {
            String key = Greenfoot.getKey();
            if(key != null) {
                char letter;
                if(key.length() == 1) {
                    letter = key.charAt(0);
                }else{
                    letter = '-';
                }
                if(world.getWordList().get(letter) != null) {
                    Word word = world.getWordList().get(letter);
                    typedWord = word;
                    String str = word.getString();
                    str = str.substring(1, str.length());
                    curWord = str;
                    typingWord = true;
                }
            }
        }else{
            String key = Greenfoot.getKey();
            if(key != null) {
                char letter;
                if(key.length() == 1) {
                    letter = key.charAt(0);
                }else{
                    letter = '-';
                }
                if(letter == curWord.charAt(0)) {
                    curWord = curWord.substring(1, curWord.length());
                    Laser laser = new Laser();
                    getWorld().addObject(laser, typedWord.getX(), getWorld().getHeight());
                    if(curWord.equals("")) {
                        typingWord = false;
                        typedWord = null;
                    }
                }
            }
        }
    }    
}
