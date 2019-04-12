/**
 * Write a description of class Reader here.
 * 
 * @author N/A
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.InputStream;

public class Reader  
{
    /**
     * Opens a text file inside the package folder and returns a scanner to
     * read it. This works for text files inside jar files.
     * 
     * @param name The name of the text file
     * @return A Scanner object that is used to read the contents of the text
     *  file.
     */
    public Scanner getScanner(String filename) {
        InputStream myFile = getClass().getResourceAsStream(filename);
        if(myFile != null) {
            return new Scanner(myFile);
        }
        return null;
    }
}
