import java.util.Map;

public abstract class Alive {
 boolean isAlive;
 double hp;
 public Map<String, Integer> currentPosition;

 public void die(){
     isAlive = false;
 }

 abstract void paint();
}

