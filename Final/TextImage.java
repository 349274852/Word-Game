import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextImage here.
 * 
 * @author Stanley Chan 
 * @version (a version number or a date)
 */
public class TextImage extends Actor
{
    Word word;
    
    public TextImage(Word word) {
        this.word = word;
        if(word.isPowerUp()) {
            setImage(new GreenfootImage("nuke.png"));
            getImage().scale(getImage().getWidth() / 2, getImage().getHeight() / 2);
            setLocation(word.getX(), 30);
        }else {
            setImage(new GreenfootImage("enemy.png"));
            setLocation(word.getX(), 0);
        }
        setRotation(getRotation() + 180);
    }
    
    /**
     * Act - do whatever the TextImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!word.inWorld()) {
            getWorld().removeObject(this);
            return;
        }
        setLocation(word.getX(), word.getY() - 30);
    }    
}
