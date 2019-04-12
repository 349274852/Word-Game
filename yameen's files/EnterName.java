import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnterName here.
 * 
 * @author Stanley Chan, Yameen
 * @version (a version number or a date)
 */
public class EnterName extends World
{

    private String name = "";
    private int score;
    
    private int wordDelay = 200;
    private int wordDelayDef = 200;
    
    UIRenderer renderer = new UIRenderer();
    
    GreenfootImage image;
    
    private Queue<Word> annihilated;
    private int wordsKilled = 0;
    
    /**
     * Constructor for objects of class EnterName.
     * 
     */
    public EnterName(int score, Queue<Word> annihilated)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        this.score = score;
        this.annihilated = annihilated;
        wordsKilled = annihilated.getSize();
        makeImage();
    }
    
    public void makeImage() {
        image = new GreenfootImage("blackhole.jpg");
        GreenfootImage enterName = new GreenfootImage("enter name.png");
        addObject(new EnterNameImage(), getWidth()/2, 400);
        addObject(new YouLose(), getWidth() / 2, 150);
        
        image.setFont(new Font("Arial", false, false, 50));
        image.setColor(Color.WHITE);
        image.setFont(new Font("Arial", false, false, 25));
        renderer.drawShadowString(image, name, 25, getHeight() - 50);
        image.setFont(new Font("Arial", false, false, 20));
        renderer.drawShadowString(image, "Words Annihilated(" + wordsKilled + "):", getWidth() - 250, 350);
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
        if(!annihilated.isEmpty()) {
            if(wordDelay > 10) wordDelay--;
            else{
                AnnihilatedWord word = new AnnihilatedWord(annihilated.dequeue());
                addObject(word, getWidth() - 100, 400);
                wordDelay = wordDelayDef;
            }
        }
    }
}
