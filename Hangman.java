package Hangman;
import java.io.*;
import java.util.*;
public class Hangman {
    public static void getWord(){
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
    public static void buildWord(String word){
        letter[] array = new letter[word.length()];
        for(int i = 0; i < word.length(); i++){
            array[i].currentLetter = word.charAt(i);
        }
    }
    public void gameLoop(){

    }
    public void display(){

    }
    public static void main(String[] args) {
        /* String first = " O";
        String second = " O\n |";
        String third =  " O\n/|";
        String fourth = " O\n/|\\";
        String fifth = " O\n/|\\" + "\n/";
        String sixth = " O\n/|\\" + "\n/ \\"; */
    }
}