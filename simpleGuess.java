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

    public static String easyHangman() {
        String array[] = {"able", "acid", "aged", "also", "area", "army", "away", "baby", "back", "ball", "band", "bank", "base", "bath", "bear", "beat", "been", "beer", "bell", "belt", "best", "bill", "bird", "blow", "blue", "boat", "body", "bomb", "bond", "bone", "book", "boom", "born", "boss", "both", "bowl", "bulk", "burn", "bush", "busy", "call", "calm", "came", "camp", "card", "care", 
        "case", "cash", "cast", "cell", "chat", "chip", "city", "club", "coal", "coat", "code", "cold", "come", "cook", "cool", "cope", "copy", "CORE", "cost", "crew", "crop", "dark", "data", "date", "dawn", "days", "dead", "deal", "dean", "dear", "debt", "deep", "deny", "desk", "dial", "dick", "diet", "disc", "disk", "does", "done", "door", "dose", "down", "draw", "drew", "drop", "drug", "dual", "duke", "dust", "duty", "each", "earn", "ease", "east", "easy", "edge", "else", "even", "ever", "evil", "exit", "face", "fact", "fail", "fair", "fall", "farm", "fast", "fate", "fear", "feed", "feel", "feet", "fell", "felt", "file", "fill", "film", "find", "fine", "fire", "firm", "fish", "five", "flat", "flow", "food", "foot", "ford", "form", "fort", "four", "free", "from", "fuel", "full", "fund", "gain", "game", "gate", "gave", "gear", "gene", "gift", "girl", "give", "glad", "goal", "goes", "gold", "Golf", "gone", "good", "gray", "grew", "grey", "grow", "gulf", "hair", "half", "hall", 
        "hand", "hang", "hard", "harm", "hate", "have", "head", "hear", "heat", "held", "hell", "help", "here", "hero", "high", "hill", "hire", "hold", "hole", "holy", "home", "hope", "host", "hour", "huge", "hung", "hunt", "hurt", "idea", "inch", "into", "iron", "item", "jack", "jane", "jean", "john", "join", "jump", "jury", "just", "keen", "keep", "kent", "kept", "kick", "kill", "kind", "king", "knee", "knew", "know", "lack", "lady", "laid", "lake", "land", "lane", "last", "late", "lead", "left", "less", "life", "lift", "like", "line", "link", "list", "live", "load", "loan", "lock", "logo", "long", "look", "lord", "lose", "loss", "lost", "love", "luck", "made", "mail", "main", "make", "male", "many", "Mark", "mass", "matt", "meal", "mean", "meat", "meet", "menu", "mere", "mike", "mile", "milk", "mill", "mind", "mine", "miss", "mode", "mood", "moon", "more", "most", "move", "much", "must", "name", "navy", "near", "neck", "need", "news", "next", "nice", "nick", "nine", "none", 
        "nose", "note", "okay", "once", "only", "onto", "open", "oral", "over", "pace", "pack", "page", "paid", "pain", "pair", "palm", "park", "part", "pass", "past", "path", "peak", "pick", "pink", "pipe", "plan", "play", "plot", "plug", "plus", "poll", "pool", "poor", "port", "post", "pull", "pure", "push", "race", "rail", "rain", "rank", "rare", "rate", "read", "real", "rear", "rely", "rent", "rest", "rice", "rich", "ride", "ring", "rise", "risk", "road", "rock", "role", "roll", "roof", "room", "root", "rose", "rule", "rush", "ruth", "safe", "said", "sake", "sale", "salt", "same", "sand", "save", "seat", "seed", "seek", "seem", "seen", "self", "sell", "send", "sent", "sept", "ship", "shop", "shot", "show", "shut", "sick", "side", "sign", "site", "size", "skin", "slip", "slow", "snow", "soft", "soil", "sold", "sole", "some", "song", "soon", "sort", "soul", "spot", "star", "stay", "step", "stop", "such", "suit", "sure", "take", "tale", "talk", "tall", "tank", "tape", "task", 
        "team", "tech", "tell", "tend", "term", "test", "text", "than", "that", "them", "then", "they", "thin", "this", "thus", "till", "time", "tiny", "told", "toll", "tone", "tony", "took", "tool", "tour", "town", "tree", "trip", "true", "tune", "turn", "twin", "type", "unit", "upon", "used", "user", "vary", "vast", "very", "vice", "view", "vote", "wage", "wait", "wake", "walk", "wall", "want", "ward", "warm", "wash", "wave", "ways", "weak", "wear", "week", "well", "went", "were", "west", "what", "when", "whom", "wide", "wife", "wild", "will", "wind", "wine", "wing", "wire", "wise", "wish", "with", "wood", "word", "wore", "work", "yard", "yeah", "year", "your", "zero", "zone"};
        int index = (int)(Math.random()*array.length);
        return array[index];
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