import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnterName here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnterName extends World
{

    private String name = "";
    private int score;
    
    UIRenderer renderer = new UIRenderer();
    
    GreenfootImage image;
    
    /**
     * Constructor for objects of class EnterName.
     * 
     */
    public EnterName(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        this.score = score;
        makeImage();
        System.out.println(Scores.array.size());
    }
    
    public void makeImage() {
        image = new GreenfootImage("earth modified.jpg");
        image.setFont(new Font("Arial", false, false, 50));
        image.setColor(Color.WHITE);
        renderer.drawShadowString(image, "You lose!", getWidth() / 2 - 100, 50);
        renderer.drawShadowString(image, "Enter name (type):", 3, 200);
        image.setFont(new Font("Arial", false, false, 25));
        renderer.drawShadowString(image, name, 3, 250);
        setBackground(image);
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if(key != null) {
            if(!key.equals("enter") && name.length() < 20 && key.length() == 1) {
                name += key.charAt(0);
                makeImage();
            }else if(key.equals("enter") && name.length() > 0){
                if(!ScoreManager.containsName(name)) {
                    ScoreManager.addToScoreboard(name, score);
                    Greenfoot.setWorld(new GameOver());
                }else{
                    renderer.drawShadowString(image, "Name already taken", 3, 300);
                }
            }else if(Greenfoot.isKeyDown("backspace") && name.length() > 0) {
                name = name.substring(0, name.length() - 1);
                makeImage();
            }
        }
    }
}
