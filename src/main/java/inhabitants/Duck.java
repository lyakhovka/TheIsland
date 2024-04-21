package inhabitants;

import java.util.HashMap;

public class Duck extends Omnivore{
    public static final String ICON = "\uD83E\uDD86";
    public static final String NAME = "Duck";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
    }

    public Duck(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 1;
        this.maxFoodAmount = 0.15;
        this.maxSpeed = 4;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
        this.possiblePreys.put("Caterpillar", 90);
    }

    public void paint() {
        System.out.print(ICON);
    }
}
