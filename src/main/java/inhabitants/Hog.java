package inhabitants;

import java.util.HashMap;

public class Hog extends Omnivore{
    public static final String ICON = "\uD83D\uDC37";
    public static final String NAME = "Hog";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
    }

    public Hog(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 400;
        this.maxFoodAmount = 50;
        this.maxSpeed = 2;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
        this.possiblePreys.put("Mouse", 50);
        this.possiblePreys.put("Caterpillar", 90);
    }

    public void paint() {
        System.out.print(ICON);
    }
}
