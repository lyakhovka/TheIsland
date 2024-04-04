import java.util.HashMap;

public class Plant extends Alive{
    public static final String ICON = "\uD83C\uDF31";
    public static final String NAME = "Plant";
    public static final double MIN_PLANT_WEIGHT = 0.1; //amount of food for the smallest herbivore
    public static final double MAX_PLANT_WEIGHT = 60; //amount of food for the biggest herbivore
    public double weight;

    public String getName(){return NAME;}

    public Plant(Integer x, Integer y){
        this.currentPosition = new HashMap<>();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = Math.random() * (MAX_PLANT_WEIGHT - MIN_PLANT_WEIGHT) + MIN_PLANT_WEIGHT;
    }

    public void paint(){
        System.out.print(ICON);
    }

    @Override
    public void die() {
        this.weight = 0;
    }
}
