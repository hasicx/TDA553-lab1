package cars;

import java.awt.Color;

public abstract class Truck extends Vehicle {
  public static final int MIN_FLATBED_ANGLE = 0;
  public static final int MAX_FLATBED_ANGLE = 70;

  private Flatbed flatbed;
  private int nrDoors;

  public Truck(int nrDoors, double enginePower, Color color, String modelName) {
    super(enginePower, color, modelName);
    this.nrDoors = nrDoors;
    this.flatbed = new Flatbed(MIN_FLATBED_ANGLE, MAX_FLATBED_ANGLE);
  }

  public int getFlatbedAngle() {
    return flatbed.getCurrentAngle();
  }

  public void raiseFlatbed(int degrees) {
    if (currentSpeed > 0) {
      throw new IllegalStateException("Cannot raise flatbed during motion.");
    }
    flatbed.raise(degrees);
  }

  public void lowerFlatbed(int degrees) {
    if (currentSpeed > 0) {
      throw new IllegalStateException("Cannot lower flatbed during motion.");
    }
    flatbed.lower(degrees);
  }

  public void gas(double amount) {
    if (flatbed.getCurrentAngle() > 0) {
      throw new IllegalStateException("Cannot gas while flatbed is raised.");
    }
    super.gas(amount);
  }
}
