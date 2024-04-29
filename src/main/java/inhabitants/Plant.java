package inhabitants;

import java.util.HashMap;

public class Plant extends Alive {
    public static final String icon = "\uD83C\uDF31";
    public static final String name = "inhabitants.Plant";
    public static final double MIN_PLANT_WEIGHT = 0.1; //amount of food for the smallest herbivore
    public static final double MAX_PLANT_WEIGHT = 60; //amount of food for the biggest herbivore


    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Plant(Integer x, Integer y) {
        this.currentPosition = new HashMap<>();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = Math.random() * (MAX_PLANT_WEIGHT - MIN_PLANT_WEIGHT) + MIN_PLANT_WEIGHT;
    }

    public void paint() {
        System.out.print(icon);
    }

}
