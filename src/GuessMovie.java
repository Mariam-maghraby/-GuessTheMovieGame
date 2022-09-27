import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class GuessMovie {

    public static void main(String[] args) {
        Scanner scannedFile = Game.readFileThenScanIt();
        ArrayList<String> moviesList= new ArrayList<String>();
        while (scannedFile.hasNextLine()){
            Game.appendMoviesFromTxtFileToList(scannedFile, moviesList);
        }

        int randomMovieIndex = Game.pickRandomNumber(moviesList.size()-1);
        String chosenMovie = moviesList.get(randomMovieIndex);

        System.out.println("I have randomly chosen a movie!!");
        String hiddenMovieName = Game.hiddingChosenMovieName(chosenMovie);
        System.out.println("The Movie is "+ hiddenMovieName);
        System.out.println("Try to guess it!");
        Scanner scanner = new Scanner(System.in);
        String guessedMovieName = hiddenMovieName;

        int pointsLeft=10;
        while (pointsLeft>0){
            System.out.print("Guess a letter: ");
            String inputLetter = scanner.next();
            inputLetter = String.valueOf(Game.checkIfInputIsLetter(inputLetter));
            if(chosenMovie.contains(inputLetter)){
                int indexOfRightLetter = Game.getLetterIndex(inputLetter, chosenMovie, guessedMovieName);
                guessedMovieName = guessedMovieName.substring(0, indexOfRightLetter) + inputLetter
                        + guessedMovieName.substring(indexOfRightLetter + 1);
                System.out.println("You're right, WHOOOO!!");
                System.out.println("The Movie is "+guessedMovieName);

            }
            else {
                pointsLeft --;
                System.out.println("Aaahh WRONG!!");
                System.out.println();
                System.out.format("TRY AGAIN, You still have %d points\n", pointsLeft);
            }

            if(guessedMovieName.equals(chosenMovie)){
                System.out.println("YOU WON, WHOOOOOO!!!!");
                break;
            }
        }
        if (pointsLeft == 0){
            System.out.println("GAME OVER!!!");
            System.out.println("The Movie was: "+ chosenMovie);
        }


    }



}
