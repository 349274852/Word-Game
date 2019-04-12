import java.util.*;

/**
 * Write a description of class HighScore here.
 * 
 * @author Stanley Chan 
 * @version (a version number or a date)
 */
public class Scores  
{
    // instance variables - replace the example below with your own
    public static ArrayList<PlayerScore> array = new ArrayList<PlayerScore>();
    
    public Scores()
    {
        sortScores();
    }
    
    /**
     * Gets all of the scores.
     */
    public ArrayList<PlayerScore> getScores() {
        return array;
    }
    
    /**
     * Sorts the scores in descending order.
     */
    public void sortScores() {
        ArrayList<PlayerScore> sorted = new ArrayList<PlayerScore>();
        while(!array.isEmpty()) {
            PlayerScore highest = array.get(0);
            for(int i = 0; i < array.size(); i++) {
                if(array.get(i).getScore() > highest.getScore()) {
                    highest = array.get(i);
                }
            }
            array.remove(highest);
            sorted.add(highest);
        }
        array = sorted;
    }
}
