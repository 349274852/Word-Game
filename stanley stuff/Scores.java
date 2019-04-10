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
        PlayerScore p1 = new PlayerScore("jim", 20);
        PlayerScore p2 = new PlayerScore("hey", 40);
        PlayerScore p3 = new PlayerScore("bye", 11);
        scores.add(p1);
        scores.add(p2);
        scores.add(p3);
        sortScores();
        for(PlayerScore s : scores) {
            System.out.println(s.getName());
        }
    }
    
    public void addScore(PlayerScore player) {
        scores.add(player);
    }
    
    public void sortScores() {
        ArrayList<PlayerScore> sorted = new ArrayList<PlayerScore>();
        PlayerScore highest = sorted.get(0);
        while(!scores.isEmpty()) {
            for(int i = 0; i < scores.size(); i++) {
                if(scores.get(i).getScore() > highest.getScore()) {
                    highest = scores.get(i);
                }
            }
            sorted.add(highest);
            scores.remove(highest);
        }
        scores = sorted;
    }
}
