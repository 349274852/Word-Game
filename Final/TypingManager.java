import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TypingManager here.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class TypingManager extends Actor
{
    boolean typingWord = false;
    String curWord = "";
    Word typedWord;
    MyWorld world;
    
    public TypingManager(MyWorld world) {
        getImage().setTransparency(0);
        this.world = world;
    }
    
    /**
     * Sets the current word being typed
     */
    public void setTypedWord(Word w) {
        typedWord = w;
    }
    
    /**
     * Act - do whatever the TypingManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
                   world.getShooter().setLockedOn(word);
                   world.getShooter().fire();
                   typedWord = word;
                   String str = word.getString();
                   str = str.substring(1, str.length());
                   curWord = str;
                   typedWord.chopWord();
                }else{
                    Greenfoot.playSound("misclick.wav");
                }
           }else{
                //Checks if the key they pressed matches the first letter of the word typing
               if(letter == curWord.charAt(0)) {
                   //Cuts the word and removes the first letter, replacing with 2nd
                   curWord = curWord.substring(1, curWord.length());
                   world.getShooter().fire();
                   typedWord.chopWord();
                   //Checks if they're finished typing the word
                   if(curWord.equals("")) {
                       world.getWordList().put(typedWord.getFirstLetter(), null);
                       typedWord = null;
                       world.getShooter().setLockedOn(null);
                   }
               }else{
                   Greenfoot.playSound("misclick.wav");
               }
           }
        }
    }
}
