import java.io.*;
import java.util.*;

public class Hangman {
    public void getWord(){
        String word = "";
        try{
            String nextString;
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader buffer = 
            new BufferedReader(new FileReader("wordList.txt"));
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
        Scanner sc = new Scanner(System.in);
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
                System.out.println("\nAwesome, let's do this!\n-----------------------");
                break;
            }
            else{
                System.out.println("\nThat answer is no good!");
            }
        }
        while(true){
            for(int i = 0; i < arr.length; i++){
                
            }
        }
        
    }
    public static void main(String[] args) {
        Hangman h = new Hangman();
        h.getWord();
        /* String first = " O";
        String second = " O\n |";
        String third =  " O\n/|";
        String fourth = " O\n/|\\";
        String fifth = " O\n/|\\" + "\n/";
        String sixth = " O\n/|\\" + "\n/ \\"; */
    }
}