import java.util.Scanner;
import java.lang.Math;

public class simpleGuess {
    private static final boolean work = true;
    private static double random;
    private static final String ANSI_GREEN = "\u001B[32m"; 
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static int errors = 1;

    public static void intro() {
        System. out. println(ANSI_GREEN + "Loading...." + ANSI_RESET);
        System. out. println(ANSI_YELLOW + "A number has been selected from 1-10 (inclusive).\nGuess the number. You have 3 chances!" + ANSI_RESET);
    }

    public static void question() {
        System.out.println("=========================================");
        System.out.println("== Hello, welcome to my Guessing Game! == \n== Please choose a game:               ==");
        System.out.println("== 1. Guess the number                 == \n== 2. Hangman                          ==");
        System.out.println("=========================================");
    }

    public static double optionOne() {
        double random = (int)(Math.random()*10) + 1;
        return random;
    }


    public static void main(String[] args) {

        while (work) {
            question();
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            if (option == 2) {
                System.out.println("So you've choosen option 2, Hangman? \nDo you wish to change your mind?\n(Y/N)");
                char confirmation = sc.next().toUpperCase().charAt(0);
                if (confirmation == 'Y') {
                    continue;
                }
                if (confirmation == 'N') {
                    System.out.println("abcdefg");
                    System.out.println("-------");
                }
                
            }
            if (option == 1) {
                System.out.println("So you've choosen option 1, Guessing Game? \nDo you wish to change your mind?\n(Y/N)");
                char confirmation = sc.next().toUpperCase().charAt(0);
                if (confirmation == 'Y') {
                    continue;
                }
                while (confirmation == 'N') {
                    int key = (int)optionOne();
                    intro();
                    int guess = sc.nextInt();
                    int i = 2;
                    for (i=i; i > 0; i--) {
                        if (guess == key) {
                            System.out.println("Nice, you guessed right.");
                            break;
                        }
                        else if (i > 1) {
                            System.out.println("Try again, you have " + i + " guesses left");
                            guess = sc.nextInt();
                        }
                        if (i == 1) {
                            System.out.println("Try again, you have " + i + " guess left");
                            guess = sc.nextInt();
                        }
                        if (guess == key) {
                            System.out.println("Nice, you guessed right.");
                            break;
                        }
                    }
                    if (i == 0) {
                        System.out.println("Unfortunately you've ran out of guesses. The answer was " + key);
                    }
                    System.out.println("Want to try again (Y) or return to other options (R)?");
                    char secondConfirmation = sc.next().toUpperCase().charAt(0);
                    while (secondConfirmation != 'R' && secondConfirmation != 'Y') {
                        System.out.println("Enter the letter or a word beginning with R to return to other options");
                        System.out.println("Enter the letter or a word beginning with Y to play again");
                        secondConfirmation = sc.next().toUpperCase().charAt(0);
                    }
                    if (secondConfirmation == 'Y') {
                        confirmation = 'N';
                    }
                    else {
                        confirmation = 'R';
                    }
                }
            }     
        }
   

    }
}