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
    
    public void setTypedWord(Word w) {
        typedWord = w;
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
        typingWord = typedWord != null;
        String key = Greenfoot.getKey();
        if(key != null) {
           char letter;
           //Checks if key pressed is a singular letter, and not 'backspace' or 'enter', etc.
           if(key.length() == 1) {
               letter = key.charAt(0);
           }else{
               letter = '-';
           }
           //Checks if the player was initially typing a word
           if(!typingWord) {
                if(world.getWordList().get(letter) != null) {
                   Word word = world.getWordList().get(letter);
                   typedWord = word;
                   String str = word.getString();
                   str = str.substring(1, str.length());
                   curWord = str;
                   fire();
                   typedWord.chopWord();
                }
           }else{
                //Checks if the key they pressed matches the first letter of the word typing
               if(letter == curWord.charAt(0)) {
                   //Cuts the word and removes the first letter, replacing with 2nd
                   curWord = curWord.substring(1, curWord.length());
                   fire();
                   typedWord.chopWord();
                   //Checks if they're finished typing the word
                   if(curWord.equals("")) {
                       world.getWordList().put(typedWord.getFirstLetter(), null);
                       typedWord = null;
                       world.getShooter().setLockedOn(null);
                   }
               }
           }
           delay = defDelay;
        }
    }
    
    public void fire() {
        Laser laser = new Laser(typedWord);
        getWorld().addObject(laser, typedWord.getX(), getWorld().getHeight());
    }
}
