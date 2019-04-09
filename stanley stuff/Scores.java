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
    private HashMap<String, Integer> scores = new HashMap<String, Integer>();
    
    public Scores()
    {
        addScore("jane", 20);
        addScore("james", 35);
        addScore("bob", 70);
        addScore("jimmy", 60);
        for(String s : scores.keySet()) {
            System.out.println(s + ", " + scores.get(s));
        }
    }
    
    public void addScore(String name, int score) {
        HashMap<String, Integer> sorted = new HashMap<String, Integer>();
        if(scores.size() == 0) {
            scores.put(name, score);
            return;
        }
        for(String s : scores.keySet()) {
            if(scores.get(s) < score) {
                sorted.put(name, score);
            }
            sorted.put(s, scores.get(s));
        }
        scores = sorted;
    }
    
    public void sortScores() {
        for(String s : scores.keySet()) {
            
        }
    }
}
