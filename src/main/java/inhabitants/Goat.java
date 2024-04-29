package inhabitants;

import java.util.HashMap;

public class Goat extends Herbivore{
    public static final String icon = "\uD83D\uDC10";
    public static final String name = "Goat";

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Goat(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 60;
        this.maxFoodAmount = 10;
        this.maxSpeed = 2;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
    }

    public void paint() {
        System.out.print(icon);
    }
}
