public class Plant extends Alive{
    public static final String ICON = "\uD83C\uDF31";
    public static final double MIN_PLANT_WEIGHT = 0.1; //amount of food for the smallest herbivore
    public static final double MAX_PLANT_WEIGHT = 60; //amount of food for the biggest herbivore
    public double weight;

    public Plant(){
        this.weight = Math.random() * (MAX_PLANT_WEIGHT - MIN_PLANT_WEIGHT) + MIN_PLANT_WEIGHT;
    }

    public void paint(){
        System.out.print(ICON);
    }

}
