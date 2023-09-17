public class Game {

    private String name;
    private int storage;
    private int score;
    
    public Game(String name, int GB, int score){
        this.name = name;
        this.storage = GB;
        this.score = score;
    }
    public String getName(){
        return name;
    }
    public int getStorage(){
        return storage;
    }
    public int getScore(){
        return score;
    }
    @Override
    public String toString(){
        String gameInfo = getName() + ", " + getStorage() + "GB, " + getScore();
        return gameInfo;
    }
}
