import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Game implements Difficulty{
    GamePlotter gameplot;
    int difficulty;
    int score;
    int minX;
    int maxX;
    Player player;
    ArrayList<EnemyVehicle> enemies;
    final int STARTING_DISTANCE = 20;
    final int MAX_NO_OF_PASSING_ENEMIES = 5; // idk
    public Game(int difficulty){
        gameplot = new GamePlotter(this);
        score = 0;
        enemies = new ArrayList<EnemyVehicle>();
        this.setDifficulty(difficulty);
        if(difficulty == 1){ //EASY = 1
            player = new Player();
            this.minX = 0;
            this.maxX = 5;
            for(int i =0; i<2; i++){
                enemies.add(getNewRandomVehicle());
            }
        }
        else if(difficulty == 2){ //MEDIUM = 2
            player = new Player();
            this.minX = 0;
            this.maxX = 10;
            for(int i=0; i<4; i++){
                enemies.add(getNewRandomVehicle());
            }
        }
        else{//HARD = 3
            player = new Player();
            this.minX = 0;
            this.maxX = 15;
            for(int i=0; i<6; i++){
                enemies.add(getNewRandomVehicle());
            }
        }
    }
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public EnemyVehicle getNewRandomVehicle(){
        Random rand = new Random();
        int prob = rand.nextInt(2);
        if(prob == 1){
            return new Tank(minX, maxX, STARTING_DISTANCE);
        }
        else{
            return new Helicopter(minX, maxX, STARTING_DISTANCE);
        }

    }
    public void play(){
        int passedBorder = 0;
        gameplot.plot();
        printGameState();
        while(passedBorder < MAX_NO_OF_PASSING_ENEMIES){
            Scanner input = new Scanner(System.in);
                System.out.println("Enter the coordinates (x,y) to bomb: ");
                int coordinateX = input.nextInt();
                int coordinateY = input.nextInt();
                player.attack(coordinateX, coordinateY, getEnemies());

            for(int i = 0; i< getEnemies().size(); i++){
                if(getEnemies().get(i).isDestroyed()){
                    getEnemies().set(i,getNewRandomVehicle());
                    score ++;
                }
                getEnemies().get(i).move();
                if(getEnemies().get(i).getDistanceToBorder()<=0){
                    passedBorder++;
                    getEnemies().set(i,getNewRandomVehicle());
                }
            }
            gameplot.plot();
            printGameState(); // maybe problem here prints after the move
        }
        System.out.println("Final score: " + score);
    }
    public ArrayList<EnemyVehicle> getEnemies(){
        return enemies;
    }
    public void enemiesTurn(){ // didnt used in play()
        for(int i = 0; i<getEnemies().size(); i++){
            getEnemies().get(i).move();
        }
    }
    public void printGameState(){
        for(int i = 0; i<getEnemies().size(); i++){
            System.out.println(getEnemies().get(i));
        }
    }
}
