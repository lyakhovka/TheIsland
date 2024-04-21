package inhabitants;

import island.Island;

import java.util.Iterator;

public abstract class Herbivore extends Animal {
    @Override
    public synchronized void run() {
        int x = currentPosition.get("X");
        int y = currentPosition.get("Y");
        synchronized (Island.cells[x][y].plantsInCell) {
            for (Plant plant : Island.cells[x][y].plantsInCell) {
                synchronized (plant) {
                    eat(plant);
                }
            }
            Iterator<Plant> iterator = Island.cells[x][y].plantsInCell.iterator();

            while (iterator.hasNext()) {
                Plant plant = iterator.next();
                if (plant.weight == 0.0) {
                    iterator.remove();
                }
            }
            reproduce(Island.cells[x][y].animalsInCell);
            move(setDestination());
        }
    }
}
