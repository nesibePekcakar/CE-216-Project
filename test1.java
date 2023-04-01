import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {

    public static void main(String[] args) {

        final int A = 2;
        final int B = 6059;
        final int C = 12998;
        final int D = 24411;
        final int E = 30289;
        final int F = 34514;
        final int G = 39615;
        final int H = 43539;
        final int I = 48043;
        final int J = 52543;
        final int K = 53694;
        final int L = 54739;
        final int M = 58690;
        final int N = 64574;
        final int O = 66666;
        final int P = 69279;
        final int Q = 79583;
        final int R = 80297;
        final int S = 86237;
        final int T = 102124;
        final int U = 109443;
        final int V = 112667;
        final int W = 114859;
        final int X = 118542;
        final int Y = 118637;
        final int Z = 119071;

        Scanner input = new Scanner(System.in);
        String word = input.next();

        long start = System.nanoTime();
        char firstLetter = word.charAt(0);

        int startLine = switch (firstLetter) {
            case 'a' -> A;
            case 'b' -> B;
            case 'c' -> C;
            case 'd' -> D;
            case 'e' -> E;
            case 'f' -> F;
            case 'g' -> G;
            case 'h' -> H;
            case 'i' -> I;
            case 'j' -> J;
            case 'k' -> K;
            case 'l' -> L;
            case 'm' -> M;
            case 'n' -> N;
            case 'o' -> O;
            case 'p' -> P;
            case 'q' -> Q;
            case 'r' -> R;
            case 's' -> S;
            case 't' -> T;
            case 'u' -> U;
            case 'v' -> V;
            case 'w' -> W;
            case 'x' -> X;
            case 'y' -> Y;
            case 'z' -> Z;
            default -> -1;
        };

        boolean found = false;


            try (BufferedReader br = new BufferedReader(new FileReader("eng-tur.dict"))) {
                String line;
                int lineNumber = 1;
                while ((line = br.readLine()) != null) {
                    if (lineNumber >= startLine) {
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
                                if (matcher.matches()) { //check if the line is a headword.
                                    break;
                                }
                                System.out.println(line); //print the line.
                            }
                        }
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        long end = System.nanoTime();
        long elapsedTime = (end - start);
        double time = elapsedTime/1000000000d;
        System.out.println(time + "seconds");
        }
    }
