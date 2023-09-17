import java.util.Random;
public class Hangman{
    //properties
    private StringBuffer secretWord;
    private StringBuffer knownSoFar;
    private StringBuffer usedLetters;
    private StringBuffer allLetters;
    private int numOfIncorrectTries;
    private int maxAllowedIncorrectTries = 6;
    //constructor
    public Hangman(){
        this.allLetters = new StringBuffer("abcdefghijklmnoqprstuvwxyz");
        this.usedLetters = new StringBuffer(26);
        this.numOfIncorrectTries = 0;
        this.secretWord = chooseSecretWord(); 
        this.knownSoFar = new StringBuffer(20);
        for(int i = 0; i < this.secretWord.length(); i++)
        {
            this.knownSoFar.append("_");
        }
}
    //getters and setters
    public StringBuffer getSecretWord(){
        return secretWord;
    }
    public StringBuffer getKnownSoFar(){
        return knownSoFar;
    }
    public StringBuffer getUsedLetters(){
        return usedLetters;
    }
    public StringBuffer getAllLetters(){
        return allLetters;
    }
    public int getNumOfIncorrectTries(){
        return numOfIncorrectTries;
    }
    public int getMaxAllowedIncorrectTries(){
        return maxAllowedIncorrectTries;
    }
    public void setSecretWord(StringBuffer secretWord){
        this.secretWord = secretWord;
    }
    public void setKnownSoFar(StringBuffer knownSoFar){
        this.knownSoFar = knownSoFar;
    }
    public void setAllLetters(StringBuffer allLetters){
        this.allLetters = allLetters;
    }
    public void setUsedLetters(StringBuffer usedLetters){
        this.usedLetters = usedLetters;
    }
    public void setNumberOfIncorrectTries(int numberOfIncorrectTries){
        this.numOfIncorrectTries = numberOfIncorrectTries;
    }
    public void setMaxAllowedIncorrectTries(int maxAllowedIncorrectTries){
        this.maxAllowedIncorrectTries = maxAllowedIncorrectTries;
    }
    //other methods
    /**
    * Method randomly chooses a word from an array of words. 
    @return result in terms of StringBuffer. This result will be used to initialize the instance variable called "secretWord"
    */
    private StringBuffer chooseSecretWord(){
        //Potential secret words stored in the array.
        String[] secretWordList = {"embarresment","fluorescent", "accomodate","psychiatrist",
        "questionnaire","necessary","mischevious","occasionally","pheneumonia","restaurant",
        "millenium","ridiculous","phenomenon", "sixth","rural", "colonel", "ironic","irregardless",
        "lieutenant", "didactic", "february","behaviour", "development" };
        // creating a random object and choosing the index number of a word
        Random rand = new Random();
        int chosenIndex = rand.nextInt(secretWordList.length); // which word is chosen from the wordList as an index number
        StringBuffer result = new StringBuffer(secretWordList[chosenIndex]); // secret word as the type of a StringBuffer
        return result;
    }
    /** This method takes a char as a parameter and returns 
     * the number of occcurences of the letters in secretWord
     * updates the knownSoFar variable
     * updates numberOfIncorrectTries variable
     * updates usedLetters variable
     * updates allLetter variable **/

    public int tryThis(char controlChar){
        //assuming that validity of the paramater was checked in main method, this part
        //aims to solve possible problems that might be caused by case of the letter 
        controlChar = Character.toLowerCase (controlChar);
        String tempSecretWord = this.secretWord.toString().toLowerCase();
    
        //checking whether that letter is given before and 
        //assuming it is an incorrect try if it is used before
        if (this.usedLetters.indexOf ("" + controlChar) > -1) {
            this.numOfIncorrectTries ++;
            return 0;
        }
        else {
            this.usedLetters.append (controlChar);
        }
    
        //calculating the number of occurences of the given letter
        int numberOfOccurrence = 0;
    
        for (int i = 0; i < tempSecretWord.length(); i++) {
            if (tempSecretWord.charAt(i) == controlChar) {
                numberOfOccurrence++;
                this.knownSoFar.replace (i, i + 1, "" + controlChar); //updating the known part of the secret word
            }
        }
    
        //increasing the number of incorrect tries if letter does not occur in secret word 
        if (numberOfOccurrence == 0) {
            this.numOfIncorrectTries++;
        }
    
        //returning the number of occurences
        return numberOfOccurrence;
    }
    public boolean hasLost(){
        return numOfIncorrectTries == maxAllowedIncorrectTries;
    }
    public boolean isGameOver(){
        if(hasLost() == true || knownSoFar.toString().equals(secretWord.toString())){
            return true;
        }
        else{
            return false;
        }
    }
}