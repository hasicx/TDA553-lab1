```mermaid

classDiagram

  namespace cars {

    class Movable{
      turnLeft() void
      turnRight() void
      move() void
    }

    class Vehicle {
    }

    class TransportVehicle {
    }

    class CarCarrier {
    }

    class Truck {
      getFlatbedAngle() int
      raiseFlatbed() void
      lowerFlatbed() void
    }

    class Scania {
    }

    class Flatbed {
      -int maxAngle
      -int minAngle
      -int currentAngle
      +raise() void
      +lower() void
    }

    class Car {
    }

    class TrimmedCar {
    }

    class TurboCar {
    }

    class Volvo240 {
    }

    class Saab95 {
    }
  }

  <<abstract>> Vehicle
  <<abstract>> TransportVehicle
  <<abstract>> CarCarrier
  <<abstract>> Truck
  <<abstract>> Car
  <<abstract>> TrimmedCar
  <<abstract>> TurboCar
  <<interface>> Movable

  Vehicle <|.. Movable
  Vehicle <|-- TransportVehicle
  Vehicle <|-- Car
  TransportVehicle <|-- Truck
  TransportVehicle <|-- CarCarrier
  Truck <|-- Scania
  Truck *-- Flatbed
  Car <|-- TrimmedCar
  Car <|-- TurboCar
  TrimmedCar <|-- Volvo240
  TurboCar <|-- Saab95

```