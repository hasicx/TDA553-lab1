package cars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestVolvo240 {

  public static final double TRIMFACTOR = Volvo240.TRIMFACTOR;

  @Test
  public void speedFactorReturnsProductOfBaseSpeedFactorAndTrimFactor() {
    Volvo240 volvo240 = new Volvo240();
    double expectedSpeedFactor = volvo240.baseSpeedFactor() * TRIMFACTOR;
    assertEquals(expectedSpeedFactor, volvo240.speedFactor(), Constants.DOUBLE_EQUALITY_TOLERANCE);
  }
}
