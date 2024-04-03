import java.util.Map;

public abstract class Alive {
 boolean isCreatureAlive;
 double hp;
 public Map<String, Integer> currentPosition;

 public void die(){
     isCreatureAlive = false;
 }

 abstract void paint();
}

