import java.io.*;
import java.util.*;

public class Hangman {
    /* Starter method */
    public void start(){
        getWord();
    }
    /* Reads a list of words in from a text file and puts them into an
     * ArrayList. A word from the ArrayList is then chosen at random
     * and passed to the buildWord() method
     */
    public void getWord(){
        String word = "";
        try{
            String nextString;
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader buffer = 
            new BufferedReader(new FileReader("test.txt"));
            while((nextString = buffer.readLine()) != null){
                list.add(nextString);
            }
            buffer.close();
            Random rand = new Random();
            int randNum = rand.nextInt(list.size());
            word = list.get(randNum);
            buildWord(word);
        }
        catch(Exception e){
            System.out.println("An error occured. Cannot read file.");
        }
    }
    /* Builds the word using an array of objects from the letter.java class
     * and passes this array to the gameLoop() method
     */
    public void buildWord(String word){
        letter[] arr = new letter[word.length()];
        for(int i = 0; i < word.length(); i++){
            arr[i] = new letter();
            arr[i].character = word.charAt(i);
        }
        gameLoop(arr);
    }
    /* All game logic is contained here. Passes result to
     * teardown() method once user has won or lost
     */
    public void gameLoop(letter[] arr){
        String[] man = new String[7];
        man[0] = " O";
        man[1] = " O\n |";
        man[2] = " O\n/|";
        man[3] = " O\n/|\\";
        man[4] = " O\n/|\\" + "\n/";
        man[5] = " O\n/|\\" + "\n/ \\";
        man[6] = " |\n |\n O\n/|\\" + "\n/ \\\n";
        Scanner sc = new Scanner(System.in);
        boolean playerWon;
        char[] temp = new char[arr.length];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i].character;
        }
        String fullWord = String.copyValueOf(temp);
        System.out.println("\nLet's play Hangman!\n-------------------");
        while(true){
            System.out.println("\nDo you need to read the rules? (Y/N)");
            String rules = sc.nextLine();
            if(rules.equalsIgnoreCase("Y")){
                System.out.println("\n\n * * * * * * * * * * * * * * * * *\n No worries!\n\n" +
                " Controls:\n [ENTER] - Enter your letter/word\n" +
                " [BACKSPACE] or [DELETE] - Erase the last letter entry\n\n" +
                " Keep guessing letters in" +
                " the word or guess the entire word itself!\n If you guess a" +
                " letter correctly, the letter will appear. Guess incorrectly\n and" +
                " this poor sod is one step closer to being strung up!" +
                " Too many\n wrong guesses and not only is our man done for," +
                " you lose! Guess all\n of the letters or the entire word before" +
                " that happens and you win!\n * * * * * * * * * * * * * * * * * *\n\n Now, let's get started!\n\n----------------------------\n\n"
                );
                break;
            }
            else if(rules.equalsIgnoreCase("N")){
                System.out.println("\nAwesome, let's do this!\n-----------------------\n");
                break;
            }
            else{
                System.out.println("\nThat answer is no good!");
            }
        }
        int a = 0;
        while(a < 7){
            for(int i = 0; i < arr.length; i++){
                arr[i].display();
            }
            System.out.println("\n\nGuess a letter or the word!");
            String guess = sc.nextLine();
            for(int i = 0; i < arr.length; i++){
                int counter = 0;
                /* The user guesses a letter correctly */
                if((guess.length() == 1) && (guess.toUpperCase().charAt(0) == arr[i].character)){
                    arr[i].isCorrect = true;
                    System.out.println("\n\n** Nice! **\n\n");
                    break;
                }
                /* The user guesses a letter incorrectly */
                for(int j = 0; j < arr.length; j++){
                    if((guess.length() == 1) && (guess.toUpperCase().charAt(0) != arr[j].character)){
                         counter++;
                    }
                }
                if(counter == arr.length && a < 6){
                    System.out.println("\n\n** Oof! Guess again! **\n\n\n" + man[a] + "\n\n\n");
                    a++;
                    break;
                }
                if(counter == arr.length && a == 6){
                    System.out.println("\n\n" + man[6]);
                    teardown(false);
                }
                /* The user guess all of the letters correctly */
                /* ... */
                /* The user guesses the word correctly */
                if(guess.equalsIgnoreCase(fullWord)){
                    System.out.println("\nYou guessed the word!\n");
                    for(int j = 0; j < arr.length; j++){
                        arr[j].isCorrect = true;
                        arr[j].display();
                        sc.close();
                    }
                    System.out.println("\n");
                    playerWon = true;
                    teardown(playerWon);
                }
                /* The user guesses the word incorrectly */
                /* ... */
            }
        }
    }
    /* Ends the game after the gameLoop() method has decided that
     * the user has met either the winning or losing conditions
     */
    public void teardown(boolean playerWon){
        if(playerWon == true){
            System.out.println("\n\nCongrats, you won the game!" +
            " Come play again sometime!\n\n------------------------\n");
            System.exit(0);
        }
        if(playerWon == false){
            System.out.println("That's too bad." +
            " You did your best though! Come play again anytime!\n\n------------------------\n");
            System.exit(0);
        }
    }
    /* Driver method */
    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.start();
    }
}