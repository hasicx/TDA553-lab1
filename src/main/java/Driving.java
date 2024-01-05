// Purpose: Playing around with the cars package.

import cars.Saab95;
import cars.Scania;
import cars.Vehicle;
import cars.Volvo240;
import java.util.ArrayList;

public class Driving {
  public static void main(String[] args) {

    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();
    Scania scania = new Scania();

    saab.setTurboOn();

    ArrayList<Vehicle> vehicles = new ArrayList<>(2);

    vehicles.add(saab);
    vehicles.add(volvo);
    vehicles.add(scania);

    for (Vehicle vehicle : vehicles) {
      System.out.printf("car: %s\n", vehicle.toString());
      System.out.printf("dir: %s\n", vehicle.getDirection());
      System.out.printf("speed: %.3f\n", vehicle.getCurrentSpeed());
      System.out.printf("pos: (%.3f, %.3f)\n", vehicle.getX(), vehicle.getY());
      vehicle.move();
      System.out.printf("pos: (%.3f, %.3f)\n", vehicle.getX(), vehicle.getY());
      vehicle.turnRight();
      vehicle.gas(1);
      vehicle.move();
      System.out.printf("pos: (%.3f, %.3f)\n", vehicle.getX(), vehicle.getY());
      saab.gas(1);
    }

    //   System.out.printf("saab enginepower: %.3f\n", saab.getEnginePower());
    //   for (int i = 0; i < 5; i++) {
    //     saab.gas(1);
    //     System.out.printf("saab speed: %.2f\n", saab.getCurrentSpeed());
    //   }

    //   for (int i = 0; i < 5; i++) {
    //     saab.brake(1);
    //     System.out.printf("saab speed: %.2f\n", saab.getCurrentSpeed());
    //   }
  }
}
