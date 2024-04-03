public abstract class Carnivore extends Animal {

    @Override
    public void run() {
        while(isAlive){
            int x = currentPosition.get("X");
            int y = currentPosition.get("Y");
            for (Animal animal : Island.cells[x][y].animalsInCell) {
                eat(animal);
            }
            for (Animal animal : Island.cells[x][y].animalsInCell) {
                reproduce(animal);
            }
            move(setDestination());


        }
    }


}
