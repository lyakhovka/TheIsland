package inhabitants;

import java.util.HashMap;

public class Mouse extends Omnivore{
    public static final String icon = "\uD83D\uDC2D";
    public static final String name = "Mouse";

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Mouse(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 0.05;
        this.maxFoodAmount = 0.01;
        this.maxSpeed = 1;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Plant", 100);
        this.possiblePreys.put("Caterpillar", 90);
    }

    public void paint() {
        System.out.print(icon);
    }
}
