public abstract class Omnivore extends Animal {
    @Override
    public void run() {
        while(this.hp>0){
            int x = currentPosition.get("X");
            int y = currentPosition.get("Y");
            for (Plant plant : Island.cells[x][y].plantsInCell) {
                eat(plant);
            }
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

