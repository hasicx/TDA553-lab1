```mermaid
classDiagram
  class Car
  class TrimmedCar
  class TurboCar
  Car <-- TrimmedCar
  Car <-- TurboCar
  class Volvo240
  TrimmedCar <-- Volvo240
  class Saab95
  TurboCar <-- Saab95
```