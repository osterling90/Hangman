public class letter{
    public boolean isCorrect;
    public char character;

    public letter(){
        this.isCorrect = false;
    }
    public letter(boolean value){
        this.isCorrect = value;
    }
    public char get(){
        return this.character;
    }
    public void display(){
        if(this.isCorrect == false){
            System.out.print(" _ ");
        }
        else{
            System.out.print(" " + this.character + " ");
        }
    }
}