package football.entities.supplement;
//we create this class
public abstract class BaseSupplement implements Supplement{
    // with this fields
    private int energy;
    private double price;

    protected BaseSupplement(int energy, double price) {
        this.energy = energy;
        this.price = price;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
