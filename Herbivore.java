public abstract class Herbivore extends Animal{
    private static final Object lock = new Object();
    @Override
    public void run() {
        while(isCreatureAlive){
            int x = currentPosition.get("X");
            int y = currentPosition.get("Y");
            synchronized (lock) {
                for (Plant plant : Island.cells[x][y].plantsInCell) {
                    eat(plant);
                }
            }
            for (Animal animal : Island.cells[x][y].animalsInCell) {
                reproduce(animal);
            }
            move(setDestination());


        }
    }

}
