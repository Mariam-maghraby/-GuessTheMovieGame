import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static Scanner readFileThenScanIt() {
        File file = new File("movies.txt");
        try{
            Scanner fileScanner = new Scanner(file);
            return fileScanner;

        }
        catch ( FileNotFoundException e){
            System.out.println("Caught File exception error " + e.getMessage());
            return null;
        }
    }

    public static void appendMoviesFromTxtFileToList(Scanner scannedFile, ArrayList<String> moviesList){
        String movieTitle = scannedFile.nextLine();
        try {
            moviesList.add(movieTitle);
        }
        catch (IndexOutOfBoundsException e){
            throw e;
        }
    }


    public static int pickRandomNumber(int max){
        int randomNumber = (int)Math.random()*(max);
        return randomNumber;
    }

    public static void checkIfInputIsLetter(String s){
        try {
            if(s.length() > 1) {
                throw new RuntimeException("You must input one letter at !\n");
            }
            char c = s.charAt(0);
            if (!(Character.isLetter(c))){
                throw new RuntimeException("Char is not a letter!\n");
            }
        }
        catch(RuntimeException re){
            System.out.print(re.getMessage());
        }
    }

    public static String hiddingChosenMovieName(String name){
        String hiddenName = name.replaceAll("[a-zA-Z]", "_");
        return hiddenName;
    }

    public static int getLetterIndex(String letter, String word, String guessedWord){
        int indexOfRightLetter = word.indexOf(letter);
        if(guessedWord.contains(letter)) {
            for (int i = indexOfRightLetter + 1; i < word.length(); i++) {
                if(word.charAt(i) == guessedWord.charAt(indexOfRightLetter)) {
                    indexOfRightLetter = i;
                }
            }
        }
        return indexOfRightLetter;
    }
}
