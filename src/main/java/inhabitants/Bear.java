package inhabitants;

import java.util.HashMap;

public class Bear extends Carnivore {
    public static final String icon = "\uD83D\uDC3B";
    public static final String name = "Bear";

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Bear(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 500;
        this.maxFoodAmount = 80;
        this.maxSpeed = 2;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Boar", 80);
        possiblePreys.put("Horse", 40);
        possiblePreys.put("Deer", 80);
        possiblePreys.put("Rabbit", 80);
        possiblePreys.put("Mouse", 90);
        possiblePreys.put("Goat", 70);
        possiblePreys.put("Sheep", 70);
        possiblePreys.put("Hog", 50);
        possiblePreys.put("Buffalo", 20);
        possiblePreys.put("Duck", 10);


    }

    public void paint() {
        System.out.print(icon);
    }

}
