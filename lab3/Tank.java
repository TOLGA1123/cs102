public class Tank extends EnemyVehicle{
    
    double armor; // tanks deal less dmg from attacks
    public Tank(int minX, int maxX, int y){
        super(minX, maxX, y);
        armor = 25;
    }
    @Override
    public String getType() {
        return "Tank";
    }
    @Override
    public void takeDamage(double damage){
        this.healthPoint = healthPoint - (damage - armor);
    }
    public String toString(){
        String output = "";
        output += "A " + this.getType() + " is at location (" + this.getLocation().getX() + ","+ this.getLocation().getY() + ") .";
        output += " It has " + this.healthPoint + " points left.";
        return output;
    }
    

}
