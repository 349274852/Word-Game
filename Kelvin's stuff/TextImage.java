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
    private boolean isDead = false;
    
    public TextImage(Word word) {
        this.word = word;
        setRotation(getRotation() + 180);
    }
    
    /**
     * Act - do whatever the TextImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkDeath();
        if(!word.inWorld()) {
            getWorld().removeObject(this);
            return;
        }
        setLocation(word.getX(), word.getY() - 30);
        die();
    }    
    
    /*
     * A method which checks if the spaceship intersects with other objects.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneIntersectingObject(clss);
        return actor != null;
    }
    
    /**
     * Check if the player is dead by examining whether there is any enemy 
     * touching the baseline.
     */
    public void checkDeath()
    {
        if(getY() >= getWorld().getHeight()-10)
        {
            isDead = true;
            //System.out.println("hello");
        }
        //if(canSee(Shooter.class))
        //{
            //isDead = true;
            //System.out.println("hello");
        //}
    }
    
    //if the spaceship is damaged, set the screen to the GameOver page.
    public void die()
    {
        if(isDead ==true)
        {
            isDead = false;
            Greenfoot.setWorld(new GameOver());
        }
    }
}
