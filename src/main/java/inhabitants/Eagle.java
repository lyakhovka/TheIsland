package inhabitants;

import java.util.HashMap;

public class Eagle extends Carnivore {
    public static final String ICON = "\uD83E\uDD85";
    public static final String NAME = "Eagle";

    public String getName() {
        return NAME;
    }

    public String getIcon() {
        return ICON;
    }

    public Eagle(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 6;
        this.maxFoodAmount = 1;
        this.maxSpeed = 3;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Fox", 10);
        possiblePreys.put("Rabbit", 90);
        possiblePreys.put("Mouse", 90);
        possiblePreys.put("Duck", 80);


    }

    public void paint() {
        System.out.print(ICON);
    }
}
