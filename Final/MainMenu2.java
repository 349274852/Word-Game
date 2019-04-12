import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu2 here.
 * 
 * @author Steven Lin
 * @version (a version number or a date)
 */
public class MainMenu2 extends World
{

    /**
     * Constructor for objects of class MainMenu2.
     * 
     */
    
    public static GreenfootSound music = new GreenfootSound("open.mp3");
    
    public MainMenu2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        prepare();
        music.play();
        setBackground(new GreenfootImage("earth modified.jpg"));
    }
    private void prepare()
    {
        PlayButton PlayButton = new PlayButton();
        addObject(PlayButton,250,210);
        Highscore HighScore = new Highscore();
        addObject(HighScore, 259, 320);
        HowToPlay HowToPlay = new HowToPlay();
        addObject(HowToPlay, 250 , 410);
        TitleText TitleText = new TitleText();
        addObject(TitleText, 250 , 80);
    }
}
