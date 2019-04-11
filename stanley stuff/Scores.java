import java.util.*;

/**
 * Write a description of class HighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scores  
{
    // instance variables - replace the example below with your own
    private ArrayList<PlayerScore> scores = new ArrayList<PlayerScore>();
    
    public Scores()
    {
        scores = ScoreManager.scores;
        sortScores();
    }
    
    public ArrayList<PlayerScore> getScores() {
        return scores;
    }
    
    public void sortScores() {
        ArrayList<PlayerScore> sorted = new ArrayList<PlayerScore>();
        while(!scores.isEmpty()) {
            PlayerScore highest = scores.get(0);
            for(int i = 0; i < scores.size(); i++) {
                if(scores.get(i).getScore() > highest.getScore()) {
                    highest = scores.get(i);
                }
            }
            scores.remove(highest);
            sorted.add(highest);
        }
        scores = sorted;
    }
}
