package cars;

import java.awt.Color;

public abstract class Truck extends TransportVehicle {
  public static final int MIN_FLATBED_ANGLE = 0;
  public static final int MAX_FLATBED_ANGLE = 70;

  private int nrDoors;

  public Truck(int nrDoors, double enginePower, Color color, String modelName) {
    super(nrDoors, enginePower, color, modelName);
  }

  private Lift createLift() {
    return new Lift(MIN_FLATBED_ANGLE, MAX_FLATBED_ANGLE);
  }

  @Override
  protected void initializeLift() {
    this.lift = createLift();
  }

  @Override
  protected void setLiftAngleToTilted() {
    lift.setAngle(lift.getMaxAngle());
  }

  @Override
  protected void restoreLiftAngle() {
    lift.setAngle(lift.getMinAngle());
  }

  @Override
  protected boolean platformIsTilted() {
    return lift.getCurrentAngle() > 0;
  }

  public void setLiftAngle(int angle) {
    lift.setAngle(angle);
  }
}
