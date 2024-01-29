package cars;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;

public class Cottrell extends CarCarrier {
  private static final int MAX_PLATFORM_ANGLE = 0;
  private static final int MIN_PLATFORM_ANGLE = -20;
  private static final double SIZE_RELATED_SPEED_IMPACT = 0.15;
  private static final int MAX_VEHICLES_ON_DECK = 8;

  public Cottrell() {
    super(2, 500, Color.BLACK, "Cottrell");
  }

  private Lift createLift() {
    return new Lift(MIN_PLATFORM_ANGLE, MAX_PLATFORM_ANGLE);
  }

  @Override
  protected void initializeLift() {
    lift = createLift();
    lift.setToMaxAngle();
  }

  private Deque<Transportable> createDeck() {
    return new ArrayDeque<Transportable>(MAX_VEHICLES_ON_DECK);
  }

  @Override
  protected void initializeDeck() {
    deck = createDeck();
  }

  @Override
  protected double speedFactor() {
    return baseSpeedFactor() * SIZE_RELATED_SPEED_IMPACT;
  }

  @Override
  protected boolean platformIsTilted() {
    return lift.getCurrentAngle() < 0;
  }
}
