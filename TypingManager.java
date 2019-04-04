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
    
    int delay = 2;
    int defDelay = 2;
    
    public TypingManager(MyWorld world) {
        this.world = world;
    }
    /**
     * Act - do whatever the TypingManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(delay > 0) {
            delay--;
            return;
        }
        //if the person isn't typing a word
        String key = Greenfoot.getKey();
        if(key != null) {
           char letter;
           if(key.length() == 1) {
               letter = key.charAt(0);
           }else{
               letter = '-';
           }
           if(!typingWord) {
                if(world.getWordList().get(letter) != null) {
                   Word word = world.getWordList().get(letter);
                   typedWord = word;
                   String str = word.getString();
                   str = str.substring(1, str.length());
                   curWord = str;
                   typingWord = true;
                   Laser laser = new Laser();
                   getWorld().addObject(laser, typedWord.getX(), getWorld().getHeight());
                   typedWord.chopWord();
                }
           }else{
                //checks if the key they pressed matches the first letter of the word typing
               if(letter == curWord.charAt(0)) {
                   //cuts the word and removes the first letter, replacing with 2nd
                   curWord = curWord.substring(1, curWord.length());
                   Laser laser = new Laser();
                   getWorld().addObject(laser, typedWord.getX(), getWorld().getHeight());
                   typedWord.chopWord();
                   //checks if they're finished typing the word
                   if(curWord.equals("")) {
                       typingWord = false;
                       typedWord = null;
                       world.getShooter().setLockedOn(null);
                   }
               }
           }
           delay = defDelay;
        }
    }  
    
    public void shootLaser() {
        int x = typedWord.getX();
        int y = typedWord.getY();
        
    }
}
