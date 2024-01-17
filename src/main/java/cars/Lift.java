package cars;

public class Lift {
  private static final int DEFAULT_MIN_ANGLE = 0;
  private static final int DEFAULT_MAX_ANGLE = 90;

  private int currentAngle;
  private int minAngle;
  private int maxAngle;

  public Lift(int minAngle, int maxAngle) {
    this.currentAngle = minAngle;
    this.minAngle = minAngle;
    this.maxAngle = maxAngle;
  }

  public Lift() {
    this(DEFAULT_MIN_ANGLE, DEFAULT_MAX_ANGLE);
  }

  public int getCurrentAngle() {
    return currentAngle;
  }

  public int getMinAngle() {
    return minAngle;
  }

  public int getMaxAngle() {
    return maxAngle;
  }

  public void setToMaxAngle() {
    currentAngle = maxAngle;
  }

  public void setToMinAngle() {
    currentAngle = minAngle;
  }

  // public void raise(int degrees) {
  //   if (degrees + currentAngle > maxAngle) {
  //     throw new IllegalArgumentException("Cannot raise flatbed above max angle.");
  //   }
  //   currentAngle += degrees;
  // }

  // public void lower(int degrees) {
  //   if (degrees > currentAngle) {
  //     throw new IllegalArgumentException("Cannot lower flatbed below min angle.");
  //   }
  //   currentAngle -= degrees;
  // }

  public void setAngle(int angle) {
    if (angle < minAngle || angle > maxAngle) {
      throw new IllegalArgumentException("Angle must be between min and max angle.");
    }
    currentAngle = angle;
  }
}
