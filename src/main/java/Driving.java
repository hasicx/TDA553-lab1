// Purpose: Playing around with the cars package.

import cars.Car;
import cars.CarCarrier;
import cars.Cottrell;
import cars.RepairShop;
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
    System.out.println("Carrier angle: " + carrier.getLiftAngle());

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

    // Test repairshop
    RepairShop<Car> rs = new RepairShop<>(5);
    String orderId = rs.createOrder(unloadedVolvo);
    System.out.println("Order id: " + orderId);
    System.out.println("Inventory size: " + rs.getInventorySize());
    System.out.println("Order exists: " + rs.orderExists(orderId));
    System.out.println("Completing order...");
    Car returnedCar = rs.completeOrder(orderId);
    System.out.println("Inventory size: " + rs.getInventorySize());
    System.out.println("Order exists: " + rs.orderExists(orderId));

    // Test Trucks
    System.out.println("Scania lift angle: " + scania.getLiftAngle());
  }
}
