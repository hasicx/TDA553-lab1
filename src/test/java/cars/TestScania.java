package cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestScania {

  @Test
  public void liftStartsAtAngle0() {
    Scania scania = new Scania();
    int expectedAngle = 0;
    assertEquals(expectedAngle, scania.getLiftAngle());
  }

  @Test
  public void loweringLiftBelowMinAngleRaisesIllegalArgException() {
    Scania scania = new Scania();
    int minAngle = scania.getMinLiftAngle();
    scania.brake(1);
    assertThrows(IllegalArgumentException.class, () -> scania.setLiftAngle(minAngle - 1));
  }

  @Test
  public void raisingLiftAboveMaxAngleRaisesIllegalArgException() {
    Scania scania = new Scania();
    int maxAngle = scania.getMaxLiftAngle();
    scania.brake(1);
    assertThrows(IllegalArgumentException.class, () -> scania.setLiftAngle(maxAngle + 1));
  }

  @Test
  public void untiltingLiftDuringMotionRaisesIllegalStateException() {
    Scania scania = new Scania();
    scania.gas(1);
    assertThrows(IllegalStateException.class, () -> scania.disableTiltedMode());
  }

  @Test
  public void tiltingLiftDuringMotionRaisesIllegalStateException() {
    Scania scania = new Scania();
    scania.gas(1);
    assertThrows(IllegalStateException.class, () -> scania.enableTiltedMode());
  }

  @Test
  public void gassingDuringTiltedModeRaisesIllegalStateException() {
    Scania scania = new Scania();
    scania.brake(1);
    scania.enableTiltedMode();
    assertThrows(IllegalStateException.class, () -> scania.gas(1));
  }
}
