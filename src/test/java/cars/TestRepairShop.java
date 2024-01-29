// Tests for src/main/java/Repairshop.java

package cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestRepairShop {

  private static final int DEFAULT_CAPACITY = 5;

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  public void newWorkShopHasCorrectCapacity(int capacity) {
    RepairShop<Car> rs = new RepairShop<>(capacity);
    assertEquals(rs.getCapacity(), capacity);
  }

  @Test
  public void newWorkShopHasZeroInventory() {
    RepairShop<Car> rs = new RepairShop<>(DEFAULT_CAPACITY);
    assertEquals(rs.getInventorySize(), 0);
  }

  @Test
  public void newOrderIncreasesInventorySizeByOne() {
    RepairShop<Car> rs = new RepairShop<>(DEFAULT_CAPACITY);
    String orderId = rs.createOrder(new Volvo240());
    assertEquals(rs.getInventorySize(), 1);
  }

  @Test
  public void newOrderIsStoredInInventory() {
    RepairShop<Car> rs = new RepairShop<>(DEFAULT_CAPACITY);
    String orderId = rs.createOrder(new Volvo240());
    assertTrue(rs.orderExists(orderId));
  }

  @ParameterizedTest
  // Max load value is one less than default capacity
  @ValueSource(ints = {1, 2, 3, 4})
  public void canAcceptOrderReturnsTrueWhenNotFull(int loadAmount) {
    RepairShop<Car> rs = new RepairShop<>(DEFAULT_CAPACITY);
    for (int i = 0; i < loadAmount; i++) {
      rs.createOrder(new Volvo240());
    }
    assertTrue(rs.canAcceptOrder());
  }

  @Test
  public void canAcceptOrderReturnsFalseWhenFull() {
    RepairShop<Car> rs = new RepairShop<>(DEFAULT_CAPACITY);
    for (int i = 0; i < DEFAULT_CAPACITY; i++) {
      rs.createOrder(new Volvo240());
    }
    assertFalse(rs.canAcceptOrder());
  }

  @Test
  public void creatingOrderWhenFullThrowsIllegalStateException() {
    RepairShop<Car> rs = new RepairShop<>(1);
    rs.createOrder(new Volvo240());
    assertThrows(IllegalStateException.class, () -> rs.createOrder(new Volvo240()));
  }

  @Test
  public void completingOrderRemovesOrderFromInventory() {
    RepairShop<Volvo240> rs = new RepairShop<>(DEFAULT_CAPACITY);
    String orderId = rs.createOrder(new Volvo240());
    rs.completeOrder(orderId);
    assertFalse(rs.orderExists(orderId));
  }
}
