import java.io.*;
import java.util.*;

public class Hangman {
    public void start(){
        getWord();
    }
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
    public void buildWord(String word){
        letter[] arr = new letter[word.length()];
        for(int i = 0; i < word.length(); i++){
            arr[i] = new letter();
            arr[i].character = word.charAt(i);
            //arr[i].display();
        }
        gameLoop(arr);
    }
    public void gameLoop(letter[] arr){
        String[] man = new String[6];
        man[0] = " O";
        man[1] = " O\n |";
        man[2] = " O\n/|";
        man[3] = " O\n/|\\";
        man[4] = " O\n/|\\" + "\n/";
        man[5] = " O\n/|\\" + "\n/ \\";
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
                System.out.println("\n No worries!\n\n Keep guessing letters in" +
                " the word or guess the entire word itself!\n If you guess a" +
                " letter correctly, it will appear. Guess incorrectly\n and" +
                " some poor guy is one step closer to being strung up!" +
                " Too many\n wrong guesses and our guy is not only dead but" +
                " you lose! Guess all\n of the letters or the entire word before" +
                " that happens and you win!\n\n Now, let's get started!\n----------------------------"
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
        while(a < 6){
            for(int i = 0; i < arr.length; i++){
                arr[i].display();
            }
            System.out.println("\n\nGuess a letter or the word!");
            String guess = sc.nextLine();
            for(int i = 0; i < arr.length; i++){
                if(guess.length() == 1 && guess.toUpperCase().charAt(0) == arr[i].character){
                    arr[i].isCorrect = true;
                    System.out.println("\nNice!\n");
                }
                /*if(guess.length() == 1 && guess.toUpperCase().charAt(0) != arr[i].character){
                    System.out.println(man[a]);
                }*/
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
                /*if(guess.equalsIgnoreCase(fullWord) != true){
                    System.out.println(man[a]);
                }*/
                if(a == 5){
                    System.out.println("\nOh no!\n\n" + " |\n |\n O\n/|\\" + "\n/ \\\n");
                    teardown(false);
                }
            }
            a++;
        }
    }
    public void teardown(boolean playerWon){
        if(playerWon == true){
            System.out.println("Congrats, you won the game!" +
            " Come play again sometime!\n\n------------------------\n");
            System.exit(0);
        }
        if(playerWon == false){
            System.out.println("Ouch, that's tough." +
            " You did your best though! Come play again anytime!\n\n------------------------\n");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.start();
    }
}