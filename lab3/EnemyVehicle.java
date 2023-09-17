import java.awt.*;
import java.util.Random;
public abstract class EnemyVehicle implements Movable, Destructible{
    
    final int BASE_SPEED = 3;
    //position properties
    int x;
    int y;
    double healthPoint; //health point of a vehicle
    public EnemyVehicle(int minX, int maxX, int y){
        Random rand = new Random();
        this.x = rand.nextInt(maxX-minX) + minX;//??? what if the x coordinate is crowded? 
        //ITS OK can be multiple vehicle in the same coordinates
        this.y = y;
        healthPoint = 100;
    }

    public int getDistanceToBorder(){
        return y;
    }

    public abstract String getType();

    public void move(){
        y = y - BASE_SPEED;
    }
    public Point getLocation(){ //???
        return new Point (x,y);
    }
    public boolean isDestroyed(){
        return healthPoint == 0;
    }
    public void takeDamage(double damage){
        this.healthPoint -= damage;
    }
    

    
}
