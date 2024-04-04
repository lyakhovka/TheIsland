import java.util.Iterator;

public abstract class Omnivore extends Animal {
    @Override
    public void run() {
        while (this.hp > 0) {
            int x = currentPosition.get("X");
            int y = currentPosition.get("Y");
            synchronized (Island.cells[x][y].plantsInCell) {
                for (Plant plant : Island.cells[x][y].plantsInCell) {
                    eat(plant);
                }
                Iterator<Plant> plantsIterator = Island.cells[x][y].plantsInCell.iterator();
                while (plantsIterator.hasNext()) {
                    Plant plant = plantsIterator.next();
                    if (plant.weight == 0.0) {
                        plantsIterator.remove();
                    }
                }

                for (Animal animal : Island.cells[x][y].animalsInCell) {
                    eat(animal);
                }
                Iterator<Animal> animalsIterator = Island.cells[x][y].animalsInCell.iterator();
                while (animalsIterator.hasNext()) {
                    Animal animal = animalsIterator.next();
                    if (animal.hp == 0.0) {
                        animalsIterator.remove();
                    }
                }
                reproduce(Island.cells[x][y].animalsInCell);
                move(setDestination());

//                Island.cells[x][y].reportStatus();

            }
        }
    }
}

