package fairyShop.models;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument{

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    @Override
    public void use() {
        int currentPower = getPower();

        if(getPower() < 0){
            setPower(0);
        } else {
            setPower(currentPower);
        }
    }

    @Override
    public boolean isBroken() {
        if(getPower() == 0){
            return true;
        }

        return false;
    }

    @Override
    public int getPower() {
        return power;
    }

    public void setPower(int power) {

        if(power < 0){
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);

        }

        this.power = power;
    }
}
