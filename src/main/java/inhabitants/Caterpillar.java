package inhabitants;

import java.util.HashMap;

public class Caterpillar extends Herbivore{
    public static final String ICON = "\uD83D\uDC1B";
    public static final String NAME = "Caterpillar";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
    }

    public Caterpillar(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 0.01;
        this.maxFoodAmount = 0;
        this.maxSpeed = 0;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
    }

    public void paint() {
        System.out.print(ICON);
    }
}
