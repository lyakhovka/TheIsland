package inhabitants;

import java.util.HashMap;

public class Buffalo extends Herbivore{
    public static final String ICON = "\uD83D\uDC03";
    public static final String NAME = "Buffalo";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
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
        System.out.print(ICON);
    }
}
