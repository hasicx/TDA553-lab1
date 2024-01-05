package cars;

import java.awt.Color;
import java.awt.geom.Point2D;

public abstract class Vehicle implements Movable {

  private static final int MIN_VELOCITY = 0;
  private static final double TIME_INTERVAL_LENGTH = 0.5;
  private static final double ENGINE_POWER_RESCALE_AMOUNT = 0.01;

  private double enginePower; // Engine power of the car
  private Color color; // Color of the car
  private String modelName; // The car model name

  // State of motion
  private Point2D.Double position;
  private Direction direction;

  protected double currentSpeed; // The current speed of the car

  protected Vehicle(double enginePower, Color color, String modelName) {
    this.enginePower = enginePower;
    this.color = color;
    this.modelName = modelName;
    this.position = new Point2D.Double();
    this.direction = Direction.NORTH;

    startEngine();
  }

  public double getEnginePower() {
    return enginePower;
  }

  public double getCurrentSpeed() {
    return currentSpeed;
  }

  public Color getColor() {
    return color;
  }

  public double getX() {
    return position.x;
  }

  public double getY() {
    return position.y;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setColor(Color clr) {
    color = clr;
  }

  public void startEngine() {
    currentSpeed = 0.1;
  }

  public void stopEngine() {
    currentSpeed = 0;
  }

  protected double baseSpeedFactor() {
    return enginePower * ENGINE_POWER_RESCALE_AMOUNT;
  }

  protected abstract double speedFactor();

  protected double integrateAcceleration(double amount) {
    return getCurrentSpeed() + speedFactor() * amount;
  }

  protected double integrateDeceleration(double amount) {
    return getCurrentSpeed() - speedFactor() * amount;
  }

  protected void incrementSpeed(double amount) {
    double maxVelocity = getEnginePower();
    currentSpeed = Math.min(integrateAcceleration(amount), maxVelocity);
  }

  protected void decrementSpeed(double amount) {
    currentSpeed = Math.max(integrateDeceleration(amount), MIN_VELOCITY);
  }

  private void checkAmountArg(double amount) {
    if (amount < 0 || amount > 1) {
      throw new IllegalArgumentException("amount must be between 0 and 1.");
    }
  }

  public void gas(double amount) {
    checkAmountArg(amount);
    incrementSpeed(amount);
  }

  public void brake(double amount) {
    checkAmountArg(amount);
    decrementSpeed(amount);
  }

  public void move() {
    double displacement = currentSpeed * TIME_INTERVAL_LENGTH;
    switch (direction) {
      case NORTH:
        position.y += displacement;
        break;
      case EAST:
        position.x += displacement;
        break;
      case SOUTH:
        position.y -= displacement;
        break;
      case WEST:
        position.x -= displacement;
        break;
    }
  }

  public void turnLeft() {
    direction = direction.rotateCounterClockwise();
  }

  public void turnRight() {
    direction = direction.rotateClockwise();
  }
}
