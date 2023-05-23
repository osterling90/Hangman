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