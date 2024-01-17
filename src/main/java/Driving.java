// Purpose: Playing around with the cars package.

import cars.Car;
import cars.CarCarrier;
import cars.Cottrell;
import cars.Saab95;
import cars.Scania;
import cars.TransportVehicle;
import cars.Vehicle;
import cars.Volvo240;
import java.util.ArrayList;

public class Driving {
  public static void main(String[] args) {

    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();
    Scania scania = new Scania();
    Cottrell cottrell = new Cottrell();

    saab.setTurboOn();

    ArrayList<Vehicle> vehicles = new ArrayList<>(2);

    vehicles.add(saab);
    vehicles.add(volvo);
    vehicles.add(scania);
    vehicles.add(cottrell);

    // Test loading and unloading cars on car carrier
    CarCarrier carrier = new Cottrell();
    carrier.brake(1);
    carrier.enableTiltedMode();
    carrier.load(volvo);
    carrier.disableTiltedMode();

    // Check positions of carrier and volvo before moving
    System.out.println("Carrier position: " + carrier.getX() + ", " + carrier.getY());
    System.out.println("Volvo position: " + volvo.getX() + ", " + volvo.getY());

    // Move carrier before unloading
    carrier.gas(1);
    carrier.move();
    carrier.brake(1);

    // Check positions after moving before unloading
    System.out.println("Carrier position: " + carrier.getX() + ", " + carrier.getY());
    System.out.println("Volvo position: " + volvo.getX() + ", " + volvo.getY());

    carrier.enableTiltedMode();
    Volvo240 unloadedVolvo = (Volvo240) carrier.unload();

    // Check positions of carrier and volvo after unloading
    System.out.println("Carrier position: " + carrier.getX() + ", " + carrier.getY());
    System.out.println("Volvo position: " + volvo.getX() + ", " + volvo.getY());

  }
}
