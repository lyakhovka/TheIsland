import java.util.Iterator;

public abstract class Herbivore extends Animal{
    private static final Object lock = new Object();
    @Override
    public void run() {
        while(this.hp>0) {
            int x = currentPosition.get("X");
            int y = currentPosition.get("Y");
            synchronized (Island.cells[x][y].plantsInCell) {
                for (Plant plant : Island.cells[x][y].plantsInCell) {
                    eat(plant);
                }
                Iterator<Plant> iterator = Island.cells[x][y].plantsInCell.iterator();
                while (iterator.hasNext()) {
                    Plant plant = iterator.next();
                    if (plant.weight == 0.0) {
                        iterator.remove();
                    }
                }

            }
            synchronized (Island.cells[x][y].animalsInCell){
            for (Animal animal : Island.cells[x][y].animalsInCell) {
                reproduce(animal);
            }
        }

        }
    }

}
