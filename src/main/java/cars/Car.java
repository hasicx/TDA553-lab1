package cars;

import java.awt.Color;

public abstract class Car extends Vehicle implements Transportable {

  private int nrDoors; // Number of doors on the car

  public Car(int nrDoors, double enginePower, Color color, String modelName) {
    super(enginePower, color, modelName);
    this.nrDoors = nrDoors;
  }

  public int getNrDoors() {
    return nrDoors;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public void setPosition(double x, double y) {
    this.position.setLocation(x, y);
  }
}
