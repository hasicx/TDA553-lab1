package cars;

public interface Transportable {
  void setPosition(double x, double y);

  void setDirection(Direction dir);

  double getX();

  double getY();
}
