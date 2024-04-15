package island;

import inhabitants.Animal;
import inhabitants.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Cell {

    public List<Animal> animalsInCell = new ArrayList<>();
    public List<Plant> plantsInCell = new ArrayList<>();
    public int x;
    public int y;

    //   private final int SPECIES_TOTAL_AMOUNT = 16;

    private Map<String, Integer> maxAliveAmountInCell = getMaxAliveAmountInCell();

    private Map<String, Integer> getMaxAliveAmountInCell() {
        Map<String, Integer> maxAmount = new HashMap<>();
        maxAmount.put("inhabitants.Wolf", 3);
//        maxAmount.put("Boa", 30);
//        maxAmount.put("Fox", 30);
        maxAmount.put("inhabitants.Bear", 5);
//        maxAmount.put("Eagle", 20);
//        maxAmount.put("Horse", 20);
//        maxAmount.put("Deer", 20);
        maxAmount.put("inhabitants.Rabbit", 7);
//        maxAmount.put("Mouse", 500);
//        maxAmount.put("Goat", 140);
//        maxAmount.put("Sheep", 140);
//        maxAmount.put("Hog", 50);
//        maxAmount.put("Buffalo", 10);
//        maxAmount.put("Duck", 200);
//        maxAmount.put("Caterpillar", 1000);
        maxAmount.put("inhabitants.Plant", 10);

        return maxAmount;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;

        for (String aliveName : maxAliveAmountInCell.keySet()) {
            Random random = new Random();
            int aliveAmount = random.nextInt(maxAliveAmountInCell.get(aliveName));
            for (int i = 0; i < aliveAmount; i++) {
                try {
                    Object newAlive = Class.forName(aliveName).getDeclaredConstructor(Integer.class, Integer.class).newInstance(x, y);
                    if (newAlive instanceof Animal) {
                        animalsInCell.add((Animal) newAlive);
                    } else if (newAlive instanceof Plant) {
                        plantsInCell.add((Plant) newAlive);
                    }

                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }
            }

        }
    }

    public void lifeRound() {
        List<Thread> threads = new ArrayList<>();
        synchronized (animalsInCell) {
            for (Animal animal : animalsInCell) {
                Thread animalLife = new Thread(animal);
                threads.add(animalLife);
                animalLife.start();
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void reportStatus() {
        System.out.println();
        System.out.println();
        System.out.println("CELL[" + x + "][" + y + "]");
        System.out.println("ANIMALS_TOTAL_AMOUNT: " + animalsInCell.size());

        for (int i = 0; i < animalsInCell.size(); i++) {
            animalsInCell.get(i).paint();
            // System.out.print("hp: " + animalsInCell.get(i).hp + " weight: " + animalsInCell.get(i).weight + " speed: " + animalsInCell.get(i).maxSpeed + " foodAmount: " + animalsInCell.get(i).maxFoodAmount);
//            System.out.println("Possible preys: ");
//            for (String prey : animalsInCell.get(i).possiblePreys.keySet()) {
//                System.out.println("prey: " + prey + " probability: " + animalsInCell.get(i).possiblePreys.get(prey));
//            }
        }
        System.out.println();
        System.out.println("PLANTS_TOTAL_AMOUNT: " + plantsInCell.size());
        for (int i = 0; i < plantsInCell.size(); i++) {
            plantsInCell.get(i).paint();
//            System.out.println();
//            System.out.println("weight: " + plantsInCell.get(i).weight);
        }
    }

}
