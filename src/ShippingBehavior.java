public interface ShippingBehavior {
    void ship(Order order);
    void charge(Order order);
}
// ASK GÜNDÜZ!!! There is code duplication here.
class ArasCargoBehavior implements ShippingBehavior {
    public void ship(Order order) {
        order.setCurrentStatus(OrderStatus.SHIPPED);
        System.out.println("This order is being shipped by Aras Cargo.");
    }
    public void charge(Order order) {
        System.out.println("The shipping cost is 12 Turkish Lira.");
    }
}

class YurticiCargoBehavior implements ShippingBehavior {
    public void ship(Order order) {
        order.setCurrentStatus(OrderStatus.SHIPPED);
        System.out.println("This order is being shipped by Yurtiçi Cargo.");
    }
    public void charge(Order order) {
        System.out.println("The shipping cost is 10 Turkish Lira.");
    }
}
