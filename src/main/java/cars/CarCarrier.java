package cars;

import java.awt.Color;
import java.util.Deque;

public abstract class CarCarrier extends TransportVehicle {
  
  private static final double MAX_LOADING_DISTANCE = 1.0;
  private static final double DISPLACEMENT_AFTER_UNLOADING = 1e-1;
  protected Deque<Transportable> deck;

  public CarCarrier(int nrDoors, double enginePower, Color color, String modelName) {
    super(nrDoors, enginePower, color, modelName);
    initializeDeck();
  } 

  protected abstract void initializeDeck();

  @Override
  protected void setLiftAngleToTilted() {
    lift.setAngle(lift.getMinAngle());
  }

  @Override
  protected void restoreLiftAngle() {
    lift.setAngle(lift.getMaxAngle());
  }

  private boolean isInProximity(Transportable transportable) {
    double yDistance = Math.abs(transportable.getY() - this.getY());
    double xDistance = Math.abs(transportable.getX() - this.getX());
    return Math.max(yDistance, xDistance) <= MAX_LOADING_DISTANCE;
  }

  public void load(Transportable transportable) {
    if (!platformIsTilted()) {
      throw new IllegalStateException("Platform must be tilted to load car.");
    }
    if (!isInProximity(transportable)) {
      throw new IllegalArgumentException("Car must be in proximity to load.");
    }
    deck.addLast(transportable);
  }

  private void setCarPositionOnUnload(Transportable transportable) {
    Direction dir = this.getDirection();
    transportable.setDirection(dir);
    
    switch (dir) {
      case NORTH:
        transportable.setPosition(this.getX(), this.getY() - DISPLACEMENT_AFTER_UNLOADING);
        break;
      case EAST:
        transportable.setPosition(this.getX() - DISPLACEMENT_AFTER_UNLOADING, this.getY());
        break;
      case SOUTH:
        transportable.setPosition(this.getX(), this.getY() + DISPLACEMENT_AFTER_UNLOADING);
        break;
      case WEST:
        transportable.setPosition(this.getX() + DISPLACEMENT_AFTER_UNLOADING, this.getY());
        break;
    }
  }

  public Transportable unload() {
    if (!platformIsTilted()) {
      throw new IllegalStateException("Platform must be tilted to unload car.");
    }
    Transportable transportable = deck.removeLast();
    setCarPositionOnUnload(transportable); 
    return transportable;
  }

  public int getNumCarsOnDeck() {
    return deck.size();
  }

  @Override
  public void move() {
    super.move();
    for (Transportable transportable : deck) {
      transportable.setPosition(this.getX(), this.getY());
    }
  }

}
