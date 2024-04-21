package inhabitants;

import java.util.HashMap;

public class Sheep extends Herbivore{
    public static final String ICON = "\uD83D\uDC11";
    public static final String NAME = "Sheep";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
    }

    public Sheep(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 70;
        this.maxFoodAmount = 15;
        this.maxSpeed = 2;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
    }

    public void paint() {
        System.out.print(ICON);
    }
}
