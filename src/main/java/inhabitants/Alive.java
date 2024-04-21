package inhabitants;

import java.util.Map;

public abstract class Alive {
    double weight;
    public double hp;
    public Map<String, Integer> currentPosition;

    public void die() {
        weight = 0.0;
        hp = 0.0;
    }

    public abstract void paint();

    abstract String getName();

    public double getHp() {
        return hp;
    }
}

