import java.awt.*;

public class Saab95 extends Car {

    public boolean turboOn;

    public Saab95() {
        super(2, 125, Color.red, "Saab95");
    }


    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    protected double speedFactor(){
        return super.speedFactor() * (turboOn ? 1.3 : 1);
    }

    @Override
    protected void incrementSpeed(double amount){
        currentSpeed = integrateAcceleration(amount);
    }

    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = integrateDeceleration(amount);
    }

}