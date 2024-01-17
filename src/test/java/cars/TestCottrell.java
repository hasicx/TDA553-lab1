package cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestCottrell {

  @Test
  public void cannotLoadIfNotInProximity() {
    Cottrell cottrell = new Cottrell();
    Volvo240 volvo = new Volvo240();
    volvo.gas(0.5);
    volvo.setDirection(Direction.NORTH);
    double travelDistance = 5.0;
    while (cottrell.getY() < travelDistance) {
      cottrell.move();
    }
    assertThrows(IllegalStateException.class, () -> cottrell.load(volvo));
  }

  @Test
  public void newDeckIsEmpty() {
    Cottrell cottrell = new Cottrell();
    assertEquals(0, cottrell.getNumCarsOnDeck());
  }

  //Tests for CarCarrier/Cottrell
  @Test
  public void loadedVehiclesMoveWithCarrier() {
    Cottrell cottrell = new Cottrell();
    Volvo240 volvo = new Volvo240();
    cottrell.brake(1);
    cottrell.enableTiltedMode();
    cottrell.load(volvo);
    cottrell.disableTiltedMode();

    cottrell.gas(0.5);
    cottrell.move();

    assertEquals(cottrell.getX(), volvo.getX(), Constants.DOUBLE_EQUALITY_TOLERANCE);
    assertEquals(cottrell.getY(), volvo.getY(), Constants.DOUBLE_EQUALITY_TOLERANCE);
  }

}
