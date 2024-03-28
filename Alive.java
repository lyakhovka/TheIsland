public abstract class Alive {
 boolean isAlive;
 double hp;

 public void die(){
     isAlive = false;
 }

 abstract void paint();
}

