package inhabitants;

import island.Island;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Animal extends Alive implements Runnable {
    public String ICON;
    public String Name;
    public int maxSpeed;
    public double maxFoodAmount;
    public Map<String, Integer> possiblePreys;

    public String getIcon() {
        return ICON;
    }

    public String getName() {
        return Name;
    }

    public Animal() {
        this.hp = 1.000d;
        this.currentPosition = new HashMap<>();
    }

    public Map<String, Integer> setDestination() {

        Map<String, Integer> destinationCell = new HashMap<>();
        if (maxSpeed > 0) {
            int maxAvailableDistanceWidth = Island.getIslandWidth()-1;
            int maxAvailableDistanceHeight = Island.getIslandHeight()-1;
            Random random = new Random();

            int x = random.nextInt(maxSpeed);
            if (x >= maxAvailableDistanceWidth) x = maxAvailableDistanceWidth;
            destinationCell.put("X", x);

            int y = random.nextInt(maxSpeed);
            if (y >= maxAvailableDistanceHeight) y = maxAvailableDistanceHeight;
            destinationCell.put("Y", y);
        }
        else destinationCell = currentPosition;

        return destinationCell;
    }

    public void move(Map<String, Integer> destinationCoordinates) {
        this.currentPosition.put("X", destinationCoordinates.get("X"));
        this.currentPosition.put("Y", destinationCoordinates.get("Y"));
        this.hp = this.hp * 0.300d;
        System.out.println("\nMOVED: " + this.getIcon() + " (hp = " + this.hp + ")");

    }

    /*Check if this animal can eat the possible prey (accordingly to requirements).
    If no, return false.
    Else this animal eats the prey and increase its hp to the max value if prey is bigger then required amount of food.
    Or to proportional value if prey weight is smaller then required  amount of food.
    Prey object is deleted*/
    public boolean eat(Alive possiblePrey) {
        Animal prey;
        Plant forage;
        int eatProbability = new Random().nextInt(100);
        double requiredFoodAmount = (1.000d - this.hp) * this.maxFoodAmount;
        if (requiredFoodAmount == 0.000d) return false;

        if (!this.possiblePreys.keySet().contains(possiblePrey.getName())) {
            return false;
        } else {
            if (eatProbability <= this.possiblePreys.get(possiblePrey.getName())) {
                if (possiblePrey instanceof Animal) {
                    prey = (Animal) possiblePrey;
                    if (prey.weight > requiredFoodAmount) {
                        this.hp = 1.000d;
                    } else {
                        this.hp += prey.weight / this.maxFoodAmount;
                    }
                    System.out.println("EATEN: " + ((Animal) possiblePrey).getIcon());
                    ((Animal) possiblePrey).die();

                }

                if (possiblePrey instanceof Plant) {

                    forage = (Plant) possiblePrey;
                    if (forage.weight > requiredFoodAmount) {
                        this.hp = 1;
                    } else {
                        this.hp += forage.weight / this.maxFoodAmount;
                    }
                    System.out.println("EATEN: " + ((Plant) possiblePrey).getIcon());
                    ((Plant) possiblePrey).die();

                }
            }
       }
        return true;
    }

    public void reproduce(List<Animal> possiblePartners) {
        Class speciesToReproduce = this.getClass();
        Integer x = this.currentPosition.get("X");
        Integer y = this.currentPosition.get("Y");
        int partnersAmount = 0;
        int offspringsAmount = 0;

        for (Animal possiblePartner : possiblePartners) {
            if (possiblePartner.getClass().equals(speciesToReproduce)) partnersAmount++;
        }

        offspringsAmount = partnersAmount / 2;

        for (int i = 0; i < offspringsAmount; i++) {
            try {
                var newAnimal = speciesToReproduce.getDeclaredConstructor(Integer.class, Integer.class).newInstance(x, y);
                System.out.println("\nREPRODUCE: " + this.getIcon());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }

        }
    }

    public void run() {
    }

}
