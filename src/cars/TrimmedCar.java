package cars;

import java.awt.*;

public abstract class TrimmedCar extends Car {

    protected TrimmedCar(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    @Override
    protected abstract double speedFactor();

    @Override
    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(integrateAcceleration(amount), getEnginePower());
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(integrateDeceleration(amount), 0);
    }

}