public interface OrderCommand {
    public void execute();
}
class PayCommand implements OrderCommand {
    Order order;
    public PayCommand(Order order) {
        this.order = order;
    }
    public void execute() {
        System.out.println("Your payment of " + order.getTotalPrice() + " TL has been paid.");
    }
}
class CancelCommand implements OrderCommand {
    Order order;
    public CancelCommand(Order order){
        this.order = order;
    }
    public void execute() {
        System.out.println("Your payment of " + order.getTotalPrice() + " TL has been cancelled.");
    }
}