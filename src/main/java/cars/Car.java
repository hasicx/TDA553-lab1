package cars;

import java.awt.Color;

public abstract class Car extends Vehicle {

  private int nrDoors; // Number of doors on the car

  public Car(int nrDoors, double enginePower, Color color, String modelName) {
    super(enginePower, color, modelName);
    this.nrDoors = nrDoors;
  }

  public int getNrDoors() {
    return nrDoors;
  }
}
