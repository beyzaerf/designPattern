import java.util.List;

public class Order {
    private int orderId;
    private User sender;
    private Location destination;
    private List<Item> items;
    private double totalWeight;
    private OrderStatus currentStatus;
    private int totalPrice;
    ShippingBehavior shippingBehavior;
    IPaymentCommand paymentCommand;
    ICancelCommand cancelCommand;

    public int getTotalPrice() { return totalPrice; }
    public double getTotalWeight() { return totalWeight; }
    public int getOrderId() { return orderId; }
    public List<Item> getItems() { return items; }
    public Location getDestination() { return destination; }
    public String trackOrder() { return "Your order is currently " + currentStatus + "."; }
    public User getSender() { return sender; }
    public ShippingBehavior getShippingBehavior() { return shippingBehavior; }
    public void setCurrentStatus(OrderStatus currentStatus) { this.currentStatus = currentStatus; }
    public void setDestination(Location destination) { this.destination = destination; }
    public void setItems(List<Item> items) { this.items = items; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setSender(User sender) { this.sender = sender; }
    public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }
    public void setTotalWeight(double totalWeight) { this.totalWeight = totalWeight; }

    public void setPaymentCommand(IPaymentCommand paymentCommand) {
        this.paymentCommand = paymentCommand;
    }

    public void setCancelCommand(ICancelCommand cancelCommand) {
        this.cancelCommand = cancelCommand;
    }

    public Order(int orderId, User sender, List<Item> items, ShippingBehavior shippingBehavior) {
        this.orderId = orderId;
        this.sender = sender;
        this.destination = sender.getAddress();
        this.items = items;
        this.shippingBehavior = shippingBehavior;
        this.totalWeight = items.stream().filter(item -> item.getWeight() > 0).mapToInt(Item::getWeight).sum();
        int extraFee = this.shippingBehavior.getExtraFee(this.totalWeight);
        this.totalPrice = items.stream().filter(item -> item.getPrice() > 0).mapToInt(Item::getPrice).sum() + extraFee;
        this.currentStatus = OrderStatus.RECEIVED;
    }
}
enum OrderStatus {
    RECEIVED,
    SHIPPED,
    DELIVERED;
}