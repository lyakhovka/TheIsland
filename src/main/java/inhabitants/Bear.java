package inhabitants;

import java.util.HashMap;

public class Bear extends Carnivore {
  public static final String ICON = "\uD83D\uDC3B";
  public static final String NAME = "inhabitants.Bear";
  public String getName(){return NAME;}
  public Bear(Integer x, Integer y){
    super();
    this.currentPosition.put("X", x);
    this.currentPosition.put("Y", y);
    this.weight = 500;
    this.maxFoodAmount = 80;
    this.maxSpeed = 2;
    this.possiblePreys = new HashMap<>();
   // possiblePreys.put("Boar", 80);
   // possiblePreys.put("Horse", 40);
   // possiblePreys.put("Deer", 80);
    possiblePreys.put("inhabitants.Rabbit", 80);
//    possiblePreys.put("Mouse", 90);
//    possiblePreys.put("Goat", 70);
//    possiblePreys.put("Sheep", 70);
//    possiblePreys.put("Hog", 50);
//    possiblePreys.put("Buffalo", 20);
//    possiblePreys.put("Duck", 10);


  }

  public void paint(){
    System.out.print(ICON);
  }

}
