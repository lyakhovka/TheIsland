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

    private Map<String, Integer> maxAliveAmountInCell = getMaxAliveAmountInCell();

    private Map<String, Integer> getMaxAliveAmountInCell() {

        Map<String, Integer> maxAmount = new HashMap<>();

        /* Original amounts from the task*/
//        maxAmount.put("Wolf", 30);
//        maxAmount.put("Boa", 30);
//        maxAmount.put("Fox", 30);
//        maxAmount.put("Bear", 5);
//        maxAmount.put("Eagle", 20);
//        maxAmount.put("Horse", 20);
//        maxAmount.put("Deer", 20);
//        maxAmount.put("Rabbit", 150);
//        maxAmount.put("Mouse", 500);
//        maxAmount.put("Goat", 140);
//        maxAmount.put("Sheep", 140);
//        maxAmount.put("Hog", 50);
//        maxAmount.put("Buffalo", 10);
//        maxAmount.put("Duck", 200);
//        maxAmount.put("Caterpillar", 1000);
//        maxAmount.put("Plant", 200);


        /*Test smaller amounts*/
        maxAmount.put("Wolf", 3);
        maxAmount.put("Boa", 3);
        maxAmount.put("Fox", 5);
        maxAmount.put("Bear", 3);
        maxAmount.put("Eagle", 2);
        maxAmount.put("Horse", 2);
        maxAmount.put("Deer", 2);
        maxAmount.put("Rabbit", 7);
        maxAmount.put("Mouse", 9);
        maxAmount.put("Goat", 4);
        maxAmount.put("Sheep", 4);
        maxAmount.put("Hog", 5);
        maxAmount.put("Buffalo", 2);
        maxAmount.put("Duck", 9);
        maxAmount.put("Caterpillar", 9);
        maxAmount.put("Plant", 20);

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
                    Object newAlive = Class.forName("inhabitants." + aliveName).getDeclaredConstructor(Integer.class, Integer.class).newInstance(x, y);
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

        Iterator<Animal> iterator = animalsInCell.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.hp < 0.01) {
                System.out.println("\nDIED FROM STARVATION: " + animal.getIcon());
                iterator.remove();
            }
        }
    }

    public void reportStatus() {

        System.out.println();
        System.out.println();
        System.out.println("CELL[" + x + "][" + y + "]");
        System.out.println("TOTAL CELL ANIMAL COUNT: " + animalsInCell.size());

        for (int i = 0; i < animalsInCell.size(); i++) {
            animalsInCell.get(i).paint();
        }
        System.out.println("\nTOTAL CELL PLANTS COUNT: " + plantsInCell.size());
        for (int i = 0; i < plantsInCell.size(); i++) {
            plantsInCell.get(i).paint();
        }

    }

}
