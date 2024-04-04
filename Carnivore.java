import java.util.Iterator;

public abstract class Carnivore extends Animal {
    private static final Object lock = new Object();
    @Override
    public void run() {
        while(isCreatureAlive){
            int x = currentPosition.get("X");
            int y = currentPosition.get("Y");
                synchronized (lock) {
                    for (Animal animal : Island.cells[x][y].animalsInCell) {
                        eat(animal);
                    }
                    Iterator<Animal> iterator = Island.cells[x][y].animalsInCell.iterator();
                    while (iterator.hasNext()){
                        Animal animal = iterator.next();
                        if(!animal.isCreatureAlive){
                            iterator.remove();
                        }
                    }
                    Island.cells[x][y].reportStatus();
                    for (Animal animal : Island.cells[x][y].animalsInCell) {
                        reproduce(animal);
                    }
                    move(setDestination());

                }
        }
    }
}
