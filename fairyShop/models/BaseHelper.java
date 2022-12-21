package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

import static fairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;

public abstract class BaseHelper implements Helper {

    private final static int REDUCING_LEVEL = 10;
    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
        setName(name);
        setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    @Override
    public void work() {
        int newEnergy = getEnergy() - REDUCING_LEVEL;

        if(newEnergy < 0){
            setEnergy(0);
        } else {
            setEnergy(newEnergy);
        }

    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        if(getEnergy() > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name == null && name.trim().isEmpty()){
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }
}
