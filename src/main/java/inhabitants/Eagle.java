package inhabitants;

import java.util.HashMap;

public class Eagle extends Carnivore {
    public static final String icon = "\uD83E\uDD85";
    public static final String name = "Eagle";

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
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
        this.possiblePreys.put("Rabbit", 90);
        this.possiblePreys.put("Mouse", 90);
        this.possiblePreys.put("Duck", 80);


    }

    public void paint() {
        System.out.print(icon);
    }
}
