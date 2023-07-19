import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
    }

    @Override
    protected double speedFactor(){
        return super.speedFactor() * trimFactor;
    }

    @Override
    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(integrateAcceleration(amount), getEnginePower());
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(integrateDeceleration(amount), 0);
    }

}