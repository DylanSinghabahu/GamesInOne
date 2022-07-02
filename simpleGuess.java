import java.util.Scanner;
import java.lang.Math;

public class simpleGuess {
    private static final boolean work = true;
    private static double random;
    private static final String ANSI_GREEN = "\u001B[32m"; 
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static int errors = 1;




    public static void question() {
        System.out.println("================================");
        System.out.println("Hello, welcome to my Guessing Game! \nPlease choose a game:");
        System.out.println("1. Guess the number \n2. Hangman");
        System.out.println("================================");
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
            if (option == 1) {
                System.out.println("So you've choosen option 1? \nDo you wish to change your mind?\n(Y/N)");
                char confirmation = sc.next().toUpperCase().charAt(0);
                if (confirmation == 'Y') {
                    continue;
                }
                while (confirmation == 'N') {
                    int key = (int)optionOne();
                    System.out.println(key);
                    System. out. println(ANSI_GREEN + "Loading...." + ANSI_RESET);
                    System. out. println(ANSI_YELLOW + "A number has been selected from 1-10 (inclusive).\nGuess the number. you have 3 chances!" + ANSI_RESET);
                    int guess = sc.nextInt();
                    for (int i = 2; i > 0; i--) {
                        if (guess == key) {
                            System.out.println("Nice, you guessed right.");
                            break;
                        }
                        else {
                            if (i > 1) {
                                System.out.println("Try again, you have " + i + " guesses left");
                                errors++;
                                guess = sc.nextInt();
                            }
                            else {
                                System.out.println("Try again, you have " + i + " guess left");
                                errors++;
                                guess = sc.nextInt();
                            }
                        }
                    }
                    if (errors == 3) {
                        System.out.println("Unfortunately you've ran out of guesses. The answer was " + key);
                    }
                    System.out.println("Want to try again (Y) or return to other options (R)?");
                    char secondConfirmation = sc.next().toUpperCase().charAt(0);
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
