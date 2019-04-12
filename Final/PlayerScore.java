/**
 * Write a description of class PlayerScore here.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class PlayerScore  
{
    private String name;
    private int score;

    /**
     * Constructor for objects of class PlayerScore
     */
    public PlayerScore(String player, int score)
    {
        name = player;
        this.score = score;
    }
    
    /**
     * Returns the name of the player
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the score of the player
     */
    public int getScore() {
        return score;
    }
}
