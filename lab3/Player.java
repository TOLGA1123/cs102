import java.util.ArrayList;
public class Player {
    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;
    public Player(){

    }
    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies){
        for(int i = 0; i<enemies.size(); i++){
        if(Math.sqrt(Math.pow((enemies.get(i).getLocation().getX() - x),2) + Math.pow((enemies.get(i).getLocation().getY() - y), 2)) <= BOMB_RADIUS) {
            enemies.get(i).takeDamage(DAMAGE);
        }
    }
    }
}
