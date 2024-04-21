package inhabitants;

import java.util.HashMap;

public class Deer extends Herbivore{
    public static final String ICON = "\uD83E\uDD8C";
    public static final String NAME = "Deer";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
    }

    public Deer(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 300;
        this.maxFoodAmount = 50;
        this.maxSpeed = 2;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
    }

    public void paint() {
        System.out.print(ICON);
    }
}
