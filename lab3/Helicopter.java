public class Helicopter extends EnemyVehicle {
    int speed;
    public Helicopter(int minX, int maxX, int y){
        super(minX, maxX, y);
        speed = BASE_SPEED;
    }
    @Override
    public void move(){
        y = y-speed;
        speed ++;
    }
    
    @Override
    public String getType() {
        return "Helicopter";
    }
    public String toString(){
        String output = "";
        output += "A " + this.getType() + " is at location (" + this.getLocation().getX() + "," + this.getLocation().getY() +  ") .";
        output += " It has " + this.healthPoint + " points left." + " It's speed is " + speed + ".";
        return output;
    }
}
