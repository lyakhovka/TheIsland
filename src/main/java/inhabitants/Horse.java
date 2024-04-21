package inhabitants;

import java.util.HashMap;

public class Horse extends Herbivore{
    public static final String ICON = "\uD83D\uDC0E";
    public static final String NAME = "Horse";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
    }

    public Horse(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 400;
        this.maxFoodAmount = 60;
        this.maxSpeed = 4;
        this.possiblePreys = new HashMap<>();
        possiblePreys.put("Plant", 100);
    }

    public void paint() {
        System.out.print(ICON);
    }
}
