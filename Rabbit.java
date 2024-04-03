import java.util.HashMap;

public class Rabbit extends Herbivore{
    public static final String ICON = "\uD83D\uDC07";
    public static final String NAME = "Rabbit";

    public Rabbit(Integer x, Integer y){
        super();
        this.currentPosition.put("X", x);
        this.currentPosition.put("Y", y);
        this.weight = 2;
        this.maxFoodAmount = 0.45;
        this.maxSpeed = 2;
        this.possiblePreys = new HashMap<>();
        possiblePreys.put("Plant", 100);
    }

    public void paint(){
        System.out.print(ICON);
    }


}
