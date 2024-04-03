public abstract class Herbivore extends Animal{
    @Override
    public void run() {
        while(isAlive){
            int x = currentPosition.get("X");
            int y = currentPosition.get("Y");
            for (Plant plant : Island.cells[x][y].plantsInCell) {
                eat(plant);
            }
            for (Animal animal : Island.cells[x][y].animalsInCell) {
                reproduce(animal);
            }
            move(setDestination());


        }
    }

}
