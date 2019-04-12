import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnnihilatedWord here.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class AnnihilatedWord extends Actor
{
    private Word word;
    
    public AnnihilatedWord(Word word) {
        this.word = word;
        GreenfootImage img = new GreenfootImage(word.getString(), 20, Color.WHITE, Color.BLACK);
        img.setTransparency(195);
        setImage(img);
    }
    
    /**
     * Act - do whatever the AnnihilatedWord wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + 1);
        if(getY() == getWorld().getHeight() - 5) {
            getWorld().removeObject(this);
        }
    }    
}
