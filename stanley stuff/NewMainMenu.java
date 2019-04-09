import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class NewMainMenu here.
 * 
 * @author Stanley Chan, Kelvin Mo
 * @version (a version number or a date)
 */
public class NewMainMenu extends World
{

    private int currentSelection = 0;
    
    private HashMap<Integer, String> map = new HashMap<Integer, String>();
    
    private int height, width;
    
    private MenuSelector select;
    private UIRenderer renderer;
    
    public static GreenfootSound music = new GreenfootSound("open.wav");
    
    /**
     * Constructor for objects of class NewMainMenu.
     * 
     */
    public NewMainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        height = getHeight();
        width = getWidth();
        map.put(0, "play");
        map.put(1, "highscores");
        map.put(2, "howtoplay");
        select = new MenuSelector();
        renderer = new UIRenderer();
        makeImage();
        addObject(select, width / 2 - 50, height / 2 + 45);
        music.play();
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if("down".equals(key)) {
            if(currentSelection < map.size()) {
                currentSelection++;
                select.moveDown();
            }
        }else if("up".equals(key)) {
            if(currentSelection > 0) {
                currentSelection--;
                select.moveUp();
            }
        }else if("enter".equals(key)) {
            switchWorld(map.get(currentSelection));
        }
    }
    
    public void switchWorld(String world) { 
        switch(world) {
            case "play":
                Greenfoot.setWorld(new NewOpeningScreen());
                music.stop();
                break;
        }
    }
    
    public void makeImage() {
        GreenfootImage image = new GreenfootImage("earth modified.jpg");
        
        Font font = new Font("Arial", false, false, 20);
        image.setFont(font);
        image.setColor(Color.WHITE);
        renderer.drawShadowString(image, "The Domination of Illiterate Aliens", 110, height / 2 - 50);
        renderer.drawShadowString(image, "Start", width / 2 - 25, height / 2 + 50);
        renderer.drawShadowString(image, "High Scores", width / 2 - 25, height / 2 + 100);
        renderer.drawShadowString(image, "How to Play", width / 2 - 25, height / 2 + 150);
        setBackground(image);
    }
}
