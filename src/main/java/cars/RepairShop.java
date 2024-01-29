package cars;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RepairShop<T> {

  private final int capacity;
  private Map<String, T> orders;

  public RepairShop(int capacity) {
    this.capacity = capacity;
    this.orders = createOrderMap();
  }

  private <S> Map<S, T> createOrderMap() {
    return new HashMap<>(capacity);
  }

  public boolean canAcceptOrder() {
    return orders.size() < capacity;
  }

  public int getInventorySize() {
    return orders.size();
  }

  public int getCapacity() {
    return capacity;
  }

  public String createOrder(T t) {
    if (!canAcceptOrder()) {
      throw new IllegalStateException("Inventory is full.");
    }
    String id = UUID.randomUUID().toString();
    orders.put(id, t);
    return id;
  }

  public T completeOrder(String id) {
    return orders.remove(id);
  }

  public boolean orderExists(String id) {
    return orders.containsKey(id);
  }
}
