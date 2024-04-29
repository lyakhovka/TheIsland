package inhabitants;

import java.util.HashMap;

public class Horse extends Herbivore{
    public static final String icon = "\uD83D\uDC0E";
    public static final String name = "Horse";

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Horse(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 400;
        this.maxFoodAmount = 60;
        this.maxSpeed = 4;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
    }

    public void paint() {
        System.out.print(icon);
    }
}
