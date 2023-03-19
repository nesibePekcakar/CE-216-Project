import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test3 {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("^\\d\\."); //a string starts with a single digit number and a dot. (3.)
        String prevLine = null; //the headword of the meaning matched.
        String firstMeaning = "1. parlak";
        String[] firstMeaningSplitted = firstMeaning.split("\\s+"); //split from the space
        String meaningSearched = firstMeaningSplitted[1]; //the first word of meaning without the number and the dot.
        int lineNo = 1; //to store the line no, so that we can access the headword.
        try (BufferedReader br = new BufferedReader(new FileReader("eng-tur.dict"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find() && line.contains(meaningSearched)) {

                    if (prevLine != null) {
                        System.out.println(prevLine); //to print the headword first.
                    }
                    System.out.println(line); //the meaning matched.
                }
                prevLine = line;
                lineNo++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}