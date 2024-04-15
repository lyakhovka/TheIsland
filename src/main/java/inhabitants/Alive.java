package inhabitants;

import java.util.Map;

public abstract class Alive {
 //boolean isCreatureAlive;
 double weight;
 double hp;
 public Map<String, Integer> currentPosition;

 public void die(){
  weight = 0.0;
  hp = 0.0;
  //isCreatureAlive = false;
 }

 public abstract void paint();
 abstract String getName();
}

