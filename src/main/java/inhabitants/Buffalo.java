package inhabitants;

import java.util.HashMap;

public class Buffalo extends Herbivore{
    public static final String icon = "\uD83D\uDC03";
    public static final String name = "Buffalo";

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Buffalo(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 700;
        this.maxFoodAmount = 100;
        this.maxSpeed = 3;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
    }

    public void paint() {
        System.out.print(icon);
    }
}
