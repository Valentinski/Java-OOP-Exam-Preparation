package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import static goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {
    private static final int ENERGY_COST_OF_DIGGING = 15;
    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        museum = new BaseMuseum();
    }

    public void dig(){
        energy = Math.max(0, energy - ENERGY_COST_OF_DIGGING);
    }

    public boolean canDig(){
        return energy > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    protected void setEnergy(double energy) {
        if(energy < 0){
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    protected void setMuseum(Museum museum) {
        this.museum = museum;
    }
}
