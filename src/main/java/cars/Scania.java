package cars;

import java.awt.Color;

public class Scania extends Truck {
  private static final double SIZE_RELATED_SPEED_IMPACT = 0.4;

  public Scania() {
    super(2, 200, Color.RED, "Scania");
  }

  @Override
  protected double speedFactor() {
    return baseSpeedFactor() * SIZE_RELATED_SPEED_IMPACT;
  }
}
