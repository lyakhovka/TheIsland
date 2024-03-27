import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Animal extends Alive{

    public int weight;
    public int maxAmount;
    public int maxSpeed;
    public int maxFoodAmount;
    public ArrayList<Alive> possiblePreys;
    public Map<String, Integer> setDestination(){
        Map<String, Integer> destinationCell = new HashMap<>();
        int islandWidth = 100; //temporary hardcoded
        int islandHeight = 20; //temporary hardcoded
        Random random = new Random();

        int x = random.nextInt(maxSpeed);
        if (x>islandWidth) x = islandWidth;
        destinationCell.put("X", x);

        int y = random.nextInt(maxSpeed);
        if (y>islandHeight) y=islandHeight;
        destinationCell.put("Y", y);

        return destinationCell;
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
            if (!this.possiblePreys.contains(possiblePrey)) {
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
        if (possiblePartner.getClass().equals(speciesToReproduce)){

            try {
                speciesToReproduce.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |NoSuchMethodException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void die(){
        if (this.hp < 0.1) this.isAlive = false;
    }

}
