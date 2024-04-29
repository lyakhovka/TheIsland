package inhabitants;

import java.util.HashMap;

public class Wolf extends Carnivore {
    public static final String icon = "\uD83D\uDC3A";
    public static final String name = "Wolf";

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Wolf(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 50;
        this.maxFoodAmount = 8;
        this.maxSpeed = 3;
        this.possiblePreys = new HashMap<>();
        possiblePreys.put("Horse", 10);
        possiblePreys.put("Deer", 15);
        possiblePreys.put("Rabbit", 60);
        possiblePreys.put("Mouse", 80);
        possiblePreys.put("Goat", 60);
        possiblePreys.put("Sheep", 70);
        possiblePreys.put("Hog", 15);
        possiblePreys.put("Buffalo", 10);
        possiblePreys.put("Duck", 40);
    }

    public void paint() {
        System.out.print(icon);
    }
}
