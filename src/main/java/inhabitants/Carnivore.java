package inhabitants;

import island.Island;

import java.util.Iterator;

public abstract class Carnivore extends Animal {

    @Override
    public void run() {
        int x = currentPosition.get("X");
        int y = currentPosition.get("Y");
        synchronized (Island.cells[x][y].animalsInCell) {
            for (Animal animal : Island.cells[x][y].animalsInCell) {
                synchronized (animal) {
                    eat(animal);
                }
            }
            Iterator<Animal> iterator = Island.cells[x][y].animalsInCell.iterator();

            while (iterator.hasNext()) {
                Animal animal = iterator.next();
                if (animal.hp < 0.01) {
                    iterator.remove();
                }

            }

            reproduce(Island.cells[x][y].animalsInCell);
            move(setDestination());
        }

    }

}
