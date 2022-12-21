package fairyShop.models;

import static fairyShop.common.ExceptionMessages.PRESENT_ENERGY_LESS_THAN_ZERO;
import static fairyShop.common.ExceptionMessages.PRESENT_NAME_NULL_OR_EMPTY;

public class PresentImpl implements Present {

    private final static int DECREASE_VALUE = 10;
    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        setName(name);
        setEnergyRequired(energyRequired);
    }

    @Override
    public void getCrafted() {
        int currentEnergy = getEnergyRequired() - DECREASE_VALUE;
        if(currentEnergy < 0){
            setEnergyRequired(0);
        }else {
            setEnergyRequired(currentEnergy);
        }
    }

    @Override
    public boolean isDone() {
        if(getEnergyRequired() == 0){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name == null && name.trim().isEmpty()){
            throw new NullPointerException(PRESENT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getEnergyRequired() {
        return energyRequired;
    }

    public void setEnergyRequired(int energyRequired) {

        if(energyRequired < 0){
            throw new IllegalArgumentException(PRESENT_ENERGY_LESS_THAN_ZERO);
        }

        this.energyRequired = energyRequired;
    }
}
