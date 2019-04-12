import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class ScoreManager here.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class ScoreManager extends Actor
{
    private int value = 0;
    private int score = 0;
    
    private int level = 1;
    
    private MyWorld world;
    
    private UIRenderer renderer;
    
    public ScoreManager(MyWorld world) {
        this.world = world;
        renderer = new UIRenderer();
        
        makeImage();
    }
    
    /**
     * Checks if the player name is already present in the high scores list.
     */
    public static boolean containsName(String playername) {
        for(PlayerScore s : Scores.array) {
            if(s.getName().equals(playername)) return true;
        }
        return false;
    }
    
    /**
     * Adds the player name to the score list.
     */
    public static void addToScoreboard(String playername, int score) {
        PlayerScore player = new PlayerScore(playername, score);
        Scores.array.add(player);
        if(Scores.array.size() > 10) {
            Scores.array.remove(Scores.array.size());
        }
    }
    
    /**
     * Adds to the score
     */
    public void addScore(int add) {
        score += add;
    }
    
    /**
     * Sets the score to a number
     */
    public void setScore(int set) {
        score = set;
    }
    
    /**
     * Returns the current score
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Returns the counter value
     */
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
    
    /**
     * Adds to the current level.
     */
    public void addLevel(int modifier) {
        level += modifier;
    }
    
    public void makeImage() {
        GreenfootImage image = new GreenfootImage(world.getWidth(), world.getHeight());
        Font font = new Font("Arial", false, false, 18);
        image.setFont(font);
        image.setColor(Color.WHITE);
        renderer.drawShadowString(image, "" + value, 0, 30);
        renderer.drawShadowString(image, "Level: " + level, 0, 60);
        setImage(image);
    }
}
