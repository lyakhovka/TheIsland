public abstract class Carnivore extends Animal {

    @Override
    public boolean eat(Alive possiblePrey) {
        Animal prey;
        double requiredFoodAmount = this.hp * this.maxFoodAmount;

        if (!this.possiblePreys.contains(possiblePrey)) {
            return false;
        } else if (possiblePrey instanceof Animal) {
            prey = (Animal) possiblePrey;
            if (prey.weight > requiredFoodAmount) {
                this.hp = 1;
            } else {
                this.hp += prey.weight / this.maxFoodAmount;
            }

            possiblePrey = null;

        }
        return true;
    }


}
