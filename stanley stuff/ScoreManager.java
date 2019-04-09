import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreManager extends Actor
{
    private int value = 0;
    private int score = 0;
    
    private MyWorld world;
    
    private UIRenderer renderer;
    
    public ScoreManager(MyWorld world) {
        this.world = world;
        renderer = new UIRenderer();
        
        makeImage();
    }
    
    public void addScore(int add) {
        score += add;
    }
    
    public void setScore(int set) {
        score = set;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getCounterValue() {
        return value;
    }
    
    /**
     * Act - do whatever the ScoreManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(value < score) {
            value++;
            makeImage();
        }else if(value > score) {
            value--;
            makeImage();
        }
    }   
    
    public void makeImage() {
        GreenfootImage image = new GreenfootImage(world.getWidth(), world.getHeight());
        //renderer.drawRect(image, 2, 2, 50, 50, Color.BLACK);
        //image.drawString("hello", 30, 30);
        
        //image.setColor(Color.BLACK);
        //image.fillRect(0, 0, world.getWidth(), world.getHeight());
        
        Font font = new Font("Arial", false, false, 18);
        image.setFont(font);
        image.setColor(Color.WHITE);
        renderer.drawShadowString(image, "" + value, 0, 30);
        //image.drawImage(image, 360, 20);
        setImage(image);
    }
}
