package cars;

import java.awt.Color;

public abstract class TransportVehicle extends Vehicle {

  private int nrDoors;
  protected Lift lift;

  public TransportVehicle(int nrDoors, double enginePower, Color color, String modelName) {
    super(enginePower, color, modelName);
    this.nrDoors = nrDoors;
    initializeLift();
  }

  protected abstract void initializeLift();

  protected abstract void setLiftAngleToTilted();

  protected abstract void restoreLiftAngle();

  protected abstract boolean platformIsTilted();

  protected boolean isInMotion() {
    return currentSpeed > 0;
  }

  protected void verifyStationarity() {
    if (isInMotion()) {
      throw new IllegalStateException("Cannot use platform during motion.");
    }
  }

  public void enableTiltedMode() {
    verifyStationarity();
    setLiftAngleToTilted();
  }

  public void disableTiltedMode() {
    verifyStationarity();
    restoreLiftAngle();
  }

  public void gas(double amount) {
    if (platformIsTilted()) {
      throw new IllegalStateException("Cannot gas while platform is tilted.");
    }
    super.gas(amount);
  }

  public int getLiftAngle() {
    return lift.getCurrentAngle();
  }

  public int getMinLiftAngle() {
    return lift.getMinAngle();
  }

  public int getMaxLiftAngle() {
    return lift.getMaxAngle();
  }
}
