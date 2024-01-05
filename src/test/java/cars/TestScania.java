package cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestScania {

  @Test
  public void flatbedStartsAtAngle0() {
    Scania scania = new Scania();
    int expectedAngle = 0;
    assertEquals(expectedAngle, scania.getFlatbedAngle());
  }

  @Test
  public void loweringFlatbedBelowMinAngleRaisesIllegalArgException() {
    Scania scania = new Scania();
    int initialAngle = scania.getFlatbedAngle();
    scania.brake(1);
    assertThrows(IllegalArgumentException.class, () -> scania.lowerFlatbed(initialAngle + 1));
  }

  @Test
  public void raisingFlatbedAboveMaxAngleRaisesIllegalArgException() {
    Scania scania = new Scania();
    scania.brake(1);
    assertThrows(
        IllegalArgumentException.class, () -> scania.raiseFlatbed(Scania.MAX_FLATBED_ANGLE + 1));
  }

  @Test
  public void loweringFlatbedDuringMotionRaisesIllegalStateException() {
    Scania scania = new Scania();
    scania.gas(1);
    assertThrows(IllegalStateException.class, () -> scania.lowerFlatbed(1));
  }

  @Test
  public void raisingFlatbedDuringMotionRaisesIllegalStateException() {
    Scania scania = new Scania();
    scania.gas(1);
    assertThrows(IllegalStateException.class, () -> scania.raiseFlatbed(1));
  }

  @Test
  public void gassingWhileFlatbedIsRaisedRaisesIllegalStateException() {
    Scania scania = new Scania();
    scania.brake(1);
    scania.raiseFlatbed(1);
    assertThrows(IllegalStateException.class, () -> scania.gas(1));
  }
}
