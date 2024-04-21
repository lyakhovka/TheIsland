package inhabitants;

import java.util.HashMap;

public class Fox extends Carnivore {
    public static final String ICON = "\uD83E\uDD8A";
    public static final String NAME = "Fox";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
    }

    public Fox(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 8;
        this.maxFoodAmount = 2;
        this.maxSpeed = 2;
        this.possiblePreys = new HashMap<>();

        this.possiblePreys.put("Rabbit", 70);
        this.possiblePreys.put("Mouse", 90);
        this.possiblePreys.put("Caterpillar", 40);
        this.possiblePreys.put("Duck", 60);


    }

    public void paint() {
        System.out.print(ICON);
    }
}