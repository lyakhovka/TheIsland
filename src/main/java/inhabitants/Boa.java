package inhabitants;

import java.util.HashMap;

public class Boa extends Carnivore {
    public static final String icon = "\uD83D\uDC0D";
    public static final String name = "Boa";

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Boa(Integer x, Integer y) {
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 15;
        this.maxFoodAmount = 3;
        this.maxSpeed = 1;
        this.possiblePreys = new HashMap<>();
        this.possiblePreys.put("Fox", 15);
        this.possiblePreys.put("Rabbit", 20);
        this.possiblePreys.put("Mouse", 40);
        this.possiblePreys.put("Duck", 10);


    }

    public void paint() {
        System.out.print(icon);
    }
}
