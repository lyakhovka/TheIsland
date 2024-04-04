import java.util.Iterator;

public abstract class Carnivore extends Animal {
    private static final Object lock = new Object();
    @Override
    public void run() {
        while(this.hp>0){
            int x = currentPosition.get("X");
            int y = currentPosition.get("Y");
                synchronized (Island.cells[x][y].animalsInCell) {
                    for (Animal animal : Island.cells[x][y].animalsInCell) {
                        eat(animal);
                    }
                    Iterator<Animal> iterator = Island.cells[x][y].animalsInCell.iterator();
                    while (iterator.hasNext()){
                        Animal animal = iterator.next();
                        if(animal.hp == 0.0){
                            iterator.remove();  //а що буде, якщо видалиться this? може цього не треба робити? може потік зупиниться по умові while і garbage collector сам прибере this?
                        }
                    }

                    Island.cells[x][y].reportStatus();
//                    for (Animal animal : Island.cells[x][y].animalsInCell) {
//                        reproduce(animal);
//                    }
                    move(setDestination());

                }
       }
    }
}
