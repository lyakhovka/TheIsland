import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Animal extends Alive implements Runnable{
    public int weight;
    public int maxSpeed;
    public double maxFoodAmount;
    public Map<String, Integer> possiblePreys;


    public Animal(){
        this.hp = 1;
        this.isCreatureAlive = true;
        this.currentPosition = new HashMap<>();
    }
    public Map<String, Integer> setDestination(){
        Map<String, Integer> destinationCell = new HashMap<>();
        int islandWidth = 10; //temporary hardcoded
        int islandHeight = 5; //temporary hardcoded
        Random random = new Random();

        int x = random.nextInt(maxSpeed);
        if (x>islandWidth) x = islandWidth;
        destinationCell.put("X", x);

        int y = random.nextInt(maxSpeed);
        if (y>islandHeight) y=islandHeight;
        destinationCell.put("Y", y);

        return destinationCell;
    }

    public void move(Map<String, Integer> destinationCoordinates){
        this.currentPosition.put("X", destinationCoordinates.get("X"));
        this.currentPosition.put("Y", destinationCoordinates.get("Y"));

    }
    public boolean eat(Alive possiblePrey){
            Animal prey;
            Plant forage;
            double requiredFoodAmount = this.hp * this.maxFoodAmount;

            //Check if this animal can eat the possible prey (accordingly to requirements).
            //If no, return false.
            //Else this animal eats the prey and increase its hp to the max value if prey is bigger then required amount of food.
            //Or to proportional value if prey weight is smaller then required  amount of food.
            //Prey object is deleted.

            //TODO add probability of eating depending on the exact prey.
            if (!this.possiblePreys.keySet().contains(possiblePrey)) {
                return false;
            } else {
                if (possiblePrey instanceof Animal) {
                    prey = (Animal) possiblePrey;
                    if (prey.weight > requiredFoodAmount) {
                        this.hp = 1;
                    } else {
                        this.hp += prey.weight / this.maxFoodAmount;
                    }
                    ((Animal) possiblePrey).hp = 0;
                }

                if (possiblePrey instanceof Plant) {

                    forage = (Plant) possiblePrey;
                    if (forage.weight > requiredFoodAmount) {
                        this.hp = 1;
                    } else {
                        this.hp += forage.weight / this.maxFoodAmount;
                    }
                    ((Plant) possiblePrey).weight = 0;
                }

            }

            return true;
        }
    public void reproduce(Animal possiblePartner){
        Class speciesToReproduce = this.getClass();
        Integer x = this.currentPosition.get("X");
        Integer y = this.currentPosition.get("Y");
        if (possiblePartner.getClass().equals(speciesToReproduce)){

            try {
                speciesToReproduce.getDeclaredConstructor(Integer.class, Integer.class).newInstance(x, y);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |NoSuchMethodException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void die(){
        if (this.hp < 0.1) this.isCreatureAlive = false;
    }

    public void run(){}

}
