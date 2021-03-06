import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class simpleGuess {
    private static final boolean work = true;
    private static double random;
    private static final String ANSI_GREEN = "\u001B[32m"; 
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\033[0;31m";
    private static final String RED_BOLD = "\033[1;31m";
    private static final String YELLOW_UNDERLINED = "\033[4;33m";
    private static final String GREEN_BOLD = "\033[1;32m";
    private static final String GREEN = "\033[0;32m";

    private static boolean go = false;


    public static void intro() {
        System. out. println(ANSI_GREEN + "Loading...." + ANSI_RESET);//different print statements, ansi_reset = futile??
        System. out. println(ANSI_YELLOW + "A number has been selected from 1-10 (inclusive).\nGuess the number. You have 3 chances!" + ANSI_RESET);
    }

    public static void question() {
        System.out.println("=========================================");
        System.out.println("==    Hello, welcome to my Program     ==");
        System.out.println("==                                     ==");
        System.out.println("== Please choose a game:               ==");
        System.out.println("==                                     ==");
        System.out.println("== 1. Guess the number                 == \n== 2. Hangman                          ==");
        System.out.println("=========================================");
    }

    public static double optionOne() {
        double random = (int)(Math.random()*10) + 1;
        return random;
    }
    public static double optionTwo() {
        double random = (int)(Math.random()*30) + 1;
        return random;
    }
    public static String hint(String theWord) {
        String newWord ="";
        String word[] = theWord.split("");
        word[0] = "_";
        for (String letter:word) {
            newWord += letter;
        }
        return newWord;
    }

    public static String Hangman(String difficulty) {
        Scanner sc = new Scanner(System.in);
        String hint = " ";
        boolean minus = false;
        boolean hintAgain = true;
        String line = ""; 
        boolean isDuplicate = true;
        String usedLetters = "";
        String array[];
        String arrayUsed[];
        boolean start=true;
        String hangman[] = {RED_BOLD+
            RED_BOLD+"  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========", 

            RED_BOLD+ "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",

            RED_BOLD+ "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",

            RED_BOLD+"  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========", 
        
            RED_BOLD+"  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",

            RED_BOLD+"  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",

            RED_BOLD+"  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="};

        if (difficulty.equals("e")) {
            array = new String[]{"able", "acid", "aged", "also", "area", "army", "away", "baby", "back", "ball", "band", "bank", "base", "bath", "bear", "beat", "been", "beer", "bell", "belt", "best", "bill", "bird", "blow", "blue", "boat", "body", "bomb", "bond", "bone", "book", "boom", "born", "boss", "both", "bowl", "bulk", "burn", "bush", "busy", "call", "calm", "came", "camp", "card", "care", 
            "case", "cash", "cast", "cell", "chat", "chip", "city", "club", "coal", "coat", "code", "cold", "come", "cook", "cool", "cope", "copy", "CORE", "cost", "crew", "crop", "dark", "data", "date", "dawn", "days", "dead", "deal", "dean", "dear", "debt", "deep", "deny", "desk", "dial", "diet", "disc", "disk", "does", "done", "door", "dose", "down", "draw", "drew", "drop", "drug", "dual", "duke", "dust", "duty", "each", "earn", "ease", "east", "easy", "edge", "else", "even", "ever", "evil", "exit", "face", "fact", "fail", "fair", "fall", "farm", "fast", "fate", "fear", "feed", "feel", "feet", "fell", "felt", "file", "fill", "film", "find", "fine", "fire", "firm", "fish", "five", "flat", "flow", "food", "foot", "ford", "form", "fort", "four", "free", "from", "fuel", "full", "fund", "gain", "game", "gate", "gave", "gear", "gene", "gift", "girl", "give", "glad", "goal", "goes", "gold", "Golf", "gone", "good", "gray", "grew", "grey", "grow", "gulf", "hair", "half", "hall", 
            "hand", "hang", "hard", "harm", "hate", "have", "head", "hear", "heat", "held", "hell", "help", "here", "hero", "high", "hill", "hire", "hold", "hole", "holy", "home", "hope", "host", "hour", "huge", "hung", "hunt", "hurt", "idea", "inch", "into", "iron", "item", "jack", "jane", "jean", "john", "join", "jump", "jury", "just", "keen", "keep", "kent", "kept", "kick", "kill", "kind", "king", "knee", "knew", "know", "lack", "lady", "laid", "lake", "land", "lane", "last", "late", "lead", "left", "less", "life", "lift", "like", "line", "link", "list", "live", "load", "loan", "lock", "logo", "long", "look", "lord", "lose", "loss", "lost", "love", "luck", "made", "mail", "main", "make", "male", "many", "Mark", "mass", "matt", "meal", "mean", "meat", "meet", "menu", "mere", "mike", "mile", "milk", "mill", "mind", "mine", "miss", "mode", "mood", "moon", "more", "most", "move", "much", "must", "name", "navy", "near", "neck", "need", "news", "next", "nice", "nick", "nine", "none", 
            "nose", "note", "okay", "once", "only", "onto", "open", "oral", "over", "pace", "pack", "page", "paid", "pain", "pair", "palm", "park", "part", "pass", "past", "path", "peak", "pick", "pink", "pipe", "plan", "play", "plot", "plug", "plus", "poll", "pool", "poor", "port", "post", "pull", "pure", "push", "race", "rail", "rain", "rank", "rare", "rate", "read", "real", "rear", "rely", "rent", "rest", "rice", "rich", "ride", "ring", "rise", "risk", "road", "rock", "role", "roll", "roof", "room", "root", "rose", "rule", "rush", "ruth", "safe", "said", "sake", "sale", "salt", "same", "sand", "save", "seat", "seed", "seek", "seem", "seen", "self", "sell", "send", "sent", "sept", "ship", "shop", "shot", "show", "shut", "sick", "side", "sign", "site", "size", "skin", "slip", "slow", "snow", "soft", "soil", "sold", "sole", "some", "song", "soon", "sort", "soul", "spot", "star", "stay", "step", "stop", "such", "suit", "sure", "take", "tale", "talk", "tall", "tank", "tape", "task", 
            "team", "tech", "tell", "tend", "term", "test", "text", "than", "that", "them", "then", "they", "thin", "this", "thus", "till", "time", "tiny", "told", "toll", "tone", "tony", "took", "tool", "tour", "town", "tree", "trip", "true", "tune", "turn", "twin", "type", "unit", "upon", "used", "user", "vary", "vast", "very", "vice", "view", "vote", "wage", "wait", "wake", "walk", "wall", "want", "ward", "warm", "wash", "wave", "ways", "weak", "wear", "week", "well", "went", "were", "west", "what", "when", "whom", "wide", "wife", "wild", "will", "wind", "wine", "wing", "wire", "wise", "wish", "with", "wood", "word", "wore", "work", "yard", "yeah", "year", "your", "zero", "zone"};    
        }
        else {
            array = new String[]{"asterisk", "apocryphal", "anemone", "colloquialism", "defibrillator", "explicit", "massachusetts", "synecdoche", "schadenfreude", "worcestershire", "phlegm", "chthonic", "pterodactyl", "mnemonic", "apropossolemn", "rendezvous", "gobbledegook", 
            "pochemuchka", "chiaroscurist", "logorrhea", "tractable", "placate", "miser", "engender", "dogma", "homogeneous", "laconic", "quiescence", "anomalous", "venerate", "assuage", "digress", "corroborate", "buttress", "antipathy", "disabuse", "feigned", "diatribe", "obdurate", "precipitate", "pragmatic", "embellish", "prevaricate", "heresy", "aberrant", "fawn", "eulogy", 
            "guile", "banal", "equivocal", "schadenfreude", "sesquipedalian"};
        }

        int index = (int)(Math.random()*array.length);
        
        String theWord = array[index];

        for (int i = 0; i < theWord.length(); i++) {
            line += " _ ";
        }
        String arrayWord[] = new String[theWord.length()];

        for (int i = 0; i < arrayWord.length; i++) {
            arrayWord[i] = theWord.charAt(i)+"";
        }
        String arrayWord2[] = new String[theWord.length()];

        for (int i =0; i < arrayWord2.length; i++) {
            arrayWord2[i] = " ";
        }
        System.out.println(ANSI_GREEN+"Please make sure the terminal is large enough to see your guess count"+ANSI_RESET);
        System.out.println(RED_BOLD+"You have 6 guesses!"+ANSI_RESET);
        for (int i = 0; i < 6; i++) {
            if (i == 5 && hintAgain) {
                System.out.println(hangman[i]);
                System.out.println(ANSI_YELLOW+"Last Guess, would you like a hint?\n"+ANSI_RESET+ANSI_GREEN+"Yes"+ANSI_RESET+ANSI_RED+"\nNo"+ANSI_RESET);
                System.out.println(Arrays.toString(arrayWord2));
                System.out.println(line);
                hint = sc.next().toUpperCase().charAt(0)+"";
                System.out.println("\n\n\n\n");
            }
            if (hint.equals("Y")) {
                System.out.println("The word is " + hint(theWord));
                System.out.println(Arrays.toString(arrayWord2));
                System.out.println(line);  
                hintAgain=false;
                System.out.println(hangman[i]);
            }

            else {
                System.out.println(Arrays.toString(arrayWord2));
                System.out.println(line);  
                System.out.println(YELLOW_UNDERLINED+"Guess a letter!"+ANSI_RESET);
                System.out.println(hangman[i]);

            }
            
            String guess = sc.next().toLowerCase().charAt(0) + "";
            arrayUsed = usedLetters.trim().split("\\s");

            for (int k = 0; k < arrayUsed.length; k++) {
                if (guess.equals(arrayUsed[k])) {
                    isDuplicate = true;
                    break;
                }
                else {
                    isDuplicate = false;
                }
            }
            System.out.println("\n\n\n\n");
            for (int j = 0; j < arrayWord.length; j++) {
                if (guess.equals(arrayWord[j].toLowerCase())) {
                    arrayWord2[j]=guess;
                    minus = true;
                }
                else if (isDuplicate) {
                    minus = true;
                    break;
                }
            }

            if (minus) {
                i--;
                minus = false;
            }
            else {
                usedLetters += " " + guess;
            }
            int left = 6-i-1;
            if (left > 1 && !Arrays.equals(arrayWord, arrayWord2)) {
                System.out.println("You have " + left + " guesses left");
            }
            else if (left == 0) {
                System.out.println(hangman[i+1]);
                break;
            }
            else if (Arrays.equals(arrayWord, arrayWord2)) {
                System.out.println("Nice, you guessed the word!\n\n\n");
                i=arrayWord.length;
                break;

            }
            else {
                System.out.println("You have " + left + " guess left");
            }


            System.out.println(ANSI_RED +"Used letters:" +ANSI_RESET + ANSI_YELLOW + usedLetters + ANSI_RESET);
            
        }
        System.out.println(GREEN+"The word was " +ANSI_RESET+ GREEN_BOLD+theWord+ANSI_RESET);
        return "Would you like to play hangman again?\nYes\nNo";

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = 0;

        while (work) {
            question();
            int option = sc.nextInt();

            if (option == 2) {
                System.out.println("So you've choosen option 2, Hangman? \nDo you wish to change your mind?\n(Y/N)");
                char confirmation = sc.next().toUpperCase().charAt(0);
                if (confirmation == 'Y') {
                    continue;
                }
                while (confirmation == 'N' || go) {
                    System.out.println("\n\n\n\n");
                    System.out.println("What difficulty would you like to choose?\nEasy\nHard");
                    String difficulty = sc.next().toLowerCase().charAt(0) + "";
                    while (!difficulty.equals("e") && !difficulty.equals("h")) {
                        System.err.println("Type \"Easy\" or \"e\" for easy difficulty and type \"Hard\" or \"h\" for hard difficulty");
                        difficulty = sc.next().toLowerCase().charAt(0) + "";
                        System.out.println(difficulty+"hi");
                    }
                    System.out.println(Hangman(difficulty));
                    char confirmations = sc.next().toUpperCase().charAt(0);
                    if (confirmations == 'Y') {
                        go = true;
                    }

                    if (confirmations == 'N') {
                        break;
                    }
                }
                

                
            }
            if (option == 1) {
                System.out.println("So you've choosen option 1, Guessing Game? \nDo you wish to change your mind?\n(Y/N)");
                char confirmation = sc.next().toUpperCase().charAt(0);
                if (confirmation == 'Y') {
                    continue;
                }
                while (confirmation == 'N') {
                    System.out.println("Which difficulty would you like to choose?\nEasy\nHard");
                    String difficulty = sc.next().toLowerCase().charAt(0) + "";
                    while (!difficulty.equals("e") && !difficulty.equals("h")) {
                        System.out.println("Type \"e\" for Easy or \"h\" for Hard difficulty");
                        difficulty = sc.next().toLowerCase().charAt(0) + "";
                    }
                    if (difficulty.equals("e")) {
                        key = (int)optionOne();
                    }
                    else {
                        key = (int)optionTwo();
                    }
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
                        System.out.println("Enter R to return to other options");
                        System.out.println("Enter Y to play again");
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