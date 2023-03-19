import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {

    public static void main(String[] args) {

        String word = "high"; //input
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader("eng-tur.dict"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (found) { //to ignore the other words that startsWith the word we are looking for. ("high" and "highway" i.e.).
                    break;   //it works because dictionaries are in alphabetical order. so our word is always the shortest one.
                }
                Pattern pattern = Pattern.compile("(.*\\w.*)\\s*/.*"); //a string with exactly two slashes (/).
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches() && line.startsWith(word)) { //line starts with word we are looking for, and contains two slashes.
                    System.out.println("The word exists in English language: \n");
                    found = true;
                    System.out.println(line); //print the headword
                    while ((line = br.readLine()) != null) { //print the lines until the next headword.
                        matcher = pattern.matcher(line);
                        if (matcher.matches()){ //check if the line is a headword.
                            break;
                        }
                        System.out.println(line); //print the line.
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
